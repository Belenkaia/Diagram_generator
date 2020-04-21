package ru.iaie.reflex.diagram.generator;

import java.util.ArrayList;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import ru.iaie.reflex.diagram.generator.ActiveProcess;
import ru.iaie.reflex.diagram.generator.DiagramNode;
import ru.iaie.reflex.diagram.generator.ProcessDiagramGenerator;
import ru.iaie.reflex.diagram.reflex.AssignmentExpression;
import ru.iaie.reflex.diagram.reflex.CompoundStatement;
import ru.iaie.reflex.diagram.reflex.Expression;
import ru.iaie.reflex.diagram.reflex.ExpressionStatement;
import ru.iaie.reflex.diagram.reflex.IfElseStat;
import ru.iaie.reflex.diagram.reflex.SetStateStat;
import ru.iaie.reflex.diagram.reflex.State;
import ru.iaie.reflex.diagram.reflex.Statement;
import ru.iaie.reflex.diagram.reflex.TimeoutFunction;

@SuppressWarnings("all")
public class StatechartDiagramGenerator extends ProcessDiagramGenerator {
  public void getStatechartNodes(final ru.iaie.reflex.diagram.reflex.Process process) {
    DiagramNode newNode = new DiagramNode("   ", "circle");
    this.addElementToProcId(newNode);
    EList<State> _states = process.getStates();
    for (final State state : _states) {
      {
        String _name = state.getName();
        DiagramNode tmpNode = new DiagramNode(_name);
        this.addElementToProcId(tmpNode);
      }
    }
  }
  
  public void generateStatechartDiagramModel(final Resource resource, final ru.iaie.reflex.diagram.reflex.Process process) {
    this.getStatechartNodes(process);
    this.generateStatechartModel(resource, process);
  }
  
