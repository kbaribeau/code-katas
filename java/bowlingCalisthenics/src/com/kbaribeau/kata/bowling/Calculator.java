package com.kbaribeau.kata.bowling;

public class Calculator {
    public int score(String input) {
        int result = 0;
        Game game = new Game(input.toCharArray());
        for (int i = 0; i < game.length(); i++) {
            Roll currentRoll = game.getRoll(i);
            if (currentRoll.isStrike()) {
                if (game.getRoll(i + 2).isSpare()) {
                    result += 20;
                } else {
                    result += 10;
                    result += game.getRoll(i + 1).calculateScore();
                    result += game.getRoll(i + 2).calculateScore();
                }
                if (i == game.length() - 3) {
                    return result;
                }
            } else if (currentRoll.isSpare()) {
                result -= game.getRoll(i - 1).calculateScore();
                result += 10;
                result += game.getRoll(i + 1).calculateScore();
                if (i == game.length() - 2) {
                    return result;
                }
            } else {
                result += currentRoll.calculateScore();
            }
        }

        return result;
    }

}
