package com.kbaribeau.kata.bowling.scorer;

import com.kbaribeau.kata.bowling.RollIterator;

public abstract class Scorer {
    protected RollIterator rollIterator;

    public Scorer(RollIterator rollIterator) {
        this.rollIterator = rollIterator;
    }

    public abstract int score();
}
