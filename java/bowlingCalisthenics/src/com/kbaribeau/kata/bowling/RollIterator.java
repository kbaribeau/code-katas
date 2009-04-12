package com.kbaribeau.kata.bowling;

public class RollIterator {

    private RollCollection rollCollection;
    private int rollIndex = -1;

    public RollIterator(RollCollection rollCollection) {
        this.rollCollection = rollCollection;
    }

    private RollIterator(RollCollection rollCollection, int rollIndex) {
        this.rollCollection = rollCollection;
        this.rollIndex = rollIndex;
    }

    public Roll roll() {
        return rollCollection.rollAt(rollIndex);
    }

    public RollIterator next() {
        return new RollIterator(rollCollection, rollIndex + 1);
    }

    public RollIterator prev() {
        return new RollIterator(rollCollection, rollIndex - 1);
    }

    public int score() {
        return roll().calculateScore();
    }

    public boolean atLastFrame() {
        return rollIndex + roll().distanceToEnd() == rollCollection.length();

    }
}
