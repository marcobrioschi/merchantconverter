package biz.brioschi.merchantconverter;

enum IntergalacticChar {

    I(1, null),
    V(5, I),
    X(10, I),
    L(50, X),
    C(100, X),
    D(500, C),
    M(1000, C)
    ;

    private final int charValue;
    private final IntergalacticChar canSubtractChar;

    private IntergalacticChar(int charValue, IntergalacticChar canSubtractChar) {
        this.charValue = charValue;
        this.canSubtractChar = canSubtractChar;
    }

    int getCharValue() {
        return charValue;
    }

    int getCharValueWithFollower(IntergalacticChar followerChar) throws InvalidIntergalacticCharSequence {
        if (charValue < followerChar.getCharValue()) {
            if ( this == followerChar.canSubtractChar ) {
                return -charValue;
            } else {
                throw new InvalidIntergalacticCharSequence();
            }
        } else {
            return charValue;
        }
    }

}
