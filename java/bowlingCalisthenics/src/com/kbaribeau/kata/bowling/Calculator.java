package com.kbaribeau.kata.bowling;

public class Calculator {
    public int score(String input) {
        int result = 0;
        Game game = new Game(input.toCharArray());
        for (int i = 0; i < game.length(); i++) {
            char c = game.getRoll(i).getValue();
            if (c == '/') {
                result -= calculateScoreForSingleRoll(game.getRoll(i - 1));
                result += 10;
                result += calculateScoreForSingleRoll(game.getRoll(i + 1));
                if (i == game.length() - 2) {
                    return result;
                }
            } else if (c == 'X') {
                if (game.getRoll(i + 2).getValue() == '/') {
                    result += 20;
                } else {
                    result += 10;
                    result += calculateScoreForSingleRoll(game.getRoll(i + 1));
                    result += calculateScoreForSingleRoll(game.getRoll(i + 2));
                }
                if (i == game.length() - 3) {
                    return result;
                }
            } else {
                result += calculateScoreForSingleRoll(game.getRoll(i));
            }
        }

        return result;
    }

    private int calculateScoreForSingleRoll(Roll inputStr) {
        if (inputStr.getValue() == 'X') {
            return 10;
        }
        return Integer.parseInt(String.valueOf(inputStr.getValue()));
    }
}
