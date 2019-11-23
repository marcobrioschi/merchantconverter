// Generated from C:/MyData/_WorkingDir/Repositories/git/merchantconverter/antlr\IntergalacticExpression.g4 by ANTLR 4.7.2
package biz.brioschi.merchantconverter.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IntergalacticExpressionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IntergalacticExpressionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IntergalacticExpressionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(IntergalacticExpressionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntergalacticExpressionParser#sumexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSumexpression(IntergalacticExpressionParser.SumexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntergalacticExpressionParser#multexpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultexpression(IntergalacticExpressionParser.MultexpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link IntergalacticExpressionParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(IntergalacticExpressionParser.ValueContext ctx);
}