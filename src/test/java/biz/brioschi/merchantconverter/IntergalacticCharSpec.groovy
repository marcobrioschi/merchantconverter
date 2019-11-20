package biz.brioschi.merchantconverter


import spock.lang.Specification
import spock.lang.Unroll

class IntergalacticCharSpec extends Specification {

    @Unroll
    def "Single values are well mapped: #intergalacticChar = #mappedValue"(String intergalacticChar, int mappedValue) {

        given:
        IntergalacticChar ch = IntergalacticChar.valueOf(intergalacticChar)

        when:
        int resultValue = ch.getCharValue()

        then:
        assert resultValue == mappedValue

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

    /**
     * 'I' can be subtracted from 'V' and 'X' only. 'X' can be subtracted from
     * 'L' and 'C' only. 'C' can be subtracted from 'D' and 'M' only. 'V', 'L',
     * and 'D' can never be subtracted.
     */
    private def generateValidSubtractionCoupleList() {
        return [
                [ IntergalacticChar.I , IntergalacticChar.V ],
                [ IntergalacticChar.I , IntergalacticChar.X ],
                [ IntergalacticChar.X , IntergalacticChar.L ],
                [ IntergalacticChar.X , IntergalacticChar.C ],
                [ IntergalacticChar.C , IntergalacticChar.D ],
                [ IntergalacticChar.C , IntergalacticChar.M ]
        ]
    }

    /**
     * Only one small-value symbol may be subtracted from any large-value symbol.
     */
    private def generateAllSubtractionCoupleList() {
        return GroovyCollections.combinations(
                IntergalacticChar.values(),
                IntergalacticChar.values()
        ).findAll(
                { current, follower -> current.getCharValue() < follower.getCharValue() }
        )
    }

    private def generateAllDecreasingCoupleList() {
        return GroovyCollections.combinations(
                IntergalacticChar.values(),
                IntergalacticChar.values()
        ).findAll(
                { current, follower -> current.getCharValue() >= follower.getCharValue() }
        )
    }

    @Unroll
    def "Sequence of IntergalacticChar with decreasing values are OK [#currentCh , #followerCh]"(
            IntergalacticChar currentCh,
            IntergalacticChar followerCh
    ) {

        when:
        int expectedResultValue = currentCh.getCharValue()
        int resultValue = currentCh.getCharValueWithFollower(followerCh)

        then:
        assert resultValue == expectedResultValue

        where:
        [ currentCh, followerCh ]  <<  generateAllDecreasingCoupleList()

    }

    @Unroll
    def "When smaller values [#currentCh] precede larger values [#followerCh], the smaller values are subtracted"(
            IntergalacticChar currentCh,
            IntergalacticChar followerCh
    ) {

        when:
        int expectedResultValue = -currentCh.getCharValue()
        int resultValue = currentCh.getCharValueWithFollower(followerCh)

        then:
        assert resultValue == expectedResultValue

        where:
        [ currentCh, followerCh ]  <<  generateValidSubtractionCoupleList()

    }

    @Unroll
    def "Not only chars can be subtracted from all chars: [#currentCh] / [#followerCh] isn't a valid couple"(
            IntergalacticChar currentCh,
            IntergalacticChar followerCh
    ) {

        when:
        currentCh.getCharValueWithFollower(followerCh)

        then:
        thrown(InvalidIntergalacticCharSequence)

        where:
        [ currentCh, followerCh ] << generateAllSubtractionCoupleList().minus( generateValidSubtractionCoupleList() )

    }

}
