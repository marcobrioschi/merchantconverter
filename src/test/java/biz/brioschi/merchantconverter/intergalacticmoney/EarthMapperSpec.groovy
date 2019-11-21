package biz.brioschi.merchantconverter.intergalacticmoney


import spock.lang.Specification
import spock.lang.Unroll

class EarthMapperSpec extends Specification{

    EarthMapper earthMapper

    def setup() {
        earthMapper = new EarthMapper()
    }

    @Unroll
    def "Some valid examples of IntergalacticMoney in earth notation: #earthString = #moneyValue"(
            String earthString,
            int moneyValue
    ) {

        when:
        Money money = earthMapper.buildFromString(earthString)

        then:
        assert money.money == moneyValue

        where:
        earthString             << IntergalacticMoneySequenceHelper.getEarthStringList()
        moneyValue              << IntergalacticMoneySequenceHelper.getMoneyValueList()

    }

    @Unroll
    def "Negative and zero are valid money [#earthString, #moneyValue]"(String earthString, int moneyValue) {

        when:
        Money money = earthMapper.buildFromString(earthString)

        then:
        assert money.money == moneyValue

        where:
        earthString             << [    "0",    "-1",   "-10",      "-100",     "-1000"     ]
        moneyValue              << [      0,      -1,     -10,        -100,       -1000     ]

    }

    @Unroll
    def "Invalid earth string '#invalidString' throw an error"(String invalidString) {

        when:
        earthMapper.buildFromString(invalidString)

        then:
        thrown(IntergalacticMoneyException.class)

        where:
        invalidString << [ "123X", "X123", "12x3", "abaco", "??", "", null ]

    }

    @Unroll
    def "Check formal string for the mapper [#string -> #expected]"(String string, boolean expected) {

        when:
        boolean result = earthMapper.isCompatibleString(string)

        then:
        assert result == expected

        where:
        string          ||  expected
        null            ||  false
        ""              ||  false
        "1"             ||  true
        "9"             ||  true
        "0123456789"    ||  true
        "1A"            ||  false
        "A1"            ||  false
        "A"             ||  false

    }

}
