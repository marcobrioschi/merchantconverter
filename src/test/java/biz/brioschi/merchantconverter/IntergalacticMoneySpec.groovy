package biz.brioschi.merchantconverter

import spock.lang.Specification

class IntergalacticMoneySpec extends Specification {

    def "The money can be visualized in for all the species"() {

        when:

        IntergalacticMoney money = new IntergalacticMoney("V")

        then:

        assert money.toIntergalacticString() == "V"
        assert money.toEarthString() == "5"

    }

}
