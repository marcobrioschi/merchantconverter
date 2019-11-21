package biz.brioschi.merchantconverter.intergalacticmoney;

public class IntergalacticMapper implements MoneyMapper {

    private final String MAPPER_DESC = "Space symbols";

    private final IntergalacticBuilder builder = new IntergalacticBuilder();
    private final IntergalacticFormatter formatter = new IntergalacticFormatter();

    @Override
    public String getMapperDescription() {
        return MAPPER_DESC;
    }

    @Override
    public boolean isCompatibleString(String src) {
        if (src != null) {
            return src.matches("[MDCLXVI]+");
        } else {
            return false;
        }
    }

    public Money buildFromString(String inputString) throws IntergalacticMoneyException {
        return builder.buildFromIntergalacticString(inputString);
    }

    public String toString(Money money) {
        return formatter.format(money);
    }

}
