package com.kbaribeau.kata.bowling;

public class Game {

    private char[] rolls;

    public Game(char[] rolls) {
        this.rolls = rolls;
    }

    public int length() {
        return rolls.length;
    }

    public Roll getRoll(int i) {
        char roll = rolls[i];
        if (roll == '/') {
            return new Spare(roll);
        }
        if (roll == 'X') {
            return new Strike(roll);
        }
        return new Roll(rolls[i]);
    }
}
