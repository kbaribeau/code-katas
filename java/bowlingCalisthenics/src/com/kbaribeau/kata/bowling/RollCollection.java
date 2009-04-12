package com.kbaribeau.kata.bowling;

public class RollCollection {

    private char[] rolls;

    public RollCollection(char[] rolls) {
        this.rolls = rolls;
    }

    public int length() {
        return rolls.length;
    }

    public Roll getRoll(int i) {
        return new Roll(rolls[i]);
    }
}
