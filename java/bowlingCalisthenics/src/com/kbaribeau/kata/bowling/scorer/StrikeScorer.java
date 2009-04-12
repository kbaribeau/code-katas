package com.kbaribeau.kata.bowling.scorer;

import com.kbaribeau.kata.bowling.RollIterator;

class StrikeScorer extends Scorer {
    public StrikeScorer(RollIterator rollIterator) {
        super(rollIterator);
    }

    public int score() {
        if (rollIterator.next().next().currentRoll().isSpare()) {
            return 20;
        }

        RollIterator nextRoll = rollIterator.next();
        return 10 + nextRoll.score() + nextRoll.next().score();
    }
}
