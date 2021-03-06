/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.diagram.reflex.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import ru.iaie.reflex.diagram.reflex.EnumMember;
import ru.iaie.reflex.diagram.reflex.ReflexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.impl.EnumImpl#getEnumId <em>Enum Id</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.impl.EnumImpl#getEnumMembers <em>Enum Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumImpl extends MinimalEObjectImpl.Container implements ru.iaie.reflex.diagram.reflex.Enum
{
  /**
   * The default value of the '{@link #getEnumId() <em>Enum Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumId()
   * @generated
   * @ordered
   */
  protected static final String ENUM_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEnumId() <em>Enum Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumId()
   * @generated
   * @ordered
   */
  protected String enumId = ENUM_ID_EDEFAULT;

  /**
   * The cached value of the '{@link #getEnumMembers() <em>Enum Members</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumMembers()
   * @generated
   * @ordered
   */
  protected EList<EnumMember> enumMembers;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumImpl()
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
    return ReflexPackage.Literals.ENUM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getEnumId()
  {
    return enumId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setEnumId(String newEnumId)
  {
    String oldEnumId = enumId;
    enumId = newEnumId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.ENUM__ENUM_ID, oldEnumId, enumId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<EnumMember> getEnumMembers()
  {
    if (enumMembers == null)
    {
      enumMembers = new EObjectContainmentEList<EnumMember>(EnumMember.class, this, ReflexPackage.ENUM__ENUM_MEMBERS);
    }
    return enumMembers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReflexPackage.ENUM__ENUM_MEMBERS:
        return ((InternalEList<?>)getEnumMembers()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case ReflexPackage.ENUM__ENUM_ID:
        return getEnumId();
      case ReflexPackage.ENUM__ENUM_MEMBERS:
        return getEnumMembers();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReflexPackage.ENUM__ENUM_ID:
        setEnumId((String)newValue);
        return;
      case ReflexPackage.ENUM__ENUM_MEMBERS:
        getEnumMembers().clear();
        getEnumMembers().addAll((Collection<? extends EnumMember>)newValue);
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
      case ReflexPackage.ENUM__ENUM_ID:
        setEnumId(ENUM_ID_EDEFAULT);
        return;
      case ReflexPackage.ENUM__ENUM_MEMBERS:
        getEnumMembers().clear();
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
      case ReflexPackage.ENUM__ENUM_ID:
        return ENUM_ID_EDEFAULT == null ? enumId != null : !ENUM_ID_EDEFAULT.equals(enumId);
      case ReflexPackage.ENUM__ENUM_MEMBERS:
        return enumMembers != null && !enumMembers.isEmpty();
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
    result.append(" (enumId: ");
    result.append(enumId);
    result.append(')');
    return result.toString();
  }

} //EnumImpl
