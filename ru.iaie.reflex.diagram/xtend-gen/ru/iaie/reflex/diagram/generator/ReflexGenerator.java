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
  private final String WORKING_DIRECTORY = "D:\\GitHub\\runtime-EclipseXtext\\test\\src-gen";
  
  private final String STATECHART_FILE_NAME_TAIL = "_statechart_diagram.gml";
  
  private ActivityDiagramGenerator activityDiagramGenerator = new ActivityDiagramGenerator();
  
  private DataDiagramGenerator dataDiagramGenerator = new DataDiagramGenerator();
  
  private StatechartDiagramGenerator statechartDiagramGenerator = new StatechartDiagramGenerator();
  
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    fsa.generateFile("data_diagram.gml", this.dataDiagramGenerator.generateDataDiagram(resource));
    this.dataDiagramGenerator.clear();
    System.out.print("Generate statechart GML diagrams...");
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process process : _filter) {
      {
        String _name = process.getName();
        String _plus = (_name + this.STATECHART_FILE_NAME_TAIL);
        fsa.generateFile(_plus, this.statechartDiagramGenerator.generateStatechartDiagram(resource, process));
        this.statechartDiagramGenerator.clear();
      }
    }
    System.out.println("done.");
    fsa.generateFile("activity_diagram.gml", this.activityDiagramGenerator.generateActivityDiagram(resource));
    fsa.generateFile("activity_diagram.graphml", this.activityDiagramGenerator.generateActivityGraphMLDiagram(resource, this.WORKING_DIRECTORY, this.STATECHART_FILE_NAME_TAIL));
    this.activityDiagramGenerator.clear();
  }
}
