package com.kbaribeau.kata.bowling;

public class Calculator {
    public int score(String input) {
        int result = 0;
        RollIterator rollIterator = new RollIterator(new RollCollection(input.toCharArray()));
        while (!rollIterator.atEnd()) {
            Roll currentRoll = rollIterator.getRoll();
            if (currentRoll.isStrike()) {
                if (rollIterator.next().next().getRoll().isSpare()) {
                    result += 20;
                } else {
                    result += 10;
                    RollIterator nextRoll = rollIterator.next();
                    result += nextRoll.currentRollScore();
                    result += nextRoll.next().currentRollScore();
                }

                if (rollIterator.atLastFrame()) {
                    return result;
                }
            } else if (currentRoll.isSpare()) {
                result -= rollIterator.prev().currentRollScore();
                result += 10;
                result += rollIterator.next().currentRollScore();

                if (rollIterator.atLastFrame()) {
                    return result;
                }
            } else {
                result += currentRoll.calculateScore();
            }
            rollIterator = rollIterator.next();
        }

        return result;
    }

}
