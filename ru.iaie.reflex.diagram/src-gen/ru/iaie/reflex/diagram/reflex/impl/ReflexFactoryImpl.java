/**
 * generated by Xtext 2.20.0
 */
package ru.iaie.reflex.diagram.reflex.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import ru.iaie.reflex.diagram.reflex.AdditiveExpression;
import ru.iaie.reflex.diagram.reflex.AdditiveOp;
import ru.iaie.reflex.diagram.reflex.AssignOperator;
import ru.iaie.reflex.diagram.reflex.AssignStat;
import ru.iaie.reflex.diagram.reflex.AssignmentExpression;
import ru.iaie.reflex.diagram.reflex.BitAndExpression;
import ru.iaie.reflex.diagram.reflex.BitOrExpression;
import ru.iaie.reflex.diagram.reflex.BitXorExpression;
import ru.iaie.reflex.diagram.reflex.CType;
import ru.iaie.reflex.diagram.reflex.CTypeSignSpec;
import ru.iaie.reflex.diagram.reflex.CaseStat;
import ru.iaie.reflex.diagram.reflex.CastExpression;
import ru.iaie.reflex.diagram.reflex.CompareEqOp;
import ru.iaie.reflex.diagram.reflex.CompareExpression;
import ru.iaie.reflex.diagram.reflex.CompareOp;
import ru.iaie.reflex.diagram.reflex.CompoundStatement;
import ru.iaie.reflex.diagram.reflex.Const;
import ru.iaie.reflex.diagram.reflex.DeclaredVariable;
import ru.iaie.reflex.diagram.reflex.EnumMember;
import ru.iaie.reflex.diagram.reflex.EqualityExpression;
import ru.iaie.reflex.diagram.reflex.ErrorStat;
import ru.iaie.reflex.diagram.reflex.Expression;
import ru.iaie.reflex.diagram.reflex.ExpressionStatement;
import ru.iaie.reflex.diagram.reflex.Function;
import ru.iaie.reflex.diagram.reflex.FunctionCall;
import ru.iaie.reflex.diagram.reflex.IfElseStat;
import ru.iaie.reflex.diagram.reflex.ImportedVariable;
import ru.iaie.reflex.diagram.reflex.InfixOp;
import ru.iaie.reflex.diagram.reflex.InfixPostfixOp;
import ru.iaie.reflex.diagram.reflex.LogicalAndExpression;
import ru.iaie.reflex.diagram.reflex.LogicalOrExpression;
import ru.iaie.reflex.diagram.reflex.MultiplicativeExpression;
import ru.iaie.reflex.diagram.reflex.MultiplicativeOp;
import ru.iaie.reflex.diagram.reflex.PhysicalVariable;
import ru.iaie.reflex.diagram.reflex.PostfixOp;
import ru.iaie.reflex.diagram.reflex.PrimaryExpression;
import ru.iaie.reflex.diagram.reflex.Program;
import ru.iaie.reflex.diagram.reflex.ProgramVariable;
import ru.iaie.reflex.diagram.reflex.ReflexFactory;
import ru.iaie.reflex.diagram.reflex.ReflexPackage;
import ru.iaie.reflex.diagram.reflex.ReflexType;
import ru.iaie.reflex.diagram.reflex.Register;
import ru.iaie.reflex.diagram.reflex.RegisterPort;
import ru.iaie.reflex.diagram.reflex.RegisterType;
import ru.iaie.reflex.diagram.reflex.SetStateStat;
import ru.iaie.reflex.diagram.reflex.ShiftExpression;
import ru.iaie.reflex.diagram.reflex.ShiftOp;
import ru.iaie.reflex.diagram.reflex.StartProcStat;
import ru.iaie.reflex.diagram.reflex.State;
import ru.iaie.reflex.diagram.reflex.Statement;
import ru.iaie.reflex.diagram.reflex.StopProcStat;
import ru.iaie.reflex.diagram.reflex.SwitchStat;
import ru.iaie.reflex.diagram.reflex.Tact;
import ru.iaie.reflex.diagram.reflex.Time;
import ru.iaie.reflex.diagram.reflex.TimeoutFunction;
import ru.iaie.reflex.diagram.reflex.UnaryExpression;
import ru.iaie.reflex.diagram.reflex.UnaryOp;
import ru.iaie.reflex.diagram.reflex.Variable;
import ru.iaie.reflex.diagram.reflex.Visibility;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReflexFactoryImpl extends EFactoryImpl implements ReflexFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReflexFactory init()
  {
    try
    {
      ReflexFactory theReflexFactory = (ReflexFactory)EPackage.Registry.INSTANCE.getEFactory(ReflexPackage.eNS_URI);
      if (theReflexFactory != null)
      {
        return theReflexFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ReflexFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReflexFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ReflexPackage.PROGRAM: return createProgram();
      case ReflexPackage.PROCESS: return createProcess();
      case ReflexPackage.VARIABLE: return createVariable();
      case ReflexPackage.IMPORTED_VARIABLE: return createImportedVariable();
      case ReflexPackage.DECLARED_VARIABLE: return createDeclaredVariable();
      case ReflexPackage.PHYSICAL_VARIABLE: return createPhysicalVariable();
      case ReflexPackage.REGISTER_PORT: return createRegisterPort();
      case ReflexPackage.PROGRAM_VARIABLE: return createProgramVariable();
      case ReflexPackage.VISIBILITY: return createVisibility();
      case ReflexPackage.STATE: return createState();
      case ReflexPackage.TIMEOUT_FUNCTION: return createTimeoutFunction();
      case ReflexPackage.STATEMENT: return createStatement();
      case ReflexPackage.COMPOUND_STATEMENT: return createCompoundStatement();
      case ReflexPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
      case ReflexPackage.ASSIGN_STAT: return createAssignStat();
      case ReflexPackage.IF_ELSE_STAT: return createIfElseStat();
      case ReflexPackage.SWITCH_STAT: return createSwitchStat();
      case ReflexPackage.CASE_STAT: return createCaseStat();
      case ReflexPackage.START_PROC_STAT: return createStartProcStat();
      case ReflexPackage.STOP_PROC_STAT: return createStopProcStat();
      case ReflexPackage.ERROR_STAT: return createErrorStat();
      case ReflexPackage.SET_STATE_STAT: return createSetStateStat();
      case ReflexPackage.FUNCTION: return createFunction();
      case ReflexPackage.REGISTER: return createRegister();
      case ReflexPackage.CONST: return createConst();
      case ReflexPackage.ENUM: return createEnum();
      case ReflexPackage.ENUM_MEMBER: return createEnumMember();
      case ReflexPackage.INFIX_OP: return createInfixOp();
      case ReflexPackage.POSTFIX_OP: return createPostfixOp();
      case ReflexPackage.FUNCTION_CALL: return createFunctionCall();
      case ReflexPackage.PRIMARY_EXPRESSION: return createPrimaryExpression();
      case ReflexPackage.UNARY_EXPRESSION: return createUnaryExpression();
      case ReflexPackage.CAST_EXPRESSION: return createCastExpression();
      case ReflexPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
      case ReflexPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
      case ReflexPackage.SHIFT_EXPRESSION: return createShiftExpression();
      case ReflexPackage.COMPARE_EXPRESSION: return createCompareExpression();
      case ReflexPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
      case ReflexPackage.BIT_AND_EXPRESSION: return createBitAndExpression();
      case ReflexPackage.BIT_XOR_EXPRESSION: return createBitXorExpression();
      case ReflexPackage.BIT_OR_EXPRESSION: return createBitOrExpression();
      case ReflexPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
      case ReflexPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
      case ReflexPackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
      case ReflexPackage.EXPRESSION: return createExpression();
      case ReflexPackage.CTYPE: return createCType();
      case ReflexPackage.REFLEX_TYPE: return createReflexType();
      case ReflexPackage.TACT: return createTact();
      case ReflexPackage.TIME: return createTime();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ReflexPackage.REGISTER_TYPE:
        return createRegisterTypeFromString(eDataType, initialValue);
      case ReflexPackage.INFIX_POSTFIX_OP:
        return createInfixPostfixOpFromString(eDataType, initialValue);
      case ReflexPackage.ASSIGN_OPERATOR:
        return createAssignOperatorFromString(eDataType, initialValue);
      case ReflexPackage.UNARY_OP:
        return createUnaryOpFromString(eDataType, initialValue);
      case ReflexPackage.COMPARE_OP:
        return createCompareOpFromString(eDataType, initialValue);
      case ReflexPackage.COMPARE_EQ_OP:
        return createCompareEqOpFromString(eDataType, initialValue);
      case ReflexPackage.SHIFT_OP:
        return createShiftOpFromString(eDataType, initialValue);
      case ReflexPackage.ADDITIVE_OP:
        return createAdditiveOpFromString(eDataType, initialValue);
      case ReflexPackage.MULTIPLICATIVE_OP:
        return createMultiplicativeOpFromString(eDataType, initialValue);
      case ReflexPackage.CTYPE_SIGN_SPEC:
        return createCTypeSignSpecFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ReflexPackage.REGISTER_TYPE:
        return convertRegisterTypeToString(eDataType, instanceValue);
      case ReflexPackage.INFIX_POSTFIX_OP:
        return convertInfixPostfixOpToString(eDataType, instanceValue);
      case ReflexPackage.ASSIGN_OPERATOR:
        return convertAssignOperatorToString(eDataType, instanceValue);
      case ReflexPackage.UNARY_OP:
        return convertUnaryOpToString(eDataType, instanceValue);
      case ReflexPackage.COMPARE_OP:
        return convertCompareOpToString(eDataType, instanceValue);
      case ReflexPackage.COMPARE_EQ_OP:
        return convertCompareEqOpToString(eDataType, instanceValue);
      case ReflexPackage.SHIFT_OP:
        return convertShiftOpToString(eDataType, instanceValue);
      case ReflexPackage.ADDITIVE_OP:
        return convertAdditiveOpToString(eDataType, instanceValue);
      case ReflexPackage.MULTIPLICATIVE_OP:
        return convertMultiplicativeOpToString(eDataType, instanceValue);
      case ReflexPackage.CTYPE_SIGN_SPEC:
        return convertCTypeSignSpecToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Program createProgram()
  {
    ProgramImpl program = new ProgramImpl();
    return program;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ru.iaie.reflex.diagram.reflex.Process createProcess()
  {
    ProcessImpl process = new ProcessImpl();
    return process;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ImportedVariable createImportedVariable()
  {
    ImportedVariableImpl importedVariable = new ImportedVariableImpl();
    return importedVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DeclaredVariable createDeclaredVariable()
  {
    DeclaredVariableImpl declaredVariable = new DeclaredVariableImpl();
    return declaredVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PhysicalVariable createPhysicalVariable()
  {
    PhysicalVariableImpl physicalVariable = new PhysicalVariableImpl();
    return physicalVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RegisterPort createRegisterPort()
  {
    RegisterPortImpl registerPort = new RegisterPortImpl();
    return registerPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ProgramVariable createProgramVariable()
  {
    ProgramVariableImpl programVariable = new ProgramVariableImpl();
    return programVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Visibility createVisibility()
  {
    VisibilityImpl visibility = new VisibilityImpl();
    return visibility;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public State createState()
  {
    StateImpl state = new StateImpl();
    return state;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TimeoutFunction createTimeoutFunction()
  {
    TimeoutFunctionImpl timeoutFunction = new TimeoutFunctionImpl();
    return timeoutFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CompoundStatement createCompoundStatement()
  {
    CompoundStatementImpl compoundStatement = new CompoundStatementImpl();
    return compoundStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpressionStatement createExpressionStatement()
  {
    ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
    return expressionStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssignStat createAssignStat()
  {
    AssignStatImpl assignStat = new AssignStatImpl();
    return assignStat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IfElseStat createIfElseStat()
  {
    IfElseStatImpl ifElseStat = new IfElseStatImpl();
    return ifElseStat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SwitchStat createSwitchStat()
  {
    SwitchStatImpl switchStat = new SwitchStatImpl();
    return switchStat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CaseStat createCaseStat()
  {
    CaseStatImpl caseStat = new CaseStatImpl();
    return caseStat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StartProcStat createStartProcStat()
  {
    StartProcStatImpl startProcStat = new StartProcStatImpl();
    return startProcStat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StopProcStat createStopProcStat()
  {
    StopProcStatImpl stopProcStat = new StopProcStatImpl();
    return stopProcStat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ErrorStat createErrorStat()
  {
    ErrorStatImpl errorStat = new ErrorStatImpl();
    return errorStat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SetStateStat createSetStateStat()
  {
    SetStateStatImpl setStateStat = new SetStateStatImpl();
    return setStateStat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Register createRegister()
  {
    RegisterImpl register = new RegisterImpl();
    return register;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Const createConst()
  {
    ConstImpl const_ = new ConstImpl();
    return const_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ru.iaie.reflex.diagram.reflex.Enum createEnum()
  {
    EnumImpl enum_ = new EnumImpl();
    return enum_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumMember createEnumMember()
  {
    EnumMemberImpl enumMember = new EnumMemberImpl();
    return enumMember;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InfixOp createInfixOp()
  {
    InfixOpImpl infixOp = new InfixOpImpl();
    return infixOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PostfixOp createPostfixOp()
  {
    PostfixOpImpl postfixOp = new PostfixOpImpl();
    return postfixOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FunctionCall createFunctionCall()
  {
    FunctionCallImpl functionCall = new FunctionCallImpl();
    return functionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PrimaryExpression createPrimaryExpression()
  {
    PrimaryExpressionImpl primaryExpression = new PrimaryExpressionImpl();
    return primaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryExpression createUnaryExpression()
  {
    UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
    return unaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CastExpression createCastExpression()
  {
    CastExpressionImpl castExpression = new CastExpressionImpl();
    return castExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MultiplicativeExpression createMultiplicativeExpression()
  {
    MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
    return multiplicativeExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AdditiveExpression createAdditiveExpression()
  {
    AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
    return additiveExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ShiftExpression createShiftExpression()
  {
    ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
    return shiftExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CompareExpression createCompareExpression()
  {
    CompareExpressionImpl compareExpression = new CompareExpressionImpl();
    return compareExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EqualityExpression createEqualityExpression()
  {
    EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
    return equalityExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BitAndExpression createBitAndExpression()
  {
    BitAndExpressionImpl bitAndExpression = new BitAndExpressionImpl();
    return bitAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BitXorExpression createBitXorExpression()
  {
    BitXorExpressionImpl bitXorExpression = new BitXorExpressionImpl();
    return bitXorExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BitOrExpression createBitOrExpression()
  {
    BitOrExpressionImpl bitOrExpression = new BitOrExpressionImpl();
    return bitOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LogicalAndExpression createLogicalAndExpression()
  {
    LogicalAndExpressionImpl logicalAndExpression = new LogicalAndExpressionImpl();
    return logicalAndExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public LogicalOrExpression createLogicalOrExpression()
  {
    LogicalOrExpressionImpl logicalOrExpression = new LogicalOrExpressionImpl();
    return logicalOrExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public AssignmentExpression createAssignmentExpression()
  {
    AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
    return assignmentExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CType createCType()
  {
    CTypeImpl cType = new CTypeImpl();
    return cType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReflexType createReflexType()
  {
    ReflexTypeImpl reflexType = new ReflexTypeImpl();
    return reflexType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Tact createTact()
  {
    TactImpl tact = new TactImpl();
    return tact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Time createTime()
  {
    TimeImpl time = new TimeImpl();
    return time;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RegisterType createRegisterTypeFromString(EDataType eDataType, String initialValue)
  {
    RegisterType result = RegisterType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertRegisterTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InfixPostfixOp createInfixPostfixOpFromString(EDataType eDataType, String initialValue)
  {
    InfixPostfixOp result = InfixPostfixOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertInfixPostfixOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignOperator createAssignOperatorFromString(EDataType eDataType, String initialValue)
  {
    AssignOperator result = AssignOperator.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAssignOperatorToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOp createUnaryOpFromString(EDataType eDataType, String initialValue)
  {
    UnaryOp result = UnaryOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertUnaryOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompareOp createCompareOpFromString(EDataType eDataType, String initialValue)
  {
    CompareOp result = CompareOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCompareOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CompareEqOp createCompareEqOpFromString(EDataType eDataType, String initialValue)
  {
    CompareEqOp result = CompareEqOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCompareEqOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ShiftOp createShiftOpFromString(EDataType eDataType, String initialValue)
  {
    ShiftOp result = ShiftOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertShiftOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AdditiveOp createAdditiveOpFromString(EDataType eDataType, String initialValue)
  {
    AdditiveOp result = AdditiveOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertAdditiveOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicativeOp createMultiplicativeOpFromString(EDataType eDataType, String initialValue)
  {
    MultiplicativeOp result = MultiplicativeOp.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMultiplicativeOpToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CTypeSignSpec createCTypeSignSpecFromString(EDataType eDataType, String initialValue)
  {
    CTypeSignSpec result = CTypeSignSpec.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertCTypeSignSpecToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReflexPackage getReflexPackage()
  {
    return (ReflexPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ReflexPackage getPackage()
  {
    return ReflexPackage.eINSTANCE;
  }

} //ReflexFactoryImpl
