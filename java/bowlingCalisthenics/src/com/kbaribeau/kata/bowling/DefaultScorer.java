package com.kbaribeau.kata.bowling;

public class DefaultScorer extends Scorer {
    public DefaultScorer(RollIterator rollIterator) {
        super(rollIterator);
    }

    public int score() {
        return rollIterator.currentRollScore();
    }
}
