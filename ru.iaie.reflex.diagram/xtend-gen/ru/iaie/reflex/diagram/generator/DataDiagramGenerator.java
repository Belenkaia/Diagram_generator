package ru.iaie.reflex.diagram.generator;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.diagram.generator.ActiveProcess;
import ru.iaie.reflex.diagram.generator.DiagramNode;
import ru.iaie.reflex.diagram.generator.ProcessDiagramGraphMLGenerator;
import ru.iaie.reflex.diagram.reflex.CType;
import ru.iaie.reflex.diagram.reflex.DeclaredVariable;
import ru.iaie.reflex.diagram.reflex.ImportedVariable;
import ru.iaie.reflex.diagram.reflex.PhysicalVariable;
import ru.iaie.reflex.diagram.reflex.ProgramVariable;
import ru.iaie.reflex.diagram.reflex.ReflexType;
import ru.iaie.reflex.diagram.reflex.Variable;

@SuppressWarnings("all")
public class DataDiagramGenerator extends ProcessDiagramGraphMLGenerator {
  private HashMap<String, Integer> variableId = new HashMap<String, Integer>();
  
  public int getVariablesNodes(final Resource resource) {
    int _xblockexpression = (int) 0;
    {
      this.count_id = this.procId.size();
      Iterable<DeclaredVariable> _filter = Iterables.<DeclaredVariable>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), DeclaredVariable.class);
      for (final DeclaredVariable variable : _filter) {
        {
          String _variableNameAndType = this.getVariableNameAndType(variable);
          DiagramNode newNode = new DiagramNode(_variableNameAndType, "ellipse");
          this.addElementToProcId(newNode);
          this.variableId.put(variable.getName(), Integer.valueOf((this.count_id - 1)));
        }
      }
      _xblockexpression = this.zeroCountId();
    }
    return _xblockexpression;
  }
  
  /**
   * def getVariablesNodesGraphML(Resource resource)
   * {
   * var String tempStr = "";
   * for (variable : resource.allContents.toIterable.filter(DeclaredVariable)) // идем по объявленным переменным
   * {
   * tempStr += graphMLTextGenerator.nodeGraphMLGenerate(count_id, variable.getVariableNameAndType(), "ellipse", "")
   * variableId.put(variable.name, count_id) // запоминаем соответствие имени переменной назначенной ее вершине Id
   * incrementCountId() // инкрементируем счетчик вершин (это число будет Id для вершины следующей вершины)
   * }
   * return tempStr;
   * }
   */
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
              node.setIdFrom(this.getElementIndexProcId(process.getName()));
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
    nameList.addAll(variable.getVarNames());
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
    String _plus = (_signed + " ");
    String _type = this.getType(variable.getType());
    String _plus_1 = (_plus + _type);
    String _plus_2 = (_plus_1 + " :");
    String _name = variable.getName();
    return (_plus_2 + _name);
  }
  
  public String getType(final ReflexType type) {
    StringConcatenation _builder = new StringConcatenation();
    String _trim = NodeModelUtils.getNode(type).getText().trim();
    _builder.append(_trim);
    return _builder.toString();
  }
  
  protected String _getVariableNameAndType(final PhysicalVariable variable) {
    String _type = variable.getType();
    String _plus = (_type + " : ");
    String _name = variable.getName();
    return (_plus + _name);
  }
  
  protected String _getSigned(final ReflexType type) {
    return "";
  }
  
  protected String _getSigned(final CType type) {
    boolean _isSignSpec = type.isSignSpec();
    if (_isSignSpec) {
      return "unsigned";
    } else {
      return "";
    }
  }
  
  public void generateDataDiagramModel(final Resource resource) {
    this.generateProcList(resource);
    this.getVariablesNodes(resource);
    this.generateDataModel(resource);
  }
  
  public String generateDataDiagram(final HashMap<String, DiagramNode> nodesId, final ArrayList<ActiveProcess> diagramModel) {
    String result = "";
    System.out.print("Generate GML data diagram...");
    this.procId = nodesId;
    this.procList = diagramModel;
    String _result = result;
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeHeadGML = this.gmlTextGenerator.writeHeadGML(this);
    _builder.append(_writeHeadGML);
    _builder.newLineIfNotEmpty();
    result = (_result + _builder);
    String _result_1 = result;
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("\t");
    String _generateNodes = this.gmlTextGenerator.generateNodes(this);
    _builder_1.append(_generateNodes, "\t");
    _builder_1.newLineIfNotEmpty();
    result = (_result_1 + _builder_1);
    String _result_2 = result;
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("\t");
    String _generateAllEdges = this.gmlTextGenerator.generateAllEdges(diagramModel);
    _builder_2.append(_generateAllEdges, "\t");
    _builder_2.newLineIfNotEmpty();
    result = (_result_2 + _builder_2);
    String _result_3 = result;
    result = (_result_3 + "]");
    System.out.println("done.");
    return result;
  }
  
  public String generateDataGraphMLDiagram(final HashMap<String, DiagramNode> nodesId, final ArrayList<ActiveProcess> diagramModel, final String url, final String statechartFileNameTail) {
    String result = "";
    System.out.print("Generate GraphML data diagram...");
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
}
