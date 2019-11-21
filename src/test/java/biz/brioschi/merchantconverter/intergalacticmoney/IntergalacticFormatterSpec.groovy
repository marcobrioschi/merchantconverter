package biz.brioschi.merchantconverter.intergalacticmoney


import spock.lang.Specification
import spock.lang.Unroll

class IntergalacticFormatterSpec extends Specification {

    IntergalacticFormatter moneyFormat

    def setup() {
        moneyFormat = new IntergalacticFormatter()
    }

    @Unroll
    def "Parse the money value #moneyValue and produce the intergalactic value #intergalacticString - base"(
            int moneyValue,
            String intergalacticString
    ) {

        when:
        String result = moneyFormat.format( new Money(moneyValue) )

        then:
        assert result == intergalacticString

        where:
        moneyValue  ||  intergalacticString
        1           ||  "I"
        2           ||  "II"
        3           ||  "III"
        4           ||  "IV"
        5           ||  "V"
        6           ||  "VI"
        7           ||  "VII"
        8           ||  "VIII"
        9           ||  "IX"
        10          ||  "X"
        20          ||  "XX"
        30          ||  "XXX"
        40          ||  "XL"
        50          ||  "L"
        60          ||  "LX"
        70          ||  "LXX"
        80          ||  "LXXX"
        90          ||  "XC"
        100         ||  "C"
        200         ||  "CC"
        300         ||  "CCC"
        400         ||  "CD"
        500         ||  "D"
        600         ||  "DC"
        700         ||  "DCC"
        800         ||  "DCCC"
        900         ||  "CM"
        1000        ||  "M"
        2000        ||  "MM"
        3000        ||  "MMM"

    }

    @Unroll
    def "Parse the money value #moneyValue and produce the intergalactic value #intergalacticString - misc"(
            int moneyValue,
            String intergalacticString
    ) {

        when:
        String result = moneyFormat.format( new Money(moneyValue) )

        then:
        assert result == intergalacticString

        where:
        moneyValue              << IntergalacticMoneySequenceHelper.getMoneyValueList()
        intergalacticString     << IntergalacticMoneySequenceHelper.getIntergalacticStringList()

    }

    @Unroll
    def "Manage negative, 0 and  big numbers like #moneyValue"(int moneyValue) {

        when:
        String result = moneyFormat.format( new Money(moneyValue) )

        then:
        assert result == IntergalacticFormatter.UNAVAILABLE_INTERGALACTIC_VALUE

        where:
        moneyValue  << [ -1000, -1, 0, 4000, 8000, 10000, 1000000 ]

    }

}
