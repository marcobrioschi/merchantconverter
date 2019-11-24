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
			sumexpression(0);
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
		return sumexpression(0);
	}

	private SumexpressionContext sumexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SumexpressionContext _localctx = new SumexpressionContext(_ctx, _parentState);
		SumexpressionContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_sumexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(13);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(12);
				multexpression(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(20);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SumexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sumexpression);
					setState(15);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(16);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(17);
					multexpression(0);
					}
					} 
				}
				setState(22);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
		return multexpression(0);
	}

	private MultexpressionContext multexpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultexpressionContext _localctx = new MultexpressionContext(_ctx, _parentState);
		MultexpressionContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_multexpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(24);
				value();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(32);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MultexpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_multexpression);
					setState(27);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(28);
					_la = _input.LA(1);
					if ( !(_la==MULT || _la==DIV) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(29);
					value();
					}
					} 
				}
				setState(34);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
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
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				match(LP);
				setState(37);
				sumexpression(0);
				setState(38);
				match(RP);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				match(INT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				match(ROMAN);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return sumexpression_sempred((SumexpressionContext)_localctx, predIndex);
		case 2:
			return multexpression_sempred((MultexpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean sumexpression_sempred(SumexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean multexpression_sempred(MultexpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13/\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\3\3\3\5\3\20\n\3\3\3\3\3\3\3\7\3\25\n"+
		"\3\f\3\16\3\30\13\3\3\4\3\4\5\4\34\n\4\3\4\3\4\3\4\7\4!\n\4\f\4\16\4$"+
		"\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5-\n\5\3\5\2\4\4\6\6\2\4\6\b\2\4\3"+
		"\2\5\6\3\2\7\b\2\61\2\n\3\2\2\2\4\17\3\2\2\2\6\33\3\2\2\2\b,\3\2\2\2\n"+
		"\13\5\4\3\2\13\f\7\2\2\3\f\3\3\2\2\2\r\20\b\3\1\2\16\20\5\6\4\2\17\r\3"+
		"\2\2\2\17\16\3\2\2\2\20\26\3\2\2\2\21\22\f\4\2\2\22\23\t\2\2\2\23\25\5"+
		"\6\4\2\24\21\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\5\3"+
		"\2\2\2\30\26\3\2\2\2\31\34\b\4\1\2\32\34\5\b\5\2\33\31\3\2\2\2\33\32\3"+
		"\2\2\2\34\"\3\2\2\2\35\36\f\4\2\2\36\37\t\3\2\2\37!\5\b\5\2 \35\3\2\2"+
		"\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\7\3\2\2\2$\"\3\2\2\2%-\3\2\2\2&\'"+
		"\7\3\2\2\'(\5\4\3\2()\7\4\2\2)-\3\2\2\2*-\7\t\2\2+-\7\n\2\2,%\3\2\2\2"+
		",&\3\2\2\2,*\3\2\2\2,+\3\2\2\2-\t\3\2\2\2\7\17\26\33\",";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}