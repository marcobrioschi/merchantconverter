package biz.brioschi.merchantconverter.intergalacticmoney


import spock.lang.Specification
import spock.lang.Unroll

class IntergalacticBuilder_InvalidSpec extends Specification {

    def generateInvalidIntergalacticString() {
        def invalidIntergalacticString = [
                "CCCC",
                "CCD",
                "CCDV",
                "CCM",
                "CCML",
                "CDC",
                "CIIV",
                "CLL",
                "CMC",
                "CMCCC",
                "CMCM",
                "CMCMCM",
                "CMD",
                "CMM",
                "CXXIXXI",
                "CXXL",
                "DCD",
                "DD",
                "DIIX",
                "DMM",
                "DXXC",
                "DXXXX",
                "IIII",
                "IIIIX",
                "IIV",
                "IIVI",
                "IIX",
                "IIXII",
                "IIXV",
                "IVI",
                "IXIX",
                "IXIXIX",
                "IXIXIXIX",
                "IXX",
                "IXXV",
                "LIIX",
                "LIXX",
                "LIXXV",
                "LL",
                "LLX",
                "LXIXXI",
                "LXL",
                "MCCD",
                "MCCM",
                "MCMM",
                "MMCMM",
                "MMMCMM",
                "MMMCMMM",
                "MMMM",
                "MXXXIXXI",
                "VV",
                "VIV",
                "XCL",
                "XCX",
                "XCXC",
                "XCXCXC",
                "XCXXX",
                "XIIII",
                "XIXX",
                "XLX",
                "XXC",
                "XXCI",
                "XXIXX",
                "XXL",
                "XXLV",
                "XXXIXX",
                "XXXX",
                "XXXXV",
        ]
    }

    /**
     * The symbols 'I', 'X', 'C', and 'M' can be repeated three times in succession,
     * but no more. (They may appear four times if the third and fourth are separated
     * by a smaller value, such as XXXIX.) 'D', 'L', and 'V' can never be repeated.
     */
    @Unroll
    def "Constraint: symbols are placed in order of value from the largest values '#invalidString' generate an error"(
            String invalidString
    ) {

        given:
        IntergalacticBuilder intergalacticBuilder = new IntergalacticBuilder()

        when:
        intergalacticBuilder.buildFromIntergalacticString(invalidString)

        then:
        thrown(IntergalacticMoneyException.class)

        where:
        invalidString   <<  generateInvalidIntergalacticString()

    }

    @Unroll
    def "Invalid intergalactic string '#invalidString' throw an error"(String invalidString) {

        given:
        IntergalacticBuilder intergalacticBuilder = new IntergalacticBuilder()

        when:
        intergalacticBuilder.buildFromIntergalacticString(invalidString)

        then:
        thrown(IntergalacticMoneyException.class)

        where:
        invalidString << [ "AAA", "MXA", "AMX", "MAI", "?", "", null ]

    }

}