  public CharSequence generateStatechartDiagram(final ru.iaie.reflex.diagram.reflex.Process process) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeHeadGML = this.gmlTextGenerator.writeHeadGML(this);
    _builder.append(_writeHeadGML);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateNodes = this.gmlTextGenerator.generateNodes(this);
    _builder.append(_generateNodes, "\t");
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
              startNode.setIdFrom(this.getElementIndexProcId("   "));
              startNode.setIdTo(this.getElementIndexProcId(state.getName()));
              this.procList.add(startNode);
            }
            ArrayList<ActiveProcess> tempProcList = null;
            tempProcList = this.getStatechartList(statement, this.getElementIndexProcId(state.getName()), "(", "");
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
              String _ticks = state.getTimeoutFunction().getTime().getTicks();
              String _plus = ("(Timeout [ time = " + _ticks);
              String contextLabel = (_plus + "ticks ]");
              ArrayList<ActiveProcess> tempProcList = null;
              tempProcList = this.getStatechartList(timeoutFunctionStatements, this.getElementIndexProcId(state.getName()), contextLabel, "");
              this.procList.addAll(tempProcList);
            }
          }
        }
      }
    }
  }
  
  protected ArrayList<ActiveProcess> _getStatechartList(final Statement statement, final int contextStateId, final String contextLabel, final String expressionStatement) {
    return new ArrayList<ActiveProcess>();
  }
  
  protected ArrayList<ActiveProcess> _getStatechartList(final IfElseStat statement, final int contextStateId, final String contextLabel, final String expressionStatement) {
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
    String newExprLabel = "";
    newExprLabel = this.getContextLabel(statement.getThen(), contextStateId, newThenContextLabel, newExprLabel);
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    ArrayList<ActiveProcess> procTempThenList = this.getStatechartList(statement.getThen(), contextStateId, newThenContextLabel, newExprLabel);
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
      newExprLabel = "";
      newExprLabel = this.getContextLabel(statement.getElse(), contextStateId, newElseContextLabel, newExprLabel);
      procTempElseList = this.getStatechartList(statement.getElse(), contextStateId, newElseContextLabel, newExprLabel);
    }
    procTempList.addAll(procTempThenList);
    procTempList.addAll(procTempElseList);
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getStatechartList(final CompoundStatement statement, final int contextStateId, final String contextLabel, final String expressionStatement) {
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    String newExprLabel = expressionStatement;
    EList<Statement> _statements = statement.getStatements();
    for (final Statement s : _statements) {
      newExprLabel = this.getContextLabel(s, contextStateId, contextLabel, newExprLabel);
    }
    EList<Statement> _statements_1 = statement.getStatements();
    for (final Statement s_1 : _statements_1) {
      {
        ArrayList<ActiveProcess> subProcList = this.getStatechartList(s_1, contextStateId, contextLabel, newExprLabel);
        procTempList.addAll(subProcList);
      }
    }
    return procTempList;
  }
  
  protected String _getContextLabel(final ExpressionStatement statement, final int contextStateId, final String contextLabel, final String expressionStatement) {
    String newExprContextLabel = "";
    int _length = expressionStatement.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      String _expression = this.getExpression(statement.getExpr());
      String _plus = ((expressionStatement + "; ") + _expression);
      newExprContextLabel = _plus;
    } else {
      String _expression_1 = this.getExpression(statement.getExpr());
      String _plus_1 = (expressionStatement + _expression_1);
      newExprContextLabel = _plus_1;
    }
    return newExprContextLabel;
  }
  
  protected String _getContextLabel(final Statement statement, final int contextStateId, final String contextLabel, final String expressionStatement) {
    return expressionStatement;
  }
  
  protected ArrayList<ActiveProcess> _getStatechartList(final SetStateStat statement, final int contextStateId, final String contextLabel, final String expressionStatement) {
    String finishEdgeLabel = null;
    int _length = expressionStatement.length();
    boolean _greaterThan = (_length > 0);
    if (_greaterThan) {
      finishEdgeLabel = (((contextLabel + "/") + expressionStatement) + ")");
    } else {
      finishEdgeLabel = (contextLabel + ")");
    }
    ActiveProcess tempElem = new ActiveProcess();
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    tempElem.setIdFrom(contextStateId);
    boolean _isNext = statement.isNext();
    if (_isNext) {
      tempElem.setIdTo((contextStateId + 1));
    } else {
      tempElem.setIdTo(this.getElementIndexProcId(statement.getStateId()));
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
  
  protected String _getExpression(final Expression expr) {
    return "";
  }
  
  protected String _getExpression(final AssignmentExpression expr) {
    StringConcatenation _builder = new StringConcatenation();
    String _trim = NodeModelUtils.getNode(expr).getText().trim();
    _builder.append(_trim);
    return _builder.toString();
  }
  
  public ArrayList<ActiveProcess> getStatechartList(final Statement statement, final int contextStateId, final String contextLabel, final String expressionStatement) {
    if (statement instanceof CompoundStatement) {
      return _getStatechartList((CompoundStatement)statement, contextStateId, contextLabel, expressionStatement);
    } else if (statement instanceof IfElseStat) {
      return _getStatechartList((IfElseStat)statement, contextStateId, contextLabel, expressionStatement);
    } else if (statement instanceof SetStateStat) {
      return _getStatechartList((SetStateStat)statement, contextStateId, contextLabel, expressionStatement);
    } else if (statement != null) {
      return _getStatechartList(statement, contextStateId, contextLabel, expressionStatement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(statement, contextStateId, contextLabel, expressionStatement).toString());
    }
  }
  
  public String getContextLabel(final Statement statement, final int contextStateId, final String contextLabel, final String expressionStatement) {
    if (statement instanceof ExpressionStatement) {
      return _getContextLabel((ExpressionStatement)statement, contextStateId, contextLabel, expressionStatement);
    } else if (statement != null) {
      return _getContextLabel(statement, contextStateId, contextLabel, expressionStatement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(statement, contextStateId, contextLabel, expressionStatement).toString());
    }
  }
  
  public String getExpression(final Expression expr) {
    if (expr instanceof AssignmentExpression) {
      return _getExpression((AssignmentExpression)expr);
    } else if (expr != null) {
      return _getExpression(expr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expr).toString());
    }
  }
}
