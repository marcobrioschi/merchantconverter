package biz.brioschi.merchantconverter.intergalacticmoney


import spock.lang.Specification
import spock.lang.Unroll

class IntergalacticBuilder_ValidSpec extends Specification {

    IntergalacticBuilder intergalacticBuilder

    def setup() {
        intergalacticBuilder = new IntergalacticBuilder()
    }

    @Unroll
    def "Single values are well mapped: #intergalacticChar = #mappedValue"(String intergalacticChar, int mappedValue) {

        when:
        Money money = intergalacticBuilder.buildFromIntergalacticString(intergalacticChar)

        then:
        assert money.money == mappedValue

        where:
        intergalacticChar   ||  mappedValue
        "I"                 ||  1
        "V"                 ||  5
        "X"                 ||  10
        "L"                 ||  50
        "C"                 ||  100
        "D"                 ||  500
        "M"                 ||  1000

    }

    @Unroll
    def "Some valid examples of IntergalacticMoney in intergalactic notation: #intergalacticString = #moneyValue"(
            String intergalacticString,
            int moneyValue
    ) {

        when:
        Money money = intergalacticBuilder.buildFromIntergalacticString(intergalacticString)

        then:
        assert money.money == moneyValue

        where:
        intergalacticString     << IntergalacticMoneySequenceHelper.getIntergalacticStringList()
        moneyValue              << IntergalacticMoneySequenceHelper.getMoneyValueList()

    }

}
