package biz.brioschi.merchantconverter.intergalacticmoney;

public interface MoneyMapper {

    public String getMapperDescription();

    public boolean isCompatibleString(String src);

    public Money buildFromString(String src) throws IntergalacticMoneyException;

    public String toString(Money money);

}
