package biz.brioschi.merchantconverter.intergalacticmoney;

import static biz.brioschi.merchantconverter.intergalacticmoney.IntergalacticChar.*;

class IntergalacticFormatter {

    static final int MAX_INTERGALACTIC_VALUE = 3999;
    static final String UNAVAILABLE_INTERGALACTIC_VALUE = "[Not an intergalactic number]";

    String format(Money money) {

        int value = money.money;

        if (!isIntergalacticDisplayableValue(value)) {
            return UNAVAILABLE_INTERGALACTIC_VALUE;
        }

        StringBuilder result = new StringBuilder();

        int cipher4 = value % 10000 - value % 1000;
        thousandFormat(cipher4, result);

        int cipher3 = value % 1000 - value % 100;
        singleDigitFormat(cipher3, C, D, M, result);

        int cipher2 = value % 100 - value % 10;
        singleDigitFormat(cipher2, X, L, C, result);

        int cipher1 = value % 10;
        singleDigitFormat(cipher1, I, V, X, result);

        return result.toString();

    }

    private boolean isIntergalacticDisplayableValue(int value) {
        return (value > 0) && (value <= MAX_INTERGALACTIC_VALUE);
    }

    private void singleDigitFormat(
            int valueToFormat,
            IntergalacticChar unitValue,
            IntergalacticChar intermediateValue,
            IntergalacticChar nextUnitValue,
            StringBuilder result
    ) {
        if (valueToFormat == isTheFour(unitValue, intermediateValue)) {
            result.append(generateTheFour(unitValue, intermediateValue));
        } else if (valueToFormat == isTheNine(unitValue, nextUnitValue)) {
            result.append(generateTheNine(unitValue, nextUnitValue));
        } else {
            int cumulatedValue = 0;
            if (valueToFormat >= intermediateValue.getCharValue()) {
                result.append(intermediateValue.toString());
                cumulatedValue += intermediateValue.getCharValue();
            }
            while (cumulatedValue < valueToFormat) {
                result.append(unitValue.toString());
                cumulatedValue += unitValue.getCharValue();
            }
        }
    }

    private int isTheFour(IntergalacticChar unitValue, IntergalacticChar intermediateValue) {
        return intermediateValue.getCharValue() - unitValue.getCharValue();
    }

    private String generateTheFour(IntergalacticChar unitValue, IntergalacticChar intermediateValue) {
        return unitValue.toString() + intermediateValue.toString();
    }

    private int isTheNine(IntergalacticChar unitValue, IntergalacticChar nextUnitValue) {
        return nextUnitValue.getCharValue() - unitValue.getCharValue();
    }

    private String generateTheNine(IntergalacticChar unitValue, IntergalacticChar nextUnitValue) {
        return unitValue.toString() + nextUnitValue.toString();
    }

    private void thousandFormat(int cipher4, StringBuilder result) {
        result.append(
                "MMM".substring( 3 - cipher4 / 1000 )
        );
    }

}
