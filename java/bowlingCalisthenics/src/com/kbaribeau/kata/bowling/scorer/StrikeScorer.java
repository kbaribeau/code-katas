package com.kbaribeau.kata.bowling.scorer;

import com.kbaribeau.kata.bowling.RollIterator;

class StrikeScorer extends Scorer {
    public StrikeScorer(RollIterator rollIterator) {
        super(rollIterator);
    }

    public int score() {
        int result = 0;
        if (rollIterator.next().next().getRoll().isSpare()) {
            result += 20;
        } else {
            result += 10;
            RollIterator nextRoll = rollIterator.next();
            result += nextRoll.currentRollScore();
            result += nextRoll.next().currentRollScore();
        }
        return result;
    }
}
