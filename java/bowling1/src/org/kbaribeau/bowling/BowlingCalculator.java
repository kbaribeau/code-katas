package org.kbaribeau.bowling;

public class BowlingCalculator {
    public int calculate(String input) {
        int result = 0;
        char[] rolls = input.toCharArray();
        for (int i = 0; i < rolls.length; i++) {

            char c = rolls[i];
            if (c == 'X') {
                char nextBowl = findScoreForNextRoll(rolls, i);
                char twoBowlsFromNow = findScoreForNextRoll(rolls, i + 1);
                result += 10 + getScore(nextBowl) + getScore(twoBowlsFromNow);
                if (rolls.length == i + 3) {
                    return result;
                }
            } else if (Character.isDigit(c)) {
                int rollValue = getScore(c);
                result += rollValue;
                if (findScoreForNextRoll(rolls, i) == '/') {
                    result += 10 - rollValue;
                    result += getScore(findScoreForNextRoll(rolls, i + 1));
                    if (rolls.length == i + 3) {
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private int getScore(char bowl) {
        if (bowl == 'X') {
            return 10;
        } else if (Character.isDigit(bowl)) {
            return Integer.parseInt(String.valueOf(bowl));
        } else {
            return 0;
        }
    }

    private char findScoreForNextRoll(char[] rolls, int rollNumber) {
        return rolls.length > rollNumber + 1 ? rolls[rollNumber + 1] : '-';
    }
}
