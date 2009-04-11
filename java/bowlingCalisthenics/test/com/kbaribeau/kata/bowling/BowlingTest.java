package com.kbaribeau.kata.bowling;

import org.junit.Test;
import org.junit.Assert;

public class BowlingTest {
    private Calculator calculator = new Calculator();

    @Test
    public void calculator_ShouldScoreGameWithSingleRoll() {
        String input = "2";

        int score = calculator.score(input);

        Assert.assertEquals(2, score);
    }

    @Test
    public void calculator_ShouldScoreGameWithSingleRoll2() {
        String input = "7";

        int score = calculator.score(input);

        Assert.assertEquals(7, score);
    }

    @Test
    public void calculator_ShouldScoreGameWithSeveralRolls() {
        String input = "7264";

        int score = calculator.score(input);

        Assert.assertEquals(19, score);
    }

    @Test
    public void calculator_ShouldScoreGameWithSpare() {
        String input = "1/2";

        int score = calculator.score(input);

        Assert.assertEquals(12, score);
    }

    @Test
    public void calculator_ShouldScoreGameWithStrike() {
        String input = "X12";

        int score = calculator.score(input);

        Assert.assertEquals(13, score);
    }

    @Test
    public void calculator_ShouldScoreGameWithStrikeInEarlyFrame() {
        String input = "X1212";

        int score = calculator.score(input);

        Assert.assertEquals(19, score);
    }

    @Test
    public void calculator_ShouldScoreGameWithSpareInEarlyFrame() {
        String input = "1/121";

        int score = calculator.score(input);

        Assert.assertEquals(15, score);
    }

    @Test
    public void calculator_ShouldScoreGameWithStrikeFollowedBySpare() {
        String input = "X1/1";

        int score = calculator.score(input);

        Assert.assertEquals(31, score);
    }

    @Test
    public void calculator_ShouldScoreGameWithSpareFollowedByStrike() {
        String input = "1/X12";

        int score = calculator.score(input);

        Assert.assertEquals(33, score);
    }
}
