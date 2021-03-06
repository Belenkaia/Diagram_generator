/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.diagram.reflex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infix Op</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.InfixOp#getOp <em>Op</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.InfixOp#getVarId <em>Var Id</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getInfixOp()
 * @model
 * @generated
 */
public interface InfixOp extends UnaryExpression
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * The literals are from the enumeration {@link ru.iaie.reflex.diagram.reflex.InfixPostfixOp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see ru.iaie.reflex.diagram.reflex.InfixPostfixOp
   * @see #setOp(InfixPostfixOp)
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getInfixOp_Op()
   * @model
   * @generated
   */
  InfixPostfixOp getOp();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.diagram.reflex.InfixOp#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see ru.iaie.reflex.diagram.reflex.InfixPostfixOp
   * @see #getOp()
   * @generated
   */
  void setOp(InfixPostfixOp value);

  /**
   * Returns the value of the '<em><b>Var Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Var Id</em>' attribute.
   * @see #setVarId(String)
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getInfixOp_VarId()
   * @model
   * @generated
   */
  String getVarId();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.diagram.reflex.InfixOp#getVarId <em>Var Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Var Id</em>' attribute.
   * @see #getVarId()
   * @generated
   */
  void setVarId(String value);

} // InfixOp
