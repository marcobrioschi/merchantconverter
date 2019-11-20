package biz.brioschi.merchantconverter

import groovy.transform.NotYetImplemented
import spock.lang.Ignore
import spock.lang.Narrative
import spock.lang.Specification

class IntergalacticMoneySpec extends Specification {

    def "The money can be visualized by all the species"() {

        given:

        IntergalacticMoney money = new IntergalacticMoney("V")

        when:

        String intergalacticString = money.toIntergalacticString()
        String earthString = money.toEarthString()

        then:

        assert intergalacticString == "V"
        assert earthString == "5"

    }

    /**
     * The symbols 'I', 'X', 'C', and 'M' can be repeated three times in succession,
     * but no more. (They may appear four times if the third and fourth are separated
     * by a smaller value, such as XXXIX.) 'D', 'L', and 'V' can never be repeated.
     */
    @Ignore
    def "Constraint: symbols are placed in order of value, starting with the largest values"() {
        expect:
        assert true == false
    }

}
