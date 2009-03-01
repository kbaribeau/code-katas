package org.kbaribeau.bowlingCalculator;

public class BowlingCalculator {
    public int calculate(String game) {
        int result = 0;
        for (int i = 0; i < game.length(); i++) {

            char roll = game.charAt(i);
            if (roll == '/') {
                char prevRoll = game.charAt(i - 1);
                char nextRoll = game.charAt(i + 1);
                result += 10 - calculateSingleRoll(prevRoll) + calculateSingleRoll(nextRoll);
                if (game.length() == i + 2) {
                    return result;
                }

            } else if (roll == 'X') {
                char nextRoll = game.charAt(i + 1);
                char twoRollsFromNow = game.charAt(i + 2);
                if (twoRollsFromNow == '/') {
                    result += 20;
                } else {
                    result += 10 + calculateSingleRoll(nextRoll) + calculateSingleRoll(twoRollsFromNow);
                }
                if (game.length() == i + 3) {
                    return result;
                }
            } else {
                result += calculateSingleRoll(roll);
            }
        }
        return result;
    }

    private int calculateSingleRoll(char c) {
        if (c == '-') return 0;
        if (c == 'X') return 10;
        return Integer.parseInt(String.valueOf(c));
    }
}
