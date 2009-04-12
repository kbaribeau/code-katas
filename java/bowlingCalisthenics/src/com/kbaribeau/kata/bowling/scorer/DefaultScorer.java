package com.kbaribeau.kata.bowling.scorer;

import com.kbaribeau.kata.bowling.RollIterator;

class DefaultScorer extends Scorer {
    public DefaultScorer(RollIterator rollIterator) {
        super(rollIterator);
    }

    public int score() {
        return rollIterator.currentRollScore();
    }
}
