package biz.brioschi.merchantconverter.converter;

import biz.brioschi.merchantconverter.antlr.IntergalacticExpressionLexer;
import biz.brioschi.merchantconverter.antlr.IntergalacticExpressionParser;
import biz.brioschi.merchantconverter.intergalacticmoney.Money;
import biz.brioschi.merchantconverter.intergalacticmoney.MoneyMapper;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    private MoneyMapper earthMapper;
    private MoneyMapper intergalacticMapper;

    public Converter(MoneyMapper earthMapper, MoneyMapper intergalacticMapper) {
        this.earthMapper = earthMapper;
        this.intergalacticMapper = intergalacticMapper;
    }

    public Map<String, String> processExpression(String string) throws Exception {

        IntergalacticExpressionParser.StartContext context = elaborateANTLRContext(string);
        IntergalacticExpressionVisitor visitor = new IntergalacticExpressionVisitor(earthMapper, intergalacticMapper);
        Money money = visitor.parseExpression(context);
        Map<String, String> result = elaborateResponse(money);

        return result;

    }

    private Map<String, String> elaborateResponse(Money money) {
        Map<String, String> result = new HashMap<>();
        result.put(earthMapper.getMapperDescription(), earthMapper.toString(money));
        result.put(intergalacticMapper.getMapperDescription(), intergalacticMapper.toString(money));
        return result;
    }

    private IntergalacticExpressionParser.StartContext elaborateANTLRContext(String string) {
        IntergalacticExpressionLexer lexer = new IntergalacticExpressionLexer(CharStreams.fromString(string));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IntergalacticExpressionParser parser = new IntergalacticExpressionParser(tokens);
        return parser.start();
    }

}
