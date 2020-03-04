package ru.iaie.reflex.diagram.generator;

@SuppressWarnings("all")
public class ActiveProcess {
  private int idFrom = 0;
  
  private int idTo = 0;
  
  private String action = "";
  
  /**
   * new (int idF, int idT, String act)
   * {
   * idFrom = idF
   * idTo = idT
   * action = act
   * }
   */
  public void setAction(final String act) {
    this.action = act;
  }
  
  public void setIdFrom(final int id) {
    this.idFrom = id;
  }
  
  public void setIdTo(final int id) {
    this.idTo = id;
  }
  
  public String getAction() {
    return this.action;
  }
  
  public int getIdFrom() {
    return this.idFrom;
  }
  
  public int getIdTo() {
    return this.idTo;
  }
}
