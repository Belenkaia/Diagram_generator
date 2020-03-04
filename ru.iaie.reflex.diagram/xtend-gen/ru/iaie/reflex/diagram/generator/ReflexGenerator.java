package ru.iaie.reflex.diagram.generator;

import com.google.common.collect.Iterables;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.diagram.generator.ActiveProcess;
import ru.iaie.reflex.diagram.reflex.StartProcStat;
import ru.iaie.reflex.diagram.reflex.State;
import ru.iaie.reflex.diagram.reflex.StateFunction;
import ru.iaie.reflex.diagram.reflex.StopProcStat;

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
  
  public CharSequence generateNodeGraphics(final int nameLength) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("graphics");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("w\t");
    _builder.append(((nameLength * 5) + 25), "\t");
    _builder.append(".0");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("h\t48.0");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("type\t\"roundrectangle\"");
    _builder.newLine();
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
  
  public CharSequence generateLabelGraphics(final String processName) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("LabelGraphics");
    _builder.newLine();
    _builder.append("[");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("text\t\"");
    _builder.append(processName, "\t");
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
  
  public CharSequence generateOneProcessNode(final int processId, final String processName) {
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
    CharSequence _generateNodeGraphics = this.generateNodeGraphics(processName.length());
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
  
  public String generateProcessNodes(final Resource resource) {
    String tempString = "";
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process e : _filter) {
      {
        String _tempString = tempString;
        CharSequence _generateOneProcessNode = this.generateOneProcessNode(this.count_id, e.getName());
        tempString = (_tempString + _generateOneProcessNode);
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
    String _generateProcessNodes = this.generateProcessNodes(resource);
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
        EList<StateFunction> _stateFunction = state.getStateFunction();
        for (final StateFunction i : _stateFunction) {
          EList<EObject> _statements = i.getBody().getStatements();
          for (final EObject e : _statements) {
            {
              int _indexOf = e.getClass().toString().indexOf("StartProcStat");
              boolean _notEquals = (_indexOf != (-1));
              if (_notEquals) {
                Iterable<StartProcStat> _filter_1 = Iterables.<StartProcStat>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), StartProcStat.class);
                for (final StartProcStat statFunction : _filter_1) {
                  boolean _equals = e.equals(statFunction);
                  if (_equals) {
                    String _name = process.getName();
                    String _plus = (" process: " + _name);
                    String _plus_1 = (_plus + "(");
                    int _indexOf_1 = this.procId.indexOf(process.getName());
                    String _plus_2 = (_plus_1 + Integer.valueOf(_indexOf_1));
                    String _plus_3 = (_plus_2 + ")");
                    String _plus_4 = (_plus_3 + "start ");
                    String _procId = statFunction.getProcId();
                    String _plus_5 = (_plus_4 + _procId);
                    String _plus_6 = (_plus_5 + "(");
                    int _indexOf_2 = this.procId.indexOf(statFunction.getProcId());
                    String _plus_7 = (_plus_6 + Integer.valueOf(_indexOf_2));
                    String _plus_8 = (_plus_7 + ")");
                    System.out.println(_plus_8);
                    ActiveProcess proc = new ActiveProcess();
                    proc.setAction("start");
                    proc.setIdFrom(this.procId.indexOf(process.getName()));
                    proc.setIdTo(this.procId.indexOf(statFunction.getProcId()));
                    this.procList.add(proc);
                  }
                }
              }
              int _indexOf_3 = e.getClass().toString().indexOf("StopProcStat");
              boolean _notEquals_1 = (_indexOf_3 != (-1));
              if (_notEquals_1) {
                Iterable<StopProcStat> _filter_2 = Iterables.<StopProcStat>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), StopProcStat.class);
                for (final StopProcStat statFunction_1 : _filter_2) {
                  boolean _equals_1 = e.equals(statFunction_1);
                  if (_equals_1) {
                    int procIdTo = this.procId.indexOf(process.getName());
                    String _procId_1 = statFunction_1.getProcId();
                    boolean _tripleNotEquals = (_procId_1 != null);
                    if (_tripleNotEquals) {
                      procIdTo = this.procId.indexOf(statFunction_1.getProcId());
                    }
                    String _name_1 = process.getName();
                    String _plus_9 = (" process: " + _name_1);
                    String _plus_10 = (_plus_9 + "(");
                    int _indexOf_4 = this.procId.indexOf(process.getName());
                    String _plus_11 = (_plus_10 + Integer.valueOf(_indexOf_4));
                    String _plus_12 = (_plus_11 + ")");
                    String _plus_13 = (_plus_12 + "stop ");
                    String _procId_2 = statFunction_1.getProcId();
                    String _plus_14 = (_plus_13 + _procId_2);
                    String _plus_15 = (_plus_14 + "(");
                    String _plus_16 = (_plus_15 + Integer.valueOf(procIdTo));
                    String _plus_17 = (_plus_16 + ")");
                    System.out.println(_plus_17);
                    ActiveProcess proc_1 = new ActiveProcess();
                    proc_1.setAction("stop");
                    proc_1.setIdFrom(this.procId.indexOf(process.getName()));
                    proc_1.setIdTo(procIdTo);
                    this.procList.add(proc_1);
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    fsa.generateFile("activity_diagram.gml", this.generateActivityDiagram(resource));
    this.procList.clear();
    this.NullProcessId();
    this.procId.clear();
  }
}
