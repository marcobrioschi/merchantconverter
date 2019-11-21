package biz.brioschi.merchantconverter.intergalacticmoney;

public class EarthMapper implements MoneyMapper {

    private final String MAPPER_DESC = "Earth symbols";

    @Override
    public String getMapperDescription() {
        return MAPPER_DESC;
    }

    @Override
    public boolean isCompatibleString(String src) {
        if (src != null) {
            return src.matches("\\d+");
        } else {
            return false;
        }
    }

    @Override
    public Money buildFromString(String src) throws IntergalacticMoneyException {
        try {
            int money = Integer.valueOf(src);
            return new Money(money);
        } catch (NumberFormatException e) {
            throw new IntergalacticMoneyException(e.getMessage());
        }
    }

    @Override
    public String toString(Money money) {
        return String.valueOf(money.money);
    }

}
