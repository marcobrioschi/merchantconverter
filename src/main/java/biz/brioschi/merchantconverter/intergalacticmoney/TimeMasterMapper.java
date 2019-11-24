package biz.brioschi.merchantconverter.intergalacticmoney;

public class TimeMasterMapper implements MoneyMapper {

    private final String MAPPER_DESC = "TimeMaster symbols";
    private final String DIALECT_EXCEPTION_STR = "IIII";
    private final Money DIALECT_EXCEPTION_VAL = new Money(4);

    private IntergalacticMapper intergalacticMapper = new IntergalacticMapper();

    @Override
    public String getMapperDescription() {
        return MAPPER_DESC;
    }

    @Override
    public boolean isCompatibleString(String src) {
        return intergalacticMapper.isCompatibleString(src);
    }

    @Override
    public Money buildFromString(String src) throws IntergalacticMoneyException {
        if (DIALECT_EXCEPTION_STR.equals(src)) {
            return DIALECT_EXCEPTION_VAL;
        } else {
            return intergalacticMapper.buildFromString(src);
        }
    }

    @Override
    public String toString(Money money) {
        if (DIALECT_EXCEPTION_VAL.equals(money)) {
            return DIALECT_EXCEPTION_STR;
        } else {
            return intergalacticMapper.toString(money);
        }
    }

}
