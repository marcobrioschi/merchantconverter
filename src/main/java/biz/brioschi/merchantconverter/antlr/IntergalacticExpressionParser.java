// Generated from C:/MyData/_WorkingDir/Repositories/git/merchantconverter/antlr\IntergalacticExpression.g4 by ANTLR 4.7.2
package biz.brioschi.merchantconverter.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IntergalacticExpressionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LP=1, RP=2, PLUS=3, MINUS=4, MULT=5, DIV=6, INT=7, ROMAN=8, WS=9;
	public static final int
		RULE_start = 0, RULE_sumexpression = 1, RULE_multexpression = 2, RULE_value = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "sumexpression", "multexpression", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LP", "RP", "PLUS", "MINUS", "MULT", "DIV", "INT", "ROMAN", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IntergalacticExpression.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IntergalacticExpressionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public SumexpressionContext sumexpression() {
			return getRuleContext(SumexpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(IntergalacticExpressionParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntergalacticExpressionVisitor ) return ((IntergalacticExpressionVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			sumexpression();
			setState(9);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SumexpressionContext extends ParserRuleContext {
		public MultexpressionContext multexpression() {
			return getRuleContext(MultexpressionContext.class,0);
		}
		public SumexpressionContext sumexpression() {
			return getRuleContext(SumexpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(IntergalacticExpressionParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(IntergalacticExpressionParser.MINUS, 0); }
		public SumexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sumexpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntergalacticExpressionVisitor ) return ((IntergalacticExpressionVisitor<? extends T>)visitor).visitSumexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumexpressionContext sumexpression() throws RecognitionException {
		SumexpressionContext _localctx = new SumexpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sumexpression);
		int _la;
		try {
			setState(17);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(12);
				multexpression();
				setState(13);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(14);
				sumexpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(16);
				multexpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultexpressionContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public MultexpressionContext multexpression() {
			return getRuleContext(MultexpressionContext.class,0);
		}
		public TerminalNode MULT() { return getToken(IntergalacticExpressionParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(IntergalacticExpressionParser.DIV, 0); }
		public MultexpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multexpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntergalacticExpressionVisitor ) return ((IntergalacticExpressionVisitor<? extends T>)visitor).visitMultexpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultexpressionContext multexpression() throws RecognitionException {
		MultexpressionContext _localctx = new MultexpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multexpression);
		int _la;
		try {
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(20);
				value();
				setState(21);
				_la = _input.LA(1);
				if ( !(_la==MULT || _la==DIV) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(22);
				multexpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(24);
				value();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode LP() { return getToken(IntergalacticExpressionParser.LP, 0); }
		public SumexpressionContext sumexpression() {
			return getRuleContext(SumexpressionContext.class,0);
		}
		public TerminalNode RP() { return getToken(IntergalacticExpressionParser.RP, 0); }
		public TerminalNode INT() { return getToken(IntergalacticExpressionParser.INT, 0); }
		public TerminalNode ROMAN() { return getToken(IntergalacticExpressionParser.ROMAN, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof IntergalacticExpressionVisitor ) return ((IntergalacticExpressionVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_value);
		try {
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case RP:
			case PLUS:
			case MINUS:
			case MULT:
			case DIV:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case LP:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				match(LP);
				setState(29);
				sumexpression();
				setState(30);
				match(RP);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 3);
				{
				setState(32);
				match(INT);
				}
				break;
			case ROMAN:
				enterOuterAlt(_localctx, 4);
				{
				setState(33);
				match(ROMAN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\'\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\24\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4\34\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5%\n\5"+
		"\3\5\2\2\6\2\4\6\b\2\4\3\2\5\6\3\2\7\b\2)\2\n\3\2\2\2\4\23\3\2\2\2\6\33"+
		"\3\2\2\2\b$\3\2\2\2\n\13\5\4\3\2\13\f\7\2\2\3\f\3\3\2\2\2\r\24\3\2\2\2"+
		"\16\17\5\6\4\2\17\20\t\2\2\2\20\21\5\4\3\2\21\24\3\2\2\2\22\24\5\6\4\2"+
		"\23\r\3\2\2\2\23\16\3\2\2\2\23\22\3\2\2\2\24\5\3\2\2\2\25\34\3\2\2\2\26"+
		"\27\5\b\5\2\27\30\t\3\2\2\30\31\5\6\4\2\31\34\3\2\2\2\32\34\5\b\5\2\33"+
		"\25\3\2\2\2\33\26\3\2\2\2\33\32\3\2\2\2\34\7\3\2\2\2\35%\3\2\2\2\36\37"+
		"\7\3\2\2\37 \5\4\3\2 !\7\4\2\2!%\3\2\2\2\"%\7\t\2\2#%\7\n\2\2$\35\3\2"+
		"\2\2$\36\3\2\2\2$\"\3\2\2\2$#\3\2\2\2%\t\3\2\2\2\5\23\33$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}