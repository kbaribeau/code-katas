package com.kbaribeau.kata.bowling.scorer;

import com.kbaribeau.kata.bowling.RollIterator;

public class ScorerFactory {
    public static Scorer create(RollIterator rollIterator) {
        if (rollIterator.getRoll().isStrike()) {
            return new StrikeScorer(rollIterator);
        } else if (rollIterator.getRoll().isSpare()) {
            return new SpareScorer(rollIterator);
        } else {
            return new DefaultScorer(rollIterator);
        }
    }
}
