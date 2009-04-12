package com.kbaribeau.kata.bowling;

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
