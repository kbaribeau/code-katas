package com.kbaribeau.kata.bowling;

public class GameIterator {

    private Game game;
    private int rollIndex = 0;

    public GameIterator(Game game) {
        this.game = game;
    }

    private GameIterator(Game game, int rollIndex) {
        this.game = game;
        this.rollIndex = rollIndex;
    }

    public boolean atEnd() {
        return game.length() == rollIndex;
    }

    public Roll getRoll() {
        return game.getRoll(rollIndex);
    }

    public GameIterator next() {
        return new GameIterator(game, rollIndex + 1);
    }

    public GameIterator prev() {
        return new GameIterator(game, rollIndex - 1);
    }
}
