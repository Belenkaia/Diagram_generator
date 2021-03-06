/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.diagram.reflex;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Shift Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.ShiftExpression#getShiftOp <em>Shift Op</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getShiftExpression()
 * @model
 * @generated
 */
public interface ShiftExpression extends CompareExpression
{
  /**
   * Returns the value of the '<em><b>Shift Op</b></em>' attribute.
   * The literals are from the enumeration {@link ru.iaie.reflex.diagram.reflex.ShiftOp}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shift Op</em>' attribute.
   * @see ru.iaie.reflex.diagram.reflex.ShiftOp
   * @see #setShiftOp(ShiftOp)
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getShiftExpression_ShiftOp()
   * @model
   * @generated
   */
  ShiftOp getShiftOp();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.diagram.reflex.ShiftExpression#getShiftOp <em>Shift Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Shift Op</em>' attribute.
   * @see ru.iaie.reflex.diagram.reflex.ShiftOp
   * @see #getShiftOp()
   * @generated
   */
  void setShiftOp(ShiftOp value);

} // ShiftExpression
