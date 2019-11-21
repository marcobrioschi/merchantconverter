package biz.brioschi.merchantconverter.intergalacticmoney


import spock.lang.Specification
import spock.lang.Unroll

class IntergalacticBuilder_SubtractionSpec extends Specification {

    IntergalacticBuilder intergalacticBuilder

    def setup() {
        intergalacticBuilder = new IntergalacticBuilder()
    }

    @Unroll
    def "Sequence of IntergalacticChar with decreasing values are OK [#charSequence]"(String charSequence) {

        when:
        intergalacticBuilder.buildFromIntergalacticString(charSequence)

        then:
        noExceptionThrown()

        where:
        charSequence  <<  IntergalacticMoneySequenceHelper.generateAllDecreasingCoupleList()

    }

    /**
     * 'I' can be subtracted from 'V' and 'X' only. 'X' can be subtracted from
     * 'L' and 'C' only. 'C' can be subtracted from 'D' and 'M' only. 'V', 'L',
     * and 'D' can never be subtracted.
     */
    private def generateValidSubtractionCoupleList() {
        return [ "IV", "IX", "XL", "XC", "CD", "CM" ]
    }

    @Unroll
    def "When smaller values precede larger values, the smaller values are subtracted  [#charSequence]"(String charSequence) {

        when:
        intergalacticBuilder.buildFromIntergalacticString(charSequence)

        then:
        noExceptionThrown()

        where:
        charSequence  <<  generateValidSubtractionCoupleList()

    }

    /**
     * Only one small-value symbol may be subtracted from any large-value symbol.
     */
    @Unroll
    def "Not all chars can be subtracted from all chars: [#charSequence] isn't a valid"(String charSequence) {

        when:
        intergalacticBuilder.buildFromIntergalacticString(charSequence)

        then:
        thrown(IntergalacticMoneyException)

        where:
        charSequence << IntergalacticMoneySequenceHelper.generateAllSubtractionCoupleList().minus( generateValidSubtractionCoupleList() )

    }

}
