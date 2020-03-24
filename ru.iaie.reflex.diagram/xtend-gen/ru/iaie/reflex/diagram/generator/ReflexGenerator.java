package ru.iaie.reflex.diagram.generator;

import com.google.common.collect.Iterables;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import ru.iaie.reflex.diagram.generator.ActivityDiagramGenerator;
import ru.iaie.reflex.diagram.generator.DataDiagramGenerator;
import ru.iaie.reflex.diagram.generator.StatechartDiagramGenerator;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class ReflexGenerator extends AbstractGenerator {
  private ActivityDiagramGenerator activityDiagramGenerator = new ActivityDiagramGenerator();
  
  private DataDiagramGenerator dataDiagramGenerator = new DataDiagramGenerator();
  
  private StatechartDiagramGenerator statechartDiagramGenerator = new StatechartDiagramGenerator();
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    fsa.generateFile("activity_diagram.gml", this.activityDiagramGenerator.generateActivityDiagram(resource));
    this.activityDiagramGenerator.clear();
    fsa.generateFile("data_diagram.gml", this.dataDiagramGenerator.generateDataDiagram(resource));
    this.dataDiagramGenerator.clear();
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process process : _filter) {
      {
        String _name = process.getName();
        String _plus = (_name + "_statechart_diagram.gml");
        fsa.generateFile(_plus, this.statechartDiagramGenerator.generateStatechartDiagram(resource, process));
        this.statechartDiagramGenerator.clear();
      }
    }
  }
}
