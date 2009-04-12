package com.kbaribeau.kata.bowling;

public class Calculator {
    public int score(String input) {
        int result = 0;
        GameIterator gameIterator = new GameIterator(new Game(input.toCharArray()));
        while (!gameIterator.atEnd()) {
            Roll currentRoll = gameIterator.getRoll();
            if (currentRoll.isStrike()) {
                if (gameIterator.next().next().getRoll().isSpare()) {
                    result += 20;
                } else {
                    result += 10;
                    result += gameIterator.next().getRoll().calculateScore();
                    result += gameIterator.next().next().getRoll().calculateScore();
                }
                if (gameIterator.next().next().next().atEnd()) {
                    return result;
                }
            } else if (currentRoll.isSpare()) {
                result -= gameIterator.prev().getRoll().calculateScore();
                result += 10;
                result += gameIterator.next().getRoll().calculateScore();
                if (gameIterator.next().next().atEnd()) {
                    return result;
                }
            } else {
                result += currentRoll.calculateScore();
            }
            gameIterator = gameIterator.next();
        }

        return result;
    }

}
