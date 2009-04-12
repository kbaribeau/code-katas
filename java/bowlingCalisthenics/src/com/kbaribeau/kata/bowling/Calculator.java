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
                    GameIterator nextRoll = gameIterator.next();
                    result += nextRoll.currentRollScore();
                    result += nextRoll.next().currentRollScore();
                }
                if (gameIterator.atLastFrame()) {
                    return result;
                }
            } else if (currentRoll.isSpare()) {
                result -= gameIterator.prev().currentRollScore();
                result += 10;
                result += gameIterator.next().currentRollScore();
                if (gameIterator.atLastFrame()) {
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
