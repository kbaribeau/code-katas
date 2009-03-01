import org.junit.Test;
import org.junit.Assert;
import org.kbaribeau.bowlingCalculator.BowlingCalculator;

public class BowlingCalculatorTest {

    BowlingCalculator calc = new BowlingCalculator();

    @Test
    public void calculate_ShouldCalculateSingleFrame_WhenThereAreNoStrikesOrSpares() {
        String game = "72";

        int result = calc.calculate(game);

        Assert.assertEquals(9, result);
    }


    @Test
    public void calculate_ShouldCalculateSingleFrame_WhenThereAreNoStrikesOrSpares2() {
        String game = "42";

        int result = calc.calculate(game);

        Assert.assertEquals(6, result);
    }


    @Test
    public void calculate_ShouldCalculateSingleFrame_WhenThereAreNoStrikesOrSpares3() {
        String game = "81";

        int result = calc.calculate(game);

        Assert.assertEquals(9, result);
    }

    @Test
    public void calculate_ShouldCalculateLastFrame_WhenThereIsASpare() {
        String game = "8/2";

        int result = calc.calculate(game);

        Assert.assertEquals(12, result);
    }

    @Test
    public void calculate_ShouldCalculateTwoFrames_WhenThereIsASpareInTheFirstFrame() {
        String game = "8/25";

        int result = calc.calculate(game);

        Assert.assertEquals(19, result);
    }

    @Test
    public void calculate_ShouldCalculateOneFrame_WhenThereIsAStrike() {
        String game = "X25";

        int result = calc.calculate(game);

        Assert.assertEquals(17, result);
    }

    @Test
    public void calculate_ShouldCalculateThreeFrames_WhenThereIsAStrikeInTheFirstFrame() {
        String game = "X2572";

        int result = calc.calculate(game);

        Assert.assertEquals(33, result);
    }

    @Test
    public void calculate_ShouldCalculateGutterBalls() {
        String game = "7-";

        int result = calc.calculate(game);

        Assert.assertEquals(7, result);            
    }

    @Test
    public void calculate_ShouldCalculateTwoFrames_WhenThereIsASpareFollowedByAStrike() {
        String game = "7/X23";

        int result = calc.calculate(game);

        Assert.assertEquals(35, result);
    }

    @Test
    public void calculate_ShouldCalculateTwoFrames_WhenThereIsAStrikeFollowedByASpare() {
        String game = "X2/3";

        int result = calc.calculate(game);

        Assert.assertEquals(33, result);
    }

    @Test
    public void calculate_ShouldCalculatePerfectGame() {
        String game = "XXXXXXXXXXXX";

        int result = calc.calculate(game);

        Assert.assertEquals(300, result);
    }

    @Test
    public void calculate_ShouldCalculateGameWith5sAndSpares() {
        String game = "5/5/5/5/5/5/5/5/5/5/5";

        int result = calc.calculate(game);

        Assert.assertEquals(150, result);
    }

    @Test
    public void calculate_ShouldCalculateGameWith9sAndGutters() {
        String game = "9-9-9-9-9-9-9-9-9-9-";

        int result = calc.calculate(game);

        Assert.assertEquals(90, result);
    }
}
