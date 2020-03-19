package ru.iaie.reflex.diagram.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ru.iaie.reflex.diagram.services.ReflexGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalReflexParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TACT", "RULE_REG_SIZE", "RULE_BIT_AND", "RULE_BIT_XOR", "RULE_BIT_OR", "RULE_LOGICAL_AND", "RULE_LOGICAL_OR", "RULE_VOID_C_TYPE", "RULE_FLOAT_C_TYPE", "RULE_DOUBLE_C_TYPE", "RULE_SHORT_C_TYPE", "RULE_INT_C_TYPE", "RULE_LONG_C_TYPE", "RULE_BOOL_TYPE", "RULE_DECIMAL", "RULE_OCTAL", "RULE_HEX", "RULE_LONG", "RULE_UNSIGNED", "RULE_DAY", "RULE_HOUR", "RULE_MINUTE", "RULE_SECOND", "RULE_MILISECOND", "RULE_MICROSECOND", "RULE_NANOSECOND", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'program'", "'{'", "'}'", "'proc'", "';'", "'from'", "'='", "','", "'['", "']'", "'local'", "'global'", "'shared'", "'state'", "'timeout'", "'if'", "'('", "')'", "'else'", "'switch'", "'case'", "':'", "'break'", "'start'", "'stop'", "'error'", "'loop'", "'restart'", "'set'", "'next'", "'const'", "'enum'", "'0t'", "'0T'", "'input'", "'output'", "'++'", "'--'", "'*='", "'/='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'+'", "'-'", "'~'", "'!'", "'<'", "'>'", "'=<'", "'>='", "'=='", "'!='", "'>>'", "'<<'", "'*'", "'/'", "'%'", "'signed'", "'unsigned'"
    };
    public static final int RULE_HEX=21;
    public static final int T__50=50;
    public static final int RULE_REG_SIZE=6;
    public static final int RULE_MINUTE=26;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_TACT=5;
    public static final int RULE_INT_C_TYPE=16;
    public static final int RULE_INT=31;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=33;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_MICROSECOND=29;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_VOID_C_TYPE=12;
    public static final int RULE_HOUR=25;
    public static final int RULE_UNSIGNED=23;
    public static final int RULE_DOUBLE_C_TYPE=14;
    public static final int RULE_LOGICAL_AND=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int RULE_BIT_AND=7;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int RULE_BOOL_TYPE=18;
    public static final int T__94=94;
    public static final int RULE_DAY=24;
    public static final int T__90=90;
    public static final int RULE_FLOAT_C_TYPE=13;
    public static final int RULE_OCTAL=20;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_SHORT_C_TYPE=15;
    public static final int RULE_DECIMAL=19;
    public static final int RULE_SECOND=27;
    public static final int RULE_LOGICAL_OR=11;
    public static final int RULE_LONG_C_TYPE=17;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_NANOSECOND=30;
    public static final int RULE_MILISECOND=28;
    public static final int RULE_STRING=32;
    public static final int RULE_SL_COMMENT=34;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=35;
    public static final int RULE_ANY_OTHER=36;
    public static final int T__88=88;
    public static final int RULE_BIT_XOR=8;
    public static final int T__89=89;
    public static final int RULE_BIT_OR=9;
    public static final int RULE_LONG=22;
    public static final int T__84=84;
    public static final int T__85=85;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalReflexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReflexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReflexParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReflex.g"; }



     	private ReflexGrammarAccess grammarAccess;

        public InternalReflexParser(TokenStream input, ReflexGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Program";
       	}

       	@Override
       	protected ReflexGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgram"
    // InternalReflex.g:65:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalReflex.g:65:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalReflex.g:66:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalReflex.g:72:1: ruleProgram returns [EObject current=null] : (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_ticks_3_0=null;
        Token otherlv_9=null;
        EObject lv_consts_4_0 = null;

        EObject lv_enums_5_0 = null;

        EObject lv_functions_6_0 = null;

        EObject lv_registers_7_0 = null;

        EObject lv_processes_8_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:78:2: ( (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' ) )
            // InternalReflex.g:79:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' )
            {
            // InternalReflex.g:79:2: (otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}' )
            // InternalReflex.g:80:3: otherlv_0= 'program' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_ticks_3_0= RULE_TACT ) )? ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )* otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getProgramKeyword_0());
              		
            }
            // InternalReflex.g:84:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:85:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:85:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:86:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProgramAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:106:3: ( (lv_ticks_3_0= RULE_TACT ) )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_TACT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalReflex.g:107:4: (lv_ticks_3_0= RULE_TACT )
                    {
                    // InternalReflex.g:107:4: (lv_ticks_3_0= RULE_TACT )
                    // InternalReflex.g:108:5: lv_ticks_3_0= RULE_TACT
                    {
                    lv_ticks_3_0=(Token)match(input,RULE_TACT,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_ticks_3_0, grammarAccess.getProgramAccess().getTicksTACTTerminalRuleCall_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getProgramRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"ticks",
                      						true,
                      						"ru.iaie.reflex.diagram.Reflex.TACT");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:124:3: ( ( (lv_consts_4_0= ruleConst ) ) | ( (lv_enums_5_0= ruleEnum ) ) | ( (lv_functions_6_0= ruleFunction ) ) | ( (lv_registers_7_0= ruleRegister ) ) | ( (lv_processes_8_0= ruleProcess ) ) )*
            loop2:
            do {
                int alt2=6;
                switch ( input.LA(1) ) {
                case 67:
                    {
                    alt2=1;
                    }
                    break;
                case 68:
                    {
                    alt2=2;
                    }
                    break;
                case RULE_VOID_C_TYPE:
                case RULE_FLOAT_C_TYPE:
                case RULE_DOUBLE_C_TYPE:
                case RULE_SHORT_C_TYPE:
                case RULE_INT_C_TYPE:
                case RULE_LONG_C_TYPE:
                case 99:
                case 100:
                    {
                    alt2=3;
                    }
                    break;
                case 71:
                case 72:
                    {
                    alt2=4;
                    }
                    break;
                case 40:
                    {
                    alt2=5;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // InternalReflex.g:125:4: ( (lv_consts_4_0= ruleConst ) )
            	    {
            	    // InternalReflex.g:125:4: ( (lv_consts_4_0= ruleConst ) )
            	    // InternalReflex.g:126:5: (lv_consts_4_0= ruleConst )
            	    {
            	    // InternalReflex.g:126:5: (lv_consts_4_0= ruleConst )
            	    // InternalReflex.g:127:6: lv_consts_4_0= ruleConst
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getConstsConstParserRuleCall_4_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_consts_4_0=ruleConst();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"consts",
            	      							lv_consts_4_0,
            	      							"ru.iaie.reflex.diagram.Reflex.Const");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalReflex.g:145:4: ( (lv_enums_5_0= ruleEnum ) )
            	    {
            	    // InternalReflex.g:145:4: ( (lv_enums_5_0= ruleEnum ) )
            	    // InternalReflex.g:146:5: (lv_enums_5_0= ruleEnum )
            	    {
            	    // InternalReflex.g:146:5: (lv_enums_5_0= ruleEnum )
            	    // InternalReflex.g:147:6: lv_enums_5_0= ruleEnum
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getEnumsEnumParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_enums_5_0=ruleEnum();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enums",
            	      							lv_enums_5_0,
            	      							"ru.iaie.reflex.diagram.Reflex.Enum");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalReflex.g:165:4: ( (lv_functions_6_0= ruleFunction ) )
            	    {
            	    // InternalReflex.g:165:4: ( (lv_functions_6_0= ruleFunction ) )
            	    // InternalReflex.g:166:5: (lv_functions_6_0= ruleFunction )
            	    {
            	    // InternalReflex.g:166:5: (lv_functions_6_0= ruleFunction )
            	    // InternalReflex.g:167:6: lv_functions_6_0= ruleFunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getFunctionsFunctionParserRuleCall_4_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_functions_6_0=ruleFunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_6_0,
            	      							"ru.iaie.reflex.diagram.Reflex.Function");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalReflex.g:185:4: ( (lv_registers_7_0= ruleRegister ) )
            	    {
            	    // InternalReflex.g:185:4: ( (lv_registers_7_0= ruleRegister ) )
            	    // InternalReflex.g:186:5: (lv_registers_7_0= ruleRegister )
            	    {
            	    // InternalReflex.g:186:5: (lv_registers_7_0= ruleRegister )
            	    // InternalReflex.g:187:6: lv_registers_7_0= ruleRegister
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getRegistersRegisterParserRuleCall_4_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_registers_7_0=ruleRegister();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"registers",
            	      							lv_registers_7_0,
            	      							"ru.iaie.reflex.diagram.Reflex.Register");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalReflex.g:205:4: ( (lv_processes_8_0= ruleProcess ) )
            	    {
            	    // InternalReflex.g:205:4: ( (lv_processes_8_0= ruleProcess ) )
            	    // InternalReflex.g:206:5: (lv_processes_8_0= ruleProcess )
            	    {
            	    // InternalReflex.g:206:5: (lv_processes_8_0= ruleProcess )
            	    // InternalReflex.g:207:6: lv_processes_8_0= ruleProcess
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getProcessesProcessParserRuleCall_4_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_6);
            	    lv_processes_8_0=ruleProcess();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"processes",
            	      							lv_processes_8_0,
            	      							"ru.iaie.reflex.diagram.Reflex.Process");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_9=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getProgramAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleProcess"
    // InternalReflex.g:233:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalReflex.g:233:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalReflex.g:234:2: iv_ruleProcess= ruleProcess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcess; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalReflex.g:240:1: ruleProcess returns [EObject current=null] : (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_variable_3_0 = null;

        EObject lv_states_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:246:2: ( (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' ) )
            // InternalReflex.g:247:2: (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' )
            {
            // InternalReflex.g:247:2: (otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}' )
            // InternalReflex.g:248:3: otherlv_0= 'proc' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_variable_3_0= ruleVariable ) )* ( (lv_states_4_0= ruleState ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getProcKeyword_0());
              		
            }
            // InternalReflex.g:252:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:253:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:253:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:254:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProcessRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:274:3: ( (lv_variable_3_0= ruleVariable ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_VOID_C_TYPE && LA3_0<=RULE_BOOL_TYPE)||LA3_0==42||(LA3_0>=99 && LA3_0<=100)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalReflex.g:275:4: (lv_variable_3_0= ruleVariable )
            	    {
            	    // InternalReflex.g:275:4: (lv_variable_3_0= ruleVariable )
            	    // InternalReflex.g:276:5: lv_variable_3_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getVariableVariableParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_7);
            	    lv_variable_3_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"variable",
            	      						lv_variable_3_0,
            	      						"ru.iaie.reflex.diagram.Reflex.Variable");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalReflex.g:293:3: ( (lv_states_4_0= ruleState ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==50) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalReflex.g:294:4: (lv_states_4_0= ruleState )
            	    {
            	    // InternalReflex.g:294:4: (lv_states_4_0= ruleState )
            	    // InternalReflex.g:295:5: lv_states_4_0= ruleState
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_states_4_0=ruleState();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"states",
            	      						lv_states_4_0,
            	      						"ru.iaie.reflex.diagram.Reflex.State");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_5=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleVariable"
    // InternalReflex.g:320:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalReflex.g:320:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalReflex.g:321:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalReflex.g:327:1: ruleVariable returns [EObject current=null] : (this_ImportedVariable_0= ruleImportedVariable | (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ImportedVariable_0 = null;

        EObject this_DeclaredVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:333:2: ( (this_ImportedVariable_0= ruleImportedVariable | (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' ) ) )
            // InternalReflex.g:334:2: (this_ImportedVariable_0= ruleImportedVariable | (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' ) )
            {
            // InternalReflex.g:334:2: (this_ImportedVariable_0= ruleImportedVariable | (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==42) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_VOID_C_TYPE && LA5_0<=RULE_BOOL_TYPE)||(LA5_0>=99 && LA5_0<=100)) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalReflex.g:335:3: this_ImportedVariable_0= ruleImportedVariable
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getVariableAccess().getImportedVariableParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ImportedVariable_0=ruleImportedVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ImportedVariable_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:344:3: (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' )
                    {
                    // InternalReflex.g:344:3: (this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';' )
                    // InternalReflex.g:345:4: this_DeclaredVariable_1= ruleDeclaredVariable otherlv_2= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getVariableAccess().getDeclaredVariableParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_9);
                    this_DeclaredVariable_1=ruleDeclaredVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_DeclaredVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_2=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getSemicolonKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleImportedVariable"
    // InternalReflex.g:362:1: entryRuleImportedVariable returns [EObject current=null] : iv_ruleImportedVariable= ruleImportedVariable EOF ;
    public final EObject entryRuleImportedVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedVariable = null;


        try {
            // InternalReflex.g:362:57: (iv_ruleImportedVariable= ruleImportedVariable EOF )
            // InternalReflex.g:363:2: iv_ruleImportedVariable= ruleImportedVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportedVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportedVariable=ruleImportedVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportedVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedVariable"


    // $ANTLR start "ruleImportedVariable"
    // InternalReflex.g:369:1: ruleImportedVariable returns [EObject current=null] : (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )* ) ;
    public final EObject ruleImportedVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token lv_varNames_3_0=null;


        	enterRule();

        try {
            // InternalReflex.g:375:2: ( (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )* ) )
            // InternalReflex.g:376:2: (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )* )
            {
            // InternalReflex.g:376:2: (otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )* )
            // InternalReflex.g:377:3: otherlv_0= 'from' otherlv_1= 'proc' ( (lv_procId_2_0= RULE_ID ) ) ( (lv_varNames_3_0= RULE_ID ) )*
            {
            otherlv_0=(Token)match(input,42,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportedVariableAccess().getFromKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,40,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getImportedVariableAccess().getProcKeyword_1());
              		
            }
            // InternalReflex.g:385:3: ( (lv_procId_2_0= RULE_ID ) )
            // InternalReflex.g:386:4: (lv_procId_2_0= RULE_ID )
            {
            // InternalReflex.g:386:4: (lv_procId_2_0= RULE_ID )
            // InternalReflex.g:387:5: lv_procId_2_0= RULE_ID
            {
            lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_procId_2_0, grammarAccess.getImportedVariableAccess().getProcIdIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportedVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"procId",
              						lv_procId_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:403:3: ( (lv_varNames_3_0= RULE_ID ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReflex.g:404:4: (lv_varNames_3_0= RULE_ID )
            	    {
            	    // InternalReflex.g:404:4: (lv_varNames_3_0= RULE_ID )
            	    // InternalReflex.g:405:5: lv_varNames_3_0= RULE_ID
            	    {
            	    lv_varNames_3_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(lv_varNames_3_0, grammarAccess.getImportedVariableAccess().getVarNamesIDTerminalRuleCall_3_0());
            	      				
            	    }
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElement(grammarAccess.getImportedVariableRule());
            	      					}
            	      					addWithLastConsumed(
            	      						current,
            	      						"varNames",
            	      						lv_varNames_3_0,
            	      						"org.eclipse.xtext.common.Terminals.ID");
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedVariable"


    // $ANTLR start "entryRuleDeclaredVariable"
    // InternalReflex.g:425:1: entryRuleDeclaredVariable returns [EObject current=null] : iv_ruleDeclaredVariable= ruleDeclaredVariable EOF ;
    public final EObject entryRuleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredVariable = null;


        try {
            // InternalReflex.g:425:57: (iv_ruleDeclaredVariable= ruleDeclaredVariable EOF )
            // InternalReflex.g:426:2: iv_ruleDeclaredVariable= ruleDeclaredVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaredVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaredVariable=ruleDeclaredVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaredVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDeclaredVariable"


    // $ANTLR start "ruleDeclaredVariable"
    // InternalReflex.g:432:1: ruleDeclaredVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) ) ;
    public final EObject ruleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;

        EObject lv_visibility_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:438:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) ) )
            // InternalReflex.g:439:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) )
            {
            // InternalReflex.g:439:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) ) )
            // InternalReflex.g:440:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_visibility_2_0= ruleVisibility ) )
            {
            // InternalReflex.g:440:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt7=2;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==43) ) {
                        alt7=1;
                    }
                    else if ( ((LA7_6>=47 && LA7_6<=49)) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT_C_TYPE:
                {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==43) ) {
                        alt7=1;
                    }
                    else if ( ((LA7_6>=47 && LA7_6<=49)) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                int LA7_3 = input.LA(2);

                if ( (LA7_3==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==43) ) {
                        alt7=1;
                    }
                    else if ( ((LA7_6>=47 && LA7_6<=49)) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                int LA7_4 = input.LA(2);

                if ( (LA7_4==RULE_ID) ) {
                    int LA7_6 = input.LA(3);

                    if ( (LA7_6==43) ) {
                        alt7=1;
                    }
                    else if ( ((LA7_6>=47 && LA7_6<=49)) ) {
                        alt7=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_VOID_C_TYPE:
            case RULE_FLOAT_C_TYPE:
            case RULE_DOUBLE_C_TYPE:
            case 99:
            case 100:
                {
                alt7=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalReflex.g:441:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_12);
                    this_PhysicalVariable_0=rulePhysicalVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PhysicalVariable_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:450:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_12);
                    this_ProgramVariable_1=ruleProgramVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ProgramVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:459:3: ( (lv_visibility_2_0= ruleVisibility ) )
            // InternalReflex.g:460:4: (lv_visibility_2_0= ruleVisibility )
            {
            // InternalReflex.g:460:4: (lv_visibility_2_0= ruleVisibility )
            // InternalReflex.g:461:5: lv_visibility_2_0= ruleVisibility
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaredVariableAccess().getVisibilityVisibilityParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_visibility_2_0=ruleVisibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDeclaredVariableRule());
              					}
              					set(
              						current,
              						"visibility",
              						lv_visibility_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Visibility");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDeclaredVariable"


    // $ANTLR start "entryRulePhysicalVariable"
    // InternalReflex.g:482:1: entryRulePhysicalVariable returns [EObject current=null] : iv_rulePhysicalVariable= rulePhysicalVariable EOF ;
    public final EObject entryRulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalVariable = null;


        try {
            // InternalReflex.g:482:57: (iv_rulePhysicalVariable= rulePhysicalVariable EOF )
            // InternalReflex.g:483:2: iv_rulePhysicalVariable= rulePhysicalVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPhysicalVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePhysicalVariable=rulePhysicalVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePhysicalVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicalVariable"


    // $ANTLR start "rulePhysicalVariable"
    // InternalReflex.g:489:1: rulePhysicalVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' ) ;
    public final EObject rulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;

        EObject lv_ports_4_0 = null;

        EObject lv_ports_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:495:2: ( ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' ) )
            // InternalReflex.g:496:2: ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' )
            {
            // InternalReflex.g:496:2: ( ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}' )
            // InternalReflex.g:497:3: ( (lv_type_0_0= ruleIntegerType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '{' ( (lv_ports_4_0= ruleRegisterPort ) ) (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )* otherlv_7= '}'
            {
            // InternalReflex.g:497:3: ( (lv_type_0_0= ruleIntegerType ) )
            // InternalReflex.g:498:4: (lv_type_0_0= ruleIntegerType )
            {
            // InternalReflex.g:498:4: (lv_type_0_0= ruleIntegerType )
            // InternalReflex.g:499:5: lv_type_0_0= ruleIntegerType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getTypeIntegerTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.diagram.Reflex.IntegerType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:516:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:517:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:517:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:518:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPhysicalVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPhysicalVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,43,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPhysicalVariableAccess().getEqualsSignKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,38,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getPhysicalVariableAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:542:3: ( (lv_ports_4_0= ruleRegisterPort ) )
            // InternalReflex.g:543:4: (lv_ports_4_0= ruleRegisterPort )
            {
            // InternalReflex.g:543:4: (lv_ports_4_0= ruleRegisterPort )
            // InternalReflex.g:544:5: lv_ports_4_0= ruleRegisterPort
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getPortsRegisterPortParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_14);
            lv_ports_4_0=ruleRegisterPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					add(
              						current,
              						"ports",
              						lv_ports_4_0,
              						"ru.iaie.reflex.diagram.Reflex.RegisterPort");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:561:3: (otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==44) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalReflex.g:562:4: otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) )
            	    {
            	    otherlv_5=(Token)match(input,44,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_5, grammarAccess.getPhysicalVariableAccess().getCommaKeyword_5_0());
            	      			
            	    }
            	    // InternalReflex.g:566:4: ( (lv_ports_6_0= ruleRegisterPort ) )
            	    // InternalReflex.g:567:5: (lv_ports_6_0= ruleRegisterPort )
            	    {
            	    // InternalReflex.g:567:5: (lv_ports_6_0= ruleRegisterPort )
            	    // InternalReflex.g:568:6: lv_ports_6_0= ruleRegisterPort
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPhysicalVariableAccess().getPortsRegisterPortParserRuleCall_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_ports_6_0=ruleRegisterPort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
            	      						}
            	      						add(
            	      							current,
            	      							"ports",
            	      							lv_ports_6_0,
            	      							"ru.iaie.reflex.diagram.Reflex.RegisterPort");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_7=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getPhysicalVariableAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicalVariable"


    // $ANTLR start "entryRuleRegisterPort"
    // InternalReflex.g:594:1: entryRuleRegisterPort returns [EObject current=null] : iv_ruleRegisterPort= ruleRegisterPort EOF ;
    public final EObject entryRuleRegisterPort() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegisterPort = null;


        try {
            // InternalReflex.g:594:53: (iv_ruleRegisterPort= ruleRegisterPort EOF )
            // InternalReflex.g:595:2: iv_ruleRegisterPort= ruleRegisterPort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterPortRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegisterPort=ruleRegisterPort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegisterPort; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegisterPort"


    // $ANTLR start "ruleRegisterPort"
    // InternalReflex.g:601:1: ruleRegisterPort returns [EObject current=null] : ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' ) ;
    public final EObject ruleRegisterPort() throws RecognitionException {
        EObject current = null;

        Token lv_regName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_port_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:607:2: ( ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' ) )
            // InternalReflex.g:608:2: ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' )
            {
            // InternalReflex.g:608:2: ( ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']' )
            // InternalReflex.g:609:3: ( (lv_regName_0_0= RULE_ID ) ) otherlv_1= '[' ( (lv_port_2_0= ruleInteger ) ) otherlv_3= ']'
            {
            // InternalReflex.g:609:3: ( (lv_regName_0_0= RULE_ID ) )
            // InternalReflex.g:610:4: (lv_regName_0_0= RULE_ID )
            {
            // InternalReflex.g:610:4: (lv_regName_0_0= RULE_ID )
            // InternalReflex.g:611:5: lv_regName_0_0= RULE_ID
            {
            lv_regName_0_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regName_0_0, grammarAccess.getRegisterPortAccess().getRegNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regName",
              						lv_regName_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,45,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRegisterPortAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalReflex.g:631:3: ( (lv_port_2_0= ruleInteger ) )
            // InternalReflex.g:632:4: (lv_port_2_0= ruleInteger )
            {
            // InternalReflex.g:632:4: (lv_port_2_0= ruleInteger )
            // InternalReflex.g:633:5: lv_port_2_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterPortAccess().getPortIntegerParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_port_2_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterPortRule());
              					}
              					set(
              						current,
              						"port",
              						lv_port_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getRegisterPortAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterPort"


    // $ANTLR start "entryRuleProgramVariable"
    // InternalReflex.g:658:1: entryRuleProgramVariable returns [EObject current=null] : iv_ruleProgramVariable= ruleProgramVariable EOF ;
    public final EObject entryRuleProgramVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramVariable = null;


        try {
            // InternalReflex.g:658:56: (iv_ruleProgramVariable= ruleProgramVariable EOF )
            // InternalReflex.g:659:2: iv_ruleProgramVariable= ruleProgramVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgramVariable=ruleProgramVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgramVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramVariable"


    // $ANTLR start "ruleProgramVariable"
    // InternalReflex.g:665:1: ruleProgramVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProgramVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:671:2: ( ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:672:2: ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:672:2: ( ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalReflex.g:673:3: ( (lv_type_0_0= ruleReflexType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalReflex.g:673:3: ( (lv_type_0_0= ruleReflexType ) )
            // InternalReflex.g:674:4: (lv_type_0_0= ruleReflexType )
            {
            // InternalReflex.g:674:4: (lv_type_0_0= ruleReflexType )
            // InternalReflex.g:675:5: lv_type_0_0= ruleReflexType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProgramVariableAccess().getTypeReflexTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleReflexType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProgramVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.diagram.Reflex.ReflexType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:692:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:693:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:693:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:694:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProgramVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramVariable"


    // $ANTLR start "entryRuleVisibility"
    // InternalReflex.g:714:1: entryRuleVisibility returns [EObject current=null] : iv_ruleVisibility= ruleVisibility EOF ;
    public final EObject entryRuleVisibility() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibility = null;


        try {
            // InternalReflex.g:714:51: (iv_ruleVisibility= ruleVisibility EOF )
            // InternalReflex.g:715:2: iv_ruleVisibility= ruleVisibility EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVisibilityRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVisibility=ruleVisibility();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVisibility; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVisibility"


    // $ANTLR start "ruleVisibility"
    // InternalReflex.g:721:1: ruleVisibility returns [EObject current=null] : ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* ) ) ;
    public final EObject ruleVisibility() throws RecognitionException {
        EObject current = null;

        Token lv_LOCAL_0_0=null;
        Token lv_GLOBAL_1_0=null;
        Token lv_SHARED_2_0=null;
        Token lv_sharingProcs_3_0=null;


        	enterRule();

        try {
            // InternalReflex.g:727:2: ( ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* ) ) )
            // InternalReflex.g:728:2: ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* ) )
            {
            // InternalReflex.g:728:2: ( ( (lv_LOCAL_0_0= 'local' ) ) | ( (lv_GLOBAL_1_0= 'global' ) ) | ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 47:
                {
                alt10=1;
                }
                break;
            case 48:
                {
                alt10=2;
                }
                break;
            case 49:
                {
                alt10=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalReflex.g:729:3: ( (lv_LOCAL_0_0= 'local' ) )
                    {
                    // InternalReflex.g:729:3: ( (lv_LOCAL_0_0= 'local' ) )
                    // InternalReflex.g:730:4: (lv_LOCAL_0_0= 'local' )
                    {
                    // InternalReflex.g:730:4: (lv_LOCAL_0_0= 'local' )
                    // InternalReflex.g:731:5: lv_LOCAL_0_0= 'local'
                    {
                    lv_LOCAL_0_0=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_LOCAL_0_0, grammarAccess.getVisibilityAccess().getLOCALLocalKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVisibilityRule());
                      					}
                      					setWithLastConsumed(current, "LOCAL", lv_LOCAL_0_0, "local");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:744:3: ( (lv_GLOBAL_1_0= 'global' ) )
                    {
                    // InternalReflex.g:744:3: ( (lv_GLOBAL_1_0= 'global' ) )
                    // InternalReflex.g:745:4: (lv_GLOBAL_1_0= 'global' )
                    {
                    // InternalReflex.g:745:4: (lv_GLOBAL_1_0= 'global' )
                    // InternalReflex.g:746:5: lv_GLOBAL_1_0= 'global'
                    {
                    lv_GLOBAL_1_0=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_GLOBAL_1_0, grammarAccess.getVisibilityAccess().getGLOBALGlobalKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getVisibilityRule());
                      					}
                      					setWithLastConsumed(current, "GLOBAL", lv_GLOBAL_1_0, "global");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:759:3: ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* )
                    {
                    // InternalReflex.g:759:3: ( ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )* )
                    // InternalReflex.g:760:4: ( (lv_SHARED_2_0= 'shared' ) ) ( (lv_sharingProcs_3_0= RULE_ID ) )*
                    {
                    // InternalReflex.g:760:4: ( (lv_SHARED_2_0= 'shared' ) )
                    // InternalReflex.g:761:5: (lv_SHARED_2_0= 'shared' )
                    {
                    // InternalReflex.g:761:5: (lv_SHARED_2_0= 'shared' )
                    // InternalReflex.g:762:6: lv_SHARED_2_0= 'shared'
                    {
                    lv_SHARED_2_0=(Token)match(input,49,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_SHARED_2_0, grammarAccess.getVisibilityAccess().getSHAREDSharedKeyword_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVisibilityRule());
                      						}
                      						setWithLastConsumed(current, "SHARED", lv_SHARED_2_0, "shared");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:774:4: ( (lv_sharingProcs_3_0= RULE_ID ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // InternalReflex.g:775:5: (lv_sharingProcs_3_0= RULE_ID )
                    	    {
                    	    // InternalReflex.g:775:5: (lv_sharingProcs_3_0= RULE_ID )
                    	    // InternalReflex.g:776:6: lv_sharingProcs_3_0= RULE_ID
                    	    {
                    	    lv_sharingProcs_3_0=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						newLeafNode(lv_sharingProcs_3_0, grammarAccess.getVisibilityAccess().getSharingProcsIDTerminalRuleCall_2_1_0());
                    	      					
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElement(grammarAccess.getVisibilityRule());
                    	      						}
                    	      						addWithLastConsumed(
                    	      							current,
                    	      							"sharingProcs",
                    	      							lv_sharingProcs_3_0,
                    	      							"org.eclipse.xtext.common.Terminals.ID");
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVisibility"


    // $ANTLR start "entryRuleState"
    // InternalReflex.g:797:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalReflex.g:797:46: (iv_ruleState= ruleState EOF )
            // InternalReflex.g:798:2: iv_ruleState= ruleState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleState; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalReflex.g:804:1: ruleState returns [EObject current=null] : (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_statements_3_0 = null;

        EObject lv_timeoutFunction_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:810:2: ( (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' ) )
            // InternalReflex.g:811:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' )
            {
            // InternalReflex.g:811:2: (otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}' )
            // InternalReflex.g:812:3: otherlv_0= 'state' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_statements_3_0= ruleStatement ) )* ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )? otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStateAccess().getStateKeyword_0());
              		
            }
            // InternalReflex.g:816:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:817:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:817:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:818:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStateRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:838:3: ( (lv_statements_3_0= ruleStatement ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||(LA11_0>=RULE_DECIMAL && LA11_0<=RULE_HEX)||LA11_0==38||LA11_0==41||(LA11_0>=52 && LA11_0<=53)||LA11_0==56||(LA11_0>=60 && LA11_0<=65)||(LA11_0>=73 && LA11_0<=74)||(LA11_0>=84 && LA11_0<=87)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalReflex.g:839:4: (lv_statements_3_0= ruleStatement )
            	    {
            	    // InternalReflex.g:839:4: (lv_statements_3_0= ruleStatement )
            	    // InternalReflex.g:840:5: lv_statements_3_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStateAccess().getStatementsStatementParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_18);
            	    lv_statements_3_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getStateRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_3_0,
            	      						"ru.iaie.reflex.diagram.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalReflex.g:857:3: ( (lv_timeoutFunction_4_0= ruleTimeoutFunction ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==51) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalReflex.g:858:4: (lv_timeoutFunction_4_0= ruleTimeoutFunction )
                    {
                    // InternalReflex.g:858:4: (lv_timeoutFunction_4_0= ruleTimeoutFunction )
                    // InternalReflex.g:859:5: lv_timeoutFunction_4_0= ruleTimeoutFunction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStateAccess().getTimeoutFunctionTimeoutFunctionParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_19);
                    lv_timeoutFunction_4_0=ruleTimeoutFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStateRule());
                      					}
                      					set(
                      						current,
                      						"timeoutFunction",
                      						lv_timeoutFunction_4_0,
                      						"ru.iaie.reflex.diagram.Reflex.TimeoutFunction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleTimeoutFunction"
    // InternalReflex.g:884:1: entryRuleTimeoutFunction returns [EObject current=null] : iv_ruleTimeoutFunction= ruleTimeoutFunction EOF ;
    public final EObject entryRuleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutFunction = null;


        try {
            // InternalReflex.g:884:56: (iv_ruleTimeoutFunction= ruleTimeoutFunction EOF )
            // InternalReflex.g:885:2: iv_ruleTimeoutFunction= ruleTimeoutFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeoutFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTimeoutFunction=ruleTimeoutFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeoutFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeoutFunction"


    // $ANTLR start "ruleTimeoutFunction"
    // InternalReflex.g:891:1: ruleTimeoutFunction returns [EObject current=null] : (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) ) ;
    public final EObject ruleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_time_1_0 = null;

        EObject lv_body_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:897:2: ( (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) ) )
            // InternalReflex.g:898:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) )
            {
            // InternalReflex.g:898:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) ) )
            // InternalReflex.g:899:3: otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_body_2_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTimeoutFunctionAccess().getTimeoutKeyword_0());
              		
            }
            // InternalReflex.g:903:3: ( (lv_time_1_0= ruleTime ) )
            // InternalReflex.g:904:4: (lv_time_1_0= ruleTime )
            {
            // InternalReflex.g:904:4: (lv_time_1_0= ruleTime )
            // InternalReflex.g:905:5: lv_time_1_0= ruleTime
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeTimeParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_time_1_0=ruleTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
              					}
              					set(
              						current,
              						"time",
              						lv_time_1_0,
              						"ru.iaie.reflex.diagram.Reflex.Time");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:922:3: ( (lv_body_2_0= ruleStatement ) )
            // InternalReflex.g:923:4: (lv_body_2_0= ruleStatement )
            {
            // InternalReflex.g:923:4: (lv_body_2_0= ruleStatement )
            // InternalReflex.g:924:5: lv_body_2_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getBodyStatementParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_2_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeoutFunction"


    // $ANTLR start "entryRuleStatement"
    // InternalReflex.g:945:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalReflex.g:945:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalReflex.g:946:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalReflex.g:952:1: ruleStatement returns [EObject current=null] : ( ( () otherlv_1= ';' ) | this_StartProcStat_2= ruleStartProcStat | this_StopProcStat_3= ruleStopProcStat | this_ErrorStat_4= ruleErrorStat | ( () ( (lv_loop_6_0= ruleLoopStat ) ) ) | ( () ( (lv_restart_8_0= ruleRestartStat ) ) ) | this_SetStateStat_9= ruleSetStateStat | this_CompoundStatement_10= ruleCompoundStatement | this_IfElseStat_11= ruleIfElseStat | this_SwitchStat_12= ruleSwitchStat | this_ExpressionStatement_13= ruleExpressionStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_StartProcStat_2 = null;

        EObject this_StopProcStat_3 = null;

        EObject this_ErrorStat_4 = null;

        AntlrDatatypeRuleToken lv_loop_6_0 = null;

        AntlrDatatypeRuleToken lv_restart_8_0 = null;

        EObject this_SetStateStat_9 = null;

        EObject this_CompoundStatement_10 = null;

        EObject this_IfElseStat_11 = null;

        EObject this_SwitchStat_12 = null;

        EObject this_ExpressionStatement_13 = null;



        	enterRule();

        try {
            // InternalReflex.g:958:2: ( ( ( () otherlv_1= ';' ) | this_StartProcStat_2= ruleStartProcStat | this_StopProcStat_3= ruleStopProcStat | this_ErrorStat_4= ruleErrorStat | ( () ( (lv_loop_6_0= ruleLoopStat ) ) ) | ( () ( (lv_restart_8_0= ruleRestartStat ) ) ) | this_SetStateStat_9= ruleSetStateStat | this_CompoundStatement_10= ruleCompoundStatement | this_IfElseStat_11= ruleIfElseStat | this_SwitchStat_12= ruleSwitchStat | this_ExpressionStatement_13= ruleExpressionStatement ) )
            // InternalReflex.g:959:2: ( ( () otherlv_1= ';' ) | this_StartProcStat_2= ruleStartProcStat | this_StopProcStat_3= ruleStopProcStat | this_ErrorStat_4= ruleErrorStat | ( () ( (lv_loop_6_0= ruleLoopStat ) ) ) | ( () ( (lv_restart_8_0= ruleRestartStat ) ) ) | this_SetStateStat_9= ruleSetStateStat | this_CompoundStatement_10= ruleCompoundStatement | this_IfElseStat_11= ruleIfElseStat | this_SwitchStat_12= ruleSwitchStat | this_ExpressionStatement_13= ruleExpressionStatement )
            {
            // InternalReflex.g:959:2: ( ( () otherlv_1= ';' ) | this_StartProcStat_2= ruleStartProcStat | this_StopProcStat_3= ruleStopProcStat | this_ErrorStat_4= ruleErrorStat | ( () ( (lv_loop_6_0= ruleLoopStat ) ) ) | ( () ( (lv_restart_8_0= ruleRestartStat ) ) ) | this_SetStateStat_9= ruleSetStateStat | this_CompoundStatement_10= ruleCompoundStatement | this_IfElseStat_11= ruleIfElseStat | this_SwitchStat_12= ruleSwitchStat | this_ExpressionStatement_13= ruleExpressionStatement )
            int alt13=11;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt13=1;
                }
                break;
            case 60:
                {
                alt13=2;
                }
                break;
            case 61:
                {
                alt13=3;
                }
                break;
            case 62:
                {
                alt13=4;
                }
                break;
            case 63:
                {
                alt13=5;
                }
                break;
            case 64:
                {
                alt13=6;
                }
                break;
            case 65:
                {
                alt13=7;
                }
                break;
            case 38:
                {
                alt13=8;
                }
                break;
            case 52:
                {
                alt13=9;
                }
                break;
            case 56:
                {
                alt13=10;
                }
                break;
            case RULE_ID:
            case RULE_DECIMAL:
            case RULE_OCTAL:
            case RULE_HEX:
            case 53:
            case 73:
            case 74:
            case 84:
            case 85:
            case 86:
            case 87:
                {
                alt13=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalReflex.g:960:3: ( () otherlv_1= ';' )
                    {
                    // InternalReflex.g:960:3: ( () otherlv_1= ';' )
                    // InternalReflex.g:961:4: () otherlv_1= ';'
                    {
                    // InternalReflex.g:961:4: ()
                    // InternalReflex.g:962:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getStatementAccess().getStatementAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:974:3: this_StartProcStat_2= ruleStartProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStartProcStatParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StartProcStat_2=ruleStartProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StartProcStat_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:983:3: this_StopProcStat_3= ruleStopProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStopProcStatParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StopProcStat_3=ruleStopProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StopProcStat_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:992:3: this_ErrorStat_4= ruleErrorStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getErrorStatParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ErrorStat_4=ruleErrorStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ErrorStat_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:1001:3: ( () ( (lv_loop_6_0= ruleLoopStat ) ) )
                    {
                    // InternalReflex.g:1001:3: ( () ( (lv_loop_6_0= ruleLoopStat ) ) )
                    // InternalReflex.g:1002:4: () ( (lv_loop_6_0= ruleLoopStat ) )
                    {
                    // InternalReflex.g:1002:4: ()
                    // InternalReflex.g:1003:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getStatementAccess().getStatementAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:1009:4: ( (lv_loop_6_0= ruleLoopStat ) )
                    // InternalReflex.g:1010:5: (lv_loop_6_0= ruleLoopStat )
                    {
                    // InternalReflex.g:1010:5: (lv_loop_6_0= ruleLoopStat )
                    // InternalReflex.g:1011:6: lv_loop_6_0= ruleLoopStat
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStatementAccess().getLoopLoopStatParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_loop_6_0=ruleLoopStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getStatementRule());
                      						}
                      						set(
                      							current,
                      							"loop",
                      							true,
                      							"ru.iaie.reflex.diagram.Reflex.LoopStat");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:1030:3: ( () ( (lv_restart_8_0= ruleRestartStat ) ) )
                    {
                    // InternalReflex.g:1030:3: ( () ( (lv_restart_8_0= ruleRestartStat ) ) )
                    // InternalReflex.g:1031:4: () ( (lv_restart_8_0= ruleRestartStat ) )
                    {
                    // InternalReflex.g:1031:4: ()
                    // InternalReflex.g:1032:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getStatementAccess().getStatementAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:1038:4: ( (lv_restart_8_0= ruleRestartStat ) )
                    // InternalReflex.g:1039:5: (lv_restart_8_0= ruleRestartStat )
                    {
                    // InternalReflex.g:1039:5: (lv_restart_8_0= ruleRestartStat )
                    // InternalReflex.g:1040:6: lv_restart_8_0= ruleRestartStat
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getStatementAccess().getRestartRestartStatParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_restart_8_0=ruleRestartStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getStatementRule());
                      						}
                      						set(
                      							current,
                      							"restart",
                      							true,
                      							"ru.iaie.reflex.diagram.Reflex.RestartStat");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:1059:3: this_SetStateStat_9= ruleSetStateStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSetStateStatParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SetStateStat_9=ruleSetStateStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetStateStat_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalReflex.g:1068:3: this_CompoundStatement_10= ruleCompoundStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getCompoundStatementParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CompoundStatement_10=ruleCompoundStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CompoundStatement_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalReflex.g:1077:3: this_IfElseStat_11= ruleIfElseStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getIfElseStatParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfElseStat_11=ruleIfElseStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfElseStat_11;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalReflex.g:1086:3: this_SwitchStat_12= ruleSwitchStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SwitchStat_12=ruleSwitchStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SwitchStat_12;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalReflex.g:1095:3: this_ExpressionStatement_13= ruleExpressionStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getExpressionStatementParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExpressionStatement_13=ruleExpressionStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExpressionStatement_13;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleCompoundStatement"
    // InternalReflex.g:1107:1: entryRuleCompoundStatement returns [EObject current=null] : iv_ruleCompoundStatement= ruleCompoundStatement EOF ;
    public final EObject entryRuleCompoundStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundStatement = null;


        try {
            // InternalReflex.g:1107:58: (iv_ruleCompoundStatement= ruleCompoundStatement EOF )
            // InternalReflex.g:1108:2: iv_ruleCompoundStatement= ruleCompoundStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompoundStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompoundStatement=ruleCompoundStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompoundStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompoundStatement"


    // $ANTLR start "ruleCompoundStatement"
    // InternalReflex.g:1114:1: ruleCompoundStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleCompoundStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1120:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalReflex.g:1121:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalReflex.g:1121:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalReflex.g:1122:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalReflex.g:1122:3: ()
            // InternalReflex.g:1123:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCompoundStatementAccess().getCompoundStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,38,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalReflex.g:1133:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID||(LA14_0>=RULE_DECIMAL && LA14_0<=RULE_HEX)||LA14_0==38||LA14_0==41||(LA14_0>=52 && LA14_0<=53)||LA14_0==56||(LA14_0>=60 && LA14_0<=65)||(LA14_0>=73 && LA14_0<=74)||(LA14_0>=84 && LA14_0<=87)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalReflex.g:1134:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalReflex.g:1134:4: (lv_statements_2_0= ruleStatement )
            	    // InternalReflex.g:1135:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundStatementAccess().getStatementsStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompoundStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"ru.iaie.reflex.diagram.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            otherlv_3=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCompoundStatementAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompoundStatement"


    // $ANTLR start "entryRuleExpressionStatement"
    // InternalReflex.g:1160:1: entryRuleExpressionStatement returns [EObject current=null] : iv_ruleExpressionStatement= ruleExpressionStatement EOF ;
    public final EObject entryRuleExpressionStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressionStatement = null;


        try {
            // InternalReflex.g:1160:60: (iv_ruleExpressionStatement= ruleExpressionStatement EOF )
            // InternalReflex.g:1161:2: iv_ruleExpressionStatement= ruleExpressionStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpressionStatement=ruleExpressionStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpressionStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpressionStatement"


    // $ANTLR start "ruleExpressionStatement"
    // InternalReflex.g:1167:1: ruleExpressionStatement returns [EObject current=null] : ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) ;
    public final EObject ruleExpressionStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expr_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1173:2: ( ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' ) )
            // InternalReflex.g:1174:2: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            {
            // InternalReflex.g:1174:2: ( ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';' )
            // InternalReflex.g:1175:3: ( (lv_expr_0_0= ruleExpression ) ) otherlv_1= ';'
            {
            // InternalReflex.g:1175:3: ( (lv_expr_0_0= ruleExpression ) )
            // InternalReflex.g:1176:4: (lv_expr_0_0= ruleExpression )
            {
            // InternalReflex.g:1176:4: (lv_expr_0_0= ruleExpression )
            // InternalReflex.g:1177:5: lv_expr_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getExpressionStatementAccess().getExprExpressionParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_expr_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getExpressionStatementRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_0_0,
              						"ru.iaie.reflex.diagram.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExpressionStatementAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpressionStatement"


    // $ANTLR start "entryRuleIfElseStat"
    // InternalReflex.g:1202:1: entryRuleIfElseStat returns [EObject current=null] : iv_ruleIfElseStat= ruleIfElseStat EOF ;
    public final EObject entryRuleIfElseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseStat = null;


        try {
            // InternalReflex.g:1202:51: (iv_ruleIfElseStat= ruleIfElseStat EOF )
            // InternalReflex.g:1203:2: iv_ruleIfElseStat= ruleIfElseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfElseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfElseStat=ruleIfElseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfElseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfElseStat"


    // $ANTLR start "ruleIfElseStat"
    // InternalReflex.g:1209:1: ruleIfElseStat returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) ;
    public final EObject ruleIfElseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_cond_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1215:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) )
            // InternalReflex.g:1216:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            {
            // InternalReflex.g:1216:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            // InternalReflex.g:1217:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfElseStatAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,53,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfElseStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1225:3: ( (lv_cond_2_0= ruleExpression ) )
            // InternalReflex.g:1226:4: (lv_cond_2_0= ruleExpression )
            {
            // InternalReflex.g:1226:4: (lv_cond_2_0= ruleExpression )
            // InternalReflex.g:1227:5: lv_cond_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getCondExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_cond_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,54,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfElseStatAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalReflex.g:1248:3: ( (lv_then_4_0= ruleStatement ) )
            // InternalReflex.g:1249:4: (lv_then_4_0= ruleStatement )
            {
            // InternalReflex.g:1249:4: (lv_then_4_0= ruleStatement )
            // InternalReflex.g:1250:5: lv_then_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getThenStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_25);
            lv_then_4_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"ru.iaie.reflex.diagram.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1267:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==55) ) {
                int LA15_1 = input.LA(2);

                if ( (synpred1_InternalReflex()) ) {
                    alt15=1;
                }
            }
            switch (alt15) {
                case 1 :
                    // InternalReflex.g:1268:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) )
                    {
                    // InternalReflex.g:1268:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalReflex.g:1269:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,55,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfElseStatAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalReflex.g:1275:4: ( (lv_else_6_0= ruleStatement ) )
                    // InternalReflex.g:1276:5: (lv_else_6_0= ruleStatement )
                    {
                    // InternalReflex.g:1276:5: (lv_else_6_0= ruleStatement )
                    // InternalReflex.g:1277:6: lv_else_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfElseStatAccess().getElseStatementParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_6_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfElseStatRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_6_0,
                      							"ru.iaie.reflex.diagram.Reflex.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfElseStat"


    // $ANTLR start "entryRuleSwitchStat"
    // InternalReflex.g:1299:1: entryRuleSwitchStat returns [EObject current=null] : iv_ruleSwitchStat= ruleSwitchStat EOF ;
    public final EObject entryRuleSwitchStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStat = null;


        try {
            // InternalReflex.g:1299:51: (iv_ruleSwitchStat= ruleSwitchStat EOF )
            // InternalReflex.g:1300:2: iv_ruleSwitchStat= ruleSwitchStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitchStat=ruleSwitchStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchStat"


    // $ANTLR start "ruleSwitchStat"
    // InternalReflex.g:1306:1: ruleSwitchStat returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) ;
    public final EObject ruleSwitchStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expr_2_0 = null;

        EObject lv_options_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1312:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) )
            // InternalReflex.g:1313:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:1313:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            // InternalReflex.g:1314:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,56,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,53,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1322:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalReflex.g:1323:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalReflex.g:1323:4: (lv_expr_2_0= ruleExpression )
            // InternalReflex.g:1324:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_24);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,54,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,38,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:1349:3: ( (lv_options_5_0= ruleCaseStat ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==57) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalReflex.g:1350:4: (lv_options_5_0= ruleCaseStat )
            	    {
            	    // InternalReflex.g:1350:4: (lv_options_5_0= ruleCaseStat )
            	    // InternalReflex.g:1351:5: lv_options_5_0= ruleCaseStat
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchStatAccess().getOptionsCaseStatParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_26);
            	    lv_options_5_0=ruleCaseStat();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
            	      					}
            	      					add(
            	      						current,
            	      						"options",
            	      						lv_options_5_0,
            	      						"ru.iaie.reflex.diagram.Reflex.CaseStat");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_6=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSwitchStatAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchStat"


    // $ANTLR start "entryRuleCaseStat"
    // InternalReflex.g:1376:1: entryRuleCaseStat returns [EObject current=null] : iv_ruleCaseStat= ruleCaseStat EOF ;
    public final EObject entryRuleCaseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStat = null;


        try {
            // InternalReflex.g:1376:49: (iv_ruleCaseStat= ruleCaseStat EOF )
            // InternalReflex.g:1377:2: iv_ruleCaseStat= ruleCaseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCaseStat=ruleCaseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseStat"


    // $ANTLR start "ruleCaseStat"
    // InternalReflex.g:1383:1: ruleCaseStat returns [EObject current=null] : (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatement ) ) (otherlv_4= 'break' otherlv_5= ';' ) ) ;
    public final EObject ruleCaseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_option_1_0 = null;

        EObject lv_body_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1389:2: ( (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatement ) ) (otherlv_4= 'break' otherlv_5= ';' ) ) )
            // InternalReflex.g:1390:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatement ) ) (otherlv_4= 'break' otherlv_5= ';' ) )
            {
            // InternalReflex.g:1390:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatement ) ) (otherlv_4= 'break' otherlv_5= ';' ) )
            // InternalReflex.g:1391:3: otherlv_0= 'case' ( (lv_option_1_0= ruleInteger ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatement ) ) (otherlv_4= 'break' otherlv_5= ';' )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCaseStatAccess().getCaseKeyword_0());
              		
            }
            // InternalReflex.g:1395:3: ( (lv_option_1_0= ruleInteger ) )
            // InternalReflex.g:1396:4: (lv_option_1_0= ruleInteger )
            {
            // InternalReflex.g:1396:4: (lv_option_1_0= ruleInteger )
            // InternalReflex.g:1397:5: lv_option_1_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getOptionIntegerParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_27);
            lv_option_1_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"option",
              						lv_option_1_0,
              						"ru.iaie.reflex.diagram.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,58,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCaseStatAccess().getColonKeyword_2());
              		
            }
            // InternalReflex.g:1418:3: ( (lv_body_3_0= ruleStatement ) )
            // InternalReflex.g:1419:4: (lv_body_3_0= ruleStatement )
            {
            // InternalReflex.g:1419:4: (lv_body_3_0= ruleStatement )
            // InternalReflex.g:1420:5: lv_body_3_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getBodyStatementParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_28);
            lv_body_3_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_3_0,
              						"ru.iaie.reflex.diagram.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1437:3: (otherlv_4= 'break' otherlv_5= ';' )
            // InternalReflex.g:1438:4: otherlv_4= 'break' otherlv_5= ';'
            {
            otherlv_4=(Token)match(input,59,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getCaseStatAccess().getBreakKeyword_4_0());
              			
            }
            otherlv_5=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_5, grammarAccess.getCaseStatAccess().getSemicolonKeyword_4_1());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseStat"


    // $ANTLR start "entryRuleStartProcStat"
    // InternalReflex.g:1451:1: entryRuleStartProcStat returns [EObject current=null] : iv_ruleStartProcStat= ruleStartProcStat EOF ;
    public final EObject entryRuleStartProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcStat = null;


        try {
            // InternalReflex.g:1451:54: (iv_ruleStartProcStat= ruleStartProcStat EOF )
            // InternalReflex.g:1452:2: iv_ruleStartProcStat= ruleStartProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStartProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStartProcStat=ruleStartProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStartProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartProcStat"


    // $ANTLR start "ruleStartProcStat"
    // InternalReflex.g:1458:1: ruleStartProcStat returns [EObject current=null] : (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' ) ;
    public final EObject ruleStartProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_procId_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1464:2: ( (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' ) )
            // InternalReflex.g:1465:2: (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:1465:2: (otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';' )
            // InternalReflex.g:1466:3: otherlv_0= 'start' ( (lv_procId_1_0= RULE_ID ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStartProcStatAccess().getStartKeyword_0());
              		
            }
            // InternalReflex.g:1470:3: ( (lv_procId_1_0= RULE_ID ) )
            // InternalReflex.g:1471:4: (lv_procId_1_0= RULE_ID )
            {
            // InternalReflex.g:1471:4: (lv_procId_1_0= RULE_ID )
            // InternalReflex.g:1472:5: lv_procId_1_0= RULE_ID
            {
            lv_procId_1_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_procId_1_0, grammarAccess.getStartProcStatAccess().getProcIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStartProcStatRule());
              					}
              					setWithLastConsumed(
              						current,
              						"procId",
              						lv_procId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStartProcStatAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartProcStat"


    // $ANTLR start "entryRuleStopProcStat"
    // InternalReflex.g:1496:1: entryRuleStopProcStat returns [EObject current=null] : iv_ruleStopProcStat= ruleStopProcStat EOF ;
    public final EObject entryRuleStopProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcStat = null;


        try {
            // InternalReflex.g:1496:53: (iv_ruleStopProcStat= ruleStopProcStat EOF )
            // InternalReflex.g:1497:2: iv_ruleStopProcStat= ruleStopProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStopProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStopProcStat=ruleStopProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStopProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStopProcStat"


    // $ANTLR start "ruleStopProcStat"
    // InternalReflex.g:1503:1: ruleStopProcStat returns [EObject current=null] : ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) ;
    public final EObject ruleStopProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1509:2: ( ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) )
            // InternalReflex.g:1510:2: ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            {
            // InternalReflex.g:1510:2: ( () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            // InternalReflex.g:1511:3: () otherlv_1= 'stop' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';'
            {
            // InternalReflex.g:1511:3: ()
            // InternalReflex.g:1512:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStopProcStatAccess().getStopProcStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStopProcStatAccess().getStopKeyword_1());
              		
            }
            // InternalReflex.g:1522:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalReflex.g:1523:4: (lv_procId_2_0= RULE_ID )
                    {
                    // InternalReflex.g:1523:4: (lv_procId_2_0= RULE_ID )
                    // InternalReflex.g:1524:5: lv_procId_2_0= RULE_ID
                    {
                    lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_procId_2_0, grammarAccess.getStopProcStatAccess().getProcIdIDTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getStopProcStatRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"procId",
                      						lv_procId_2_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStopProcStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStopProcStat"


    // $ANTLR start "entryRuleErrorStat"
    // InternalReflex.g:1548:1: entryRuleErrorStat returns [EObject current=null] : iv_ruleErrorStat= ruleErrorStat EOF ;
    public final EObject entryRuleErrorStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorStat = null;


        try {
            // InternalReflex.g:1548:50: (iv_ruleErrorStat= ruleErrorStat EOF )
            // InternalReflex.g:1549:2: iv_ruleErrorStat= ruleErrorStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleErrorStat=ruleErrorStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorStat"


    // $ANTLR start "ruleErrorStat"
    // InternalReflex.g:1555:1: ruleErrorStat returns [EObject current=null] : ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) ;
    public final EObject ruleErrorStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_procId_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1561:2: ( ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' ) )
            // InternalReflex.g:1562:2: ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            {
            // InternalReflex.g:1562:2: ( () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';' )
            // InternalReflex.g:1563:3: () otherlv_1= 'error' ( (lv_procId_2_0= RULE_ID ) )? otherlv_3= ';'
            {
            // InternalReflex.g:1563:3: ()
            // InternalReflex.g:1564:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getErrorStatAccess().getErrorStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,62,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getErrorStatAccess().getErrorKeyword_1());
              		
            }
            // InternalReflex.g:1574:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalReflex.g:1575:4: (lv_procId_2_0= RULE_ID )
                    {
                    // InternalReflex.g:1575:4: (lv_procId_2_0= RULE_ID )
                    // InternalReflex.g:1576:5: lv_procId_2_0= RULE_ID
                    {
                    lv_procId_2_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_procId_2_0, grammarAccess.getErrorStatAccess().getProcIdIDTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getErrorStatRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"procId",
                      						lv_procId_2_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getErrorStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorStat"


    // $ANTLR start "entryRuleLoopStat"
    // InternalReflex.g:1600:1: entryRuleLoopStat returns [String current=null] : iv_ruleLoopStat= ruleLoopStat EOF ;
    public final String entryRuleLoopStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLoopStat = null;


        try {
            // InternalReflex.g:1600:48: (iv_ruleLoopStat= ruleLoopStat EOF )
            // InternalReflex.g:1601:2: iv_ruleLoopStat= ruleLoopStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoopStat=ruleLoopStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopStat.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoopStat"


    // $ANTLR start "ruleLoopStat"
    // InternalReflex.g:1607:1: ruleLoopStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'loop' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleLoopStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:1613:2: ( (kw= 'loop' kw= ';' ) )
            // InternalReflex.g:1614:2: (kw= 'loop' kw= ';' )
            {
            // InternalReflex.g:1614:2: (kw= 'loop' kw= ';' )
            // InternalReflex.g:1615:3: kw= 'loop' kw= ';'
            {
            kw=(Token)match(input,63,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getLoopStatAccess().getLoopKeyword_0());
              		
            }
            kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getLoopStatAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoopStat"


    // $ANTLR start "entryRuleRestartStat"
    // InternalReflex.g:1629:1: entryRuleRestartStat returns [String current=null] : iv_ruleRestartStat= ruleRestartStat EOF ;
    public final String entryRuleRestartStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRestartStat = null;


        try {
            // InternalReflex.g:1629:51: (iv_ruleRestartStat= ruleRestartStat EOF )
            // InternalReflex.g:1630:2: iv_ruleRestartStat= ruleRestartStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRestartStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRestartStat=ruleRestartStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRestartStat.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestartStat"


    // $ANTLR start "ruleRestartStat"
    // InternalReflex.g:1636:1: ruleRestartStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'restart' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleRestartStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:1642:2: ( (kw= 'restart' kw= ';' ) )
            // InternalReflex.g:1643:2: (kw= 'restart' kw= ';' )
            {
            // InternalReflex.g:1643:2: (kw= 'restart' kw= ';' )
            // InternalReflex.g:1644:3: kw= 'restart' kw= ';'
            {
            kw=(Token)match(input,64,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRestartStatAccess().getRestartKeyword_0());
              		
            }
            kw=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRestartStatAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestartStat"


    // $ANTLR start "entryRuleSetStateStat"
    // InternalReflex.g:1658:1: entryRuleSetStateStat returns [EObject current=null] : iv_ruleSetStateStat= ruleSetStateStat EOF ;
    public final EObject entryRuleSetStateStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStat = null;


        try {
            // InternalReflex.g:1658:53: (iv_ruleSetStateStat= ruleSetStateStat EOF )
            // InternalReflex.g:1659:2: iv_ruleSetStateStat= ruleSetStateStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetStateStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetStateStat=ruleSetStateStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetStateStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetStateStat"


    // $ANTLR start "ruleSetStateStat"
    // InternalReflex.g:1665:1: ruleSetStateStat returns [EObject current=null] : ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' ) ;
    public final EObject ruleSetStateStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_stateId_3_0=null;
        Token lv_next_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalReflex.g:1671:2: ( ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1672:2: ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1672:2: ( () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';' )
            // InternalReflex.g:1673:3: () otherlv_1= 'set' ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1673:3: ()
            // InternalReflex.g:1674:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetStateStatAccess().getSetStateStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,65,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetStateStatAccess().getSetKeyword_1());
              		
            }
            // InternalReflex.g:1684:3: ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==50) ) {
                alt19=1;
            }
            else if ( (LA19_0==66) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalReflex.g:1685:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    {
                    // InternalReflex.g:1685:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    // InternalReflex.g:1686:5: otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getSetStateStatAccess().getStateKeyword_2_0_0());
                      				
                    }
                    // InternalReflex.g:1690:5: ( (lv_stateId_3_0= RULE_ID ) )
                    // InternalReflex.g:1691:6: (lv_stateId_3_0= RULE_ID )
                    {
                    // InternalReflex.g:1691:6: (lv_stateId_3_0= RULE_ID )
                    // InternalReflex.g:1692:7: lv_stateId_3_0= RULE_ID
                    {
                    lv_stateId_3_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_stateId_3_0, grammarAccess.getSetStateStatAccess().getStateIdIDTerminalRuleCall_2_0_1_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getSetStateStatRule());
                      							}
                      							setWithLastConsumed(
                      								current,
                      								"stateId",
                      								lv_stateId_3_0,
                      								"org.eclipse.xtext.common.Terminals.ID");
                      						
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1710:4: ( (lv_next_4_0= 'next' ) )
                    {
                    // InternalReflex.g:1710:4: ( (lv_next_4_0= 'next' ) )
                    // InternalReflex.g:1711:5: (lv_next_4_0= 'next' )
                    {
                    // InternalReflex.g:1711:5: (lv_next_4_0= 'next' )
                    // InternalReflex.g:1712:6: lv_next_4_0= 'next'
                    {
                    lv_next_4_0=(Token)match(input,66,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_next_4_0, grammarAccess.getSetStateStatAccess().getNextNextKeyword_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getSetStateStatRule());
                      						}
                      						setWithLastConsumed(current, "next", true, "next");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getSetStateStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetStateStat"


    // $ANTLR start "entryRuleFunction"
    // InternalReflex.g:1733:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalReflex.g:1733:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalReflex.g:1734:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalReflex.g:1740:1: ruleFunction returns [EObject current=null] : ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_returnType_0_0 = null;

        EObject lv_argTypes_3_0 = null;

        EObject lv_argTypes_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1746:2: ( ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // InternalReflex.g:1747:2: ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // InternalReflex.g:1747:2: ( ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // InternalReflex.g:1748:3: ( (lv_returnType_0_0= ruleCType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleCType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // InternalReflex.g:1748:3: ( (lv_returnType_0_0= ruleCType ) )
            // InternalReflex.g:1749:4: (lv_returnType_0_0= ruleCType )
            {
            // InternalReflex.g:1749:4: (lv_returnType_0_0= ruleCType )
            // InternalReflex.g:1750:5: lv_returnType_0_0= ruleCType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeCTypeParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_returnType_0_0=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					set(
              						current,
              						"returnType",
              						lv_returnType_0_0,
              						"ru.iaie.reflex.diagram.Reflex.CType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1767:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1768:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1768:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1769:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,53,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalReflex.g:1789:3: ( (lv_argTypes_3_0= ruleCType ) )
            // InternalReflex.g:1790:4: (lv_argTypes_3_0= ruleCType )
            {
            // InternalReflex.g:1790:4: (lv_argTypes_3_0= ruleCType )
            // InternalReflex.g:1791:5: lv_argTypes_3_0= ruleCType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesCTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_argTypes_3_0=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					add(
              						current,
              						"argTypes",
              						lv_argTypes_3_0,
              						"ru.iaie.reflex.diagram.Reflex.CType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1808:3: (otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==44) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalReflex.g:1809:4: otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) )
            	    {
            	    otherlv_4=(Token)match(input,44,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:1813:4: ( (lv_argTypes_5_0= ruleCType ) )
            	    // InternalReflex.g:1814:5: (lv_argTypes_5_0= ruleCType )
            	    {
            	    // InternalReflex.g:1814:5: (lv_argTypes_5_0= ruleCType )
            	    // InternalReflex.g:1815:6: lv_argTypes_5_0= ruleCType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesCTypeParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_argTypes_5_0=ruleCType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"argTypes",
            	      							lv_argTypes_5_0,
            	      							"ru.iaie.reflex.diagram.Reflex.CType");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_6=(Token)match(input,54,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionAccess().getSemicolonKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRuleRegister"
    // InternalReflex.g:1845:1: entryRuleRegister returns [EObject current=null] : iv_ruleRegister= ruleRegister EOF ;
    public final EObject entryRuleRegister() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegister = null;


        try {
            // InternalReflex.g:1845:49: (iv_ruleRegister= ruleRegister EOF )
            // InternalReflex.g:1846:2: iv_ruleRegister= ruleRegister EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegister=ruleRegister();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegister; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegister"


    // $ANTLR start "ruleRegister"
    // InternalReflex.g:1852:1: ruleRegister returns [EObject current=null] : ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';' ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_regSize_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_addr1_2_0 = null;

        EObject lv_addr2_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1858:2: ( ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1859:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1859:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';' )
            // InternalReflex.g:1860:3: ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= RULE_REG_SIZE ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1860:3: ( (lv_type_0_0= ruleRegisterType ) )
            // InternalReflex.g:1861:4: (lv_type_0_0= ruleRegisterType )
            {
            // InternalReflex.g:1861:4: (lv_type_0_0= ruleRegisterType )
            // InternalReflex.g:1862:5: lv_type_0_0= ruleRegisterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getTypeRegisterTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleRegisterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.diagram.Reflex.RegisterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1879:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1880:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1880:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1881:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRegisterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:1897:3: ( (lv_addr1_2_0= ruleInteger ) )
            // InternalReflex.g:1898:4: (lv_addr1_2_0= ruleInteger )
            {
            // InternalReflex.g:1898:4: (lv_addr1_2_0= ruleInteger )
            // InternalReflex.g:1899:5: lv_addr1_2_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getAddr1IntegerParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_16);
            lv_addr1_2_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"addr1",
              						lv_addr1_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1916:3: ( (lv_addr2_3_0= ruleInteger ) )
            // InternalReflex.g:1917:4: (lv_addr2_3_0= ruleInteger )
            {
            // InternalReflex.g:1917:4: (lv_addr2_3_0= ruleInteger )
            // InternalReflex.g:1918:5: lv_addr2_3_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getAddr2IntegerParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_addr2_3_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"addr2",
              						lv_addr2_3_0,
              						"ru.iaie.reflex.diagram.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1935:3: ( (lv_regSize_4_0= RULE_REG_SIZE ) )
            // InternalReflex.g:1936:4: (lv_regSize_4_0= RULE_REG_SIZE )
            {
            // InternalReflex.g:1936:4: (lv_regSize_4_0= RULE_REG_SIZE )
            // InternalReflex.g:1937:5: lv_regSize_4_0= RULE_REG_SIZE
            {
            lv_regSize_4_0=(Token)match(input,RULE_REG_SIZE,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regSize_4_0, grammarAccess.getRegisterAccess().getRegSizeREG_SIZETerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regSize",
              						lv_regSize_4_0,
              						"ru.iaie.reflex.diagram.Reflex.REG_SIZE");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRegisterAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegister"


    // $ANTLR start "entryRuleConst"
    // InternalReflex.g:1961:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalReflex.g:1961:46: (iv_ruleConst= ruleConst EOF )
            // InternalReflex.g:1962:2: iv_ruleConst= ruleConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConst=ruleConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConst; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConst"


    // $ANTLR start "ruleConst"
    // InternalReflex.g:1968:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constId_1_0=null;
        Token otherlv_3=null;
        EObject lv_constValue_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1974:2: ( (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // InternalReflex.g:1975:2: (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:1975:2: (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' )
            // InternalReflex.g:1976:3: otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,67,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalReflex.g:1980:3: ( (lv_constId_1_0= RULE_ID ) )
            // InternalReflex.g:1981:4: (lv_constId_1_0= RULE_ID )
            {
            // InternalReflex.g:1981:4: (lv_constId_1_0= RULE_ID )
            // InternalReflex.g:1982:5: lv_constId_1_0= RULE_ID
            {
            lv_constId_1_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_constId_1_0, grammarAccess.getConstAccess().getConstIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstRule());
              					}
              					setWithLastConsumed(
              						current,
              						"constId",
              						lv_constId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:1998:3: ( (lv_constValue_2_0= ruleExpression ) )
            // InternalReflex.g:1999:4: (lv_constValue_2_0= ruleExpression )
            {
            // InternalReflex.g:1999:4: (lv_constValue_2_0= ruleExpression )
            // InternalReflex.g:2000:5: lv_constValue_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getConstValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_constValue_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"constValue",
              						lv_constValue_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConst"


    // $ANTLR start "entryRuleEnum"
    // InternalReflex.g:2025:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalReflex.g:2025:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalReflex.g:2026:2: iv_ruleEnum= ruleEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnum=ruleEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnum; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnum"


    // $ANTLR start "ruleEnum"
    // InternalReflex.g:2032:1: ruleEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';' ) ;
    public final EObject ruleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_enumMembers_1_0 = null;

        EObject lv_enumMembers_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2038:2: ( (otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';' ) )
            // InternalReflex.g:2039:2: (otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';' )
            {
            // InternalReflex.g:2039:2: (otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';' )
            // InternalReflex.g:2040:3: otherlv_0= 'enum' ( (lv_enumMembers_1_0= ruleEnumMember ) ) (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )* otherlv_4= ';'
            {
            otherlv_0=(Token)match(input,68,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalReflex.g:2044:3: ( (lv_enumMembers_1_0= ruleEnumMember ) )
            // InternalReflex.g:2045:4: (lv_enumMembers_1_0= ruleEnumMember )
            {
            // InternalReflex.g:2045:4: (lv_enumMembers_1_0= ruleEnumMember )
            // InternalReflex.g:2046:5: lv_enumMembers_1_0= ruleEnumMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_enumMembers_1_0=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumRule());
              					}
              					add(
              						current,
              						"enumMembers",
              						lv_enumMembers_1_0,
              						"ru.iaie.reflex.diagram.Reflex.EnumMember");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2063:3: (otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==44) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReflex.g:2064:4: otherlv_2= ',' ( (lv_enumMembers_3_0= ruleEnumMember ) )
            	    {
            	    otherlv_2=(Token)match(input,44,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getEnumAccess().getCommaKeyword_2_0());
            	      			
            	    }
            	    // InternalReflex.g:2068:4: ( (lv_enumMembers_3_0= ruleEnumMember ) )
            	    // InternalReflex.g:2069:5: (lv_enumMembers_3_0= ruleEnumMember )
            	    {
            	    // InternalReflex.g:2069:5: (lv_enumMembers_3_0= ruleEnumMember )
            	    // InternalReflex.g:2070:6: lv_enumMembers_3_0= ruleEnumMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_2_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_enumMembers_3_0=ruleEnumMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enumMembers",
            	      							lv_enumMembers_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.EnumMember");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_4=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getEnumAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnum"


    // $ANTLR start "entryRuleEnumMember"
    // InternalReflex.g:2096:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalReflex.g:2096:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalReflex.g:2097:2: iv_ruleEnumMember= ruleEnumMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumMember=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumMember; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumMember"


    // $ANTLR start "ruleEnumMember"
    // InternalReflex.g:2103:1: ruleEnumMember returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2109:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalReflex.g:2110:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalReflex.g:2110:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // InternalReflex.g:2111:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalReflex.g:2111:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalReflex.g:2112:4: (lv_name_0_0= RULE_ID )
            {
            // InternalReflex.g:2112:4: (lv_name_0_0= RULE_ID )
            // InternalReflex.g:2113:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getEnumMemberAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumMemberRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,43,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEnumMemberAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalReflex.g:2133:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalReflex.g:2134:4: (lv_value_2_0= ruleExpression )
            {
            // InternalReflex.g:2134:4: (lv_value_2_0= ruleExpression )
            // InternalReflex.g:2135:5: lv_value_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumMemberAccess().getValueExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumMemberRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumMember"


    // $ANTLR start "entryRuleInfixOp"
    // InternalReflex.g:2156:1: entryRuleInfixOp returns [EObject current=null] : iv_ruleInfixOp= ruleInfixOp EOF ;
    public final EObject entryRuleInfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOp = null;


        try {
            // InternalReflex.g:2156:48: (iv_ruleInfixOp= ruleInfixOp EOF )
            // InternalReflex.g:2157:2: iv_ruleInfixOp= ruleInfixOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInfixOp=ruleInfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOp"


    // $ANTLR start "ruleInfixOp"
    // InternalReflex.g:2163:1: ruleInfixOp returns [EObject current=null] : ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_1_0=null;
        Enumerator lv_op_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2169:2: ( ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:2170:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:2170:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            // InternalReflex.g:2171:3: ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) )
            {
            // InternalReflex.g:2171:3: ( (lv_op_0_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2172:4: (lv_op_0_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2172:4: (lv_op_0_0= ruleInfixPostfixOp )
            // InternalReflex.g:2173:5: lv_op_0_0= ruleInfixPostfixOp
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInfixOpAccess().getOpInfixPostfixOpEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_op_0_0=ruleInfixPostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInfixOpRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_0_0,
              						"ru.iaie.reflex.diagram.Reflex.InfixPostfixOp");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2190:3: ( (lv_varId_1_0= RULE_ID ) )
            // InternalReflex.g:2191:4: (lv_varId_1_0= RULE_ID )
            {
            // InternalReflex.g:2191:4: (lv_varId_1_0= RULE_ID )
            // InternalReflex.g:2192:5: lv_varId_1_0= RULE_ID
            {
            lv_varId_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varId_1_0, grammarAccess.getInfixOpAccess().getVarIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInfixOpRule());
              					}
              					setWithLastConsumed(
              						current,
              						"varId",
              						lv_varId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixOp"


    // $ANTLR start "entryRulePostfixOp"
    // InternalReflex.g:2212:1: entryRulePostfixOp returns [EObject current=null] : iv_rulePostfixOp= rulePostfixOp EOF ;
    public final EObject entryRulePostfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOp = null;


        try {
            // InternalReflex.g:2212:50: (iv_rulePostfixOp= rulePostfixOp EOF )
            // InternalReflex.g:2213:2: iv_rulePostfixOp= rulePostfixOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixOp=rulePostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixOp"


    // $ANTLR start "rulePostfixOp"
    // InternalReflex.g:2219:1: rulePostfixOp returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) ;
    public final EObject rulePostfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Enumerator lv_op_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2225:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) )
            // InternalReflex.g:2226:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            {
            // InternalReflex.g:2226:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            // InternalReflex.g:2227:3: ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) )
            {
            // InternalReflex.g:2227:3: ( (lv_varId_0_0= RULE_ID ) )
            // InternalReflex.g:2228:4: (lv_varId_0_0= RULE_ID )
            {
            // InternalReflex.g:2228:4: (lv_varId_0_0= RULE_ID )
            // InternalReflex.g:2229:5: lv_varId_0_0= RULE_ID
            {
            lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varId_0_0, grammarAccess.getPostfixOpAccess().getVarIdIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPostfixOpRule());
              					}
              					setWithLastConsumed(
              						current,
              						"varId",
              						lv_varId_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:2245:3: ( (lv_op_1_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2246:4: (lv_op_1_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2246:4: (lv_op_1_0= ruleInfixPostfixOp )
            // InternalReflex.g:2247:5: lv_op_1_0= ruleInfixPostfixOp
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPostfixOpAccess().getOpInfixPostfixOpEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_op_1_0=ruleInfixPostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPostfixOpRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_1_0,
              						"ru.iaie.reflex.diagram.Reflex.InfixPostfixOp");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixOp"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalReflex.g:2268:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalReflex.g:2268:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalReflex.g:2269:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalReflex.g:2275:1: ruleFunctionCall returns [EObject current=null] : ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token lv_funcId_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2281:2: ( ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' ) )
            // InternalReflex.g:2282:2: ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            {
            // InternalReflex.g:2282:2: ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')' )
            // InternalReflex.g:2283:3: ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* otherlv_5= ')'
            {
            // InternalReflex.g:2283:3: ( (lv_funcId_0_0= RULE_ID ) )
            // InternalReflex.g:2284:4: (lv_funcId_0_0= RULE_ID )
            {
            // InternalReflex.g:2284:4: (lv_funcId_0_0= RULE_ID )
            // InternalReflex.g:2285:5: lv_funcId_0_0= RULE_ID
            {
            lv_funcId_0_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_funcId_0_0, grammarAccess.getFunctionCallAccess().getFuncIdIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionCallRule());
              					}
              					setWithLastConsumed(
              						current,
              						"funcId",
              						lv_funcId_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_1=(Token)match(input,53,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2305:3: ( (lv_args_2_0= ruleExpression ) )
            // InternalReflex.g:2306:4: (lv_args_2_0= ruleExpression )
            {
            // InternalReflex.g:2306:4: (lv_args_2_0= ruleExpression )
            // InternalReflex.g:2307:5: lv_args_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_32);
            lv_args_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionCallRule());
              					}
              					add(
              						current,
              						"args",
              						lv_args_2_0,
              						"ru.iaie.reflex.diagram.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2324:3: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==44) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalReflex.g:2325:4: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,44,FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_3_0());
            	      			
            	    }
            	    // InternalReflex.g:2329:4: ( (lv_args_4_0= ruleExpression ) )
            	    // InternalReflex.g:2330:5: (lv_args_4_0= ruleExpression )
            	    {
            	    // InternalReflex.g:2330:5: (lv_args_4_0= ruleExpression )
            	    // InternalReflex.g:2331:6: lv_args_4_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_3_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_32);
            	    lv_args_4_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFunctionCallRule());
            	      						}
            	      						add(
            	      							current,
            	      							"args",
            	      							lv_args_4_0,
            	      							"ru.iaie.reflex.diagram.Reflex.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_5=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalReflex.g:2357:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalReflex.g:2357:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalReflex.g:2358:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalReflex.g:2364:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) | ( (lv_literal_1_0= ruleInteger ) ) | (otherlv_2= '(' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_literal_1_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2370:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) | ( (lv_literal_1_0= ruleInteger ) ) | (otherlv_2= '(' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= ')' ) ) )
            // InternalReflex.g:2371:2: ( ( (lv_varId_0_0= RULE_ID ) ) | ( (lv_literal_1_0= ruleInteger ) ) | (otherlv_2= '(' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= ')' ) )
            {
            // InternalReflex.g:2371:2: ( ( (lv_varId_0_0= RULE_ID ) ) | ( (lv_literal_1_0= ruleInteger ) ) | (otherlv_2= '(' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= ')' ) )
            int alt23=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt23=1;
                }
                break;
            case RULE_DECIMAL:
            case RULE_OCTAL:
            case RULE_HEX:
                {
                alt23=2;
                }
                break;
            case 53:
                {
                alt23=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalReflex.g:2372:3: ( (lv_varId_0_0= RULE_ID ) )
                    {
                    // InternalReflex.g:2372:3: ( (lv_varId_0_0= RULE_ID ) )
                    // InternalReflex.g:2373:4: (lv_varId_0_0= RULE_ID )
                    {
                    // InternalReflex.g:2373:4: (lv_varId_0_0= RULE_ID )
                    // InternalReflex.g:2374:5: lv_varId_0_0= RULE_ID
                    {
                    lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_varId_0_0, grammarAccess.getPrimaryExpressionAccess().getVarIdIDTerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"varId",
                      						lv_varId_0_0,
                      						"org.eclipse.xtext.common.Terminals.ID");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2391:3: ( (lv_literal_1_0= ruleInteger ) )
                    {
                    // InternalReflex.g:2391:3: ( (lv_literal_1_0= ruleInteger ) )
                    // InternalReflex.g:2392:4: (lv_literal_1_0= ruleInteger )
                    {
                    // InternalReflex.g:2392:4: (lv_literal_1_0= ruleInteger )
                    // InternalReflex.g:2393:5: lv_literal_1_0= ruleInteger
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralIntegerParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_literal_1_0=ruleInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      					}
                      					set(
                      						current,
                      						"literal",
                      						lv_literal_1_0,
                      						"ru.iaie.reflex.diagram.Reflex.Integer");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:2411:3: (otherlv_2= '(' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= ')' )
                    {
                    // InternalReflex.g:2411:3: (otherlv_2= '(' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= ')' )
                    // InternalReflex.g:2412:4: otherlv_2= '(' ( (lv_expr_3_0= ruleExpression ) ) otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,53,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_2_0());
                      			
                    }
                    // InternalReflex.g:2416:4: ( (lv_expr_3_0= ruleExpression ) )
                    // InternalReflex.g:2417:5: (lv_expr_3_0= ruleExpression )
                    {
                    // InternalReflex.g:2417:5: (lv_expr_3_0= ruleExpression )
                    // InternalReflex.g:2418:6: lv_expr_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExprExpressionParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_expr_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_3_0,
                      							"ru.iaie.reflex.diagram.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_2_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalReflex.g:2444:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalReflex.g:2444:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalReflex.g:2445:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalReflex.g:2451:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_FunctionCall_1 = null;

        EObject this_PostfixOp_2 = null;

        EObject this_InfixOp_3 = null;

        Enumerator lv_unaryOp_4_0 = null;

        EObject lv_rest_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2457:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2458:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2458:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) )
            int alt24=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 73:
                case 74:
                    {
                    alt24=3;
                    }
                    break;
                case EOF:
                case RULE_BIT_AND:
                case RULE_BIT_XOR:
                case RULE_BIT_OR:
                case RULE_LOGICAL_AND:
                case RULE_LOGICAL_OR:
                case 41:
                case 44:
                case 54:
                case 84:
                case 85:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                    {
                    alt24=1;
                    }
                    break;
                case 53:
                    {
                    alt24=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_DECIMAL:
            case RULE_OCTAL:
            case RULE_HEX:
            case 53:
                {
                alt24=1;
                }
                break;
            case 73:
            case 74:
                {
                alt24=4;
                }
                break;
            case 84:
            case 85:
            case 86:
            case 87:
                {
                alt24=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalReflex.g:2459:3: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrimaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2468:3: this_FunctionCall_1= ruleFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getFunctionCallParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_1=ruleFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionCall_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:2477:3: this_PostfixOp_2= rulePostfixOp
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixOpParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostfixOp_2=rulePostfixOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostfixOp_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:2486:3: this_InfixOp_3= ruleInfixOp
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getInfixOpParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InfixOp_3=ruleInfixOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InfixOp_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:2495:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2495:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2496:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) )
                    {
                    // InternalReflex.g:2496:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) )
                    // InternalReflex.g:2497:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    {
                    // InternalReflex.g:2497:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    // InternalReflex.g:2498:6: lv_unaryOp_4_0= ruleUnaryOp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryOpUnaryOpEnumRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_36);
                    lv_unaryOp_4_0=ruleUnaryOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"unaryOp",
                      							lv_unaryOp_4_0,
                      							"ru.iaie.reflex.diagram.Reflex.UnaryOp");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:2515:4: ( (lv_rest_5_0= ruleCastExpression ) )
                    // InternalReflex.g:2516:5: (lv_rest_5_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2516:5: (lv_rest_5_0= ruleCastExpression )
                    // InternalReflex.g:2517:6: lv_rest_5_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getRestCastExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_rest_5_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"rest",
                      							lv_rest_5_0,
                      							"ru.iaie.reflex.diagram.Reflex.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleCastExpression"
    // InternalReflex.g:2539:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalReflex.g:2539:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalReflex.g:2540:2: iv_ruleCastExpression= ruleCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCastExpression=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCastExpression"


    // $ANTLR start "ruleCastExpression"
    // InternalReflex.g:2546:1: ruleCastExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2552:2: ( (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2553:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2553:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID||(LA25_0>=RULE_DECIMAL && LA25_0<=RULE_HEX)||(LA25_0>=73 && LA25_0<=74)||(LA25_0>=84 && LA25_0<=87)) ) {
                alt25=1;
            }
            else if ( (LA25_0==53) ) {
                int LA25_2 = input.LA(2);

                if ( (LA25_2==RULE_ID||(LA25_2>=RULE_DECIMAL && LA25_2<=RULE_HEX)||LA25_2==53||(LA25_2>=73 && LA25_2<=74)||(LA25_2>=84 && LA25_2<=87)) ) {
                    alt25=1;
                }
                else if ( ((LA25_2>=RULE_VOID_C_TYPE && LA25_2<=RULE_BOOL_TYPE)||(LA25_2>=99 && LA25_2<=100)) ) {
                    alt25=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalReflex.g:2554:3: this_UnaryExpression_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCastExpressionAccess().getUnaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:2563:3: (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2563:3: (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2564:4: otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,53,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:2568:4: ( (lv_type_2_0= ruleReflexType ) )
                    // InternalReflex.g:2569:5: (lv_type_2_0= ruleReflexType )
                    {
                    // InternalReflex.g:2569:5: (lv_type_2_0= ruleReflexType )
                    // InternalReflex.g:2570:6: lv_type_2_0= ruleReflexType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeReflexTypeParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_type_2_0=ruleReflexType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_2_0,
                      							"ru.iaie.reflex.diagram.Reflex.ReflexType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,54,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalReflex.g:2591:4: ( (lv_right_4_0= ruleCastExpression ) )
                    // InternalReflex.g:2592:5: (lv_right_4_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2592:5: (lv_right_4_0= ruleCastExpression )
                    // InternalReflex.g:2593:6: lv_right_4_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getRightCastExpressionParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_4_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_4_0,
                      							"ru.iaie.reflex.diagram.Reflex.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalReflex.g:2615:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalReflex.g:2615:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalReflex.g:2616:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalReflex.g:2622:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CastExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2628:2: ( (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) )
            // InternalReflex.g:2629:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            {
            // InternalReflex.g:2629:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            // InternalReflex.g:2630:3: this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2638:3: ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=96 && LA26_0<=98)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalReflex.g:2639:4: () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) )
            	    {
            	    // InternalReflex.g:2639:4: ()
            	    // InternalReflex.g:2640:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2646:4: ( (lv_mulOp_2_0= ruleMultiplicativeOp ) )
            	    // InternalReflex.g:2647:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    {
            	    // InternalReflex.g:2647:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    // InternalReflex.g:2648:6: lv_mulOp_2_0= ruleMultiplicativeOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getMulOpMultiplicativeOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_mulOp_2_0=ruleMultiplicativeOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"mulOp",
            	      							lv_mulOp_2_0,
            	      							"ru.iaie.reflex.diagram.Reflex.MultiplicativeOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:2665:4: ( (lv_right_3_0= ruleCastExpression ) )
            	    // InternalReflex.g:2666:5: (lv_right_3_0= ruleCastExpression )
            	    {
            	    // InternalReflex.g:2666:5: (lv_right_3_0= ruleCastExpression )
            	    // InternalReflex.g:2667:6: lv_right_3_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightCastExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_right_3_0=ruleCastExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.CastExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalReflex.g:2689:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalReflex.g:2689:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalReflex.g:2690:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalReflex.g:2696:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_rightt_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2702:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalReflex.g:2703:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalReflex.g:2703:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* )
            // InternalReflex.g:2704:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_39);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2712:3: ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==84) ) {
                    alt27=1;
                }
                else if ( (LA27_0==85) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalReflex.g:2713:4: () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalReflex.g:2713:4: ()
            	    // InternalReflex.g:2714:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2720:4: ( (lv_addOp_2_0= ruleAdditiveOp ) )
            	    // InternalReflex.g:2721:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    {
            	    // InternalReflex.g:2721:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    // InternalReflex.g:2722:6: lv_addOp_2_0= ruleAdditiveOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getAddOpAdditiveOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_addOp_2_0=ruleAdditiveOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"addOp",
            	      							lv_addOp_2_0,
            	      							"ru.iaie.reflex.diagram.Reflex.AdditiveOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:2739:4: ( (lv_rightt_3_0= ruleAdditiveExpression ) )
            	    // InternalReflex.g:2740:5: (lv_rightt_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalReflex.g:2740:5: (lv_rightt_3_0= ruleAdditiveExpression )
            	    // InternalReflex.g:2741:6: lv_rightt_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRighttAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_rightt_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightt",
            	      							lv_rightt_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalReflex.g:2763:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalReflex.g:2763:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalReflex.g:2764:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // InternalReflex.g:2770:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_shiftOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2776:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) )
            // InternalReflex.g:2777:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalReflex.g:2777:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            // InternalReflex.g:2778:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_40);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2786:3: ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==94) ) {
                    alt28=1;
                }
                else if ( (LA28_0==95) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalReflex.g:2787:4: () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalReflex.g:2787:4: ()
            	    // InternalReflex.g:2788:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2794:4: ( (lv_shiftOp_2_0= ruleShiftOp ) )
            	    // InternalReflex.g:2795:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    {
            	    // InternalReflex.g:2795:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    // InternalReflex.g:2796:6: lv_shiftOp_2_0= ruleShiftOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getShiftOpShiftOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_shiftOp_2_0=ruleShiftOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"shiftOp",
            	      							lv_shiftOp_2_0,
            	      							"ru.iaie.reflex.diagram.Reflex.ShiftOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:2813:4: ( (lv_right_3_0= ruleShiftExpression ) )
            	    // InternalReflex.g:2814:5: (lv_right_3_0= ruleShiftExpression )
            	    {
            	    // InternalReflex.g:2814:5: (lv_right_3_0= ruleShiftExpression )
            	    // InternalReflex.g:2815:6: lv_right_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_right_3_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.ShiftExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleCompareExpression"
    // InternalReflex.g:2837:1: entryRuleCompareExpression returns [EObject current=null] : iv_ruleCompareExpression= ruleCompareExpression EOF ;
    public final EObject entryRuleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpression = null;


        try {
            // InternalReflex.g:2837:58: (iv_ruleCompareExpression= ruleCompareExpression EOF )
            // InternalReflex.g:2838:2: iv_ruleCompareExpression= ruleCompareExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompareExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompareExpression=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompareExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompareExpression"


    // $ANTLR start "ruleCompareExpression"
    // InternalReflex.g:2844:1: ruleCompareExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* ) ;
    public final EObject ruleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_cmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2850:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* ) )
            // InternalReflex.g:2851:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* )
            {
            // InternalReflex.g:2851:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* )
            // InternalReflex.g:2852:3: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getCompareExpressionAccess().getShiftExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_41);
            this_ShiftExpression_0=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ShiftExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2860:3: ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                switch ( input.LA(1) ) {
                case 88:
                    {
                    alt29=1;
                    }
                    break;
                case 89:
                    {
                    alt29=1;
                    }
                    break;
                case 90:
                    {
                    alt29=1;
                    }
                    break;
                case 91:
                    {
                    alt29=1;
                    }
                    break;

                }

                switch (alt29) {
            	case 1 :
            	    // InternalReflex.g:2861:4: () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) )
            	    {
            	    // InternalReflex.g:2861:4: ()
            	    // InternalReflex.g:2862:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getCompareExpressionAccess().getCompareExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2868:4: ( (lv_cmpOp_2_0= ruleCompareOp ) )
            	    // InternalReflex.g:2869:5: (lv_cmpOp_2_0= ruleCompareOp )
            	    {
            	    // InternalReflex.g:2869:5: (lv_cmpOp_2_0= ruleCompareOp )
            	    // InternalReflex.g:2870:6: lv_cmpOp_2_0= ruleCompareOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCompareExpressionAccess().getCmpOpCompareOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_cmpOp_2_0=ruleCompareOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getCompareExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"cmpOp",
            	      							lv_cmpOp_2_0,
            	      							"ru.iaie.reflex.diagram.Reflex.CompareOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:2887:4: ( (lv_right_3_0= ruleCompareExpression ) )
            	    // InternalReflex.g:2888:5: (lv_right_3_0= ruleCompareExpression )
            	    {
            	    // InternalReflex.g:2888:5: (lv_right_3_0= ruleCompareExpression )
            	    // InternalReflex.g:2889:6: lv_right_3_0= ruleCompareExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getCompareExpressionAccess().getRightCompareExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
            	    lv_right_3_0=ruleCompareExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getCompareExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.CompareExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalReflex.g:2911:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalReflex.g:2911:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalReflex.g:2912:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalReflex.g:2918:1: ruleEqualityExpression returns [EObject current=null] : (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpression_0 = null;

        Enumerator lv_eqCmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2924:2: ( (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalReflex.g:2925:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalReflex.g:2925:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalReflex.g:2926:3: this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getCompareExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_42);
            this_CompareExpression_0=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CompareExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2934:3: ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==92) ) {
                    alt30=1;
                }
                else if ( (LA30_0==93) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalReflex.g:2935:4: () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalReflex.g:2935:4: ()
            	    // InternalReflex.g:2936:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2942:4: ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) )
            	    // InternalReflex.g:2943:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    {
            	    // InternalReflex.g:2943:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    // InternalReflex.g:2944:6: lv_eqCmpOp_2_0= ruleCompareEqOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getEqCmpOpCompareEqOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_eqCmpOp_2_0=ruleCompareEqOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"eqCmpOp",
            	      							lv_eqCmpOp_2_0,
            	      							"ru.iaie.reflex.diagram.Reflex.CompareEqOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:2961:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalReflex.g:2962:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalReflex.g:2962:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalReflex.g:2963:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_42);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.EqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleBitAndExpression"
    // InternalReflex.g:2985:1: entryRuleBitAndExpression returns [EObject current=null] : iv_ruleBitAndExpression= ruleBitAndExpression EOF ;
    public final EObject entryRuleBitAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitAndExpression = null;


        try {
            // InternalReflex.g:2985:57: (iv_ruleBitAndExpression= ruleBitAndExpression EOF )
            // InternalReflex.g:2986:2: iv_ruleBitAndExpression= ruleBitAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitAndExpression=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitAndExpression"


    // $ANTLR start "ruleBitAndExpression"
    // InternalReflex.g:2992:1: ruleBitAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) ;
    public final EObject ruleBitAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_AND_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2998:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) )
            // InternalReflex.g:2999:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            {
            // InternalReflex.g:2999:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            // InternalReflex.g:3000:3: this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_43);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3008:3: ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_BIT_AND) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalReflex.g:3009:4: () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) )
            	    {
            	    // InternalReflex.g:3009:4: ()
            	    // InternalReflex.g:3010:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitAndExpressionAccess().getBitAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_AND_2=(Token)match(input,RULE_BIT_AND,FOLLOW_36); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_AND_2, grammarAccess.getBitAndExpressionAccess().getBIT_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3020:4: ( (lv_right_3_0= ruleBitAndExpression ) )
            	    // InternalReflex.g:3021:5: (lv_right_3_0= ruleBitAndExpression )
            	    {
            	    // InternalReflex.g:3021:5: (lv_right_3_0= ruleBitAndExpression )
            	    // InternalReflex.g:3022:6: lv_right_3_0= ruleBitAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitAndExpressionAccess().getRightBitAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_right_3_0=ruleBitAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.BitAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitAndExpression"


    // $ANTLR start "entryRuleBitXorExpression"
    // InternalReflex.g:3044:1: entryRuleBitXorExpression returns [EObject current=null] : iv_ruleBitXorExpression= ruleBitXorExpression EOF ;
    public final EObject entryRuleBitXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitXorExpression = null;


        try {
            // InternalReflex.g:3044:57: (iv_ruleBitXorExpression= ruleBitXorExpression EOF )
            // InternalReflex.g:3045:2: iv_ruleBitXorExpression= ruleBitXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitXorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitXorExpression=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitXorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitXorExpression"


    // $ANTLR start "ruleBitXorExpression"
    // InternalReflex.g:3051:1: ruleBitXorExpression returns [EObject current=null] : (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) ;
    public final EObject ruleBitXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_XOR_2=null;
        EObject this_BitAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3057:2: ( (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) )
            // InternalReflex.g:3058:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            {
            // InternalReflex.g:3058:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            // InternalReflex.g:3059:3: this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitXorExpressionAccess().getBitAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_44);
            this_BitAndExpression_0=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3067:3: ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_BIT_XOR) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalReflex.g:3068:4: () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) )
            	    {
            	    // InternalReflex.g:3068:4: ()
            	    // InternalReflex.g:3069:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitXorExpressionAccess().getBitXorExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_XOR_2=(Token)match(input,RULE_BIT_XOR,FOLLOW_36); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_XOR_2, grammarAccess.getBitXorExpressionAccess().getBIT_XORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3079:4: ( (lv_right_3_0= ruleBitXorExpression ) )
            	    // InternalReflex.g:3080:5: (lv_right_3_0= ruleBitXorExpression )
            	    {
            	    // InternalReflex.g:3080:5: (lv_right_3_0= ruleBitXorExpression )
            	    // InternalReflex.g:3081:6: lv_right_3_0= ruleBitXorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitXorExpressionAccess().getRightBitXorExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_44);
            	    lv_right_3_0=ruleBitXorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitXorExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.BitXorExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitXorExpression"


    // $ANTLR start "entryRuleBitOrExpression"
    // InternalReflex.g:3103:1: entryRuleBitOrExpression returns [EObject current=null] : iv_ruleBitOrExpression= ruleBitOrExpression EOF ;
    public final EObject entryRuleBitOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitOrExpression = null;


        try {
            // InternalReflex.g:3103:56: (iv_ruleBitOrExpression= ruleBitOrExpression EOF )
            // InternalReflex.g:3104:2: iv_ruleBitOrExpression= ruleBitOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitOrExpression=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitOrExpression"


    // $ANTLR start "ruleBitOrExpression"
    // InternalReflex.g:3110:1: ruleBitOrExpression returns [EObject current=null] : (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) ;
    public final EObject ruleBitOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_OR_2=null;
        EObject this_BitXorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3116:2: ( (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) )
            // InternalReflex.g:3117:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            {
            // InternalReflex.g:3117:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            // InternalReflex.g:3118:3: this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitOrExpressionAccess().getBitXorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_45);
            this_BitXorExpression_0=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitXorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3126:3: ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_BIT_OR) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalReflex.g:3127:4: () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) )
            	    {
            	    // InternalReflex.g:3127:4: ()
            	    // InternalReflex.g:3128:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitOrExpressionAccess().getBitOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_OR_2=(Token)match(input,RULE_BIT_OR,FOLLOW_36); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_OR_2, grammarAccess.getBitOrExpressionAccess().getBIT_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3138:4: ( (lv_right_3_0= ruleBitOrExpression ) )
            	    // InternalReflex.g:3139:5: (lv_right_3_0= ruleBitOrExpression )
            	    {
            	    // InternalReflex.g:3139:5: (lv_right_3_0= ruleBitOrExpression )
            	    // InternalReflex.g:3140:6: lv_right_3_0= ruleBitOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitOrExpressionAccess().getRightBitOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_45);
            	    lv_right_3_0=ruleBitOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.BitOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalReflex.g:3162:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalReflex.g:3162:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalReflex.g:3163:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalReflex.g:3169:1: ruleLogicalAndExpression returns [EObject current=null] : (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_AND_2=null;
        EObject this_BitOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3175:2: ( (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalReflex.g:3176:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalReflex.g:3176:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalReflex.g:3177:3: this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getBitOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_46);
            this_BitOrExpression_0=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3185:3: ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_LOGICAL_AND) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalReflex.g:3186:4: () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalReflex.g:3186:4: ()
            	    // InternalReflex.g:3187:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_AND_2=(Token)match(input,RULE_LOGICAL_AND,FOLLOW_36); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_AND_2, grammarAccess.getLogicalAndExpressionAccess().getLOGICAL_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3197:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    // InternalReflex.g:3198:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalReflex.g:3198:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    // InternalReflex.g:3199:6: lv_right_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_46);
            	    lv_right_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.LogicalAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalReflex.g:3221:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalReflex.g:3221:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalReflex.g:3222:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalReflex.g:3228:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_OR_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3234:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) )
            // InternalReflex.g:3235:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            {
            // InternalReflex.g:3235:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            // InternalReflex.g:3236:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_47);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3244:3: ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_LOGICAL_OR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalReflex.g:3245:4: () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    {
            	    // InternalReflex.g:3245:4: ()
            	    // InternalReflex.g:3246:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_OR_2=(Token)match(input,RULE_LOGICAL_OR,FOLLOW_36); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_OR_2, grammarAccess.getLogicalOrExpressionAccess().getLOGICAL_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3256:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    // InternalReflex.g:3257:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    {
            	    // InternalReflex.g:3257:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    // InternalReflex.g:3258:6: lv_right_3_0= ruleLogicalOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
            	    lv_right_3_0=ruleLogicalOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.diagram.Reflex.LogicalOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalReflex.g:3280:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalReflex.g:3280:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalReflex.g:3281:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalReflex.g:3287:1: ruleAssignmentExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_assignVar_1_0=null;
        EObject this_LogicalOrExpression_0 = null;

        Enumerator lv_assignOp_2_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3293:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) ) )
            // InternalReflex.g:3294:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) )
            {
            // InternalReflex.g:3294:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==EOF||(LA36_1>=RULE_BIT_AND && LA36_1<=RULE_LOGICAL_OR)||LA36_1==41||LA36_1==44||(LA36_1>=53 && LA36_1<=54)||(LA36_1>=73 && LA36_1<=74)||(LA36_1>=84 && LA36_1<=85)||(LA36_1>=88 && LA36_1<=98)) ) {
                    alt36=1;
                }
                else if ( (LA36_1==43||(LA36_1>=75 && LA36_1<=83)) ) {
                    alt36=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA36_0>=RULE_DECIMAL && LA36_0<=RULE_HEX)||LA36_0==53||(LA36_0>=73 && LA36_0<=74)||(LA36_0>=84 && LA36_0<=87)) ) {
                alt36=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalReflex.g:3295:3: this_LogicalOrExpression_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getLogicalOrExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LogicalOrExpression_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LogicalOrExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3304:3: ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) )
                    {
                    // InternalReflex.g:3304:3: ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) )
                    // InternalReflex.g:3305:4: ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) )
                    {
                    // InternalReflex.g:3305:4: ( (lv_assignVar_1_0= RULE_ID ) )
                    // InternalReflex.g:3306:5: (lv_assignVar_1_0= RULE_ID )
                    {
                    // InternalReflex.g:3306:5: (lv_assignVar_1_0= RULE_ID )
                    // InternalReflex.g:3307:6: lv_assignVar_1_0= RULE_ID
                    {
                    lv_assignVar_1_0=(Token)match(input,RULE_ID,FOLLOW_48); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_assignVar_1_0, grammarAccess.getAssignmentExpressionAccess().getAssignVarIDTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"assignVar",
                      							true,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3323:4: ( (lv_assignOp_2_0= ruleAssignOperator ) )
                    // InternalReflex.g:3324:5: (lv_assignOp_2_0= ruleAssignOperator )
                    {
                    // InternalReflex.g:3324:5: (lv_assignOp_2_0= ruleAssignOperator )
                    // InternalReflex.g:3325:6: lv_assignOp_2_0= ruleAssignOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getAssignOpAssignOperatorEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_36);
                    lv_assignOp_2_0=ruleAssignOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"assignOp",
                      							true,
                      							"ru.iaie.reflex.diagram.Reflex.AssignOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3342:4: ( (lv_expr_3_0= ruleLogicalOrExpression ) )
                    // InternalReflex.g:3343:5: (lv_expr_3_0= ruleLogicalOrExpression )
                    {
                    // InternalReflex.g:3343:5: (lv_expr_3_0= ruleLogicalOrExpression )
                    // InternalReflex.g:3344:6: lv_expr_3_0= ruleLogicalOrExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expr_3_0=ruleLogicalOrExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_3_0,
                      							"ru.iaie.reflex.diagram.Reflex.LogicalOrExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalReflex.g:3366:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalReflex.g:3366:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalReflex.g:3367:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalReflex.g:3373:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3379:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalReflex.g:3380:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleCType"
    // InternalReflex.g:3391:1: entryRuleCType returns [EObject current=null] : iv_ruleCType= ruleCType EOF ;
    public final EObject entryRuleCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCType = null;


        try {
            // InternalReflex.g:3391:46: (iv_ruleCType= ruleCType EOF )
            // InternalReflex.g:3392:2: iv_ruleCType= ruleCType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCType=ruleCType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCType"


    // $ANTLR start "ruleCType"
    // InternalReflex.g:3398:1: ruleCType returns [EObject current=null] : ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) ;
    public final EObject ruleCType() throws RecognitionException {
        EObject current = null;

        Token this_VOID_C_TYPE_1=null;
        Token this_FLOAT_C_TYPE_3=null;
        Token this_DOUBLE_C_TYPE_5=null;
        Token this_SHORT_C_TYPE_8=null;
        Token this_INT_C_TYPE_9=null;
        Token this_LONG_C_TYPE_10=null;
        Enumerator lv_signSpec_7_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3404:2: ( ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) )
            // InternalReflex.g:3405:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            {
            // InternalReflex.g:3405:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            int alt39=4;
            switch ( input.LA(1) ) {
            case RULE_VOID_C_TYPE:
                {
                alt39=1;
                }
                break;
            case RULE_FLOAT_C_TYPE:
                {
                alt39=2;
                }
                break;
            case RULE_DOUBLE_C_TYPE:
                {
                alt39=3;
                }
                break;
            case RULE_SHORT_C_TYPE:
            case RULE_INT_C_TYPE:
            case RULE_LONG_C_TYPE:
            case 99:
            case 100:
                {
                alt39=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalReflex.g:3406:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    {
                    // InternalReflex.g:3406:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    // InternalReflex.g:3407:4: () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE
                    {
                    // InternalReflex.g:3407:4: ()
                    // InternalReflex.g:3408:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_0_0(),
                      						current);
                      				
                    }

                    }

                    this_VOID_C_TYPE_1=(Token)match(input,RULE_VOID_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_VOID_C_TYPE_1, grammarAccess.getCTypeAccess().getVOID_C_TYPETerminalRuleCall_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3420:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    {
                    // InternalReflex.g:3420:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    // InternalReflex.g:3421:4: () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE
                    {
                    // InternalReflex.g:3421:4: ()
                    // InternalReflex.g:3422:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_FLOAT_C_TYPE_3=(Token)match(input,RULE_FLOAT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FLOAT_C_TYPE_3, grammarAccess.getCTypeAccess().getFLOAT_C_TYPETerminalRuleCall_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:3434:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    {
                    // InternalReflex.g:3434:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    // InternalReflex.g:3435:4: () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE
                    {
                    // InternalReflex.g:3435:4: ()
                    // InternalReflex.g:3436:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_2_0(),
                      						current);
                      				
                    }

                    }

                    this_DOUBLE_C_TYPE_5=(Token)match(input,RULE_DOUBLE_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DOUBLE_C_TYPE_5, grammarAccess.getCTypeAccess().getDOUBLE_C_TYPETerminalRuleCall_2_1());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:3448:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    {
                    // InternalReflex.g:3448:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    // InternalReflex.g:3449:4: () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    {
                    // InternalReflex.g:3449:4: ()
                    // InternalReflex.g:3450:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3456:4: ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( ((LA37_0>=99 && LA37_0<=100)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // InternalReflex.g:3457:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            {
                            // InternalReflex.g:3457:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            // InternalReflex.g:3458:6: lv_signSpec_7_0= ruleCTypeSignSpec
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getCTypeAccess().getSignSpecCTypeSignSpecEnumRuleCall_3_1_0());
                              					
                            }
                            pushFollow(FOLLOW_49);
                            lv_signSpec_7_0=ruleCTypeSignSpec();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getCTypeRule());
                              						}
                              						set(
                              							current,
                              							"signSpec",
                              							true,
                              							"ru.iaie.reflex.diagram.Reflex.CTypeSignSpec");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }

                    // InternalReflex.g:3475:4: (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    int alt38=3;
                    switch ( input.LA(1) ) {
                    case RULE_SHORT_C_TYPE:
                        {
                        alt38=1;
                        }
                        break;
                    case RULE_INT_C_TYPE:
                        {
                        alt38=2;
                        }
                        break;
                    case RULE_LONG_C_TYPE:
                        {
                        alt38=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }

                    switch (alt38) {
                        case 1 :
                            // InternalReflex.g:3476:5: this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE
                            {
                            this_SHORT_C_TYPE_8=(Token)match(input,RULE_SHORT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_SHORT_C_TYPE_8, grammarAccess.getCTypeAccess().getSHORT_C_TYPETerminalRuleCall_3_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalReflex.g:3481:5: this_INT_C_TYPE_9= RULE_INT_C_TYPE
                            {
                            this_INT_C_TYPE_9=(Token)match(input,RULE_INT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_INT_C_TYPE_9, grammarAccess.getCTypeAccess().getINT_C_TYPETerminalRuleCall_3_2_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalReflex.g:3486:5: this_LONG_C_TYPE_10= RULE_LONG_C_TYPE
                            {
                            this_LONG_C_TYPE_10=(Token)match(input,RULE_LONG_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_LONG_C_TYPE_10, grammarAccess.getCTypeAccess().getLONG_C_TYPETerminalRuleCall_3_2_2());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCType"


    // $ANTLR start "entryRuleIntegerType"
    // InternalReflex.g:3496:1: entryRuleIntegerType returns [String current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final String entryRuleIntegerType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerType = null;


        try {
            // InternalReflex.g:3496:51: (iv_ruleIntegerType= ruleIntegerType EOF )
            // InternalReflex.g:3497:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntegerType.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerType"


    // $ANTLR start "ruleIntegerType"
    // InternalReflex.g:3503:1: ruleIntegerType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) ;
    public final AntlrDatatypeRuleToken ruleIntegerType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOL_TYPE_0=null;
        Token this_INT_C_TYPE_1=null;
        Token this_SHORT_C_TYPE_2=null;
        Token this_LONG_C_TYPE_3=null;


        	enterRule();

        try {
            // InternalReflex.g:3509:2: ( (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) )
            // InternalReflex.g:3510:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            {
            // InternalReflex.g:3510:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            int alt40=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                alt40=1;
                }
                break;
            case RULE_INT_C_TYPE:
                {
                alt40=2;
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                alt40=3;
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                alt40=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalReflex.g:3511:3: this_BOOL_TYPE_0= RULE_BOOL_TYPE
                    {
                    this_BOOL_TYPE_0=(Token)match(input,RULE_BOOL_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_BOOL_TYPE_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_BOOL_TYPE_0, grammarAccess.getIntegerTypeAccess().getBOOL_TYPETerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3519:3: this_INT_C_TYPE_1= RULE_INT_C_TYPE
                    {
                    this_INT_C_TYPE_1=(Token)match(input,RULE_INT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_INT_C_TYPE_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_INT_C_TYPE_1, grammarAccess.getIntegerTypeAccess().getINT_C_TYPETerminalRuleCall_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:3527:3: this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE
                    {
                    this_SHORT_C_TYPE_2=(Token)match(input,RULE_SHORT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_SHORT_C_TYPE_2);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_SHORT_C_TYPE_2, grammarAccess.getIntegerTypeAccess().getSHORT_C_TYPETerminalRuleCall_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:3535:3: this_LONG_C_TYPE_3= RULE_LONG_C_TYPE
                    {
                    this_LONG_C_TYPE_3=(Token)match(input,RULE_LONG_C_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_LONG_C_TYPE_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_LONG_C_TYPE_3, grammarAccess.getIntegerTypeAccess().getLONG_C_TYPETerminalRuleCall_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleReflexType"
    // InternalReflex.g:3546:1: entryRuleReflexType returns [EObject current=null] : iv_ruleReflexType= ruleReflexType EOF ;
    public final EObject entryRuleReflexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReflexType = null;


        try {
            // InternalReflex.g:3546:51: (iv_ruleReflexType= ruleReflexType EOF )
            // InternalReflex.g:3547:2: iv_ruleReflexType= ruleReflexType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReflexTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReflexType=ruleReflexType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReflexType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReflexType"


    // $ANTLR start "ruleReflexType"
    // InternalReflex.g:3553:1: ruleReflexType returns [EObject current=null] : (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) ;
    public final EObject ruleReflexType() throws RecognitionException {
        EObject current = null;

        Token this_BOOL_TYPE_2=null;
        EObject this_CType_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3559:2: ( (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) )
            // InternalReflex.g:3560:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            {
            // InternalReflex.g:3560:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( ((LA41_0>=RULE_VOID_C_TYPE && LA41_0<=RULE_LONG_C_TYPE)||(LA41_0>=99 && LA41_0<=100)) ) {
                alt41=1;
            }
            else if ( (LA41_0==RULE_BOOL_TYPE) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalReflex.g:3561:3: this_CType_0= ruleCType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getReflexTypeAccess().getCTypeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CType_0=ruleCType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CType_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3570:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    {
                    // InternalReflex.g:3570:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    // InternalReflex.g:3571:4: () this_BOOL_TYPE_2= RULE_BOOL_TYPE
                    {
                    // InternalReflex.g:3571:4: ()
                    // InternalReflex.g:3572:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getReflexTypeAccess().getReflexTypeAction_1_0(),
                      						current);
                      				
                    }

                    }

                    this_BOOL_TYPE_2=(Token)match(input,RULE_BOOL_TYPE,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BOOL_TYPE_2, grammarAccess.getReflexTypeAccess().getBOOL_TYPETerminalRuleCall_1_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReflexType"


    // $ANTLR start "entryRuleInteger"
    // InternalReflex.g:3587:1: entryRuleInteger returns [EObject current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final EObject entryRuleInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteger = null;


        try {
            // InternalReflex.g:3587:48: (iv_ruleInteger= ruleInteger EOF )
            // InternalReflex.g:3588:2: iv_ruleInteger= ruleInteger EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntegerRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInteger=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInteger; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // InternalReflex.g:3594:1: ruleInteger returns [EObject current=null] : ( ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? ) ;
    public final EObject ruleInteger() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;
        Token lv_value_0_3=null;
        Token lv_qualfier_1_1=null;
        Token lv_qualfier_1_2=null;


        	enterRule();

        try {
            // InternalReflex.g:3600:2: ( ( ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? ) )
            // InternalReflex.g:3601:2: ( ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? )
            {
            // InternalReflex.g:3601:2: ( ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? )
            // InternalReflex.g:3602:3: ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )?
            {
            // InternalReflex.g:3602:3: ( ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) ) )
            // InternalReflex.g:3603:4: ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) )
            {
            // InternalReflex.g:3603:4: ( (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX ) )
            // InternalReflex.g:3604:5: (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX )
            {
            // InternalReflex.g:3604:5: (lv_value_0_1= RULE_DECIMAL | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_HEX )
            int alt42=3;
            switch ( input.LA(1) ) {
            case RULE_DECIMAL:
                {
                alt42=1;
                }
                break;
            case RULE_OCTAL:
                {
                alt42=2;
                }
                break;
            case RULE_HEX:
                {
                alt42=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // InternalReflex.g:3605:6: lv_value_0_1= RULE_DECIMAL
                    {
                    lv_value_0_1=(Token)match(input,RULE_DECIMAL,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_1, grammarAccess.getIntegerAccess().getValueDECIMALTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_1,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3620:6: lv_value_0_2= RULE_OCTAL
                    {
                    lv_value_0_2=(Token)match(input,RULE_OCTAL,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_2, grammarAccess.getIntegerAccess().getValueOCTALTerminalRuleCall_0_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_2,
                      							"ru.iaie.reflex.diagram.Reflex.OCTAL");
                      					
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:3635:6: lv_value_0_3= RULE_HEX
                    {
                    lv_value_0_3=(Token)match(input,RULE_HEX,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_3, grammarAccess.getIntegerAccess().getValueHEXTerminalRuleCall_0_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_3,
                      							"ru.iaie.reflex.diagram.Reflex.HEX");
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalReflex.g:3652:3: ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=RULE_LONG && LA44_0<=RULE_UNSIGNED)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalReflex.g:3653:4: ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) )
                    {
                    // InternalReflex.g:3653:4: ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) )
                    // InternalReflex.g:3654:5: (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED )
                    {
                    // InternalReflex.g:3654:5: (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED )
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==RULE_LONG) ) {
                        alt43=1;
                    }
                    else if ( (LA43_0==RULE_UNSIGNED) ) {
                        alt43=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 43, 0, input);

                        throw nvae;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalReflex.g:3655:6: lv_qualfier_1_1= RULE_LONG
                            {
                            lv_qualfier_1_1=(Token)match(input,RULE_LONG,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_qualfier_1_1, grammarAccess.getIntegerAccess().getQualfierLONGTerminalRuleCall_1_0_0());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIntegerRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"qualfier",
                              							true,
                              							"ru.iaie.reflex.diagram.Reflex.LONG");
                              					
                            }

                            }
                            break;
                        case 2 :
                            // InternalReflex.g:3670:6: lv_qualfier_1_2= RULE_UNSIGNED
                            {
                            lv_qualfier_1_2=(Token)match(input,RULE_UNSIGNED,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(lv_qualfier_1_2, grammarAccess.getIntegerAccess().getQualfierUNSIGNEDTerminalRuleCall_1_0_1());
                              					
                            }
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElement(grammarAccess.getIntegerRule());
                              						}
                              						setWithLastConsumed(
                              							current,
                              							"qualfier",
                              							true,
                              							"ru.iaie.reflex.diagram.Reflex.UNSIGNED");
                              					
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleTime"
    // InternalReflex.g:3691:1: entryRuleTime returns [EObject current=null] : iv_ruleTime= ruleTime EOF ;
    public final EObject entryRuleTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTime = null;


        try {
            // InternalReflex.g:3691:45: (iv_ruleTime= ruleTime EOF )
            // InternalReflex.g:3692:2: iv_ruleTime= ruleTime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTime=ruleTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTime; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTime"


    // $ANTLR start "ruleTime"
    // InternalReflex.g:3698:1: ruleTime returns [EObject current=null] : ( () (otherlv_1= '0t' | otherlv_2= '0T' ) (this_DAY_3= RULE_DAY ( (lv_days_4_0= RULE_DECIMAL ) ) )? (this_HOUR_5= RULE_HOUR ( (lv_hours_6_0= RULE_DECIMAL ) ) )? (this_MINUTE_7= RULE_MINUTE ( (lv_minutes_8_0= RULE_DECIMAL ) ) )? (this_SECOND_9= RULE_SECOND ( (lv_seconds_10_0= RULE_DECIMAL ) ) )? (this_MILISECOND_11= RULE_MILISECOND ( (lv_milis_12_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_13= RULE_MICROSECOND ( (lv_micros_14_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_15= RULE_NANOSECOND ( (lv_nanos_16_0= RULE_DECIMAL ) ) )? ) ;
    public final EObject ruleTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_DAY_3=null;
        Token lv_days_4_0=null;
        Token this_HOUR_5=null;
        Token lv_hours_6_0=null;
        Token this_MINUTE_7=null;
        Token lv_minutes_8_0=null;
        Token this_SECOND_9=null;
        Token lv_seconds_10_0=null;
        Token this_MILISECOND_11=null;
        Token lv_milis_12_0=null;
        Token this_MICROSECOND_13=null;
        Token lv_micros_14_0=null;
        Token this_NANOSECOND_15=null;
        Token lv_nanos_16_0=null;


        	enterRule();

        try {
            // InternalReflex.g:3704:2: ( ( () (otherlv_1= '0t' | otherlv_2= '0T' ) (this_DAY_3= RULE_DAY ( (lv_days_4_0= RULE_DECIMAL ) ) )? (this_HOUR_5= RULE_HOUR ( (lv_hours_6_0= RULE_DECIMAL ) ) )? (this_MINUTE_7= RULE_MINUTE ( (lv_minutes_8_0= RULE_DECIMAL ) ) )? (this_SECOND_9= RULE_SECOND ( (lv_seconds_10_0= RULE_DECIMAL ) ) )? (this_MILISECOND_11= RULE_MILISECOND ( (lv_milis_12_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_13= RULE_MICROSECOND ( (lv_micros_14_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_15= RULE_NANOSECOND ( (lv_nanos_16_0= RULE_DECIMAL ) ) )? ) )
            // InternalReflex.g:3705:2: ( () (otherlv_1= '0t' | otherlv_2= '0T' ) (this_DAY_3= RULE_DAY ( (lv_days_4_0= RULE_DECIMAL ) ) )? (this_HOUR_5= RULE_HOUR ( (lv_hours_6_0= RULE_DECIMAL ) ) )? (this_MINUTE_7= RULE_MINUTE ( (lv_minutes_8_0= RULE_DECIMAL ) ) )? (this_SECOND_9= RULE_SECOND ( (lv_seconds_10_0= RULE_DECIMAL ) ) )? (this_MILISECOND_11= RULE_MILISECOND ( (lv_milis_12_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_13= RULE_MICROSECOND ( (lv_micros_14_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_15= RULE_NANOSECOND ( (lv_nanos_16_0= RULE_DECIMAL ) ) )? )
            {
            // InternalReflex.g:3705:2: ( () (otherlv_1= '0t' | otherlv_2= '0T' ) (this_DAY_3= RULE_DAY ( (lv_days_4_0= RULE_DECIMAL ) ) )? (this_HOUR_5= RULE_HOUR ( (lv_hours_6_0= RULE_DECIMAL ) ) )? (this_MINUTE_7= RULE_MINUTE ( (lv_minutes_8_0= RULE_DECIMAL ) ) )? (this_SECOND_9= RULE_SECOND ( (lv_seconds_10_0= RULE_DECIMAL ) ) )? (this_MILISECOND_11= RULE_MILISECOND ( (lv_milis_12_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_13= RULE_MICROSECOND ( (lv_micros_14_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_15= RULE_NANOSECOND ( (lv_nanos_16_0= RULE_DECIMAL ) ) )? )
            // InternalReflex.g:3706:3: () (otherlv_1= '0t' | otherlv_2= '0T' ) (this_DAY_3= RULE_DAY ( (lv_days_4_0= RULE_DECIMAL ) ) )? (this_HOUR_5= RULE_HOUR ( (lv_hours_6_0= RULE_DECIMAL ) ) )? (this_MINUTE_7= RULE_MINUTE ( (lv_minutes_8_0= RULE_DECIMAL ) ) )? (this_SECOND_9= RULE_SECOND ( (lv_seconds_10_0= RULE_DECIMAL ) ) )? (this_MILISECOND_11= RULE_MILISECOND ( (lv_milis_12_0= RULE_DECIMAL ) ) )? (this_MICROSECOND_13= RULE_MICROSECOND ( (lv_micros_14_0= RULE_DECIMAL ) ) )? (this_NANOSECOND_15= RULE_NANOSECOND ( (lv_nanos_16_0= RULE_DECIMAL ) ) )?
            {
            // InternalReflex.g:3706:3: ()
            // InternalReflex.g:3707:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTimeAccess().getTimeAction_0(),
              					current);
              			
            }

            }

            // InternalReflex.g:3713:3: (otherlv_1= '0t' | otherlv_2= '0T' )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==69) ) {
                alt45=1;
            }
            else if ( (LA45_0==70) ) {
                alt45=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalReflex.g:3714:4: otherlv_1= '0t'
                    {
                    otherlv_1=(Token)match(input,69,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTimeAccess().getTKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3719:4: otherlv_2= '0T'
                    {
                    otherlv_2=(Token)match(input,70,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getTimeAccess().getTKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:3724:3: (this_DAY_3= RULE_DAY ( (lv_days_4_0= RULE_DECIMAL ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_DAY) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalReflex.g:3725:4: this_DAY_3= RULE_DAY ( (lv_days_4_0= RULE_DECIMAL ) )
                    {
                    this_DAY_3=(Token)match(input,RULE_DAY,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_DAY_3, grammarAccess.getTimeAccess().getDAYTerminalRuleCall_2_0());
                      			
                    }
                    // InternalReflex.g:3729:4: ( (lv_days_4_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3730:5: (lv_days_4_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3730:5: (lv_days_4_0= RULE_DECIMAL )
                    // InternalReflex.g:3731:6: lv_days_4_0= RULE_DECIMAL
                    {
                    lv_days_4_0=(Token)match(input,RULE_DECIMAL,FOLLOW_53); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_days_4_0, grammarAccess.getTimeAccess().getDaysDECIMALTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"days",
                      							lv_days_4_0,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3748:3: (this_HOUR_5= RULE_HOUR ( (lv_hours_6_0= RULE_DECIMAL ) ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_HOUR) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalReflex.g:3749:4: this_HOUR_5= RULE_HOUR ( (lv_hours_6_0= RULE_DECIMAL ) )
                    {
                    this_HOUR_5=(Token)match(input,RULE_HOUR,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_HOUR_5, grammarAccess.getTimeAccess().getHOURTerminalRuleCall_3_0());
                      			
                    }
                    // InternalReflex.g:3753:4: ( (lv_hours_6_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3754:5: (lv_hours_6_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3754:5: (lv_hours_6_0= RULE_DECIMAL )
                    // InternalReflex.g:3755:6: lv_hours_6_0= RULE_DECIMAL
                    {
                    lv_hours_6_0=(Token)match(input,RULE_DECIMAL,FOLLOW_54); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_hours_6_0, grammarAccess.getTimeAccess().getHoursDECIMALTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"hours",
                      							lv_hours_6_0,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3772:3: (this_MINUTE_7= RULE_MINUTE ( (lv_minutes_8_0= RULE_DECIMAL ) ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_MINUTE) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalReflex.g:3773:4: this_MINUTE_7= RULE_MINUTE ( (lv_minutes_8_0= RULE_DECIMAL ) )
                    {
                    this_MINUTE_7=(Token)match(input,RULE_MINUTE,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_MINUTE_7, grammarAccess.getTimeAccess().getMINUTETerminalRuleCall_4_0());
                      			
                    }
                    // InternalReflex.g:3777:4: ( (lv_minutes_8_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3778:5: (lv_minutes_8_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3778:5: (lv_minutes_8_0= RULE_DECIMAL )
                    // InternalReflex.g:3779:6: lv_minutes_8_0= RULE_DECIMAL
                    {
                    lv_minutes_8_0=(Token)match(input,RULE_DECIMAL,FOLLOW_55); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_minutes_8_0, grammarAccess.getTimeAccess().getMinutesDECIMALTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"minutes",
                      							lv_minutes_8_0,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3796:3: (this_SECOND_9= RULE_SECOND ( (lv_seconds_10_0= RULE_DECIMAL ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_SECOND) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalReflex.g:3797:4: this_SECOND_9= RULE_SECOND ( (lv_seconds_10_0= RULE_DECIMAL ) )
                    {
                    this_SECOND_9=(Token)match(input,RULE_SECOND,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_SECOND_9, grammarAccess.getTimeAccess().getSECONDTerminalRuleCall_5_0());
                      			
                    }
                    // InternalReflex.g:3801:4: ( (lv_seconds_10_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3802:5: (lv_seconds_10_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3802:5: (lv_seconds_10_0= RULE_DECIMAL )
                    // InternalReflex.g:3803:6: lv_seconds_10_0= RULE_DECIMAL
                    {
                    lv_seconds_10_0=(Token)match(input,RULE_DECIMAL,FOLLOW_56); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_seconds_10_0, grammarAccess.getTimeAccess().getSecondsDECIMALTerminalRuleCall_5_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"seconds",
                      							lv_seconds_10_0,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3820:3: (this_MILISECOND_11= RULE_MILISECOND ( (lv_milis_12_0= RULE_DECIMAL ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_MILISECOND) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalReflex.g:3821:4: this_MILISECOND_11= RULE_MILISECOND ( (lv_milis_12_0= RULE_DECIMAL ) )
                    {
                    this_MILISECOND_11=(Token)match(input,RULE_MILISECOND,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_MILISECOND_11, grammarAccess.getTimeAccess().getMILISECONDTerminalRuleCall_6_0());
                      			
                    }
                    // InternalReflex.g:3825:4: ( (lv_milis_12_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3826:5: (lv_milis_12_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3826:5: (lv_milis_12_0= RULE_DECIMAL )
                    // InternalReflex.g:3827:6: lv_milis_12_0= RULE_DECIMAL
                    {
                    lv_milis_12_0=(Token)match(input,RULE_DECIMAL,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_milis_12_0, grammarAccess.getTimeAccess().getMilisDECIMALTerminalRuleCall_6_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"milis",
                      							lv_milis_12_0,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3844:3: (this_MICROSECOND_13= RULE_MICROSECOND ( (lv_micros_14_0= RULE_DECIMAL ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_MICROSECOND) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalReflex.g:3845:4: this_MICROSECOND_13= RULE_MICROSECOND ( (lv_micros_14_0= RULE_DECIMAL ) )
                    {
                    this_MICROSECOND_13=(Token)match(input,RULE_MICROSECOND,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_MICROSECOND_13, grammarAccess.getTimeAccess().getMICROSECONDTerminalRuleCall_7_0());
                      			
                    }
                    // InternalReflex.g:3849:4: ( (lv_micros_14_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3850:5: (lv_micros_14_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3850:5: (lv_micros_14_0= RULE_DECIMAL )
                    // InternalReflex.g:3851:6: lv_micros_14_0= RULE_DECIMAL
                    {
                    lv_micros_14_0=(Token)match(input,RULE_DECIMAL,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_micros_14_0, grammarAccess.getTimeAccess().getMicrosDECIMALTerminalRuleCall_7_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"micros",
                      							lv_micros_14_0,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3868:3: (this_NANOSECOND_15= RULE_NANOSECOND ( (lv_nanos_16_0= RULE_DECIMAL ) ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_NANOSECOND) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalReflex.g:3869:4: this_NANOSECOND_15= RULE_NANOSECOND ( (lv_nanos_16_0= RULE_DECIMAL ) )
                    {
                    this_NANOSECOND_15=(Token)match(input,RULE_NANOSECOND,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_NANOSECOND_15, grammarAccess.getTimeAccess().getNANOSECONDTerminalRuleCall_8_0());
                      			
                    }
                    // InternalReflex.g:3873:4: ( (lv_nanos_16_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3874:5: (lv_nanos_16_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3874:5: (lv_nanos_16_0= RULE_DECIMAL )
                    // InternalReflex.g:3875:6: lv_nanos_16_0= RULE_DECIMAL
                    {
                    lv_nanos_16_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_nanos_16_0, grammarAccess.getTimeAccess().getNanosDECIMALTerminalRuleCall_8_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"nanos",
                      							lv_nanos_16_0,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTime"


    // $ANTLR start "ruleRegisterType"
    // InternalReflex.g:3896:1: ruleRegisterType returns [Enumerator current=null] : ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) ;
    public final Enumerator ruleRegisterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3902:2: ( ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) )
            // InternalReflex.g:3903:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            {
            // InternalReflex.g:3903:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==71) ) {
                alt53=1;
            }
            else if ( (LA53_0==72) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalReflex.g:3904:3: (enumLiteral_0= 'input' )
                    {
                    // InternalReflex.g:3904:3: (enumLiteral_0= 'input' )
                    // InternalReflex.g:3905:4: enumLiteral_0= 'input'
                    {
                    enumLiteral_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3912:3: (enumLiteral_1= 'output' )
                    {
                    // InternalReflex.g:3912:3: (enumLiteral_1= 'output' )
                    // InternalReflex.g:3913:4: enumLiteral_1= 'output'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getOUTPUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterTypeAccess().getOUTPUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegisterType"


    // $ANTLR start "ruleInfixPostfixOp"
    // InternalReflex.g:3923:1: ruleInfixPostfixOp returns [Enumerator current=null] : ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) ;
    public final Enumerator ruleInfixPostfixOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3929:2: ( ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) )
            // InternalReflex.g:3930:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            {
            // InternalReflex.g:3930:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==73) ) {
                alt54=1;
            }
            else if ( (LA54_0==74) ) {
                alt54=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }
            switch (alt54) {
                case 1 :
                    // InternalReflex.g:3931:3: (enumLiteral_0= '++' )
                    {
                    // InternalReflex.g:3931:3: (enumLiteral_0= '++' )
                    // InternalReflex.g:3932:4: enumLiteral_0= '++'
                    {
                    enumLiteral_0=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3939:3: (enumLiteral_1= '--' )
                    {
                    // InternalReflex.g:3939:3: (enumLiteral_1= '--' )
                    // InternalReflex.g:3940:4: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getDECEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getInfixPostfixOpAccess().getDECEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixPostfixOp"


    // $ANTLR start "ruleAssignOperator"
    // InternalReflex.g:3950:1: ruleAssignOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) ;
    public final Enumerator ruleAssignOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;


        	enterRule();

        try {
            // InternalReflex.g:3956:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) )
            // InternalReflex.g:3957:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            {
            // InternalReflex.g:3957:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            int alt55=10;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt55=1;
                }
                break;
            case 75:
                {
                alt55=2;
                }
                break;
            case 76:
                {
                alt55=3;
                }
                break;
            case 77:
                {
                alt55=4;
                }
                break;
            case 78:
                {
                alt55=5;
                }
                break;
            case 79:
                {
                alt55=6;
                }
                break;
            case 80:
                {
                alt55=7;
                }
                break;
            case 81:
                {
                alt55=8;
                }
                break;
            case 82:
                {
                alt55=9;
                }
                break;
            case 83:
                {
                alt55=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalReflex.g:3958:3: (enumLiteral_0= '=' )
                    {
                    // InternalReflex.g:3958:3: (enumLiteral_0= '=' )
                    // InternalReflex.g:3959:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3966:3: (enumLiteral_1= '*=' )
                    {
                    // InternalReflex.g:3966:3: (enumLiteral_1= '*=' )
                    // InternalReflex.g:3967:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:3974:3: (enumLiteral_2= '/=' )
                    {
                    // InternalReflex.g:3974:3: (enumLiteral_2= '/=' )
                    // InternalReflex.g:3975:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:3982:3: (enumLiteral_3= '+=' )
                    {
                    // InternalReflex.g:3982:3: (enumLiteral_3= '+=' )
                    // InternalReflex.g:3983:4: enumLiteral_3= '+='
                    {
                    enumLiteral_3=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:3990:3: (enumLiteral_4= '-=' )
                    {
                    // InternalReflex.g:3990:3: (enumLiteral_4= '-=' )
                    // InternalReflex.g:3991:4: enumLiteral_4= '-='
                    {
                    enumLiteral_4=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:3998:3: (enumLiteral_5= '<<=' )
                    {
                    // InternalReflex.g:3998:3: (enumLiteral_5= '<<=' )
                    // InternalReflex.g:3999:4: enumLiteral_5= '<<='
                    {
                    enumLiteral_5=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:4006:3: (enumLiteral_6= '>>=' )
                    {
                    // InternalReflex.g:4006:3: (enumLiteral_6= '>>=' )
                    // InternalReflex.g:4007:4: enumLiteral_6= '>>='
                    {
                    enumLiteral_6=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:4014:3: (enumLiteral_7= '&=' )
                    {
                    // InternalReflex.g:4014:3: (enumLiteral_7= '&=' )
                    // InternalReflex.g:4015:4: enumLiteral_7= '&='
                    {
                    enumLiteral_7=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:4022:3: (enumLiteral_8= '^=' )
                    {
                    // InternalReflex.g:4022:3: (enumLiteral_8= '^=' )
                    // InternalReflex.g:4023:4: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:4030:3: (enumLiteral_9= '|=' )
                    {
                    // InternalReflex.g:4030:3: (enumLiteral_9= '|=' )
                    // InternalReflex.g:4031:4: enumLiteral_9= '|='
                    {
                    enumLiteral_9=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_OREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getAssignOperatorAccess().getBIT_OREnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignOperator"


    // $ANTLR start "ruleUnaryOp"
    // InternalReflex.g:4041:1: ruleUnaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) ;
    public final Enumerator ruleUnaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4047:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) )
            // InternalReflex.g:4048:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            {
            // InternalReflex.g:4048:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            int alt56=4;
            switch ( input.LA(1) ) {
            case 84:
                {
                alt56=1;
                }
                break;
            case 85:
                {
                alt56=2;
                }
                break;
            case 86:
                {
                alt56=3;
                }
                break;
            case 87:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalReflex.g:4049:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4049:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4050:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4057:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4057:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4058:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4065:3: (enumLiteral_2= '~' )
                    {
                    // InternalReflex.g:4065:3: (enumLiteral_2= '~' )
                    // InternalReflex.g:4066:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4073:3: (enumLiteral_3= '!' )
                    {
                    // InternalReflex.g:4073:3: (enumLiteral_3= '!' )
                    // InternalReflex.g:4074:4: enumLiteral_3= '!'
                    {
                    enumLiteral_3=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getLOGICAL_NOTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getUnaryOpAccess().getLOGICAL_NOTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOp"


    // $ANTLR start "ruleCompareOp"
    // InternalReflex.g:4084:1: ruleCompareOp returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4090:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) )
            // InternalReflex.g:4091:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalReflex.g:4091:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            int alt57=4;
            switch ( input.LA(1) ) {
            case 88:
                {
                alt57=1;
                }
                break;
            case 89:
                {
                alt57=2;
                }
                break;
            case 90:
                {
                alt57=3;
                }
                break;
            case 91:
                {
                alt57=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }

            switch (alt57) {
                case 1 :
                    // InternalReflex.g:4092:3: (enumLiteral_0= '<' )
                    {
                    // InternalReflex.g:4092:3: (enumLiteral_0= '<' )
                    // InternalReflex.g:4093:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4100:3: (enumLiteral_1= '>' )
                    {
                    // InternalReflex.g:4100:3: (enumLiteral_1= '>' )
                    // InternalReflex.g:4101:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4108:3: (enumLiteral_2= '=<' )
                    {
                    // InternalReflex.g:4108:3: (enumLiteral_2= '=<' )
                    // InternalReflex.g:4109:4: enumLiteral_2= '=<'
                    {
                    enumLiteral_2=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4116:3: (enumLiteral_3= '>=' )
                    {
                    // InternalReflex.g:4116:3: (enumLiteral_3= '>=' )
                    // InternalReflex.g:4117:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATER_EQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getCompareOpAccess().getGREATER_EQEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareOp"


    // $ANTLR start "ruleCompareEqOp"
    // InternalReflex.g:4127:1: ruleCompareEqOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleCompareEqOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4133:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // InternalReflex.g:4134:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // InternalReflex.g:4134:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==92) ) {
                alt58=1;
            }
            else if ( (LA58_0==93) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalReflex.g:4135:3: (enumLiteral_0= '==' )
                    {
                    // InternalReflex.g:4135:3: (enumLiteral_0= '==' )
                    // InternalReflex.g:4136:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4143:3: (enumLiteral_1= '!=' )
                    {
                    // InternalReflex.g:4143:3: (enumLiteral_1= '!=' )
                    // InternalReflex.g:4144:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getNOT_EQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareEqOpAccess().getNOT_EQEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareEqOp"


    // $ANTLR start "ruleShiftOp"
    // InternalReflex.g:4154:1: ruleShiftOp returns [Enumerator current=null] : ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) ;
    public final Enumerator ruleShiftOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4160:2: ( ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) )
            // InternalReflex.g:4161:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            {
            // InternalReflex.g:4161:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==94) ) {
                alt59=1;
            }
            else if ( (LA59_0==95) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalReflex.g:4162:3: (enumLiteral_0= '>>' )
                    {
                    // InternalReflex.g:4162:3: (enumLiteral_0= '>>' )
                    // InternalReflex.g:4163:4: enumLiteral_0= '>>'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4170:3: (enumLiteral_1= '<<' )
                    {
                    // InternalReflex.g:4170:3: (enumLiteral_1= '<<' )
                    // InternalReflex.g:4171:4: enumLiteral_1= '<<'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getRIGHT_SHIFTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getShiftOpAccess().getRIGHT_SHIFTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftOp"


    // $ANTLR start "ruleAdditiveOp"
    // InternalReflex.g:4181:1: ruleAdditiveOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4187:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalReflex.g:4188:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalReflex.g:4188:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==84) ) {
                alt60=1;
            }
            else if ( (LA60_0==85) ) {
                alt60=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalReflex.g:4189:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4189:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4190:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4197:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4197:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4198:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOp"


    // $ANTLR start "ruleMultiplicativeOp"
    // InternalReflex.g:4208:1: ruleMultiplicativeOp returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalReflex.g:4214:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalReflex.g:4215:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalReflex.g:4215:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt61=3;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt61=1;
                }
                break;
            case 97:
                {
                alt61=2;
                }
                break;
            case 98:
                {
                alt61=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalReflex.g:4216:3: (enumLiteral_0= '*' )
                    {
                    // InternalReflex.g:4216:3: (enumLiteral_0= '*' )
                    // InternalReflex.g:4217:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4224:3: (enumLiteral_1= '/' )
                    {
                    // InternalReflex.g:4224:3: (enumLiteral_1= '/' )
                    // InternalReflex.g:4225:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4232:3: (enumLiteral_2= '%' )
                    {
                    // InternalReflex.g:4232:3: (enumLiteral_2= '%' )
                    // InternalReflex.g:4233:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMODEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getMultiplicativeOpAccess().getMODEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOp"


    // $ANTLR start "ruleCTypeSignSpec"
    // InternalReflex.g:4243:1: ruleCTypeSignSpec returns [Enumerator current=null] : ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) ;
    public final Enumerator ruleCTypeSignSpec() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4249:2: ( ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) )
            // InternalReflex.g:4250:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            {
            // InternalReflex.g:4250:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==99) ) {
                alt62=1;
            }
            else if ( (LA62_0==100) ) {
                alt62=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalReflex.g:4251:3: (enumLiteral_0= 'signed' )
                    {
                    // InternalReflex.g:4251:3: (enumLiteral_0= 'signed' )
                    // InternalReflex.g:4252:4: enumLiteral_0= 'signed'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4259:3: (enumLiteral_1= 'unsigned' )
                    {
                    // InternalReflex.g:4259:3: (enumLiteral_1= 'unsigned' )
                    // InternalReflex.g:4260:4: enumLiteral_1= 'unsigned'
                    {
                    enumLiteral_1=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCTypeSignSpecAccess().getUNSIGNEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCTypeSignSpecAccess().getUNSIGNEDEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCTypeSignSpec"

    // $ANTLR start synpred1_InternalReflex
    public final void synpred1_InternalReflex_fragment() throws RecognitionException {   
        // InternalReflex.g:1269:5: ( 'else' )
        // InternalReflex.g:1269:6: 'else'
        {
        match(input,55,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalReflex

    // Delegated rules

    public final boolean synpred1_InternalReflex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalReflex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000001800003F020L,0x0000001800000198L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000001800003F000L,0x0000001800000198L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000404800007F000L,0x0000001800000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0004008000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0003800000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000108000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000380000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0xF13802C000380010L,0x0000000000F00603L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0xF130024000380010L,0x0000000000F00603L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0xF13002C000380010L,0x0000000000F00603L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0200008000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000020000000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0004000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000000000003F000L,0x0000001800000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0040100000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000120000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0020000000380010L,0x0000000000F00600L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000004000007F000L,0x0000001800000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000000700000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000300000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x00000000C0000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x000000000F000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000000030000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000080000000000L,0x00000000000FF800L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x000000007F000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x000000007E000002L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x000000007C000002L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000078000002L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000070000002L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000040000002L});

}