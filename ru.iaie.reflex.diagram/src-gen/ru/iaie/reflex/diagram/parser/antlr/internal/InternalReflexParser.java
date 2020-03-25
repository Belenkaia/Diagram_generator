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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_TACT", "RULE_BIT_AND", "RULE_BIT_XOR", "RULE_BIT_OR", "RULE_LOGICAL_AND", "RULE_LOGICAL_OR", "RULE_VOID_C_TYPE", "RULE_FLOAT_C_TYPE", "RULE_DOUBLE_C_TYPE", "RULE_SHORT_C_TYPE", "RULE_INT_C_TYPE", "RULE_LONG_C_TYPE", "RULE_BOOL_TYPE", "RULE_HEX", "RULE_OCTAL", "RULE_DECIMAL", "RULE_LONG", "RULE_UNSIGNED", "RULE_DEC_FLOAT", "RULE_HEX_FLOAT", "RULE_DAY", "RULE_HOUR", "RULE_DEC_SEQUENCE", "RULE_EXPONENT", "RULE_SIGN", "RULE_FLOAT_SUFFIX", "RULE_HEX_SEQUENCE", "RULE_BIN_EXPONENT", "RULE_HEX_PREFIX", "RULE_MINUTE", "RULE_SECOND", "RULE_MILISECOND", "RULE_MICROSECOND", "RULE_NANOSECOND", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'program'", "'{'", "'}'", "'proc'", "';'", "'from'", "'='", "','", "'['", "']'", "'local'", "'global'", "'shared'", "'state'", "'timeout'", "'if'", "'('", "')'", "'else'", "'switch'", "'case'", "':'", "'break'", "'start'", "'stop'", "'error'", "'loop'", "'restart'", "'set'", "'next'", "'const'", "'enum'", "'0t'", "'0T'", "'input'", "'output'", "'++'", "'--'", "'*='", "'/='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'+'", "'-'", "'~'", "'!'", "'<'", "'>'", "'=<'", "'>='", "'=='", "'!='", "'>>'", "'<<'", "'*'", "'/'", "'%'", "'signed'", "'unsigned'"
    };
    public static final int RULE_HEX=18;
    public static final int T__50=50;
    public static final int RULE_SIGN=29;
    public static final int RULE_DEC_SEQUENCE=27;
    public static final int RULE_MINUTE=34;
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
    public static final int RULE_HEX_FLOAT=24;
    public static final int RULE_INT_C_TYPE=15;
    public static final int RULE_INT=39;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=41;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_MICROSECOND=37;
    public static final int RULE_VOID_C_TYPE=11;
    public static final int RULE_HEX_SEQUENCE=31;
    public static final int RULE_HOUR=26;
    public static final int RULE_UNSIGNED=22;
    public static final int RULE_DOUBLE_C_TYPE=13;
    public static final int RULE_BIN_EXPONENT=32;
    public static final int RULE_LOGICAL_AND=9;
    public static final int RULE_EXPONENT=28;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=23;
    public static final int T__49=49;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_BIT_AND=6;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int RULE_BOOL_TYPE=17;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int RULE_DAY=25;
    public static final int T__90=90;
    public static final int RULE_FLOAT_C_TYPE=12;
    public static final int RULE_OCTAL=19;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_SHORT_C_TYPE=14;
    public static final int RULE_DECIMAL=20;
    public static final int RULE_SECOND=35;
    public static final int RULE_LOGICAL_OR=10;
    public static final int RULE_LONG_C_TYPE=16;
    public static final int RULE_FLOAT_SUFFIX=30;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_NANOSECOND=38;
    public static final int RULE_MILISECOND=36;
    public static final int RULE_STRING=40;
    public static final int RULE_SL_COMMENT=42;
    public static final int RULE_HEX_PREFIX=33;
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
    public static final int RULE_WS=43;
    public static final int RULE_ANY_OTHER=44;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int RULE_BIT_XOR=7;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_BIT_OR=8;
    public static final int RULE_LONG=21;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

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
            otherlv_0=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,46,FOLLOW_5); if (state.failed) return current;
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
                case 75:
                    {
                    alt2=1;
                    }
                    break;
                case 76:
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
                case 107:
                case 108:
                    {
                    alt2=3;
                    }
                    break;
                case 79:
                case 80:
                    {
                    alt2=4;
                    }
                    break;
                case 48:
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

            otherlv_9=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,48,FOLLOW_3); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,46,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:274:3: ( (lv_variable_3_0= ruleVariable ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=RULE_VOID_C_TYPE && LA3_0<=RULE_BOOL_TYPE)||LA3_0==50||(LA3_0>=107 && LA3_0<=108)) ) {
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

                if ( (LA4_0==58) ) {
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

            otherlv_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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

            if ( (LA5_0==50) ) {
                alt5=1;
            }
            else if ( ((LA5_0>=RULE_VOID_C_TYPE && LA5_0<=RULE_BOOL_TYPE)||(LA5_0>=107 && LA5_0<=108)) ) {
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
                    otherlv_2=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,50,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportedVariableAccess().getFromKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,48,FOLLOW_3); if (state.failed) return current;
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

                    if ( ((LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=2;
                    }
                    else if ( (LA7_6==51) ) {
                        alt7=1;
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

                    if ( ((LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=2;
                    }
                    else if ( (LA7_6==51) ) {
                        alt7=1;
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

                    if ( ((LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=2;
                    }
                    else if ( (LA7_6==51) ) {
                        alt7=1;
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

                    if ( ((LA7_6>=55 && LA7_6<=57)) ) {
                        alt7=2;
                    }
                    else if ( (LA7_6==51) ) {
                        alt7=1;
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
            case 107:
            case 108:
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

            otherlv_2=(Token)match(input,51,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPhysicalVariableAccess().getEqualsSignKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
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

                if ( (LA8_0==52) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalReflex.g:562:4: otherlv_5= ',' ( (lv_ports_6_0= ruleRegisterPort ) )
            	    {
            	    otherlv_5=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
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

            otherlv_7=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,53,FOLLOW_16); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
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
            case 55:
                {
                alt10=1;
                }
                break;
            case 56:
                {
                alt10=2;
                }
                break;
            case 57:
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
                    lv_LOCAL_0_0=(Token)match(input,55,FOLLOW_2); if (state.failed) return current;
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
                    lv_GLOBAL_1_0=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
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
                    lv_SHARED_2_0=(Token)match(input,57,FOLLOW_11); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,58,FOLLOW_3); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,46,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:838:3: ( (lv_statements_3_0= ruleStatement ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||(LA11_0>=RULE_HEX && LA11_0<=RULE_DECIMAL)||(LA11_0>=RULE_DEC_FLOAT && LA11_0<=RULE_HEX_FLOAT)||LA11_0==46||LA11_0==49||(LA11_0>=60 && LA11_0<=61)||LA11_0==64||(LA11_0>=68 && LA11_0<=73)||(LA11_0>=81 && LA11_0<=82)||(LA11_0>=92 && LA11_0<=95)) ) {
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

            if ( (LA12_0==59) ) {
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

            otherlv_5=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:891:1: ruleTimeoutFunction returns [EObject current=null] : (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_statements_2_0= ruleStatement ) )* ) ;
    public final EObject ruleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_time_1_0 = null;

        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:897:2: ( (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_statements_2_0= ruleStatement ) )* ) )
            // InternalReflex.g:898:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_statements_2_0= ruleStatement ) )* )
            {
            // InternalReflex.g:898:2: (otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_statements_2_0= ruleStatement ) )* )
            // InternalReflex.g:899:3: otherlv_0= 'timeout' ( (lv_time_1_0= ruleTime ) ) ( (lv_statements_2_0= ruleStatement ) )*
            {
            otherlv_0=(Token)match(input,59,FOLLOW_20); if (state.failed) return current;
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

            // InternalReflex.g:922:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID||(LA13_0>=RULE_HEX && LA13_0<=RULE_DECIMAL)||(LA13_0>=RULE_DEC_FLOAT && LA13_0<=RULE_HEX_FLOAT)||LA13_0==46||LA13_0==49||(LA13_0>=60 && LA13_0<=61)||LA13_0==64||(LA13_0>=68 && LA13_0<=73)||(LA13_0>=81 && LA13_0<=82)||(LA13_0>=92 && LA13_0<=95)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalReflex.g:923:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalReflex.g:923:4: (lv_statements_2_0= ruleStatement )
            	    // InternalReflex.g:924:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getStatementsStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
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
            	    break loop13;
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
            int alt14=11;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt14=1;
                }
                break;
            case 68:
                {
                alt14=2;
                }
                break;
            case 69:
                {
                alt14=3;
                }
                break;
            case 70:
                {
                alt14=4;
                }
                break;
            case 71:
                {
                alt14=5;
                }
                break;
            case 72:
                {
                alt14=6;
                }
                break;
            case 73:
                {
                alt14=7;
                }
                break;
            case 46:
                {
                alt14=8;
                }
                break;
            case 60:
                {
                alt14=9;
                }
                break;
            case 64:
                {
                alt14=10;
                }
                break;
            case RULE_ID:
            case RULE_HEX:
            case RULE_OCTAL:
            case RULE_DECIMAL:
            case RULE_DEC_FLOAT:
            case RULE_HEX_FLOAT:
            case 61:
            case 81:
            case 82:
            case 92:
            case 93:
            case 94:
            case 95:
                {
                alt14=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
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

                    otherlv_1=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,46,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalReflex.g:1133:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID||(LA15_0>=RULE_HEX && LA15_0<=RULE_DECIMAL)||(LA15_0>=RULE_DEC_FLOAT && LA15_0<=RULE_HEX_FLOAT)||LA15_0==46||LA15_0==49||(LA15_0>=60 && LA15_0<=61)||LA15_0==64||(LA15_0>=68 && LA15_0<=73)||(LA15_0>=81 && LA15_0<=82)||(LA15_0>=92 && LA15_0<=95)) ) {
                    alt15=1;
                }


                switch (alt15) {
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
            	    break loop15;
                }
            } while (true);

            otherlv_3=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,60,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfElseStatAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,61,FOLLOW_24); if (state.failed) return current;
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
            pushFollow(FOLLOW_25);
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

            otherlv_3=(Token)match(input,62,FOLLOW_24); if (state.failed) return current;
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
            pushFollow(FOLLOW_26);
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
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==63) ) {
                int LA16_1 = input.LA(2);

                if ( (synpred1_InternalReflex()) ) {
                    alt16=1;
                }
            }
            switch (alt16) {
                case 1 :
                    // InternalReflex.g:1268:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) )
                    {
                    // InternalReflex.g:1268:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalReflex.g:1269:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,63,FOLLOW_24); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,64,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,61,FOLLOW_24); if (state.failed) return current;
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
            pushFollow(FOLLOW_25);
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

            otherlv_3=(Token)match(input,62,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,46,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:1349:3: ( (lv_options_5_0= ruleCaseStat ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==65) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalReflex.g:1350:4: (lv_options_5_0= ruleCaseStat )
            	    {
            	    // InternalReflex.g:1350:4: (lv_options_5_0= ruleCaseStat )
            	    // InternalReflex.g:1351:5: lv_options_5_0= ruleCaseStat
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchStatAccess().getOptionsCaseStatParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_27);
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
            	    break loop17;
                }
            } while (true);

            otherlv_6=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,65,FOLLOW_16); if (state.failed) return current;
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
            pushFollow(FOLLOW_28);
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

            otherlv_2=(Token)match(input,66,FOLLOW_24); if (state.failed) return current;
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
            pushFollow(FOLLOW_29);
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
            otherlv_4=(Token)match(input,67,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getCaseStatAccess().getBreakKeyword_4_0());
              			
            }
            otherlv_5=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
            otherlv_0=(Token)match(input,68,FOLLOW_3); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,69,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStopProcStatAccess().getStopKeyword_1());
              		
            }
            // InternalReflex.g:1522:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
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

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,70,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getErrorStatAccess().getErrorKeyword_1());
              		
            }
            // InternalReflex.g:1574:3: ( (lv_procId_2_0= RULE_ID ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
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

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
            kw=(Token)match(input,71,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getLoopStatAccess().getLoopKeyword_0());
              		
            }
            kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
            kw=(Token)match(input,72,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getRestartStatAccess().getRestartKeyword_0());
              		
            }
            kw=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,73,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetStateStatAccess().getSetKeyword_1());
              		
            }
            // InternalReflex.g:1684:3: ( (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) ) | ( (lv_next_4_0= 'next' ) ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==58) ) {
                alt20=1;
            }
            else if ( (LA20_0==74) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalReflex.g:1685:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    {
                    // InternalReflex.g:1685:4: (otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) ) )
                    // InternalReflex.g:1686:5: otherlv_2= 'state' ( (lv_stateId_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,58,FOLLOW_3); if (state.failed) return current;
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
                    lv_next_4_0=(Token)match(input,74,FOLLOW_9); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,61,FOLLOW_32); if (state.failed) return current;
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
            pushFollow(FOLLOW_33);
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
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==52) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReflex.g:1809:4: otherlv_4= ',' ( (lv_argTypes_5_0= ruleCType ) )
            	    {
            	    otherlv_4=(Token)match(input,52,FOLLOW_32); if (state.failed) return current;
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
            	    pushFollow(FOLLOW_33);
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
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,62,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1852:1: ruleRegister returns [EObject current=null] : ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';' ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_5=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_addr1_2_0 = null;

        EObject lv_addr2_3_0 = null;

        EObject lv_regSize_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1858:2: ( ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1859:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1859:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';' )
            // InternalReflex.g:1860:3: ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= ruleInteger ) ) ( (lv_addr2_3_0= ruleInteger ) ) ( (lv_regSize_4_0= ruleInteger ) ) otherlv_5= ';'
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
            pushFollow(FOLLOW_16);
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

            // InternalReflex.g:1935:3: ( (lv_regSize_4_0= ruleInteger ) )
            // InternalReflex.g:1936:4: (lv_regSize_4_0= ruleInteger )
            {
            // InternalReflex.g:1936:4: (lv_regSize_4_0= ruleInteger )
            // InternalReflex.g:1937:5: lv_regSize_4_0= ruleInteger
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getRegSizeIntegerParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_9);
            lv_regSize_4_0=ruleInteger();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"regSize",
              						lv_regSize_4_0,
              						"ru.iaie.reflex.diagram.Reflex.Integer");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1962:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalReflex.g:1962:46: (iv_ruleConst= ruleConst EOF )
            // InternalReflex.g:1963:2: iv_ruleConst= ruleConst EOF
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
    // InternalReflex.g:1969:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_constId_1_0=null;
        Token otherlv_3=null;
        EObject lv_constValue_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1975:2: ( (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' ) )
            // InternalReflex.g:1976:2: (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:1976:2: (otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';' )
            // InternalReflex.g:1977:3: otherlv_0= 'const' ( (lv_constId_1_0= RULE_ID ) ) ( (lv_constValue_2_0= ruleExpression ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalReflex.g:1981:3: ( (lv_constId_1_0= RULE_ID ) )
            // InternalReflex.g:1982:4: (lv_constId_1_0= RULE_ID )
            {
            // InternalReflex.g:1982:4: (lv_constId_1_0= RULE_ID )
            // InternalReflex.g:1983:5: lv_constId_1_0= RULE_ID
            {
            lv_constId_1_0=(Token)match(input,RULE_ID,FOLLOW_24); if (state.failed) return current;
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

            // InternalReflex.g:1999:3: ( (lv_constValue_2_0= ruleExpression ) )
            // InternalReflex.g:2000:4: (lv_constValue_2_0= ruleExpression )
            {
            // InternalReflex.g:2000:4: (lv_constValue_2_0= ruleExpression )
            // InternalReflex.g:2001:5: lv_constValue_2_0= ruleExpression
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

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:2026:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalReflex.g:2026:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalReflex.g:2027:2: iv_ruleEnum= ruleEnum EOF
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
    // InternalReflex.g:2033:1: ruleEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_enumId_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_enumMembers_3_0 = null;

        EObject lv_enumMembers_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2039:2: ( (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) )
            // InternalReflex.g:2040:2: (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:2040:2: (otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            // InternalReflex.g:2041:3: otherlv_0= 'enum' ( (lv_enumId_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,76,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalReflex.g:2045:3: ( (lv_enumId_1_0= RULE_ID ) )
            // InternalReflex.g:2046:4: (lv_enumId_1_0= RULE_ID )
            {
            // InternalReflex.g:2046:4: (lv_enumId_1_0= RULE_ID )
            // InternalReflex.g:2047:5: lv_enumId_1_0= RULE_ID
            {
            lv_enumId_1_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_enumId_1_0, grammarAccess.getEnumAccess().getEnumIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumRule());
              					}
              					setWithLastConsumed(
              						current,
              						"enumId",
              						lv_enumId_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:2067:3: ( (lv_enumMembers_3_0= ruleEnumMember ) )
            // InternalReflex.g:2068:4: (lv_enumMembers_3_0= ruleEnumMember )
            {
            // InternalReflex.g:2068:4: (lv_enumMembers_3_0= ruleEnumMember )
            // InternalReflex.g:2069:5: lv_enumMembers_3_0= ruleEnumMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_14);
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

            // InternalReflex.g:2086:3: (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==52) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalReflex.g:2087:4: otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    {
            	    otherlv_4=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getEnumAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:2091:4: ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    // InternalReflex.g:2092:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    {
            	    // InternalReflex.g:2092:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    // InternalReflex.g:2093:6: lv_enumMembers_5_0= ruleEnumMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_14);
            	    lv_enumMembers_5_0=ruleEnumMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enumMembers",
            	      							lv_enumMembers_5_0,
            	      							"ru.iaie.reflex.diagram.Reflex.EnumMember");
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

            otherlv_6=(Token)match(input,47,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEnumAccess().getRightCurlyBracketKeyword_5());
              		
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
    // InternalReflex.g:2119:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalReflex.g:2119:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalReflex.g:2120:2: iv_ruleEnumMember= ruleEnumMember EOF
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
    // InternalReflex.g:2126:1: ruleEnumMember returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2132:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) )
            // InternalReflex.g:2133:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            {
            // InternalReflex.g:2133:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
            // InternalReflex.g:2134:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
            {
            // InternalReflex.g:2134:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalReflex.g:2135:4: (lv_name_0_0= RULE_ID )
            {
            // InternalReflex.g:2135:4: (lv_name_0_0= RULE_ID )
            // InternalReflex.g:2136:5: lv_name_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,51,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEnumMemberAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalReflex.g:2156:3: ( (lv_value_2_0= ruleExpression ) )
            // InternalReflex.g:2157:4: (lv_value_2_0= ruleExpression )
            {
            // InternalReflex.g:2157:4: (lv_value_2_0= ruleExpression )
            // InternalReflex.g:2158:5: lv_value_2_0= ruleExpression
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
    // InternalReflex.g:2179:1: entryRuleInfixOp returns [EObject current=null] : iv_ruleInfixOp= ruleInfixOp EOF ;
    public final EObject entryRuleInfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOp = null;


        try {
            // InternalReflex.g:2179:48: (iv_ruleInfixOp= ruleInfixOp EOF )
            // InternalReflex.g:2180:2: iv_ruleInfixOp= ruleInfixOp EOF
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
    // InternalReflex.g:2186:1: ruleInfixOp returns [EObject current=null] : ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_1_0=null;
        Enumerator lv_op_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2192:2: ( ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:2193:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:2193:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            // InternalReflex.g:2194:3: ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) )
            {
            // InternalReflex.g:2194:3: ( (lv_op_0_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2195:4: (lv_op_0_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2195:4: (lv_op_0_0= ruleInfixPostfixOp )
            // InternalReflex.g:2196:5: lv_op_0_0= ruleInfixPostfixOp
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

            // InternalReflex.g:2213:3: ( (lv_varId_1_0= RULE_ID ) )
            // InternalReflex.g:2214:4: (lv_varId_1_0= RULE_ID )
            {
            // InternalReflex.g:2214:4: (lv_varId_1_0= RULE_ID )
            // InternalReflex.g:2215:5: lv_varId_1_0= RULE_ID
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
    // InternalReflex.g:2235:1: entryRulePostfixOp returns [EObject current=null] : iv_rulePostfixOp= rulePostfixOp EOF ;
    public final EObject entryRulePostfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOp = null;


        try {
            // InternalReflex.g:2235:50: (iv_rulePostfixOp= rulePostfixOp EOF )
            // InternalReflex.g:2236:2: iv_rulePostfixOp= rulePostfixOp EOF
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
    // InternalReflex.g:2242:1: rulePostfixOp returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) ;
    public final EObject rulePostfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Enumerator lv_op_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2248:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) )
            // InternalReflex.g:2249:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            {
            // InternalReflex.g:2249:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            // InternalReflex.g:2250:3: ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) )
            {
            // InternalReflex.g:2250:3: ( (lv_varId_0_0= RULE_ID ) )
            // InternalReflex.g:2251:4: (lv_varId_0_0= RULE_ID )
            {
            // InternalReflex.g:2251:4: (lv_varId_0_0= RULE_ID )
            // InternalReflex.g:2252:5: lv_varId_0_0= RULE_ID
            {
            lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_34); if (state.failed) return current;
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

            // InternalReflex.g:2268:3: ( (lv_op_1_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2269:4: (lv_op_1_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2269:4: (lv_op_1_0= ruleInfixPostfixOp )
            // InternalReflex.g:2270:5: lv_op_1_0= ruleInfixPostfixOp
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
    // InternalReflex.g:2291:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalReflex.g:2291:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalReflex.g:2292:2: iv_ruleFunctionCall= ruleFunctionCall EOF
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
    // InternalReflex.g:2298:1: ruleFunctionCall returns [EObject current=null] : ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalReflex.g:2304:2: ( ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalReflex.g:2305:2: ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalReflex.g:2305:2: ( ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            // InternalReflex.g:2306:3: ( (lv_funcId_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalReflex.g:2306:3: ( (lv_funcId_0_0= RULE_ID ) )
            // InternalReflex.g:2307:4: (lv_funcId_0_0= RULE_ID )
            {
            // InternalReflex.g:2307:4: (lv_funcId_0_0= RULE_ID )
            // InternalReflex.g:2308:5: lv_funcId_0_0= RULE_ID
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

            otherlv_1=(Token)match(input,61,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2328:3: ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID||(LA24_0>=RULE_HEX && LA24_0<=RULE_DECIMAL)||(LA24_0>=RULE_DEC_FLOAT && LA24_0<=RULE_HEX_FLOAT)||LA24_0==61||(LA24_0>=81 && LA24_0<=82)||(LA24_0>=92 && LA24_0<=95)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalReflex.g:2329:4: ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    {
                    // InternalReflex.g:2329:4: ( (lv_args_2_0= ruleExpression ) )
                    // InternalReflex.g:2330:5: (lv_args_2_0= ruleExpression )
                    {
                    // InternalReflex.g:2330:5: (lv_args_2_0= ruleExpression )
                    // InternalReflex.g:2331:6: lv_args_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
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

                    // InternalReflex.g:2348:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==52) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalReflex.g:2349:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,52,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalReflex.g:2353:5: ( (lv_args_4_0= ruleExpression ) )
                    	    // InternalReflex.g:2354:6: (lv_args_4_0= ruleExpression )
                    	    {
                    	    // InternalReflex.g:2354:6: (lv_args_4_0= ruleExpression )
                    	    // InternalReflex.g:2355:7: lv_args_4_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_33);
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
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_3());
              		
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
    // InternalReflex.g:2382:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalReflex.g:2382:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalReflex.g:2383:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalReflex.g:2389:1: rulePrimaryExpression returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) | this_Integer_1= ruleInteger | ( () ruleFloat ) | (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject this_Integer_1 = null;

        EObject lv_expr_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2395:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) | this_Integer_1= ruleInteger | ( () ruleFloat ) | (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' ) ) )
            // InternalReflex.g:2396:2: ( ( (lv_varId_0_0= RULE_ID ) ) | this_Integer_1= ruleInteger | ( () ruleFloat ) | (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            {
            // InternalReflex.g:2396:2: ( ( (lv_varId_0_0= RULE_ID ) ) | this_Integer_1= ruleInteger | ( () ruleFloat ) | (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' ) )
            int alt25=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt25=1;
                }
                break;
            case RULE_HEX:
            case RULE_OCTAL:
            case RULE_DECIMAL:
                {
                alt25=2;
                }
                break;
            case RULE_DEC_FLOAT:
            case RULE_HEX_FLOAT:
                {
                alt25=3;
                }
                break;
            case 61:
                {
                alt25=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalReflex.g:2397:3: ( (lv_varId_0_0= RULE_ID ) )
                    {
                    // InternalReflex.g:2397:3: ( (lv_varId_0_0= RULE_ID ) )
                    // InternalReflex.g:2398:4: (lv_varId_0_0= RULE_ID )
                    {
                    // InternalReflex.g:2398:4: (lv_varId_0_0= RULE_ID )
                    // InternalReflex.g:2399:5: lv_varId_0_0= RULE_ID
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
                    // InternalReflex.g:2416:3: this_Integer_1= ruleInteger
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIntegerParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Integer_1=ruleInteger();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Integer_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:2425:3: ( () ruleFloat )
                    {
                    // InternalReflex.g:2425:3: ( () ruleFloat )
                    // InternalReflex.g:2426:4: () ruleFloat
                    {
                    // InternalReflex.g:2426:4: ()
                    // InternalReflex.g:2427:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFloatParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    ruleFloat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:2442:3: (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    {
                    // InternalReflex.g:2442:3: (otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')' )
                    // InternalReflex.g:2443:4: otherlv_4= '(' ( (lv_expr_5_0= ruleExpression ) ) otherlv_6= ')'
                    {
                    otherlv_4=(Token)match(input,61,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalReflex.g:2447:4: ( (lv_expr_5_0= ruleExpression ) )
                    // InternalReflex.g:2448:5: (lv_expr_5_0= ruleExpression )
                    {
                    // InternalReflex.g:2448:5: (lv_expr_5_0= ruleExpression )
                    // InternalReflex.g:2449:6: lv_expr_5_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getExprExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
                    lv_expr_5_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_5_0,
                      							"ru.iaie.reflex.diagram.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_6=(Token)match(input,62,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
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
    // InternalReflex.g:2475:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalReflex.g:2475:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalReflex.g:2476:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalReflex.g:2482:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) ) ;
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
            // InternalReflex.g:2488:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2489:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2489:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) ) )
            int alt26=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 81:
                case 82:
                    {
                    alt26=3;
                    }
                    break;
                case EOF:
                case RULE_BIT_AND:
                case RULE_BIT_XOR:
                case RULE_BIT_OR:
                case RULE_LOGICAL_AND:
                case RULE_LOGICAL_OR:
                case 47:
                case 49:
                case 52:
                case 62:
                case 92:
                case 93:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                    {
                    alt26=1;
                    }
                    break;
                case 61:
                    {
                    alt26=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_HEX:
            case RULE_OCTAL:
            case RULE_DECIMAL:
            case RULE_DEC_FLOAT:
            case RULE_HEX_FLOAT:
            case 61:
                {
                alt26=1;
                }
                break;
            case 81:
            case 82:
                {
                alt26=4;
                }
                break;
            case 92:
            case 93:
            case 94:
            case 95:
                {
                alt26=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalReflex.g:2490:3: this_PrimaryExpression_0= rulePrimaryExpression
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
                    // InternalReflex.g:2499:3: this_FunctionCall_1= ruleFunctionCall
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
                    // InternalReflex.g:2508:3: this_PostfixOp_2= rulePostfixOp
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
                    // InternalReflex.g:2517:3: this_InfixOp_3= ruleInfixOp
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
                    // InternalReflex.g:2526:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2526:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2527:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_rest_5_0= ruleCastExpression ) )
                    {
                    // InternalReflex.g:2527:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) )
                    // InternalReflex.g:2528:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    {
                    // InternalReflex.g:2528:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    // InternalReflex.g:2529:6: lv_unaryOp_4_0= ruleUnaryOp
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

                    // InternalReflex.g:2546:4: ( (lv_rest_5_0= ruleCastExpression ) )
                    // InternalReflex.g:2547:5: (lv_rest_5_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2547:5: (lv_rest_5_0= ruleCastExpression )
                    // InternalReflex.g:2548:6: lv_rest_5_0= ruleCastExpression
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
    // InternalReflex.g:2570:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalReflex.g:2570:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalReflex.g:2571:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalReflex.g:2577:1: ruleCastExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2583:2: ( (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2584:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2584:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID||(LA27_0>=RULE_HEX && LA27_0<=RULE_DECIMAL)||(LA27_0>=RULE_DEC_FLOAT && LA27_0<=RULE_HEX_FLOAT)||(LA27_0>=81 && LA27_0<=82)||(LA27_0>=92 && LA27_0<=95)) ) {
                alt27=1;
            }
            else if ( (LA27_0==61) ) {
                int LA27_2 = input.LA(2);

                if ( (LA27_2==RULE_ID||(LA27_2>=RULE_HEX && LA27_2<=RULE_DECIMAL)||(LA27_2>=RULE_DEC_FLOAT && LA27_2<=RULE_HEX_FLOAT)||LA27_2==61||(LA27_2>=81 && LA27_2<=82)||(LA27_2>=92 && LA27_2<=95)) ) {
                    alt27=1;
                }
                else if ( ((LA27_2>=RULE_VOID_C_TYPE && LA27_2<=RULE_BOOL_TYPE)||(LA27_2>=107 && LA27_2<=108)) ) {
                    alt27=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // InternalReflex.g:2585:3: this_UnaryExpression_0= ruleUnaryExpression
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
                    // InternalReflex.g:2594:3: (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2594:3: (otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2595:4: otherlv_1= '(' ( (lv_type_2_0= ruleReflexType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:2599:4: ( (lv_type_2_0= ruleReflexType ) )
                    // InternalReflex.g:2600:5: (lv_type_2_0= ruleReflexType )
                    {
                    // InternalReflex.g:2600:5: (lv_type_2_0= ruleReflexType )
                    // InternalReflex.g:2601:6: lv_type_2_0= ruleReflexType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeReflexTypeParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_25);
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

                    otherlv_3=(Token)match(input,62,FOLLOW_36); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalReflex.g:2622:4: ( (lv_right_4_0= ruleCastExpression ) )
                    // InternalReflex.g:2623:5: (lv_right_4_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2623:5: (lv_right_4_0= ruleCastExpression )
                    // InternalReflex.g:2624:6: lv_right_4_0= ruleCastExpression
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
    // InternalReflex.g:2646:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalReflex.g:2646:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalReflex.g:2647:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalReflex.g:2653:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CastExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2659:2: ( (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) )
            // InternalReflex.g:2660:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            {
            // InternalReflex.g:2660:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            // InternalReflex.g:2661:3: this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
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
            // InternalReflex.g:2669:3: ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=104 && LA28_0<=106)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalReflex.g:2670:4: () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) )
            	    {
            	    // InternalReflex.g:2670:4: ()
            	    // InternalReflex.g:2671:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2677:4: ( (lv_mulOp_2_0= ruleMultiplicativeOp ) )
            	    // InternalReflex.g:2678:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    {
            	    // InternalReflex.g:2678:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    // InternalReflex.g:2679:6: lv_mulOp_2_0= ruleMultiplicativeOp
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

            	    // InternalReflex.g:2696:4: ( (lv_right_3_0= ruleCastExpression ) )
            	    // InternalReflex.g:2697:5: (lv_right_3_0= ruleCastExpression )
            	    {
            	    // InternalReflex.g:2697:5: (lv_right_3_0= ruleCastExpression )
            	    // InternalReflex.g:2698:6: lv_right_3_0= ruleCastExpression
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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalReflex.g:2720:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalReflex.g:2720:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalReflex.g:2721:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalReflex.g:2727:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_rightt_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2733:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalReflex.g:2734:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalReflex.g:2734:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )* )
            // InternalReflex.g:2735:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )*
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
            // InternalReflex.g:2743:3: ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==92) ) {
                    alt29=1;
                }
                else if ( (LA29_0==93) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalReflex.g:2744:4: () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_rightt_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalReflex.g:2744:4: ()
            	    // InternalReflex.g:2745:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2751:4: ( (lv_addOp_2_0= ruleAdditiveOp ) )
            	    // InternalReflex.g:2752:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    {
            	    // InternalReflex.g:2752:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    // InternalReflex.g:2753:6: lv_addOp_2_0= ruleAdditiveOp
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

            	    // InternalReflex.g:2770:4: ( (lv_rightt_3_0= ruleAdditiveExpression ) )
            	    // InternalReflex.g:2771:5: (lv_rightt_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalReflex.g:2771:5: (lv_rightt_3_0= ruleAdditiveExpression )
            	    // InternalReflex.g:2772:6: lv_rightt_3_0= ruleAdditiveExpression
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalReflex.g:2794:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalReflex.g:2794:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalReflex.g:2795:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalReflex.g:2801:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_shiftOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2807:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) )
            // InternalReflex.g:2808:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalReflex.g:2808:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            // InternalReflex.g:2809:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
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
            // InternalReflex.g:2817:3: ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==102) ) {
                    alt30=1;
                }
                else if ( (LA30_0==103) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalReflex.g:2818:4: () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalReflex.g:2818:4: ()
            	    // InternalReflex.g:2819:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2825:4: ( (lv_shiftOp_2_0= ruleShiftOp ) )
            	    // InternalReflex.g:2826:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    {
            	    // InternalReflex.g:2826:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    // InternalReflex.g:2827:6: lv_shiftOp_2_0= ruleShiftOp
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

            	    // InternalReflex.g:2844:4: ( (lv_right_3_0= ruleShiftExpression ) )
            	    // InternalReflex.g:2845:5: (lv_right_3_0= ruleShiftExpression )
            	    {
            	    // InternalReflex.g:2845:5: (lv_right_3_0= ruleShiftExpression )
            	    // InternalReflex.g:2846:6: lv_right_3_0= ruleShiftExpression
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
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleCompareExpression"
    // InternalReflex.g:2868:1: entryRuleCompareExpression returns [EObject current=null] : iv_ruleCompareExpression= ruleCompareExpression EOF ;
    public final EObject entryRuleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpression = null;


        try {
            // InternalReflex.g:2868:58: (iv_ruleCompareExpression= ruleCompareExpression EOF )
            // InternalReflex.g:2869:2: iv_ruleCompareExpression= ruleCompareExpression EOF
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
    // InternalReflex.g:2875:1: ruleCompareExpression returns [EObject current=null] : (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* ) ;
    public final EObject ruleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ShiftExpression_0 = null;

        Enumerator lv_cmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2881:2: ( (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* ) )
            // InternalReflex.g:2882:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* )
            {
            // InternalReflex.g:2882:2: (this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )* )
            // InternalReflex.g:2883:3: this_ShiftExpression_0= ruleShiftExpression ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )*
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
            // InternalReflex.g:2891:3: ( () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                switch ( input.LA(1) ) {
                case 96:
                    {
                    alt31=1;
                    }
                    break;
                case 97:
                    {
                    alt31=1;
                    }
                    break;
                case 98:
                    {
                    alt31=1;
                    }
                    break;
                case 99:
                    {
                    alt31=1;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // InternalReflex.g:2892:4: () ( (lv_cmpOp_2_0= ruleCompareOp ) ) ( (lv_right_3_0= ruleCompareExpression ) )
            	    {
            	    // InternalReflex.g:2892:4: ()
            	    // InternalReflex.g:2893:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getCompareExpressionAccess().getCompareExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2899:4: ( (lv_cmpOp_2_0= ruleCompareOp ) )
            	    // InternalReflex.g:2900:5: (lv_cmpOp_2_0= ruleCompareOp )
            	    {
            	    // InternalReflex.g:2900:5: (lv_cmpOp_2_0= ruleCompareOp )
            	    // InternalReflex.g:2901:6: lv_cmpOp_2_0= ruleCompareOp
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

            	    // InternalReflex.g:2918:4: ( (lv_right_3_0= ruleCompareExpression ) )
            	    // InternalReflex.g:2919:5: (lv_right_3_0= ruleCompareExpression )
            	    {
            	    // InternalReflex.g:2919:5: (lv_right_3_0= ruleCompareExpression )
            	    // InternalReflex.g:2920:6: lv_right_3_0= ruleCompareExpression
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
    // $ANTLR end "ruleCompareExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalReflex.g:2942:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalReflex.g:2942:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalReflex.g:2943:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalReflex.g:2949:1: ruleEqualityExpression returns [EObject current=null] : (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpression_0 = null;

        Enumerator lv_eqCmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2955:2: ( (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalReflex.g:2956:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalReflex.g:2956:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalReflex.g:2957:3: this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
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
            // InternalReflex.g:2965:3: ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==100) ) {
                    alt32=1;
                }
                else if ( (LA32_0==101) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalReflex.g:2966:4: () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalReflex.g:2966:4: ()
            	    // InternalReflex.g:2967:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2973:4: ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) )
            	    // InternalReflex.g:2974:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    {
            	    // InternalReflex.g:2974:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    // InternalReflex.g:2975:6: lv_eqCmpOp_2_0= ruleCompareEqOp
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

            	    // InternalReflex.g:2992:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalReflex.g:2993:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalReflex.g:2993:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalReflex.g:2994:6: lv_right_3_0= ruleEqualityExpression
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleBitAndExpression"
    // InternalReflex.g:3016:1: entryRuleBitAndExpression returns [EObject current=null] : iv_ruleBitAndExpression= ruleBitAndExpression EOF ;
    public final EObject entryRuleBitAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitAndExpression = null;


        try {
            // InternalReflex.g:3016:57: (iv_ruleBitAndExpression= ruleBitAndExpression EOF )
            // InternalReflex.g:3017:2: iv_ruleBitAndExpression= ruleBitAndExpression EOF
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
    // InternalReflex.g:3023:1: ruleBitAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) ;
    public final EObject ruleBitAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_AND_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3029:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) )
            // InternalReflex.g:3030:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            {
            // InternalReflex.g:3030:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            // InternalReflex.g:3031:3: this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
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
            // InternalReflex.g:3039:3: ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_BIT_AND) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalReflex.g:3040:4: () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) )
            	    {
            	    // InternalReflex.g:3040:4: ()
            	    // InternalReflex.g:3041:5: 
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
            	    // InternalReflex.g:3051:4: ( (lv_right_3_0= ruleBitAndExpression ) )
            	    // InternalReflex.g:3052:5: (lv_right_3_0= ruleBitAndExpression )
            	    {
            	    // InternalReflex.g:3052:5: (lv_right_3_0= ruleBitAndExpression )
            	    // InternalReflex.g:3053:6: lv_right_3_0= ruleBitAndExpression
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
    // $ANTLR end "ruleBitAndExpression"


    // $ANTLR start "entryRuleBitXorExpression"
    // InternalReflex.g:3075:1: entryRuleBitXorExpression returns [EObject current=null] : iv_ruleBitXorExpression= ruleBitXorExpression EOF ;
    public final EObject entryRuleBitXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitXorExpression = null;


        try {
            // InternalReflex.g:3075:57: (iv_ruleBitXorExpression= ruleBitXorExpression EOF )
            // InternalReflex.g:3076:2: iv_ruleBitXorExpression= ruleBitXorExpression EOF
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
    // InternalReflex.g:3082:1: ruleBitXorExpression returns [EObject current=null] : (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) ;
    public final EObject ruleBitXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_XOR_2=null;
        EObject this_BitAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3088:2: ( (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) )
            // InternalReflex.g:3089:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            {
            // InternalReflex.g:3089:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            // InternalReflex.g:3090:3: this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
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
            // InternalReflex.g:3098:3: ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==RULE_BIT_XOR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalReflex.g:3099:4: () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) )
            	    {
            	    // InternalReflex.g:3099:4: ()
            	    // InternalReflex.g:3100:5: 
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
            	    // InternalReflex.g:3110:4: ( (lv_right_3_0= ruleBitXorExpression ) )
            	    // InternalReflex.g:3111:5: (lv_right_3_0= ruleBitXorExpression )
            	    {
            	    // InternalReflex.g:3111:5: (lv_right_3_0= ruleBitXorExpression )
            	    // InternalReflex.g:3112:6: lv_right_3_0= ruleBitXorExpression
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
    // $ANTLR end "ruleBitXorExpression"


    // $ANTLR start "entryRuleBitOrExpression"
    // InternalReflex.g:3134:1: entryRuleBitOrExpression returns [EObject current=null] : iv_ruleBitOrExpression= ruleBitOrExpression EOF ;
    public final EObject entryRuleBitOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitOrExpression = null;


        try {
            // InternalReflex.g:3134:56: (iv_ruleBitOrExpression= ruleBitOrExpression EOF )
            // InternalReflex.g:3135:2: iv_ruleBitOrExpression= ruleBitOrExpression EOF
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
    // InternalReflex.g:3141:1: ruleBitOrExpression returns [EObject current=null] : (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) ;
    public final EObject ruleBitOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_OR_2=null;
        EObject this_BitXorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3147:2: ( (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) )
            // InternalReflex.g:3148:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            {
            // InternalReflex.g:3148:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            // InternalReflex.g:3149:3: this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
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
            // InternalReflex.g:3157:3: ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==RULE_BIT_OR) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalReflex.g:3158:4: () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) )
            	    {
            	    // InternalReflex.g:3158:4: ()
            	    // InternalReflex.g:3159:5: 
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
            	    // InternalReflex.g:3169:4: ( (lv_right_3_0= ruleBitOrExpression ) )
            	    // InternalReflex.g:3170:5: (lv_right_3_0= ruleBitOrExpression )
            	    {
            	    // InternalReflex.g:3170:5: (lv_right_3_0= ruleBitOrExpression )
            	    // InternalReflex.g:3171:6: lv_right_3_0= ruleBitOrExpression
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
    // $ANTLR end "ruleBitOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalReflex.g:3193:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalReflex.g:3193:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalReflex.g:3194:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalReflex.g:3200:1: ruleLogicalAndExpression returns [EObject current=null] : (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_AND_2=null;
        EObject this_BitOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3206:2: ( (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalReflex.g:3207:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalReflex.g:3207:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalReflex.g:3208:3: this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
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
            // InternalReflex.g:3216:3: ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_LOGICAL_AND) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalReflex.g:3217:4: () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalReflex.g:3217:4: ()
            	    // InternalReflex.g:3218:5: 
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
            	    // InternalReflex.g:3228:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    // InternalReflex.g:3229:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalReflex.g:3229:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    // InternalReflex.g:3230:6: lv_right_3_0= ruleLogicalAndExpression
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
            	    break loop36;
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
    // InternalReflex.g:3252:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalReflex.g:3252:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalReflex.g:3253:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalReflex.g:3259:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_OR_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3265:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) )
            // InternalReflex.g:3266:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            {
            // InternalReflex.g:3266:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            // InternalReflex.g:3267:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
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
            // InternalReflex.g:3275:3: ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_LOGICAL_OR) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalReflex.g:3276:4: () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    {
            	    // InternalReflex.g:3276:4: ()
            	    // InternalReflex.g:3277:5: 
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
            	    // InternalReflex.g:3287:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    // InternalReflex.g:3288:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    {
            	    // InternalReflex.g:3288:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    // InternalReflex.g:3289:6: lv_right_3_0= ruleLogicalOrExpression
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
            	    break loop37;
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
    // InternalReflex.g:3311:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalReflex.g:3311:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalReflex.g:3312:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalReflex.g:3318:1: ruleAssignmentExpression returns [EObject current=null] : (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_assignVar_1_0=null;
        EObject this_LogicalOrExpression_0 = null;

        Enumerator lv_assignOp_2_0 = null;

        EObject lv_expr_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3324:2: ( (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) ) )
            // InternalReflex.g:3325:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) )
            {
            // InternalReflex.g:3325:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression | ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==EOF||(LA38_1>=RULE_BIT_AND && LA38_1<=RULE_LOGICAL_OR)||LA38_1==47||LA38_1==49||LA38_1==52||(LA38_1>=61 && LA38_1<=62)||(LA38_1>=81 && LA38_1<=82)||(LA38_1>=92 && LA38_1<=93)||(LA38_1>=96 && LA38_1<=106)) ) {
                    alt38=1;
                }
                else if ( (LA38_1==51||(LA38_1>=83 && LA38_1<=91)) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
            }
            else if ( ((LA38_0>=RULE_HEX && LA38_0<=RULE_DECIMAL)||(LA38_0>=RULE_DEC_FLOAT && LA38_0<=RULE_HEX_FLOAT)||LA38_0==61||(LA38_0>=81 && LA38_0<=82)||(LA38_0>=92 && LA38_0<=95)) ) {
                alt38=1;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalReflex.g:3326:3: this_LogicalOrExpression_0= ruleLogicalOrExpression
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
                    // InternalReflex.g:3335:3: ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) )
                    {
                    // InternalReflex.g:3335:3: ( ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) ) )
                    // InternalReflex.g:3336:4: ( (lv_assignVar_1_0= RULE_ID ) ) ( (lv_assignOp_2_0= ruleAssignOperator ) ) ( (lv_expr_3_0= ruleLogicalOrExpression ) )
                    {
                    // InternalReflex.g:3336:4: ( (lv_assignVar_1_0= RULE_ID ) )
                    // InternalReflex.g:3337:5: (lv_assignVar_1_0= RULE_ID )
                    {
                    // InternalReflex.g:3337:5: (lv_assignVar_1_0= RULE_ID )
                    // InternalReflex.g:3338:6: lv_assignVar_1_0= RULE_ID
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

                    // InternalReflex.g:3354:4: ( (lv_assignOp_2_0= ruleAssignOperator ) )
                    // InternalReflex.g:3355:5: (lv_assignOp_2_0= ruleAssignOperator )
                    {
                    // InternalReflex.g:3355:5: (lv_assignOp_2_0= ruleAssignOperator )
                    // InternalReflex.g:3356:6: lv_assignOp_2_0= ruleAssignOperator
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

                    // InternalReflex.g:3373:4: ( (lv_expr_3_0= ruleLogicalOrExpression ) )
                    // InternalReflex.g:3374:5: (lv_expr_3_0= ruleLogicalOrExpression )
                    {
                    // InternalReflex.g:3374:5: (lv_expr_3_0= ruleLogicalOrExpression )
                    // InternalReflex.g:3375:6: lv_expr_3_0= ruleLogicalOrExpression
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
    // InternalReflex.g:3397:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalReflex.g:3397:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalReflex.g:3398:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalReflex.g:3404:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3410:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalReflex.g:3411:2: this_AssignmentExpression_0= ruleAssignmentExpression
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
    // InternalReflex.g:3422:1: entryRuleCType returns [EObject current=null] : iv_ruleCType= ruleCType EOF ;
    public final EObject entryRuleCType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCType = null;


        try {
            // InternalReflex.g:3422:46: (iv_ruleCType= ruleCType EOF )
            // InternalReflex.g:3423:2: iv_ruleCType= ruleCType EOF
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
    // InternalReflex.g:3429:1: ruleCType returns [EObject current=null] : ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) ;
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
            // InternalReflex.g:3435:2: ( ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) ) )
            // InternalReflex.g:3436:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            {
            // InternalReflex.g:3436:2: ( ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE ) | ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE ) | ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE ) | ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) ) )
            int alt41=4;
            switch ( input.LA(1) ) {
            case RULE_VOID_C_TYPE:
                {
                alt41=1;
                }
                break;
            case RULE_FLOAT_C_TYPE:
                {
                alt41=2;
                }
                break;
            case RULE_DOUBLE_C_TYPE:
                {
                alt41=3;
                }
                break;
            case RULE_SHORT_C_TYPE:
            case RULE_INT_C_TYPE:
            case RULE_LONG_C_TYPE:
            case 107:
            case 108:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalReflex.g:3437:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    {
                    // InternalReflex.g:3437:3: ( () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE )
                    // InternalReflex.g:3438:4: () this_VOID_C_TYPE_1= RULE_VOID_C_TYPE
                    {
                    // InternalReflex.g:3438:4: ()
                    // InternalReflex.g:3439:5: 
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
                    // InternalReflex.g:3451:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    {
                    // InternalReflex.g:3451:3: ( () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE )
                    // InternalReflex.g:3452:4: () this_FLOAT_C_TYPE_3= RULE_FLOAT_C_TYPE
                    {
                    // InternalReflex.g:3452:4: ()
                    // InternalReflex.g:3453:5: 
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
                    // InternalReflex.g:3465:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    {
                    // InternalReflex.g:3465:3: ( () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE )
                    // InternalReflex.g:3466:4: () this_DOUBLE_C_TYPE_5= RULE_DOUBLE_C_TYPE
                    {
                    // InternalReflex.g:3466:4: ()
                    // InternalReflex.g:3467:5: 
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
                    // InternalReflex.g:3479:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    {
                    // InternalReflex.g:3479:3: ( () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE ) )
                    // InternalReflex.g:3480:4: () ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )? (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    {
                    // InternalReflex.g:3480:4: ()
                    // InternalReflex.g:3481:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getCTypeAccess().getCTypeAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3487:4: ( (lv_signSpec_7_0= ruleCTypeSignSpec ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=107 && LA39_0<=108)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // InternalReflex.g:3488:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            {
                            // InternalReflex.g:3488:5: (lv_signSpec_7_0= ruleCTypeSignSpec )
                            // InternalReflex.g:3489:6: lv_signSpec_7_0= ruleCTypeSignSpec
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

                    // InternalReflex.g:3506:4: (this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE | this_INT_C_TYPE_9= RULE_INT_C_TYPE | this_LONG_C_TYPE_10= RULE_LONG_C_TYPE )
                    int alt40=3;
                    switch ( input.LA(1) ) {
                    case RULE_SHORT_C_TYPE:
                        {
                        alt40=1;
                        }
                        break;
                    case RULE_INT_C_TYPE:
                        {
                        alt40=2;
                        }
                        break;
                    case RULE_LONG_C_TYPE:
                        {
                        alt40=3;
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
                            // InternalReflex.g:3507:5: this_SHORT_C_TYPE_8= RULE_SHORT_C_TYPE
                            {
                            this_SHORT_C_TYPE_8=(Token)match(input,RULE_SHORT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_SHORT_C_TYPE_8, grammarAccess.getCTypeAccess().getSHORT_C_TYPETerminalRuleCall_3_2_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalReflex.g:3512:5: this_INT_C_TYPE_9= RULE_INT_C_TYPE
                            {
                            this_INT_C_TYPE_9=(Token)match(input,RULE_INT_C_TYPE,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_INT_C_TYPE_9, grammarAccess.getCTypeAccess().getINT_C_TYPETerminalRuleCall_3_2_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalReflex.g:3517:5: this_LONG_C_TYPE_10= RULE_LONG_C_TYPE
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
    // InternalReflex.g:3527:1: entryRuleIntegerType returns [String current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final String entryRuleIntegerType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIntegerType = null;


        try {
            // InternalReflex.g:3527:51: (iv_ruleIntegerType= ruleIntegerType EOF )
            // InternalReflex.g:3528:2: iv_ruleIntegerType= ruleIntegerType EOF
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
    // InternalReflex.g:3534:1: ruleIntegerType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) ;
    public final AntlrDatatypeRuleToken ruleIntegerType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BOOL_TYPE_0=null;
        Token this_INT_C_TYPE_1=null;
        Token this_SHORT_C_TYPE_2=null;
        Token this_LONG_C_TYPE_3=null;


        	enterRule();

        try {
            // InternalReflex.g:3540:2: ( (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE ) )
            // InternalReflex.g:3541:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            {
            // InternalReflex.g:3541:2: (this_BOOL_TYPE_0= RULE_BOOL_TYPE | this_INT_C_TYPE_1= RULE_INT_C_TYPE | this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE | this_LONG_C_TYPE_3= RULE_LONG_C_TYPE )
            int alt42=4;
            switch ( input.LA(1) ) {
            case RULE_BOOL_TYPE:
                {
                alt42=1;
                }
                break;
            case RULE_INT_C_TYPE:
                {
                alt42=2;
                }
                break;
            case RULE_SHORT_C_TYPE:
                {
                alt42=3;
                }
                break;
            case RULE_LONG_C_TYPE:
                {
                alt42=4;
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
                    // InternalReflex.g:3542:3: this_BOOL_TYPE_0= RULE_BOOL_TYPE
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
                    // InternalReflex.g:3550:3: this_INT_C_TYPE_1= RULE_INT_C_TYPE
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
                    // InternalReflex.g:3558:3: this_SHORT_C_TYPE_2= RULE_SHORT_C_TYPE
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
                    // InternalReflex.g:3566:3: this_LONG_C_TYPE_3= RULE_LONG_C_TYPE
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
    // InternalReflex.g:3577:1: entryRuleReflexType returns [EObject current=null] : iv_ruleReflexType= ruleReflexType EOF ;
    public final EObject entryRuleReflexType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReflexType = null;


        try {
            // InternalReflex.g:3577:51: (iv_ruleReflexType= ruleReflexType EOF )
            // InternalReflex.g:3578:2: iv_ruleReflexType= ruleReflexType EOF
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
    // InternalReflex.g:3584:1: ruleReflexType returns [EObject current=null] : (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) ;
    public final EObject ruleReflexType() throws RecognitionException {
        EObject current = null;

        Token this_BOOL_TYPE_2=null;
        EObject this_CType_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3590:2: ( (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) ) )
            // InternalReflex.g:3591:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            {
            // InternalReflex.g:3591:2: (this_CType_0= ruleCType | ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( ((LA43_0>=RULE_VOID_C_TYPE && LA43_0<=RULE_LONG_C_TYPE)||(LA43_0>=107 && LA43_0<=108)) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_BOOL_TYPE) ) {
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
                    // InternalReflex.g:3592:3: this_CType_0= ruleCType
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
                    // InternalReflex.g:3601:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    {
                    // InternalReflex.g:3601:3: ( () this_BOOL_TYPE_2= RULE_BOOL_TYPE )
                    // InternalReflex.g:3602:4: () this_BOOL_TYPE_2= RULE_BOOL_TYPE
                    {
                    // InternalReflex.g:3602:4: ()
                    // InternalReflex.g:3603:5: 
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
    // InternalReflex.g:3618:1: entryRuleInteger returns [EObject current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final EObject entryRuleInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteger = null;


        try {
            // InternalReflex.g:3618:48: (iv_ruleInteger= ruleInteger EOF )
            // InternalReflex.g:3619:2: iv_ruleInteger= ruleInteger EOF
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
    // InternalReflex.g:3625:1: ruleInteger returns [EObject current=null] : ( ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? ) ;
    public final EObject ruleInteger() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_1=null;
        Token lv_value_0_2=null;
        Token lv_value_0_3=null;
        Token lv_qualfier_1_1=null;
        Token lv_qualfier_1_2=null;


        	enterRule();

        try {
            // InternalReflex.g:3631:2: ( ( ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? ) )
            // InternalReflex.g:3632:2: ( ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? )
            {
            // InternalReflex.g:3632:2: ( ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )? )
            // InternalReflex.g:3633:3: ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) ) ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )?
            {
            // InternalReflex.g:3633:3: ( ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) ) )
            // InternalReflex.g:3634:4: ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) )
            {
            // InternalReflex.g:3634:4: ( (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL ) )
            // InternalReflex.g:3635:5: (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL )
            {
            // InternalReflex.g:3635:5: (lv_value_0_1= RULE_HEX | lv_value_0_2= RULE_OCTAL | lv_value_0_3= RULE_DECIMAL )
            int alt44=3;
            switch ( input.LA(1) ) {
            case RULE_HEX:
                {
                alt44=1;
                }
                break;
            case RULE_OCTAL:
                {
                alt44=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt44=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalReflex.g:3636:6: lv_value_0_1= RULE_HEX
                    {
                    lv_value_0_1=(Token)match(input,RULE_HEX,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_1, grammarAccess.getIntegerAccess().getValueHEXTerminalRuleCall_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_1,
                      							"ru.iaie.reflex.diagram.Reflex.HEX");
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3651:6: lv_value_0_2= RULE_OCTAL
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
                    // InternalReflex.g:3666:6: lv_value_0_3= RULE_DECIMAL
                    {
                    lv_value_0_3=(Token)match(input,RULE_DECIMAL,FOLLOW_50); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_0_3, grammarAccess.getIntegerAccess().getValueDECIMALTerminalRuleCall_0_0_2());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getIntegerRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_0_3,
                      							"ru.iaie.reflex.diagram.Reflex.DECIMAL");
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalReflex.g:3683:3: ( ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=RULE_LONG && LA46_0<=RULE_UNSIGNED)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalReflex.g:3684:4: ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) )
                    {
                    // InternalReflex.g:3684:4: ( (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED ) )
                    // InternalReflex.g:3685:5: (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED )
                    {
                    // InternalReflex.g:3685:5: (lv_qualfier_1_1= RULE_LONG | lv_qualfier_1_2= RULE_UNSIGNED )
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==RULE_LONG) ) {
                        alt45=1;
                    }
                    else if ( (LA45_0==RULE_UNSIGNED) ) {
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
                            // InternalReflex.g:3686:6: lv_qualfier_1_1= RULE_LONG
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
                            // InternalReflex.g:3701:6: lv_qualfier_1_2= RULE_UNSIGNED
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


    // $ANTLR start "entryRuleFloat"
    // InternalReflex.g:3722:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // InternalReflex.g:3722:45: (iv_ruleFloat= ruleFloat EOF )
            // InternalReflex.g:3723:2: iv_ruleFloat= ruleFloat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFloatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFloat=ruleFloat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFloat.getText(); 
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
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // InternalReflex.g:3729:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_DEC_FLOAT_0= RULE_DEC_FLOAT | this_HEX_FLOAT_1= RULE_HEX_FLOAT ) ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_DEC_FLOAT_0=null;
        Token this_HEX_FLOAT_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3735:2: ( (this_DEC_FLOAT_0= RULE_DEC_FLOAT | this_HEX_FLOAT_1= RULE_HEX_FLOAT ) )
            // InternalReflex.g:3736:2: (this_DEC_FLOAT_0= RULE_DEC_FLOAT | this_HEX_FLOAT_1= RULE_HEX_FLOAT )
            {
            // InternalReflex.g:3736:2: (this_DEC_FLOAT_0= RULE_DEC_FLOAT | this_HEX_FLOAT_1= RULE_HEX_FLOAT )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_DEC_FLOAT) ) {
                alt47=1;
            }
            else if ( (LA47_0==RULE_HEX_FLOAT) ) {
                alt47=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalReflex.g:3737:3: this_DEC_FLOAT_0= RULE_DEC_FLOAT
                    {
                    this_DEC_FLOAT_0=(Token)match(input,RULE_DEC_FLOAT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_DEC_FLOAT_0);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_DEC_FLOAT_0, grammarAccess.getFloatAccess().getDEC_FLOATTerminalRuleCall_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3745:3: this_HEX_FLOAT_1= RULE_HEX_FLOAT
                    {
                    this_HEX_FLOAT_1=(Token)match(input,RULE_HEX_FLOAT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_HEX_FLOAT_1);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_HEX_FLOAT_1, grammarAccess.getFloatAccess().getHEX_FLOATTerminalRuleCall_1());
                      		
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
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleTime"
    // InternalReflex.g:3756:1: entryRuleTime returns [EObject current=null] : iv_ruleTime= ruleTime EOF ;
    public final EObject entryRuleTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTime = null;


        try {
            // InternalReflex.g:3756:45: (iv_ruleTime= ruleTime EOF )
            // InternalReflex.g:3757:2: iv_ruleTime= ruleTime EOF
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
    // InternalReflex.g:3763:1: ruleTime returns [EObject current=null] : ( () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )? ) ;
    public final EObject ruleTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_isDay_3_0=null;
        Token lv_days_4_0=null;
        Token lv_isHour_5_0=null;
        Token lv_hours_6_0=null;


        	enterRule();

        try {
            // InternalReflex.g:3769:2: ( ( () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )? ) )
            // InternalReflex.g:3770:2: ( () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )? )
            {
            // InternalReflex.g:3770:2: ( () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )? )
            // InternalReflex.g:3771:3: () (otherlv_1= '0t' | otherlv_2= '0T' ) ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )? ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )?
            {
            // InternalReflex.g:3771:3: ()
            // InternalReflex.g:3772:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTimeAccess().getTimeAction_0(),
              					current);
              			
            }

            }

            // InternalReflex.g:3778:3: (otherlv_1= '0t' | otherlv_2= '0T' )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==77) ) {
                alt48=1;
            }
            else if ( (LA48_0==78) ) {
                alt48=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalReflex.g:3779:4: otherlv_1= '0t'
                    {
                    otherlv_1=(Token)match(input,77,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTimeAccess().getTKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3784:4: otherlv_2= '0T'
                    {
                    otherlv_2=(Token)match(input,78,FOLLOW_51); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getTimeAccess().getTKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:3789:3: ( ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_DAY) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalReflex.g:3790:4: ( (lv_isDay_3_0= RULE_DAY ) ) ( (lv_days_4_0= RULE_DECIMAL ) )
                    {
                    // InternalReflex.g:3790:4: ( (lv_isDay_3_0= RULE_DAY ) )
                    // InternalReflex.g:3791:5: (lv_isDay_3_0= RULE_DAY )
                    {
                    // InternalReflex.g:3791:5: (lv_isDay_3_0= RULE_DAY )
                    // InternalReflex.g:3792:6: lv_isDay_3_0= RULE_DAY
                    {
                    lv_isDay_3_0=(Token)match(input,RULE_DAY,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isDay_3_0, grammarAccess.getTimeAccess().getIsDayDAYTerminalRuleCall_2_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"isDay",
                      							true,
                      							"ru.iaie.reflex.diagram.Reflex.DAY");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3808:4: ( (lv_days_4_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3809:5: (lv_days_4_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3809:5: (lv_days_4_0= RULE_DECIMAL )
                    // InternalReflex.g:3810:6: lv_days_4_0= RULE_DECIMAL
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

            // InternalReflex.g:3827:3: ( ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_HOUR) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalReflex.g:3828:4: ( (lv_isHour_5_0= RULE_HOUR ) ) ( (lv_hours_6_0= RULE_DECIMAL ) )
                    {
                    // InternalReflex.g:3828:4: ( (lv_isHour_5_0= RULE_HOUR ) )
                    // InternalReflex.g:3829:5: (lv_isHour_5_0= RULE_HOUR )
                    {
                    // InternalReflex.g:3829:5: (lv_isHour_5_0= RULE_HOUR )
                    // InternalReflex.g:3830:6: lv_isHour_5_0= RULE_HOUR
                    {
                    lv_isHour_5_0=(Token)match(input,RULE_HOUR,FOLLOW_52); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isHour_5_0, grammarAccess.getTimeAccess().getIsHourHOURTerminalRuleCall_3_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTimeRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"isHour",
                      							true,
                      							"ru.iaie.reflex.diagram.Reflex.HOUR");
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3846:4: ( (lv_hours_6_0= RULE_DECIMAL ) )
                    // InternalReflex.g:3847:5: (lv_hours_6_0= RULE_DECIMAL )
                    {
                    // InternalReflex.g:3847:5: (lv_hours_6_0= RULE_DECIMAL )
                    // InternalReflex.g:3848:6: lv_hours_6_0= RULE_DECIMAL
                    {
                    lv_hours_6_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:3869:1: ruleRegisterType returns [Enumerator current=null] : ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) ;
    public final Enumerator ruleRegisterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3875:2: ( ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) )
            // InternalReflex.g:3876:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            {
            // InternalReflex.g:3876:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==79) ) {
                alt51=1;
            }
            else if ( (LA51_0==80) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalReflex.g:3877:3: (enumLiteral_0= 'input' )
                    {
                    // InternalReflex.g:3877:3: (enumLiteral_0= 'input' )
                    // InternalReflex.g:3878:4: enumLiteral_0= 'input'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3885:3: (enumLiteral_1= 'output' )
                    {
                    // InternalReflex.g:3885:3: (enumLiteral_1= 'output' )
                    // InternalReflex.g:3886:4: enumLiteral_1= 'output'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:3896:1: ruleInfixPostfixOp returns [Enumerator current=null] : ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) ;
    public final Enumerator ruleInfixPostfixOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3902:2: ( ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) )
            // InternalReflex.g:3903:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            {
            // InternalReflex.g:3903:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==81) ) {
                alt52=1;
            }
            else if ( (LA52_0==82) ) {
                alt52=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalReflex.g:3904:3: (enumLiteral_0= '++' )
                    {
                    // InternalReflex.g:3904:3: (enumLiteral_0= '++' )
                    // InternalReflex.g:3905:4: enumLiteral_0= '++'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3912:3: (enumLiteral_1= '--' )
                    {
                    // InternalReflex.g:3912:3: (enumLiteral_1= '--' )
                    // InternalReflex.g:3913:4: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:3923:1: ruleAssignOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) ;
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
            // InternalReflex.g:3929:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) )
            // InternalReflex.g:3930:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            {
            // InternalReflex.g:3930:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            int alt53=10;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt53=1;
                }
                break;
            case 83:
                {
                alt53=2;
                }
                break;
            case 84:
                {
                alt53=3;
                }
                break;
            case 85:
                {
                alt53=4;
                }
                break;
            case 86:
                {
                alt53=5;
                }
                break;
            case 87:
                {
                alt53=6;
                }
                break;
            case 88:
                {
                alt53=7;
                }
                break;
            case 89:
                {
                alt53=8;
                }
                break;
            case 90:
                {
                alt53=9;
                }
                break;
            case 91:
                {
                alt53=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalReflex.g:3931:3: (enumLiteral_0= '=' )
                    {
                    // InternalReflex.g:3931:3: (enumLiteral_0= '=' )
                    // InternalReflex.g:3932:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3939:3: (enumLiteral_1= '*=' )
                    {
                    // InternalReflex.g:3939:3: (enumLiteral_1= '*=' )
                    // InternalReflex.g:3940:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:3947:3: (enumLiteral_2= '/=' )
                    {
                    // InternalReflex.g:3947:3: (enumLiteral_2= '/=' )
                    // InternalReflex.g:3948:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:3955:3: (enumLiteral_3= '+=' )
                    {
                    // InternalReflex.g:3955:3: (enumLiteral_3= '+=' )
                    // InternalReflex.g:3956:4: enumLiteral_3= '+='
                    {
                    enumLiteral_3=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:3963:3: (enumLiteral_4= '-=' )
                    {
                    // InternalReflex.g:3963:3: (enumLiteral_4= '-=' )
                    // InternalReflex.g:3964:4: enumLiteral_4= '-='
                    {
                    enumLiteral_4=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:3971:3: (enumLiteral_5= '<<=' )
                    {
                    // InternalReflex.g:3971:3: (enumLiteral_5= '<<=' )
                    // InternalReflex.g:3972:4: enumLiteral_5= '<<='
                    {
                    enumLiteral_5=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:3979:3: (enumLiteral_6= '>>=' )
                    {
                    // InternalReflex.g:3979:3: (enumLiteral_6= '>>=' )
                    // InternalReflex.g:3980:4: enumLiteral_6= '>>='
                    {
                    enumLiteral_6=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:3987:3: (enumLiteral_7= '&=' )
                    {
                    // InternalReflex.g:3987:3: (enumLiteral_7= '&=' )
                    // InternalReflex.g:3988:4: enumLiteral_7= '&='
                    {
                    enumLiteral_7=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:3995:3: (enumLiteral_8= '^=' )
                    {
                    // InternalReflex.g:3995:3: (enumLiteral_8= '^=' )
                    // InternalReflex.g:3996:4: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:4003:3: (enumLiteral_9= '|=' )
                    {
                    // InternalReflex.g:4003:3: (enumLiteral_9= '|=' )
                    // InternalReflex.g:4004:4: enumLiteral_9= '|='
                    {
                    enumLiteral_9=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4014:1: ruleUnaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) ;
    public final Enumerator ruleUnaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4020:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) )
            // InternalReflex.g:4021:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            {
            // InternalReflex.g:4021:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            int alt54=4;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt54=1;
                }
                break;
            case 93:
                {
                alt54=2;
                }
                break;
            case 94:
                {
                alt54=3;
                }
                break;
            case 95:
                {
                alt54=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalReflex.g:4022:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4022:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4023:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4030:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4030:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4031:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4038:3: (enumLiteral_2= '~' )
                    {
                    // InternalReflex.g:4038:3: (enumLiteral_2= '~' )
                    // InternalReflex.g:4039:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4046:3: (enumLiteral_3= '!' )
                    {
                    // InternalReflex.g:4046:3: (enumLiteral_3= '!' )
                    // InternalReflex.g:4047:4: enumLiteral_3= '!'
                    {
                    enumLiteral_3=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4057:1: ruleCompareOp returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4063:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) )
            // InternalReflex.g:4064:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalReflex.g:4064:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            int alt55=4;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt55=1;
                }
                break;
            case 97:
                {
                alt55=2;
                }
                break;
            case 98:
                {
                alt55=3;
                }
                break;
            case 99:
                {
                alt55=4;
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
                    // InternalReflex.g:4065:3: (enumLiteral_0= '<' )
                    {
                    // InternalReflex.g:4065:3: (enumLiteral_0= '<' )
                    // InternalReflex.g:4066:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4073:3: (enumLiteral_1= '>' )
                    {
                    // InternalReflex.g:4073:3: (enumLiteral_1= '>' )
                    // InternalReflex.g:4074:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4081:3: (enumLiteral_2= '=<' )
                    {
                    // InternalReflex.g:4081:3: (enumLiteral_2= '=<' )
                    // InternalReflex.g:4082:4: enumLiteral_2= '=<'
                    {
                    enumLiteral_2=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4089:3: (enumLiteral_3= '>=' )
                    {
                    // InternalReflex.g:4089:3: (enumLiteral_3= '>=' )
                    // InternalReflex.g:4090:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4100:1: ruleCompareEqOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleCompareEqOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4106:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // InternalReflex.g:4107:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // InternalReflex.g:4107:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==100) ) {
                alt56=1;
            }
            else if ( (LA56_0==101) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalReflex.g:4108:3: (enumLiteral_0= '==' )
                    {
                    // InternalReflex.g:4108:3: (enumLiteral_0= '==' )
                    // InternalReflex.g:4109:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4116:3: (enumLiteral_1= '!=' )
                    {
                    // InternalReflex.g:4116:3: (enumLiteral_1= '!=' )
                    // InternalReflex.g:4117:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4127:1: ruleShiftOp returns [Enumerator current=null] : ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) ;
    public final Enumerator ruleShiftOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4133:2: ( ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) )
            // InternalReflex.g:4134:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            {
            // InternalReflex.g:4134:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==102) ) {
                alt57=1;
            }
            else if ( (LA57_0==103) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalReflex.g:4135:3: (enumLiteral_0= '>>' )
                    {
                    // InternalReflex.g:4135:3: (enumLiteral_0= '>>' )
                    // InternalReflex.g:4136:4: enumLiteral_0= '>>'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4143:3: (enumLiteral_1= '<<' )
                    {
                    // InternalReflex.g:4143:3: (enumLiteral_1= '<<' )
                    // InternalReflex.g:4144:4: enumLiteral_1= '<<'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4154:1: ruleAdditiveOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4160:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalReflex.g:4161:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalReflex.g:4161:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
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
                    // InternalReflex.g:4162:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4162:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4163:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4170:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4170:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4171:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4181:1: ruleMultiplicativeOp returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalReflex.g:4187:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalReflex.g:4188:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalReflex.g:4188:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt59=3;
            switch ( input.LA(1) ) {
            case 104:
                {
                alt59=1;
                }
                break;
            case 105:
                {
                alt59=2;
                }
                break;
            case 106:
                {
                alt59=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }

            switch (alt59) {
                case 1 :
                    // InternalReflex.g:4189:3: (enumLiteral_0= '*' )
                    {
                    // InternalReflex.g:4189:3: (enumLiteral_0= '*' )
                    // InternalReflex.g:4190:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4197:3: (enumLiteral_1= '/' )
                    {
                    // InternalReflex.g:4197:3: (enumLiteral_1= '/' )
                    // InternalReflex.g:4198:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4205:3: (enumLiteral_2= '%' )
                    {
                    // InternalReflex.g:4205:3: (enumLiteral_2= '%' )
                    // InternalReflex.g:4206:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4216:1: ruleCTypeSignSpec returns [Enumerator current=null] : ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) ;
    public final Enumerator ruleCTypeSignSpec() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4222:2: ( ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) )
            // InternalReflex.g:4223:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            {
            // InternalReflex.g:4223:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==107) ) {
                alt60=1;
            }
            else if ( (LA60_0==108) ) {
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
                    // InternalReflex.g:4224:3: (enumLiteral_0= 'signed' )
                    {
                    // InternalReflex.g:4224:3: (enumLiteral_0= 'signed' )
                    // InternalReflex.g:4225:4: enumLiteral_0= 'signed'
                    {
                    enumLiteral_0=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4232:3: (enumLiteral_1= 'unsigned' )
                    {
                    // InternalReflex.g:4232:3: (enumLiteral_1= 'unsigned' )
                    // InternalReflex.g:4233:4: enumLiteral_1= 'unsigned'
                    {
                    enumLiteral_1=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
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
        match(input,63,FOLLOW_2); if (state.failed) return ;

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
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000180000001F820L,0x0000180000019800L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x000180000001F800L,0x0000180000019800L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x040480000003F800L,0x0000180000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0400800000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0380000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0010800000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x00000000001C0000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x3802C000019C0010L,0x00000000F00603F1L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000000L,0x0000000000006000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x30024000019C0012L,0x00000000F00603F1L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x3002C000019C0010L,0x00000000F00603F1L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x30024000019C0010L,0x00000000F00603F1L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0002000000000010L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0400000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000000001F800L,0x0000180000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x4010000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000060000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x70024000019C0010L,0x00000000F00603F1L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x20000000019C0010L,0x00000000F0060000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x000400000003F800L,0x0000180000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000002L,0x0000070000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000030000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000002L,0x000000C000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000002L,0x0000000F00000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000002L,0x0000003000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0008000000000000L,0x000000000FF80000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000600002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000006000002L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000004000002L});

}