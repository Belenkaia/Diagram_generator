/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.diagram.reflex.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import ru.iaie.reflex.diagram.reflex.ReflexPackage;
import ru.iaie.reflex.diagram.reflex.RegisterPort;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Register Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.impl.RegisterPortImpl#getRegName <em>Reg Name</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.impl.RegisterPortImpl#getPort <em>Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RegisterPortImpl extends MinimalEObjectImpl.Container implements RegisterPort
{
  /**
   * The default value of the '{@link #getRegName() <em>Reg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegName()
   * @generated
   * @ordered
   */
  protected static final String REG_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRegName() <em>Reg Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRegName()
   * @generated
   * @ordered
   */
  protected String regName = REG_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort()
   * @generated
   * @ordered
   */
  protected static final String PORT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPort()
   * @generated
   * @ordered
   */
  protected String port = PORT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RegisterPortImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReflexPackage.Literals.REGISTER_PORT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getRegName()
  {
    return regName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setRegName(String newRegName)
  {
    String oldRegName = regName;
    regName = newRegName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.REGISTER_PORT__REG_NAME, oldRegName, regName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getPort()
  {
    return port;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setPort(String newPort)
  {
    String oldPort = port;
    port = newPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.REGISTER_PORT__PORT, oldPort, port));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReflexPackage.REGISTER_PORT__REG_NAME:
        return getRegName();
      case ReflexPackage.REGISTER_PORT__PORT:
        return getPort();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReflexPackage.REGISTER_PORT__REG_NAME:
        setRegName((String)newValue);
        return;
      case ReflexPackage.REGISTER_PORT__PORT:
        setPort((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReflexPackage.REGISTER_PORT__REG_NAME:
        setRegName(REG_NAME_EDEFAULT);
        return;
      case ReflexPackage.REGISTER_PORT__PORT:
        setPort(PORT_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReflexPackage.REGISTER_PORT__REG_NAME:
        return REG_NAME_EDEFAULT == null ? regName != null : !REG_NAME_EDEFAULT.equals(regName);
      case ReflexPackage.REGISTER_PORT__PORT:
        return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (regName: ");
    result.append(regName);
    result.append(", port: ");
    result.append(port);
    result.append(')');
    return result.toString();
  }

} //RegisterPortImpl
