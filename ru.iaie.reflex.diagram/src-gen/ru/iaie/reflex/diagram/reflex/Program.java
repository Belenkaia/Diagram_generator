/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.diagram.reflex;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.Program#getName <em>Name</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.Program#isTicks <em>Ticks</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.Program#getConsts <em>Consts</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.Program#getEnums <em>Enums</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.Program#getFunctions <em>Functions</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.Program#getRegisters <em>Registers</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.Program#getProcesses <em>Processes</em>}</li>
 * </ul>
 *
 * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getProgram()
 * @model
 * @generated
 */
public interface Program extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getProgram_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.diagram.reflex.Program#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Ticks</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ticks</em>' attribute.
   * @see #setTicks(boolean)
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getProgram_Ticks()
   * @model
   * @generated
   */
  boolean isTicks();

  /**
   * Sets the value of the '{@link ru.iaie.reflex.diagram.reflex.Program#isTicks <em>Ticks</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ticks</em>' attribute.
   * @see #isTicks()
   * @generated
   */
  void setTicks(boolean value);

  /**
   * Returns the value of the '<em><b>Consts</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.diagram.reflex.Const}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Consts</em>' containment reference list.
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getProgram_Consts()
   * @model containment="true"
   * @generated
   */
  EList<Const> getConsts();

  /**
   * Returns the value of the '<em><b>Enums</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.diagram.reflex.Enum}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enums</em>' containment reference list.
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getProgram_Enums()
   * @model containment="true"
   * @generated
   */
  EList<ru.iaie.reflex.diagram.reflex.Enum> getEnums();

  /**
   * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.diagram.reflex.Function}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Functions</em>' containment reference list.
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getProgram_Functions()
   * @model containment="true"
   * @generated
   */
  EList<Function> getFunctions();

  /**
   * Returns the value of the '<em><b>Registers</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.diagram.reflex.Register}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Registers</em>' containment reference list.
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getProgram_Registers()
   * @model containment="true"
   * @generated
   */
  EList<Register> getRegisters();

  /**
   * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
   * The list contents are of type {@link ru.iaie.reflex.diagram.reflex.Process}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Processes</em>' containment reference list.
   * @see ru.iaie.reflex.diagram.reflex.ReflexPackage#getProgram_Processes()
   * @model containment="true"
   * @generated
   */
  EList<ru.iaie.reflex.diagram.reflex.Process> getProcesses();

} // Program
