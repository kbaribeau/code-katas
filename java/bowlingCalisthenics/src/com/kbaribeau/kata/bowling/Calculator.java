package com.kbaribeau.kata.bowling;

public class Calculator {
    public int score(String input) {
        int result = 0;
        RollIterator rollIterator = new RollIterator(new RollCollection(input.toCharArray()));
        while (true) {
            Scorer currentRollScorer = ScorerFactory.create(rollIterator);
            result += currentRollScorer.score();
            if (rollIterator.atLastFrame()) {
                return result;
            }
            rollIterator = rollIterator.next();
        }

    }

}
