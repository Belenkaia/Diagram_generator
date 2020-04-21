package ru.iaie.reflex.diagram.generator;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.diagram.generator.ActiveProcess;
import ru.iaie.reflex.diagram.generator.DiagramNode;
import ru.iaie.reflex.diagram.generator.ProcessDiagramGraphMLGenerator;
import ru.iaie.reflex.diagram.reflex.CompoundStatement;
import ru.iaie.reflex.diagram.reflex.IfElseStat;
import ru.iaie.reflex.diagram.reflex.StartProcStat;
import ru.iaie.reflex.diagram.reflex.State;
import ru.iaie.reflex.diagram.reflex.Statement;
import ru.iaie.reflex.diagram.reflex.StopProcStat;
import ru.iaie.reflex.diagram.reflex.TimeoutFunction;

@SuppressWarnings("all")
public class ActivityDiagramGenerator extends ProcessDiagramGraphMLGenerator {
  public void generateActivityModel(final Resource resource) {
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process process : _filter) {
      EList<State> _states = process.getStates();
      for (final State state : _states) {
        {
          EList<Statement> _statements = state.getStatements();
          for (final Statement statement : _statements) {
            {
              ArrayList<ActiveProcess> tempProcList = null;
              tempProcList = this.getActiveList(statement, this.getElementIndexProcId(process.getName()));
              this.procList.addAll(tempProcList);
            }
          }
          TimeoutFunction _timeoutFunction = state.getTimeoutFunction();
          boolean _tripleNotEquals = (_timeoutFunction != null);
          if (_tripleNotEquals) {
            EList<Statement> _statements_1 = state.getTimeoutFunction().getStatements();
            for (final Statement timeoutFunctionStatements : _statements_1) {
              {
                ArrayList<ActiveProcess> tempProcList = null;
                tempProcList = this.getActiveList(timeoutFunctionStatements, this.getElementIndexProcId(process.getName()));
                this.procList.addAll(tempProcList);
              }
            }
          }
        }
      }
    }
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final StartProcStat statement, final int contextProcessId) {
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    ActiveProcess proc = new ActiveProcess();
    proc.setAction("start");
    proc.setIdFrom(contextProcessId);
    proc.setIdTo(this.getElementIndexProcId(statement.getProcId()));
    procTempList.add(proc);
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final StopProcStat statement, final int contextProcessId) {
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    ActiveProcess proc = new ActiveProcess();
    proc.setAction("stop");
    proc.setIdFrom(contextProcessId);
    String _procId = statement.getProcId();
    boolean _tripleNotEquals = (_procId != null);
    if (_tripleNotEquals) {
      proc.setIdTo(this.getElementIndexProcId(statement.getProcId()));
    } else {
      proc.setIdTo(contextProcessId);
    }
    procTempList.add(proc);
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final IfElseStat statement, final int contextProcessId) {
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    ArrayList<ActiveProcess> procTempThenList = this.getActiveList(statement.getThen(), contextProcessId);
    ArrayList<ActiveProcess> procTempElseList = new ArrayList<ActiveProcess>();
    Statement _else = statement.getElse();
    boolean _tripleNotEquals = (_else != null);
    if (_tripleNotEquals) {
      procTempElseList = this.getActiveList(statement.getElse(), contextProcessId);
    }
    procTempList.addAll(procTempThenList);
    procTempList.addAll(procTempElseList);
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final CompoundStatement statement, final int contextProcessId) {
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    EList<Statement> _statements = statement.getStatements();
    for (final Statement s : _statements) {
      {
        ArrayList<ActiveProcess> subProcList = this.getActiveList(s, contextProcessId);
        procTempList.addAll(subProcList);
      }
    }
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final Statement statement, final int contextProcessId) {
    return new ArrayList<ActiveProcess>();
  }
  
  public void generateActivityDiagramModel(final Resource resource) {
    this.generateProcList(resource);
    this.generateActivityModel(resource);
  }
  
  public String generateActivityDiagram(final HashMap<String, DiagramNode> nodesId, final ArrayList<ActiveProcess> diagramModel) {
    String result = "";
    System.out.print("Generate GML activity diagram...");
    String _result = result;
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeHeadGML = this.gmlTextGenerator.writeHeadGML(this);
    _builder.append(_writeHeadGML);
    _builder.newLineIfNotEmpty();
    result = (_result + _builder);
    this.procId = nodesId;
    this.procList = diagramModel;
    String _result_1 = result;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\t");
    String _generateNodes = this.gmlTextGenerator.generateNodes(this);
    _builder_1.append(_generateNodes, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t\t");
    String _generateAllEdges = this.gmlTextGenerator.generateAllEdges(diagramModel);
    _builder_1.append(_generateAllEdges, "\t\t\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t\t");
    _builder_1.append("]");
    result = (_result_1 + _builder_1);
    System.out.println("done.");
    return result;
  }
  
  public String generateActivityGraphMLDiagram(final HashMap<String, DiagramNode> nodesId, final ArrayList<ActiveProcess> diagramModel, final String url, final String statechartFileNameTail) {
    String result = "";
    System.out.print("Generate GraphML activity diagram...");
    String _result = result;
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _headGraphMlGenerator = this.graphMLTextGenerator.headGraphMlGenerator(this);
    _builder.append(_headGraphMlGenerator);
    _builder.newLineIfNotEmpty();
    result = (_result + _builder);
    this.procId = nodesId;
    this.procList = diagramModel;
    String _result_1 = result;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("<graph edgedefault=\"directed\" id=\"G\">");
    _builder_1.newLine();
    _builder_1.append("\t");
    String _generateNodes = this.graphMLTextGenerator.generateNodes(this, url, statechartFileNameTail);
    _builder_1.append(_generateNodes, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("\t");
    String _generateAllEdges = this.graphMLTextGenerator.generateAllEdges(diagramModel);
    _builder_1.append(_generateAllEdges, "\t");
    _builder_1.newLineIfNotEmpty();
    _builder_1.append("  ");
    _builder_1.append("</graph>");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("<data key=\"d6\">");
    _builder_1.newLine();
    _builder_1.append("\t  ");
    _builder_1.append("<y:Resources/>");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("</data>");
    _builder_1.newLine();
    _builder_1.append("</graphml>");
    result = (_result_1 + _builder_1);
    System.out.println("done.");
    return result;
  }
  
  public ArrayList<ActiveProcess> getActiveList(final Statement statement, final int contextProcessId) {
    if (statement instanceof CompoundStatement) {
      return _getActiveList((CompoundStatement)statement, contextProcessId);
    } else if (statement instanceof IfElseStat) {
      return _getActiveList((IfElseStat)statement, contextProcessId);
    } else if (statement instanceof StartProcStat) {
      return _getActiveList((StartProcStat)statement, contextProcessId);
    } else if (statement instanceof StopProcStat) {
      return _getActiveList((StopProcStat)statement, contextProcessId);
    } else if (statement != null) {
      return _getActiveList(statement, contextProcessId);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(statement, contextProcessId).toString());
    }
  }
}
