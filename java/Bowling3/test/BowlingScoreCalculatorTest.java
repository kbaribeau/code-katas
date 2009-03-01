import org.junit.Assert;
import org.junit.Test;

public class BowlingScoreCalculatorTest {
    private BowlingScoreCalculator calculator = new BowlingScoreCalculator();

    @Test
    public void calculate_ShouldCalculateFrameWithNoStrikesOrSpares() {
        String input = "43";

        int result = calculator.calculate(input);

        Assert.assertEquals(7, result);
    }

    @Test
    public void calculate_ShouldCalculateFrameWithNoStrikesOrSpares2() {
        String input = "27";

        int result = calculator.calculate(input);

        Assert.assertEquals(9, result);
    }

    @Test
    public void calculate_ShouldCalculateFrameWithNoStrikesOrSpares3() {
        String input = "42";

        int result = calculator.calculate(input);

        Assert.assertEquals(6, result);
    }

    @Test
    public void calculate_ShouldCalculateFrameWithASpare() {
        String input = "4/2";

        int result = calculator.calculate(input);

        Assert.assertEquals(12, result);
    }

    @Test
    public void calculate_ShouldCalculateFrameWithASpare2() {
        String input = "2/8";

        int result = calculator.calculate(input);

        Assert.assertEquals(18, result);
    }

    @Test
    public void calculate_ShouldCalculateAStrike() {
        String input = "X28";

        int result = calculator.calculate(input);

        Assert.assertEquals(20, result);
    }

    @Test
    public void calculate_ShouldCalculateAStrike2() {
        String input = "X52";

        int result = calculator.calculate(input);

        Assert.assertEquals(17, result);
    }

    @Test
    public void calculate_ShouldCalculateAStrike_WhenThereIsAnotherFollowingStrike() {
        String input = "XX2";

        int result = calculator.calculate(input);

        Assert.assertEquals(22, result);
    }

    @Test
    public void calculate_ShouldCalculateAStrike_WhenThereAreThreeStrikes() {
        String input = "XXX";

        int result = calculator.calculate(input);

        Assert.assertEquals(30, result);
    }

    @Test
    public void calculate_ShouldCalculateASpare_WhenItIsFollowedByAStrike() {
        String input = "7/X";

        int result = calculator.calculate(input);

        Assert.assertEquals(20, result);
    }

    @Test
    public void calculate_ShouldCalculateTwoFrames() {
        String input = "7281";

        int result = calculator.calculate(input);

        Assert.assertEquals(18, result);
    }

    @Test
    public void calculate_ShouldCalculateTwoFrames_WhenThereIsASpareInFrame1() {
        String input = "7/81";

        int result = calculator.calculate(input);

        Assert.assertEquals(27, result);
    }

    @Test
    public void calculate_ShouldCalculateTwoFrames_WhenThereIsAStrikeInFrame1() {
        String input = "X7281";

        int result = calculator.calculate(input);

        Assert.assertEquals(37, result);
    }

    @Test
    public void calculate_ShouldCalculateTwoFrames_WhenThereIsAStrikeInFrame2() {
        String input = "72X12";

        int result = calculator.calculate(input);

        Assert.assertEquals(22, result);
    }

    @Test
    public void calculate_ShouldCalculatePerfectGame() {
        String input = "XXXXXXXXXXXX";

        int result = calculator.calculate(input);

        Assert.assertEquals(300, result);
    }

    @Test
    public void calculate_ShouldCalculateGameOf9s() {
        String input = "9-9-9-9-9-9-9-9-9-9-";

        int result = calculator.calculate(input);

        Assert.assertEquals(90, result);
    }

    @Test
    public void calculate_ShouldCalculateGameOf5sAndSpares() {
        String input = "5/5/5/5/5/5/5/5/5/5/5";

        int result = calculator.calculate(input);

        Assert.assertEquals(150, result);
    }


}
