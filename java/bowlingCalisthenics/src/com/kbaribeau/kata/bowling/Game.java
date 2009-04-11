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
        return new Roll(rolls[i]);
    }
}
