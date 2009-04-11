package com.kbaribeau.kata.bowling;

public class Roll {
    private char roll;

    public Roll(char roll) {
        this.roll = roll;
    }

    public char getValue() {
        return roll;
    }

    public int calculateScoreForSingleRoll() {
        if (getValue() == 'X') {
            return 10;
        }
        return Integer.parseInt(String.valueOf(getValue()));
    }
}
