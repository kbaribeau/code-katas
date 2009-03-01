import org.junit.Assert;
import org.junit.Test;
import org.kbaribeau.bowling.BowlingCalculator;

public class BowlingTest {
    private BowlingCalculator bowlingCalculator = new BowlingCalculator();

    @Test
    public void bowling_ShouldCalculateOneStrike() {
        String input = "X";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(10, result);
    }

    @Test
    public void bowling_ShouldCalculateOneFrame_WhenThereAreThreeStrikes() {
        String input = "XXX";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(30, result);


    }

    @Test
    public void bowling_ShouldCalculateOneFrame_WhenThereAreTwoStrikesAndAGutter() {
        String input = "XX-";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(20, result);

    }

    @Test
    public void bowling_ShouldCalculateOneFrame_WhenThereIsOneStrikeAndTwoGutters() {
        String input = "X--";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(10, result);

    }

    @Test
    public void bowling_ShouldCalculateOneFrame_WhenThereAreSingleRolls() {
        String input = "53";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(8, result);

    }

    @Test
    public void bowling_ShouldCalculateOneFrame_WhenThereAreSingleRolls2() {
        String input = "27";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(9, result);

    }

    @Test
    public void bowling_ShouldCalculateSpares_WhenNextRollIsADigit() {
        String input = "2/3";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(13, result);

    }

    @Test
    public void bowling_ShouldCalculateMultipleFrames() {
        String input = "1234";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(10, result);
    }

    @Test
    public void bowling_ShouldCalculateMultipleFrames_WhenThereIsAStrikeInFrameOne() {
        String input = "X123";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(19, result);
    }


    @Test
    public void bowling_ShouldCalculateSpares_WhenNextRollIsAnotherSpare() {
        String input = "1/2/3";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(25, result);
    }

    @Test
    public void bowling_ShouldCalculateSpares_WhenNextRollIsAStrike() {
        String input = "1/X32";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(35, result);
    }

    @Test
    public void bowling_ShouldCalculatePerfectGame() {
        String input = "XXXXXXXXXXXX";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(300, result);
    }

    @Test
    public void bowling_ShouldCalculateAlmostPerfectGame() {
        String input = "XXXXXXXXXXX9";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(299, result); //is this right?
    }

    @Test
    public void bowling_ShouldCalculateAll9s() {
        String input = "9-9-9-9-9-9-9-9-9-9-";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(90, result);
    }

    @Test
    public void bowling_ShouldCalculateAll5sAndSpares() {
        String input = "5/5/5/5/5/5/5/5/5/5/5";

        int result = bowlingCalculator.calculate(input);

        Assert.assertEquals(150, result);
    }

    


}
