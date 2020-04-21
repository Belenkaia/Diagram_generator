package ru.iaie.reflex.diagram.generator;

import java.util.ArrayList;
import java.util.HashMap;
import ru.iaie.reflex.diagram.generator.ActiveProcess;
import ru.iaie.reflex.diagram.generator.DiagramNode;

@SuppressWarnings("all")
public class ResultOfSeparation {
  private ArrayList<ArrayList<ActiveProcess>> diagramComponents;
  
  private ArrayList<HashMap<String, DiagramNode>> diagramComponentNodes;
  
  public ArrayList<ArrayList<ActiveProcess>> getDiagramComponents() {
    return this.diagramComponents;
  }
  
  public ArrayList<HashMap<String, DiagramNode>> getDiagramComponentNodes() {
    return this.diagramComponentNodes;
  }
  
  public ArrayList<ArrayList<ActiveProcess>> setDiagramComponents(final ArrayList<ArrayList<ActiveProcess>> components) {
    return this.diagramComponents = components;
  }
  
  public ArrayList<HashMap<String, DiagramNode>> setDiagramComponentNodes(final ArrayList<HashMap<String, DiagramNode>> compNodes) {
    return this.diagramComponentNodes = compNodes;
  }
}
