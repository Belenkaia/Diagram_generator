package ru.iaie.reflex.diagram.generator;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.diagram.generator.ActiveProcess;
import ru.iaie.reflex.diagram.reflex.CType;
import ru.iaie.reflex.diagram.reflex.DeclaredVariable;
import ru.iaie.reflex.diagram.reflex.IfElseStat;
import ru.iaie.reflex.diagram.reflex.ImportedVariable;
import ru.iaie.reflex.diagram.reflex.PhysicalVariable;
import ru.iaie.reflex.diagram.reflex.ProgramVariable;
import ru.iaie.reflex.diagram.reflex.ReflexType;
import ru.iaie.reflex.diagram.reflex.StartProcStat;
import ru.iaie.reflex.diagram.reflex.State;
import ru.iaie.reflex.diagram.reflex.Statement;
import ru.iaie.reflex.diagram.reflex.StopProcStat;
import ru.iaie.reflex.diagram.reflex.Variable;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class ReflexGenerator extends AbstractGenerator {
  private int count_id = 0;
  
  private ArrayList<ActiveProcess> procList = new ArrayList<ActiveProcess>();
  
  private ArrayList<Object> procId = new ArrayList<Object>();
  
  private HashMap<String, Integer> variableId = new HashMap<String, Integer>();
  
  public void increaseProcessId() {
    this.count_id++;
  }
  
  public void NullProcessId() {
    this.count_id = 0;
  }
  
  public CharSequence writeHeadGML() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Creator\t\"tranlator\"");
    _builder.newLine();
    _builder.append("Version\t\"2.15\"");
    _builder.newLine();
    _builder.append("graph");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("hierarchic\t1");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("label\t\"\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("directed\t1");
    this.NullProcessId();
    _builder.newLineIfNotEmpty();
    return _builder;
  }
  
  public CharSequence generateNodeGraphics(final int nameLength, final String typeOfNode) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("graphics");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("w\t");
    _builder.append((nameLength * 10), "\t");
    _builder.append(".0");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("h\t48.0");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type\t\"");
    _builder.append(typeOfNode, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("raisedBorder\t0");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fill\t\"#FFFFFF\"");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("outline\t\"#000000\"");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateLabelGraphics(final String label) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("LabelGraphics");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("text\t\"");
    _builder.append(label, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("fontSize\t12");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("fontName\t\"Dialog\"");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generateOneProcessNode(final int processId, final String processName, final String typeOfNode) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("node");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("id\t");
    _builder.append(processId, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("label\t\"");
    _builder.append(processName, "\t");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("    ");
    CharSequence _generateNodeGraphics = this.generateNodeGraphics(processName.length(), typeOfNode);
    _builder.append(_generateNodeGraphics, "    ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    CharSequence _generateLabelGraphics = this.generateLabelGraphics(processName);
    _builder.append(_generateLabelGraphics, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public String generateProcessNodes(final Resource resource, final int diagrammFlag) {
    String tempString = "";
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process e : _filter) {
      {
        if ((diagrammFlag == 0)) {
          String _tempString = tempString;
          CharSequence _generateOneProcessNode = this.generateOneProcessNode(this.count_id, e.getName(), "roundrectangle");
          tempString = (_tempString + _generateOneProcessNode);
        }
        if ((diagrammFlag == 1)) {
          String _tempString_1 = tempString;
          CharSequence _generateOneProcessNode_1 = this.generateOneProcessNode(this.count_id, e.getName(), "ellipse");
          tempString = (_tempString_1 + _generateOneProcessNode_1);
        }
        this.procId.add(this.count_id, e.getName());
        this.increaseProcessId();
      }
    }
    return tempString;
  }
  
  public CharSequence generateActivityDiagram(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeHeadGML = this.writeHeadGML();
    _builder.append(_writeHeadGML);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateProcessNodes = this.generateProcessNodes(resource, 0);
    _builder.append(_generateProcessNodes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    this.constructActiveModel(resource);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    this.checkProcList();
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateAllEdges = this.generateAllEdges();
    _builder.append(_generateAllEdges, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    return _builder;
  }
  
  public CharSequence generateOneEdge(final int fromId, final int toId, final String label) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("edge");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("source\t");
    _builder.append(fromId, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("target\t");
    _builder.append(toId, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("label\t\"");
    _builder.append(label, "\t");
    _builder.append("\"");
    System.out.println(((("generate edge from " + Integer.valueOf(fromId)) + " to ") + Integer.valueOf(toId)));
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public String generateAllEdges() {
    String tempString = "";
    for (int i = 0; (i < this.procList.size()); i++) {
      String _tempString = tempString;
      CharSequence _generateOneEdge = this.generateOneEdge(this.procList.get(i).getIdFrom(), this.procList.get(i).getIdTo(), this.procList.get(i).getAction());
      tempString = (_tempString + _generateOneEdge);
    }
    return tempString;
  }
  
  public void checkProcList() {
    for (final ActiveProcess proc : this.procList) {
      int _idFrom = proc.getIdFrom();
      String _plus = ("proc " + Integer.valueOf(_idFrom));
      String _plus_1 = (_plus + " ");
      String _action = proc.getAction();
      String _plus_2 = (_plus_1 + _action);
      String _plus_3 = (_plus_2 + " ");
      int _idTo = proc.getIdTo();
      String _plus_4 = (_plus_3 + Integer.valueOf(_idTo));
      System.out.print(_plus_4);
    }
  }
  
  public void constructActiveModel(final Resource resource) {
    for (int i = 0; (i < this.procId.size()); i++) {
      String _plus = (Integer.valueOf(i) + ":");
      Object _get = this.procId.get(i);
      String _plus_1 = (_plus + _get);
      String _plus_2 = (_plus_1 + ", ");
      System.out.print(_plus_2);
    }
    System.out.println();
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process process : _filter) {
      EList<State> _states = process.getStates();
      for (final State state : _states) {
        EList<Statement> _statements = state.getStatements();
        for (final Statement statement : _statements) {
          {
            ArrayList<ActiveProcess> tempProcList = null;
            try {
              tempProcList = this.getActiveList(statement);
            } catch (final Throwable _t) {
              if (_t instanceof IllegalArgumentException) {
                final IllegalArgumentException ex = (IllegalArgumentException)_t;
                System.out.println(ex);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            if ((tempProcList != null)) {
              for (final ActiveProcess elem : tempProcList) {
                {
                  elem.setIdFrom(this.procId.indexOf(process.getName()));
                  int _idTo = elem.getIdTo();
                  boolean _equals = (_idTo == (-1));
                  if (_equals) {
                    elem.setIdTo(this.procId.indexOf(process.getName()));
                  }
                  this.procList.add(elem);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public String getVariablesNodes(final Resource resource) {
    String tempStr = "";
    Iterable<DeclaredVariable> _filter = Iterables.<DeclaredVariable>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), DeclaredVariable.class);
    for (final DeclaredVariable variable : _filter) {
      {
        String _tempStr = tempStr;
        CharSequence _generateOneProcessNode = this.generateOneProcessNode(this.count_id, this.getVariableNameAndType(variable), "roundrectangle");
        tempStr = (_tempStr + _generateOneProcessNode);
        this.variableId.put(variable.getName(), Integer.valueOf(this.count_id));
        this.increaseProcessId();
      }
    }
    return tempStr;
  }
  
  public void generateDataModel(final Resource resource) {
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process process : _filter) {
      EList<Variable> _variable = process.getVariable();
      for (final Variable vars : _variable) {
        {
          ArrayList<String> tempNames = this.getVariableName(vars);
          for (final String varName : tempNames) {
            {
              ActiveProcess node = new ActiveProcess();
              node.setIdFrom(this.procId.indexOf(process.getName()));
              node.setIdTo((this.variableId.get(varName)).intValue());
              node.setAction(this.getVariableAction(vars));
              this.procList.add(node);
            }
          }
        }
      }
    }
  }
  
  protected ArrayList<String> _getVariableName(final DeclaredVariable variable) {
    ArrayList<String> nameList = new ArrayList<String>();
    nameList.add(variable.getName());
    return nameList;
  }
  
  protected ArrayList<String> _getVariableName(final ImportedVariable variable) {
    ArrayList<String> nameList = new ArrayList<String>();
    EList<String> _varNames = variable.getVarNames();
    for (final String vars : _varNames) {
      nameList.add(vars);
    }
    return nameList;
  }
  
  protected String _getVariableAction(final DeclaredVariable variable) {
    return "declare";
  }
  
  protected String _getVariableAction(final ImportedVariable variable) {
    return "import";
  }
  
  protected String _getVariableNameAndType(final ProgramVariable variable) {
    String _signed = this.getSigned(variable.getType());
    String _plus = (_signed + " ReflexType : ");
    String _plus_1 = (_plus + " ");
    String _name = variable.getName();
    return (_plus_1 + _name);
  }
  
  protected String _getVariableNameAndType(final PhysicalVariable variable) {
    String _type = variable.getType();
    String _plus = (_type + " : ");
    String _name = variable.getName();
    return (_plus + _name);
  }
  
  protected String _getReflexType(final CType type) {
    return type.toString();
  }
  
  protected String _getReflexType(final ReflexType type) {
    return "ReflexType";
  }
  
  protected String _getSigned(final ReflexType type) {
    return "";
  }
  
  protected String _getSigned(final CType type) {
    boolean _isSignSpec = type.isSignSpec();
    if (_isSignSpec) {
      return "unsigned";
    } else {
      return "signed";
    }
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final StartProcStat statement) {
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    ActiveProcess proc = new ActiveProcess();
    proc.setAction("start");
    proc.setIdFrom((-1));
    proc.setIdTo(this.procId.indexOf(statement.getProcId()));
    procTempList.add(proc);
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final StopProcStat statement) {
    ArrayList<ActiveProcess> procTempList = new ArrayList<ActiveProcess>();
    ActiveProcess proc = new ActiveProcess();
    proc.setAction("stop");
    proc.setIdFrom((-1));
    String _procId = statement.getProcId();
    boolean _tripleNotEquals = (_procId != null);
    if (_tripleNotEquals) {
      proc.setIdTo(this.procId.indexOf(statement.getProcId()));
    } else {
      proc.setIdTo((-1));
    }
    procTempList.add(proc);
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final IfElseStat statement) {
    ArrayList<ActiveProcess> procTempList = null;
    Statement _then = statement.getThen();
    String _plus = ("then: " + _then);
    System.out.println(_plus);
    Statement _else = statement.getElse();
    String _plus_1 = ("else: " + _else);
    System.out.println(_plus_1);
    ArrayList<ActiveProcess> procTempThenList = this.getActiveList(statement.getThen());
    ArrayList<ActiveProcess> procTempElseList = null;
    Statement _else_1 = statement.getElse();
    boolean _tripleNotEquals = (_else_1 != null);
    if (_tripleNotEquals) {
      procTempElseList = this.getActiveList(statement.getElse());
    }
    if ((procTempThenList != null)) {
      for (final ActiveProcess l : procTempThenList) {
        procTempList.add(l);
      }
    }
    if ((procTempElseList != null)) {
      for (final ActiveProcess l_1 : procTempElseList) {
        procTempList.add(l_1);
      }
    }
    return procTempList;
  }
  
  protected ArrayList<ActiveProcess> _getActiveList(final Statement statement) {
    return null;
  }
  
  public CharSequence generateDataDiagram(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeHeadGML = this.writeHeadGML();
    _builder.append(_writeHeadGML);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateProcessNodes = this.generateProcessNodes(resource, 1);
    _builder.append(_generateProcessNodes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _variablesNodes = this.getVariablesNodes(resource);
    _builder.append(_variablesNodes, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    this.generateDataModel(resource);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateAllEdges = this.generateAllEdges();
    _builder.append(_generateAllEdges, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    return _builder;
  }
  
  public void clear() {
    this.procList.clear();
    this.NullProcessId();
    this.procId.clear();
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    fsa.generateFile("activity_diagram.gml", this.generateActivityDiagram(resource));
    this.clear();
    fsa.generateFile("data_diagram.gml", this.generateDataDiagram(resource));
    this.clear();
  }
  
  public ArrayList<String> getVariableName(final Variable variable) {
    if (variable instanceof DeclaredVariable) {
      return _getVariableName((DeclaredVariable)variable);
    } else if (variable instanceof ImportedVariable) {
      return _getVariableName((ImportedVariable)variable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(variable).toString());
    }
  }
  
  public String getVariableAction(final Variable variable) {
    if (variable instanceof DeclaredVariable) {
      return _getVariableAction((DeclaredVariable)variable);
    } else if (variable instanceof ImportedVariable) {
      return _getVariableAction((ImportedVariable)variable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(variable).toString());
    }
  }
  
  public String getVariableNameAndType(final DeclaredVariable variable) {
    if (variable instanceof PhysicalVariable) {
      return _getVariableNameAndType((PhysicalVariable)variable);
    } else if (variable instanceof ProgramVariable) {
      return _getVariableNameAndType((ProgramVariable)variable);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(variable).toString());
    }
  }
  
  public String getReflexType(final ReflexType type) {
    if (type instanceof CType) {
      return _getReflexType((CType)type);
    } else if (type != null) {
      return _getReflexType(type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
  
  public String getSigned(final ReflexType type) {
    if (type instanceof CType) {
      return _getSigned((CType)type);
    } else if (type != null) {
      return _getSigned(type);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(type).toString());
    }
  }
  
  public ArrayList<ActiveProcess> getActiveList(final Statement statement) {
    if (statement instanceof IfElseStat) {
      return _getActiveList((IfElseStat)statement);
    } else if (statement instanceof StartProcStat) {
      return _getActiveList((StartProcStat)statement);
    } else if (statement instanceof StopProcStat) {
      return _getActiveList((StopProcStat)statement);
    } else if (statement != null) {
      return _getActiveList(statement);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(statement).toString());
    }
  }
}
