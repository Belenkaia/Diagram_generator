package ru.iaie.reflex.diagram.generator;

import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import ru.iaie.reflex.diagram.generator.ActiveProcess;
import ru.iaie.reflex.diagram.generator.GMLDiagramGenerator;
import ru.iaie.reflex.diagram.generator.GMLTextGenerator;
import ru.iaie.reflex.diagram.reflex.CompoundStatement;
import ru.iaie.reflex.diagram.reflex.Expression;
import ru.iaie.reflex.diagram.reflex.IfElseStat;
import ru.iaie.reflex.diagram.reflex.SetStateStat;
import ru.iaie.reflex.diagram.reflex.State;
import ru.iaie.reflex.diagram.reflex.Statement;
import ru.iaie.reflex.diagram.reflex.TimeoutFunction;

@SuppressWarnings("all")
public class StatechartDiagramGenerator extends GMLDiagramGenerator {
  private GMLTextGenerator gmlTextGenerator = new GMLTextGenerator();
  
  public String generateStatechartNodes(final Resource resource, final ru.iaie.reflex.diagram.reflex.Process process) {
    String tempString = "";
    String _tempString = tempString;
    CharSequence _generateOneProcessNode = this.gmlTextGenerator.generateOneProcessNode(this.count_id, "     ", "circle");
    tempString = (_tempString + _generateOneProcessNode);
    this.procId.add(this.count_id, "start_default");
    this.count_id++;
    EList<State> _states = process.getStates();
    for (final State state : _states) {
      {
        String _tempString_1 = tempString;
        CharSequence _generateOneProcessNode_1 = this.gmlTextGenerator.generateOneProcessNode(this.count_id, state.getName(), "roundrectangle");
        tempString = (_tempString_1 + _generateOneProcessNode_1);
        this.procId.add(this.count_id, state.getName());
        this.count_id++;
      }
    }
    return tempString;
  }
  
