import junit.framework.Assert;
import org.junit.Test;

public class BowlingCalculatorTest {

    private BowlingCalculator calculator = new BowlingCalculator();

    @Test
    public void calculate_ShouldCalcualateSingleFrame() {
        String input = "42";

        int result = calculator.calculate(input);

        Assert.assertEquals(6, result);
    }

    @Test
    public void calculate_ShouldCalcualateSingleFrame2() {
        String input = "27";

        int result = calculator.calculate(input);

        Assert.assertEquals(9, result);
    }


    @Test
    public void calculate_ShouldCalcualateSingleFrame3() {
        String input = "18";

        int result = calculator.calculate(input);

        Assert.assertEquals(9, result);
    }

    @Test
    public void calculate_ShouldCalcualateSingleFrame_WhenThereIsASpare() {
        String input = "1/5";

        int result = calculator.calculate(input);

        Assert.assertEquals(15, result);
    }

    @Test
    public void calculate_ShouldCalcualateSingleFrame_WhenThereIsASpare2() {
        String input = "1/7";

        int result = calculator.calculate(input);

        Assert.assertEquals(17, result);
    }

    @Test
    public void calculate_ShouldCalcualateTwoFrames_WhenThereIsASpareInFrame1() {
        String input = "1/72";

        int result = calculator.calculate(input);

        Assert.assertEquals(26, result);
    }

    @Test
    public void calcualte_ShouldCalculateSingleFrame_WhenThereIsAStrike() {
        String input = "X12";

        int result = calculator.calculate(input);

        Assert.assertEquals(13, result);
    }

    @Test
    public void calcualte_ShouldCalculateThreeFrames_WhenThereIsAStrikeInFrameOne() {
        String input = "X1272";

        int result = calculator.calculate(input);

        Assert.assertEquals(25, result);
    }

    @Test
    public void calcualte_ShouldCalculateResult_WhenThereIsASpareFollowedByAStrike() {
        String input = "1/X12";

        int result = calculator.calculate(input);

        Assert.assertEquals(33, result);
    }

    @Test
    public void calcualte_ShouldCalculateResult_WhenThereIsAStrikeFollowedByASpare() {
        String input = "X1/4";

        int result = calculator.calculate(input);

        Assert.assertEquals(34, result);
    }

    @Test
    public void calculate_ShouldCalculateSingleFrame_WhenThereIsAGutterBall() {
        String input = "1-";

        int result = calculator.calculate(input);

        Assert.assertEquals(1, result);
    }

    @Test
    public void calculate_ShouldCalculateSingleFrame_WhenThereIsAGutterBallAfterAStrike() {
        String input = "X1-";

        int result = calculator.calculate(input);

        Assert.assertEquals(11, result);
    }

    @Test
    public void calculate_ShouldCalculateSingleFrame_WhenThereIsAGutterBallAfterASpare() {
        String input = "1/-";

        int result = calculator.calculate(input);

        Assert.assertEquals(10, result);
    }

    @Test
    public void calculate_ShouldCalculatePerfectGame() {
        String input = "XXXXXXXXXXXX";

        int result = calculator.calculate(input);

        Assert.assertEquals(300, result);
    }


        @Test
    public void calculate_ShouldCalculateGame_WhenThereAreLotsOfSpares() {
        String input = "5/5/5/5/5/5/5/5/5/5/5";

        int result = calculator.calculate(input);

        Assert.assertEquals(150, result);
    }


        @Test
    public void calculate_ShouldCalculateGame_WhenThereAreGutterBalls() {
        String input = "8-8-8-8-8-8--88-8-8-";

        int result = calculator.calculate(input);

        Assert.assertEquals(80, result);
    }

}
