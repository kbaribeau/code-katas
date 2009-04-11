package com.kbaribeau.kata.bowling;

public class Roll {
    private char roll;

    public Roll(char roll) {
        this.roll = roll;
    }

    public int calculateScore() {
        if (isStrike()) {
            return 10;
        }
        return Integer.parseInt(String.valueOf(roll));
    }

    public boolean isStrike() {
        return roll == 'X';
    }

    public boolean isSpare() {
        return roll == '/';
    }
}
