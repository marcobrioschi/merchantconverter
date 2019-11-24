package biz.brioschi.merchantconverter;

import biz.brioschi.merchantconverter.intergalacticmoney.Money;
import biz.brioschi.merchantconverter.intergalacticmoney.MoneyMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {

    private List<MoneyMapper> mappers;

    public Converter(List<MoneyMapper> mappers) {
        this.mappers = mappers;
    }

    public Map<String, String> processExpression(String value) throws Exception {
        MoneyMapper decodeMapper = findCompatibleMapper(value);
        if (decodeMapper != null) {
            Money money = decodeMapper.buildFromString(value);
            Map<String, String> result = new HashMap<>();
            for (MoneyMapper printMapper : mappers) {
                result.put(printMapper.getMapperDescription(), printMapper.toString(money));
            }
            return result;
        } else {
            throw new Exception("The string '" + value + "' isn't a valid money value");
        }
    }

    private MoneyMapper findCompatibleMapper(String value) {
        for (MoneyMapper mapper : mappers) {
            if (mapper.isCompatibleString(value)) {
                return mapper;
            }
        }
        return null;
    }

}
