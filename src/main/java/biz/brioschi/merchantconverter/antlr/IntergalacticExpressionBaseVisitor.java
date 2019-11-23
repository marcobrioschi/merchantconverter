// Generated from C:/MyData/_WorkingDir/Repositories/git/merchantconverter/antlr\IntergalacticExpression.g4 by ANTLR 4.7.2
package biz.brioschi.merchantconverter.antlr;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link IntergalacticExpressionVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public class IntergalacticExpressionBaseVisitor<T> extends AbstractParseTreeVisitor<T> implements IntergalacticExpressionVisitor<T> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitStart(IntergalacticExpressionParser.StartContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitSumexpression(IntergalacticExpressionParser.SumexpressionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitMultexpression(IntergalacticExpressionParser.MultexpressionContext ctx) { return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public T visitValue(IntergalacticExpressionParser.ValueContext ctx) { return visitChildren(ctx); }
}