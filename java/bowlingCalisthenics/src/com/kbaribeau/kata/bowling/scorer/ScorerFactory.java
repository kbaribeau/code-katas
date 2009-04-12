package com.kbaribeau.kata.bowling.scorer;

import com.kbaribeau.kata.bowling.Roll;
import com.kbaribeau.kata.bowling.RollIterator;

public class ScorerFactory {
    public static Scorer create(RollIterator rollIterator) {
        Roll currentRoll = rollIterator.getRoll();
        if (currentRoll.isStrike()) {
            return new StrikeScorer(rollIterator);
        }
        if (currentRoll.isSpare()) {
            return new SpareScorer(rollIterator);
        }
        return new DefaultScorer(rollIterator);

    }
}
