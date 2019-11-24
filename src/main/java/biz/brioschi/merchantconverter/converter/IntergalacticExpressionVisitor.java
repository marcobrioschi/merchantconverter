package biz.brioschi.merchantconverter.converter;

import biz.brioschi.merchantconverter.antlr.IntergalacticExpressionBaseVisitor;
import biz.brioschi.merchantconverter.antlr.IntergalacticExpressionParser;
import biz.brioschi.merchantconverter.intergalacticmoney.IntergalacticMoneyException;
import biz.brioschi.merchantconverter.intergalacticmoney.Money;
import biz.brioschi.merchantconverter.intergalacticmoney.MoneyMapper;

import java.security.InvalidParameterException;

public class IntergalacticExpressionVisitor extends IntergalacticExpressionBaseVisitor {

    private MoneyMapper earthMapper;
    private MoneyMapper intergalacticMapper;
    private String errorDescription;

    public IntergalacticExpressionVisitor(MoneyMapper earthMapper, MoneyMapper intergalacticMapper) {
        this.earthMapper = earthMapper;
        this.intergalacticMapper = intergalacticMapper;
        this.errorDescription = null;
    }

    public Money parseExpression(IntergalacticExpressionParser.StartContext ctx) throws Exception {
        Money result = visitStart(ctx);
        if ( errorDescription != null ) {
            throw new Exception(errorDescription);
        }
        return result;
    }

    @Override
    public Money visitStart(IntergalacticExpressionParser.StartContext ctx) {
        return visitSumexpression(ctx.sumexpression());
    }

    @Override
    public Money visitSumexpression(IntergalacticExpressionParser.SumexpressionContext ctx) {
        Money result = visitMultexpression(ctx.multexpression());
        if (result != null) {
            if (ctx.PLUS() != null) {               // PLUS sumexpression
                Money firstOperator = visitSumexpression(ctx.sumexpression());
                if (firstOperator != null) {
                    result = firstOperator.add(result);
                }
            } else if (ctx.MINUS() != null) {       // MINUS sumexpression
                Money firstOperator = visitSumexpression(ctx.sumexpression());
                if (firstOperator != null) {
                    result = firstOperator.minus(result);
                }
            }
        }
        return result;
    }

    @Override
    public Money visitMultexpression(IntergalacticExpressionParser.MultexpressionContext ctx) {
        Money result = visitValue(ctx.value());
        if (result != null) {
            if (ctx.MULT() != null) {               // MULT multexpression
                Money firstOperator = visitMultexpression(ctx.multexpression());
                if (firstOperator != null) {
                    result = firstOperator.mult(result);
                }
            } else if (ctx.DIV() != null) {         // DIV multexpression
                Money firstOperator = visitMultexpression(ctx.multexpression());
                if (firstOperator != null) {
                    result = firstOperator.div(result);
                }
            }
        }
        return result;
    }

    @Override
    public Money visitValue(IntergalacticExpressionParser.ValueContext ctx) {
        if (ctx.sumexpression() != null) {
            return visitSumexpression(ctx.sumexpression());
        } else if (ctx.ROMAN() != null) {
            try {
                return intergalacticMapper.buildFromString(ctx.ROMAN().getText());
            } catch (IntergalacticMoneyException e) {
                errorDescription = e.getMessage();
                return null;
            }
        } else if (ctx.INT() != null) {
            try {
                return earthMapper.buildFromString(ctx.INT().getText());
            } catch (IntergalacticMoneyException e) {
                errorDescription = e.getMessage();
                return null;
            }
        } else {
            errorDescription = "Invalid token: " + ctx.getText();
            return null;
        }
    }
}
