package com.kbaribeau.kata.bowling;

public abstract class Scorer {
    protected RollIterator rollIterator;

    public Scorer(RollIterator rollIterator) {
        this.rollIterator = rollIterator;
    }

    public abstract int score();
}
