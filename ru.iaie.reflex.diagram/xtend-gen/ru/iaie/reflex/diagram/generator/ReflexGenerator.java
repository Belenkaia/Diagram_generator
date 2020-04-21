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
import ru.iaie.reflex.diagram.generator.ResultOfSeparation;
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
    System.out.print("Generate statechart GML diagrams...");
    Iterable<ru.iaie.reflex.diagram.reflex.Process> _filter = Iterables.<ru.iaie.reflex.diagram.reflex.Process>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), ru.iaie.reflex.diagram.reflex.Process.class);
    for (final ru.iaie.reflex.diagram.reflex.Process process : _filter) {
      {
        this.statechartDiagramGenerator.generateStatechartDiagramModel(resource, process);
        String _name = process.getName();
        String _plus = (_name + this.STATECHART_FILE_NAME_TAIL);
        fsa.generateFile(_plus, this.statechartDiagramGenerator.generateStatechartDiagram(process));
        this.statechartDiagramGenerator.clear();
      }
    }
    System.out.println("done.");
    this.activityDiagramGenerator.generateActivityDiagramModel(resource);
    ResultOfSeparation activityResult = this.activityDiagramGenerator.separateDiadram();
    for (int i = 0; (i < activityResult.getDiagramComponents().size()); i++) {
      {
        fsa.generateFile(((("activity_diagram" + "_") + Integer.valueOf(i)) + ".gml"), this.activityDiagramGenerator.generateActivityDiagram(activityResult.getDiagramComponentNodes().get(i), activityResult.getDiagramComponents().get(i)));
        fsa.generateFile(((("activity_diagram" + "_") + Integer.valueOf(i)) + ".graphml"), this.activityDiagramGenerator.generateActivityGraphMLDiagram(activityResult.getDiagramComponentNodes().get(i), activityResult.getDiagramComponents().get(i), this.WORKING_DIRECTORY, this.STATECHART_FILE_NAME_TAIL));
        this.activityDiagramGenerator.clear();
      }
    }
    this.dataDiagramGenerator.generateDataDiagramModel(resource);
    ResultOfSeparation dataResult = this.dataDiagramGenerator.separateDiadram();
    for (int j = 0; (j < dataResult.getDiagramComponents().size()); j++) {
      {
        fsa.generateFile(((("data_diagram" + "_") + Integer.valueOf(j)) + ".gml"), this.dataDiagramGenerator.generateDataDiagram(dataResult.getDiagramComponentNodes().get(j), dataResult.getDiagramComponents().get(j)));
        fsa.generateFile(((("data_diagram" + "_") + Integer.valueOf(j)) + ".graphml"), this.dataDiagramGenerator.generateDataGraphMLDiagram(dataResult.getDiagramComponentNodes().get(j), dataResult.getDiagramComponents().get(j), this.WORKING_DIRECTORY, this.STATECHART_FILE_NAME_TAIL));
        this.dataDiagramGenerator.clear();
      }
    }
  }
}
