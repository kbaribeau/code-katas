package com.kbaribeau.kata.bowling.scorer;

import com.kbaribeau.kata.bowling.RollIterator;

class SpareScorer extends Scorer {
    public SpareScorer(RollIterator rollIterator) {
        super(rollIterator);
    }

    public int score() {
        return 10 - rollIterator.prev().currentRollScore() + rollIterator.next().currentRollScore();
    }
}
