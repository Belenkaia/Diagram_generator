/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.diagram.reflex.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import ru.iaie.reflex.diagram.reflex.AssignmentExpression;
import ru.iaie.reflex.diagram.reflex.Expression;
import ru.iaie.reflex.diagram.reflex.ReflexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.impl.AssignmentExpressionImpl#isAssignVar <em>Assign Var</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.impl.AssignmentExpressionImpl#isAssignOp <em>Assign Op</em>}</li>
 *   <li>{@link ru.iaie.reflex.diagram.reflex.impl.AssignmentExpressionImpl#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AssignmentExpressionImpl extends ExpressionImpl implements AssignmentExpression
{
  /**
   * The default value of the '{@link #isAssignVar() <em>Assign Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssignVar()
   * @generated
   * @ordered
   */
  protected static final boolean ASSIGN_VAR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAssignVar() <em>Assign Var</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssignVar()
   * @generated
   * @ordered
   */
  protected boolean assignVar = ASSIGN_VAR_EDEFAULT;

  /**
   * The default value of the '{@link #isAssignOp() <em>Assign Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssignOp()
   * @generated
   * @ordered
   */
  protected static final boolean ASSIGN_OP_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAssignOp() <em>Assign Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAssignOp()
   * @generated
   * @ordered
   */
  protected boolean assignOp = ASSIGN_OP_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpr() <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpr()
   * @generated
   * @ordered
   */
  protected Expression expr;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssignmentExpressionImpl()
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
    return ReflexPackage.Literals.ASSIGNMENT_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAssignVar()
  {
    return assignVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAssignVar(boolean newAssignVar)
  {
    boolean oldAssignVar = assignVar;
    assignVar = newAssignVar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_VAR, oldAssignVar, assignVar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isAssignOp()
  {
    return assignOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setAssignOp(boolean newAssignOp)
  {
    boolean oldAssignOp = assignOp;
    assignOp = newAssignOp;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_OP, oldAssignOp, assignOp));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getExpr()
  {
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpr(Expression newExpr, NotificationChain msgs)
  {
    Expression oldExpr = expr;
    expr = newExpr;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR, oldExpr, newExpr);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setExpr(Expression newExpr)
  {
    if (newExpr != expr)
    {
      NotificationChain msgs = null;
      if (expr != null)
        msgs = ((InternalEObject)expr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR, null, msgs);
      if (newExpr != null)
        msgs = ((InternalEObject)newExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR, null, msgs);
      msgs = basicSetExpr(newExpr, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR, newExpr, newExpr));
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
      case ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR:
        return basicSetExpr(null, msgs);
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
      case ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_VAR:
        return isAssignVar();
      case ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_OP:
        return isAssignOp();
      case ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR:
        return getExpr();
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
      case ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_VAR:
        setAssignVar((Boolean)newValue);
        return;
      case ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_OP:
        setAssignOp((Boolean)newValue);
        return;
      case ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR:
        setExpr((Expression)newValue);
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
      case ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_VAR:
        setAssignVar(ASSIGN_VAR_EDEFAULT);
        return;
      case ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_OP:
        setAssignOp(ASSIGN_OP_EDEFAULT);
        return;
      case ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR:
        setExpr((Expression)null);
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
      case ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_VAR:
        return assignVar != ASSIGN_VAR_EDEFAULT;
      case ReflexPackage.ASSIGNMENT_EXPRESSION__ASSIGN_OP:
        return assignOp != ASSIGN_OP_EDEFAULT;
      case ReflexPackage.ASSIGNMENT_EXPRESSION__EXPR:
        return expr != null;
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
    result.append(" (assignVar: ");
    result.append(assignVar);
    result.append(", assignOp: ");
    result.append(assignOp);
    result.append(')');
    return result.toString();
  }

} //AssignmentExpressionImpl
