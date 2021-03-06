package com.kbaribeau.kata.bowling;

import com.kbaribeau.kata.bowling.scorer.Scorer;
import com.kbaribeau.kata.bowling.scorer.ScorerFactory;

public class Calculator {
    public int score(String input) {
        int result = 0;
        RollIterator rollIterator = new RollIterator(new RollCollection(input.toCharArray()));
        do {
            rollIterator = rollIterator.next();
            Scorer currentRollScorer = ScorerFactory.create(rollIterator);
            result += currentRollScorer.score();
        } while (!rollIterator.atLastFrame());

        return result;
    }

}