  public CharSequence generateStatechartDiagram(final Resource resource, final ru.iaie.reflex.diagram.reflex.Process process) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeHeadGML = this.gmlTextGenerator.writeHeadGML(this);
    _builder.append(_writeHeadGML);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateStatechartNodes = this.generateStatechartNodes(resource, process);
    _builder.append(_generateStatechartNodes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    this.generateStatechartModel(resource, process);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateAllEdges = this.gmlTextGenerator.generateAllEdges(this.procList);
    _builder.append(_generateAllEdges, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    return _builder;
  }
  
  public void generateStatechartModel(final Resource resource, final ru.iaie.reflex.diagram.reflex.Process process) {
    boolean flagFirstStateInProcess = true;
    EList<State> _states = process.getStates();
    for (final State state : _states) {
      {
        EList<Statement> _statements = state.getStatements();
        for (final Statement statement : _statements) {
          {
            if (flagFirstStateInProcess) {
              ActiveProcess startNode = new ActiveProcess();
              startNode.setIdFrom(this.procId.indexOf("start_default"));
              startNode.setIdTo(this.procId.indexOf(state.getName()));
              this.procList.add(startNode);
            }
            ArrayList<ActiveProcess> tempProcList = null;
            tempProcList = this.getStatechartList(statement, this.procId.indexOf(state.getName()), "(");
            this.procList.addAll(tempProcList);
            flagFirstStateInProcess = false;
          }
        }
        TimeoutFunction _timeoutFunction = state.getTimeoutFunction();
        boolean _tripleNotEquals = (_timeoutFunction != null);
        if (_tripleNotEquals) {
          EList<Statement> _statements_1 = state.getTimeoutFunction().getStatements();
          for (final Statement timeoutFunctionStatements : _statements_1) {
            {
              String contextLabel = ("(Timeout [ time = " + " ]");
              ArrayList<ActiveProcess> tempProcList = null;
              tempProcList = this.getStatechartList(timeoutFunctionStatements, this.procId.indexOf(state.getName()), contextLabel);
              this.procList.addAll(tempProcList);
            }
          }
        }
      }
    }
  }
  
  protected ArrayList<ActiveProcess> _getStatechartList(final Statement statement, final int contextStateId, final String contextLabel) {
    return new ArrayList<ActiveProcess>();
  }
  
  protected ArrayList<ActiveProcess> _getStatechartList(final IfElseStat statement, final int contextStateId, final String contextLabel) {
    String newThenContextLabel = null;
    int index = contextLabel.lastIndexOf("]");
    if ((index != (-1))) {
      String _substring = contextLabel.substring(0, index);
      String _plus = (_substring + " &amp;&amp; (");
      String _translateExpr = this.translateExpr(statement.getCond());
      String _plus_1 = (_plus + _translateExpr);
      String _plus_2 = (_plus_1 + ") ]");
      newThenContextLabel = _plus_2;
    } else {
      String _translateExpr_1 = this.translateExpr(statement.getCond());
      String _plus_3 = ((contextLabel + "[ (") + _translateExpr_1);
      String _plus_4 = (_plus_3 + ") ]");
      newThenContextLabel = _plus_4;
    }
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    ArrayList<ActiveProcess> procTempThenList = this.getStatechartList(statement.getThen(), contextStateId, newThenContextLabel);
    ArrayList<ActiveProcess> procTempElseList = new ArrayList<ActiveProcess>();
    Statement _else = statement.getElse();
    boolean _tripleNotEquals = (_else != null);
    if (_tripleNotEquals) {
      String newElseContextLabel = null;
      if ((index != (-1))) {
        String _substring_1 = contextLabel.substring(0, index);
        String _plus_5 = (_substring_1 + " &amp;&amp; !(");
        String _translateExpr_2 = this.translateExpr(statement.getCond());
        String _plus_6 = (_plus_5 + _translateExpr_2);
        String _plus_7 = (_plus_6 + ") ]");
        newElseContextLabel = _plus_7;
      } else {
        String _translateExpr_3 = this.translateExpr(statement.getCond());
        String _plus_8 = ((contextLabel + "[ !(") + _translateExpr_3);
        String _plus_9 = (_plus_8 + ") ]");
        newElseContextLabel = _plus_9;
      }
      procTempElseList = this.getStatechartList(statement.getElse(), contextStateId, newElseContextLabel);
    }
    procTempList.addAll(procTempThenList);
    procTempList.addAll(procTempElseList);
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getStatechartList(final CompoundStatement statement, final int contextStateId, final String contextLabel) {
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    EList<Statement> _statements = statement.getStatements();
    for (final Statement s : _statements) {
      {
        ArrayList<ActiveProcess> subProcList = this.getStatechartList(s, contextStateId, contextLabel);
        procTempList.addAll(subProcList);
      }
    }
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getStatechartList(final SetStateStat statement, final int contextStateId, final String contextLabel) {
    String finishEdgeLabel = null;
    finishEdgeLabel = (contextLabel + ")");
    ActiveProcess tempElem = new ActiveProcess();
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    tempElem.setIdFrom(contextStateId);
    boolean _isNext = statement.isNext();
    if (_isNext) {
      tempElem.setIdTo((contextStateId + 1));
    } else {
      tempElem.setIdTo(this.procId.indexOf(statement.getStateId()));
    }
    tempElem.setAction(finishEdgeLabel);
    procTempList.add(tempElem);
    return procTempList;
  }
  
  public String translateExpr(final Expression expr) {
    StringConcatenation _builder = new StringConcatenation();
    String _trim = NodeModelUtils.getNode(expr).getText().trim();
    _builder.append(_trim);
    return _builder.toString();
  }
  
  public ArrayList<ActiveProcess> getStatechartList(final Statement statement, final int contextStateId, final String contextLabel) {
    if (statement instanceof CompoundStatement) {
      return _getStatechartList((CompoundStatement)statement, contextStateId, contextLabel);
    } else if (statement instanceof IfElseStat) {
      return _getStatechartList((IfElseStat)statement, contextStateId, contextLabel);
    } else if (statement instanceof SetStateStat) {
      return _getStatechartList((SetStateStat)statement, contextStateId, contextLabel);
    } else if (statement != null) {
      return _getStatechartList(statement, contextStateId, contextLabel);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(statement, contextStateId, contextLabel).toString());
    }
  }
}
