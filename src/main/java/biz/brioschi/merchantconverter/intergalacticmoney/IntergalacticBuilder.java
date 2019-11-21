package biz.brioschi.merchantconverter.intergalacticmoney;

import java.util.*;
import java.util.stream.Collectors;

class IntergalacticBuilder {

    Money buildFromIntergalacticString(String intergalacticString) throws IntergalacticMoneyException {

        if ( (intergalacticString == null) || ("".equals(intergalacticString)) ) {
            throw new IntergalacticMoneyException("Empty string isn't a valid intergalactic string");
        }

        List<IntergalacticChar> iChars = getIntergalacticChars(intergalacticString);
        validateIntergalacticCharSequence(iChars);
        int money = calculateMoneyValue(iChars);

        return new Money(money);

    }

    private List<IntergalacticChar> getIntergalacticChars(String intergalacticString) throws IntergalacticMoneyException {
        try {
            return intergalacticString
                    .chars()
                    .mapToObj(c -> IntergalacticChar.valueOf(String.valueOf((char) c)))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new IntergalacticMoneyException(e.getMessage());
        }
    }

    private void validateIntergalacticCharSequence(List<IntergalacticChar> iChars) throws IntergalacticMoneyException {

        Set<IntergalacticChar> alreadySubtractedIntergalacticChar = new HashSet<>();
        int currentCharOccurrences = 0;

        checkCharactersWithOnlyAnOccurrence(iChars);

        int i = 0;
        while ( i < iChars.size() - 1 ) {

            IntergalacticChar currentChar = iChars.get(i);
            IntergalacticChar nextChar = iChars.get(i + 1);

            if (currentChar.getCharValue() < nextChar.getCharValue()) {

                checkASequenceOfMoreOneCharacterSubtracted(currentCharOccurrences, currentChar);
                checkInvalidCharacterSubtraction(currentChar, nextChar);
                checkCharacterAlreadySubtracted(alreadySubtractedIntergalacticChar, currentChar);
                if (i < (iChars.size() - 2)) {
                    IntergalacticChar nextNextChar = iChars.get(i + 2);
                    checkIsADecreasingSequence(currentChar, nextNextChar);
                    ++i;
                }

            } else if (currentChar.getCharValue() == nextChar.getCharValue()) {
                currentCharOccurrences = validateOccurrences(currentCharOccurrences, currentChar);
            } else if (currentChar.getCharValue() > nextChar.getCharValue()) {
                currentCharOccurrences = 0;
            }

            ++i;
        }

    }

    private void checkCharactersWithOnlyAnOccurrence(List<IntergalacticChar> iChars) throws IntergalacticMoneyException {
        Map<IntergalacticChar, Integer> occurrences = new HashMap<>();
        for (IntergalacticChar singleChar : IntergalacticChar.values()) {
            if (singleChar.getMaxOccurrences() == 1) {
                occurrences.put(singleChar, 1);
            }
        }
        for (IntergalacticChar singleChar : iChars) {
            if (occurrences.containsKey(singleChar)) {
                occurrences.put( singleChar, occurrences.get(singleChar) - 1 );
                if (occurrences.get(singleChar) < 0) {
                    throw new IntergalacticMoneyException("The symbol '" + singleChar.name() + "' have too many occurrences");
                }
            }
        }
    }

    private int validateOccurrences(int currentCharOccurrences, IntergalacticChar currentChar) throws IntergalacticMoneyException {
        if (++currentCharOccurrences >= currentChar.getMaxOccurrences()) {
            throw new IntergalacticMoneyException("Too many occurrences for the symbol '" + currentChar.name() + "'");
        }
        return currentCharOccurrences;
    }

    private void checkIsADecreasingSequence(IntergalacticChar currentChar, IntergalacticChar nextNextChar) throws IntergalacticMoneyException {
        if (nextNextChar.getCharValue() >= currentChar.getCharValue()) {
            throw new IntergalacticMoneyException("The symbol '" + nextNextChar.name() + "' can't follow the symbol '" + currentChar.name() + "'");
        }
    }

    private void checkCharacterAlreadySubtracted(Set<IntergalacticChar> alreadySubtractedIntergalacticChar, IntergalacticChar currentChar) throws IntergalacticMoneyException {
        if (alreadySubtractedIntergalacticChar.contains(currentChar)) {
            throw new IntergalacticMoneyException("The symbol '" + currentChar.name() + "' is subtracted too many times");
        } else {
            alreadySubtractedIntergalacticChar.add(currentChar);
        }
    }

    private void checkInvalidCharacterSubtraction(IntergalacticChar currentChar, IntergalacticChar nextChar) throws IntergalacticMoneyException {
        if (nextChar.getCanSubtractChar() != currentChar) {
            throw new IntergalacticMoneyException("The symbol '" + currentChar.name() + "' can't be subtracted from the symbol '" + nextChar.name() + "'");
        }
    }

    private void checkASequenceOfMoreOneCharacterSubtracted(int currentCharOccurrences, IntergalacticChar currentChar) throws IntergalacticMoneyException {
        if (currentCharOccurrences > 0) {
            throw new IntergalacticMoneyException("The symbol '" + currentChar.name() + "' is subtracted in sequence");
        }
    }

    private int calculateMoneyValue(List<IntergalacticChar> iChars) {

        int value = 0;

        int i = 0;
        while ( i < iChars.size() ) {

            IntergalacticChar currentChar = iChars.get(i);
            IntergalacticChar nextChar = (i < iChars.size() - 1)?iChars.get(i + 1):null;

            if ( (nextChar != null) && (nextChar.getCanSubtractChar() == currentChar) ) {
                value -= currentChar.getCharValue();
                value += nextChar.getCharValue();
                i += 2;
            } else {
                value += currentChar.getCharValue();
                i += 1;
            }

        }

        return value;

    }

}