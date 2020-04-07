package ru.iaie.reflex.diagram.generator;

import java.util.ArrayList;
import ru.iaie.reflex.diagram.generator.ActiveProcess;

@SuppressWarnings("all")
public class ProcessDiagramGenerator {
  protected int count_id = 0;
  
  protected ArrayList<ActiveProcess> procList = new ArrayList<ActiveProcess>();
  
  protected ArrayList<String> procId = new ArrayList<String>();
  
  public boolean addElementToProcList(final ActiveProcess elem) {
    return this.procList.add(elem);
  }
  
  public boolean addAllElementsToProcList(final ArrayList<ActiveProcess> list) {
    return this.procList.addAll(list);
  }
  
  public boolean addElementToProcId(final String elem) {
    return this.procId.add(elem);
  }
  
  public void addElementToProcId(final int index, final String elem) {
    this.procId.add(index, elem);
  }
  
  public String getElementProcId(final int index) {
    return this.procId.get(index);
  }
  
  public int getElementIndexProcId(final String elem) {
    return this.procId.indexOf(elem);
  }
  
  public int zeroCountId() {
    return this.count_id = 0;
  }
  
  public int incrementCountId() {
    return this.count_id++;
  }
  
  public int getCountId() {
    return this.count_id;
  }
  
  public void clear() {
    this.procList.clear();
    this.count_id = 0;
    this.procId.clear();
  }
}
