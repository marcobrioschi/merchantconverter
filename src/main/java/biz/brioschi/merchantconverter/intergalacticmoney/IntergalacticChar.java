package biz.brioschi.merchantconverter.intergalacticmoney;

enum IntergalacticChar {

    I(1, 3,null),
    V(5, 1, I),
    X(10, 3, I),
    L(50, 1, X),
    C(100, 3, X),
    D(500, 1, C),
    M(1000, 3, C)
    ;

    private final int charValue;
    private final int maxOccurrences;
    private final IntergalacticChar canSubtractChar;

    private IntergalacticChar(int charValue, int maxOccurrences, IntergalacticChar canSubtractChar) {
        this.charValue = charValue;
        this.maxOccurrences = maxOccurrences;
        this.canSubtractChar = canSubtractChar;
    }

    int getCharValue() {
        return charValue;
    }

    int getMaxOccurrences() {
        return maxOccurrences;
    }

    IntergalacticChar getCanSubtractChar() {
        return canSubtractChar;
    }

}
