package com.kbaribeau.kata.bowling;

public class RollIterator {

    private RollCollection rollCollection;
    private int rollIndex = 0;

    public RollIterator(RollCollection rollCollection) {
        this.rollCollection = rollCollection;
    }

    private RollIterator(RollCollection rollCollection, int rollIndex) {
        this.rollCollection = rollCollection;
        this.rollIndex = rollIndex;
    }

    public boolean atEnd() {
        return rollCollection.length() == rollIndex;
    }

    public Roll getRoll() {
        return rollCollection.getRoll(rollIndex);
    }

    public RollIterator next() {
        return new RollIterator(rollCollection, rollIndex + 1);
    }

    public RollIterator prev() {
        return new RollIterator(rollCollection, rollIndex - 1);
    }

    public int currentRollScore() {
        return getRoll().calculateScore();
    }

    public boolean atLastFrame() {
        int distanceToEnd = getRoll().isSpare() ? 2 : 3;
        return rollIndex + distanceToEnd == rollCollection.length();

    }
}
