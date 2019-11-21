package biz.brioschi.merchantconverter.intergalacticmoney

import spock.lang.Specification
import spock.lang.Unroll

class IntergalacticMapperSpec extends Specification {

    @Unroll
    def "Check formal string for the mapper [#string -> #expected]"(String string, boolean expected) {

        given:
        IntergalacticMapper intergalacticMapper = new IntergalacticMapper()

        when:
        boolean result = intergalacticMapper.isCompatibleString(string)

        then:
        assert result == expected

        where:
        string          ||  expected
        null            ||  false
        ""              ||  false
        "I"             ||  true
        "IX"            ||  true
        "MDCLXVI"       ||  true
        "IA"            ||  false
        "AI"            ||  false
        "A"             ||  false

    }

}
