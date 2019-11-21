package biz.brioschi.merchantconverter.intergalacticmoney

import biz.brioschi.merchantconverter.intergalacticmoney.IntergalacticChar

class IntergalacticMoneySequenceHelper {

    static def generateAllDecreasingCoupleList() {
        return GroovyCollections.combinations(
                IntergalacticChar.values(),
                IntergalacticChar.values()
        ).findAll(
                { current, follower -> current.getCharValue() > follower.getCharValue() }
        ).collect(
                { it -> it[0].name() + it[1].name() }
        )
    }

    static def generateAllSubtractionCoupleList() {
        return GroovyCollections.combinations(
                IntergalacticChar.values(),
                IntergalacticChar.values()
        ).findAll(
                { current, follower -> current.getCharValue() < follower.getCharValue() }
        ).collect(
                { it -> it[0].name() + it[1].name() }
        )
    }

    static def knowValidCouples() {
        def couples = [

                // From specs
                [ 'MMVI',           '2006',     2006  ],
                [ 'MCMXLIV',        '1944',     1944  ],
                [ 'MCMIII',         '1903',     1903  ],

                // Trivial
                [ 'V',              '5',        5     ],
                [ 'XV',             '15',       15    ],
                [ 'MDCLXVI',        '1666',     1666  ],
                [ 'MMXCIV',         '2094',     2094  ],

                // Edge cases
                [ 'I',              '1',        1     ],
                [ 'IX',             '9',        9     ],
                [ 'LXXXIX',         '89',       89    ],
                [ 'XC',             '90',       90    ],
                [ 'XCI',            '91',       91    ],
                [ 'DCXCVIII',       '698',      698   ],
                [ 'DCXCIX',         '699',      699   ],
                [ 'DCC',            '700',      700   ],
                [ 'DCCI',           '701',      701   ],
                [ 'MCDXLVIII',      '1448',     1448  ],
                [ 'MCDXLIX',        '1449',     1449  ],
                [ 'MCDL',           '1450',     1450  ],
                [ 'MCDLI',          '1451',     1451  ],
                [ 'MCMXCVIII',      '1998',     1998  ],
                [ 'MCMXCIX',        '1999',     1999  ],
                [ 'MM',             '2000',     2000  ],
                [ 'MMI',            '2001',     2001  ],
                [ 'MMMCMXCIX',      '3999',     3999  ],

                // 10 Random (goolge generator)
                [ 'MMMCDLXXI',      '3471',     3471  ],
                [ 'MMMDCCXI',       '3711',     3711  ],
                [ 'CCCXCIX',        '399',      399   ],
                [ 'MMXXXV',         '2035',     2035  ],
                [ 'DCCCLXXVII',     '877',      877   ],
                [ 'MDX',            '1510',     1510  ],
                [ 'DCLXXXI',        '681',      681   ],
                [ 'MMLXXIII',       '2073',     2073  ],
                [ 'MMDCCXV',        '2715',     2715  ],
                [ 'MDCCXIX',        '1719',     1719  ],

                // Napoléon Bonaparte
                [ 'MDCCLXIX',       '1769',     1769  ],
                [ 'MDCCXCIX',       '1799',     1799  ],
                [ 'MDCCCIV',        '1804',     1804  ],
                [ 'MDCCCXV',        '1815',     1815  ],
                [ 'MDCCCXXI',       '1821',     1821  ]

        ]
    }

    static def getIntergalacticStringList() {
        return knowValidCouples().collect { it[0] }
    }

    static def getEarthStringList() {
        return knowValidCouples().collect { it[1] }
    }

    static def getMoneyValueList() {
        return knowValidCouples().collect { it[2] }
    }

}
