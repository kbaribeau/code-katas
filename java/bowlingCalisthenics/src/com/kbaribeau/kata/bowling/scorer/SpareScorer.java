package com.kbaribeau.kata.bowling.scorer;

import com.kbaribeau.kata.bowling.RollIterator;

class SpareScorer extends Scorer {
    public SpareScorer(RollIterator rollIterator) {
        super(rollIterator);
    }

    public int score() {
        RollIterator previousRoll = rollIterator.prev();
        RollIterator nextRoll = rollIterator.next();
        return 10 - previousRoll.score() + nextRoll.score();
    }
}
