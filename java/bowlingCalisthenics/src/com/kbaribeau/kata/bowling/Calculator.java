package com.kbaribeau.kata.bowling;

public class Calculator {
    public int score(String input) {
        int result = 0;
        char[] rolls = input.toCharArray();
        for (int i = 0; i < rolls.length; i++) {
            char c = rolls[i];
            if (c == '/') {
                result -= calculateScoreForSingleRoll(String.valueOf(rolls[i - 1]));
                result += 10;
                result += calculateScoreForSingleRoll(String.valueOf(rolls[i + 1]));
                if (i == rolls.length - 2) {
                    return result;
                }
            } else if (c == 'X') {
                if (rolls[i + 2] == '/') {
                    result += 20;
                } else {
                    result += 10;
                    result += calculateScoreForSingleRoll(String.valueOf(rolls[i + 1]));
                    result += calculateScoreForSingleRoll(String.valueOf(rolls[i + 2]));
                }
                if (i == rolls.length - 3) {
                    return result;
                }
            } else {
                result += calculateScoreForSingleRoll(String.valueOf(c));
            }
        }

        return result;
    }

    private int calculateScoreForSingleRoll(String inputStr) {
        if (inputStr.charAt(0) == 'X') {
            return 10;
        }
        return Integer.parseInt(inputStr);
    }
}
