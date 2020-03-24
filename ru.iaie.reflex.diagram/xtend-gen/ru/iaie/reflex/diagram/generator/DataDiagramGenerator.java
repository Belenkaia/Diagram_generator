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
import ru.iaie.reflex.diagram.generator.GMLDiagramGenerator;
import ru.iaie.reflex.diagram.generator.GMLTextGenerator;
import ru.iaie.reflex.diagram.reflex.CType;
import ru.iaie.reflex.diagram.reflex.DeclaredVariable;
import ru.iaie.reflex.diagram.reflex.ImportedVariable;
import ru.iaie.reflex.diagram.reflex.PhysicalVariable;
import ru.iaie.reflex.diagram.reflex.ProgramVariable;
import ru.iaie.reflex.diagram.reflex.ReflexType;
import ru.iaie.reflex.diagram.reflex.Variable;

@SuppressWarnings("all")
public class DataDiagramGenerator extends GMLDiagramGenerator {
  private HashMap<String, Integer> variableId = new HashMap<String, Integer>();
  
  private GMLTextGenerator gmlTextGenerator = new GMLTextGenerator();
  
  public String getVariablesNodes(final Resource resource) {
    String tempStr = "";
    Iterable<DeclaredVariable> _filter = Iterables.<DeclaredVariable>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), DeclaredVariable.class);
    for (final DeclaredVariable variable : _filter) {
      {
        String _tempStr = tempStr;
        CharSequence _generateOneProcessNode = this.gmlTextGenerator.generateOneProcessNode(this.count_id, this.getVariableNameAndType(variable), "ellipse");
        tempStr = (_tempStr + _generateOneProcessNode);
        this.variableId.put(variable.getName(), Integer.valueOf(this.count_id));
        this.incrementCountId();
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
  
  public CharSequence generateDataDiagram(final Resource resource) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _writeHeadGML = this.gmlTextGenerator.writeHeadGML(this);
    _builder.append(_writeHeadGML);
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    String _generateProcessNodes = this.gmlTextGenerator.generateProcessNodes(resource, this);
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
    String _generateAllEdges = this.gmlTextGenerator.generateAllEdges(this.procList);
    _builder.append(_generateAllEdges, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("]");
    return _builder;
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
}
