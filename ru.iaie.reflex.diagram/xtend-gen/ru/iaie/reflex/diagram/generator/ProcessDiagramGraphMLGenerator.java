package ru.iaie.reflex.diagram.generator;

import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.diagram.generator.DiagramNode;
import ru.iaie.reflex.diagram.generator.GraphMLTextGenerator;
import ru.iaie.reflex.diagram.generator.GraphSeparator;
import ru.iaie.reflex.diagram.generator.ProcessDiagramGenerator;
import ru.iaie.reflex.diagram.generator.ResultOfSeparation;

@SuppressWarnings("all")
public class ProcessDiagramGraphMLGenerator extends ProcessDiagramGenerator {
  protected GraphMLTextGenerator graphMLTextGenerator = new GraphMLTextGenerator();
  
  protected GraphSeparator graphSeparator = new GraphSeparator();
  
  public void generateProcList(final Resource resource) {
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process e : _filter) {
      {
        String _name = e.getName();
        DiagramNode newNode = new DiagramNode(_name);
        this.addElementToProcId(newNode);
      }
    }
    this.zeroCountId();
  }
  
  public ResultOfSeparation separateDiadram() {
    return this.graphSeparator.separateGraph(this.procList, this.procId);
  }
}
