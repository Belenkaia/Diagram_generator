package ru.iaie.reflex.diagram.generator;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.diagram.generator.ActiveProcess;
import ru.iaie.reflex.diagram.generator.GMLTextGenerator;
import ru.iaie.reflex.diagram.generator.GraphMLTextGenerator;
import ru.iaie.reflex.diagram.generator.ProcessDiagramGenerator;
import ru.iaie.reflex.diagram.reflex.CompoundStatement;
import ru.iaie.reflex.diagram.reflex.IfElseStat;
import ru.iaie.reflex.diagram.reflex.StartProcStat;
import ru.iaie.reflex.diagram.reflex.State;
import ru.iaie.reflex.diagram.reflex.Statement;
import ru.iaie.reflex.diagram.reflex.StopProcStat;
import ru.iaie.reflex.diagram.reflex.TimeoutFunction;

@SuppressWarnings("all")
public class ActivityDiagramGenerator extends ProcessDiagramGenerator {
  private GMLTextGenerator gmlTextGenerator = new GMLTextGenerator();
  
  private GraphMLTextGenerator graphMLTextGenerator = new GraphMLTextGenerator();
  
  public void constructActiveModel(final Resource resource) {
    for (int i = 0; (i < this.procId.size()); i++) {
      String _plus = (Integer.valueOf(i) + ":");
      String _get = this.procId.get(i);
      String _plus_1 = (_plus + _get);
      String _plus_2 = (_plus_1 + ", ");
      System.out.print(_plus_2);
    }
    System.out.println();
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process process : _filter) {
      EList<State> _states = process.getStates();
      for (final State state : _states) {
        {
          EList<Statement> _statements = state.getStatements();
          for (final Statement statement : _statements) {
            {
              ArrayList<ActiveProcess> tempProcList = null;
              tempProcList = this.getActiveList(statement, this.procId.indexOf(process.getName()));
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
                tempProcList = this.getActiveList(timeoutFunctionStatements, this.procId.indexOf(process.getName()));
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
    proc.setIdTo(this.procId.indexOf(statement.getProcId()));
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
      proc.setIdTo(this.procId.indexOf(statement.getProcId()));
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
  
  public CharSequence generateActivityDiagram(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeHeadGML = this.gmlTextGenerator.writeHeadGML(this);
    _builder.append(_writeHeadGML);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateProcessNodes = this.gmlTextGenerator.generateProcessNodes(resource, this);
    _builder.append(_generateProcessNodes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    this.constructActiveModel(resource);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateAllEdges = this.gmlTextGenerator.generateAllEdges(this.procList);
    _builder.append(_generateAllEdges, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    return _builder;
  }
  
  public CharSequence generateActivityGraphMLDiagram(final Resource resource, final String url) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _headGraphMlGenerator = this.graphMLTextGenerator.headGraphMlGenerator(this);
    _builder.append(_headGraphMlGenerator);
    _builder.newLineIfNotEmpty();
    _builder.append("<graph edgedefault=\"directed\" id=\"G\">");
    _builder.newLine();
    _builder.append("\t");
    String _generateProcessNodes = this.graphMLTextGenerator.generateProcessNodes(resource, this, url);
    _builder.append(_generateProcessNodes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateAllEdges = this.graphMLTextGenerator.generateAllEdges(this.procList);
    _builder.append(_generateAllEdges, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("  ");
    _builder.append("</graph>");
    _builder.newLine();
    _builder.append("    ");
    _builder.append("<data key=\"d6\">");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<y:Resources/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</data>");
    _builder.newLine();
    _builder.append("</graphml>");
    return _builder;
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
