package com.kbaribeau.kata.bowling;

public class Calculator {
    public int score(String input) {
        int result = 0;
        Game game = new Game(input.toCharArray());
        for (int i = 0; i < game.length(); i++) {
            char c = game.getRoll(i);
            if (c == '/') {
                result -= calculateScoreForSingleRoll(String.valueOf(game.getRoll(i - 1)));
                result += 10;
                result += calculateScoreForSingleRoll(String.valueOf(game.getRoll(i + 1)));
                if (i == game.length() - 2) {
                    return result;
                }
            } else if (c == 'X') {
                if (game.getRoll(i + 2) == '/') {
                    result += 20;
                } else {
                    result += 10;
                    result += calculateScoreForSingleRoll(String.valueOf(game.getRoll(i + 1)));
                    result += calculateScoreForSingleRoll(String.valueOf(game.getRoll(i + 2)));
                }
                if (i == game.length() - 3) {
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
