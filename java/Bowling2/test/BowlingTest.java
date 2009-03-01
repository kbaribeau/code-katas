import org.junit.Test;
import org.junit.Assert;

public class BowlingTest {

    Bowling bowling = new Bowling();

    @Test
    public void bowling_ShouldCalculateSingleFrame_WhenThereAreNoStrikesOrSpares() {
        String input = "27";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(9, result);
    }

    @Test
    public void bowling_ShouldCalculateSingleFrame_WhenThereAreNoStrikesOrSpares2() {
        String input = "51";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(6, result);
    }

    @Test
    public void bowling_ShouldCalculateSingleFrame_WhenThereAreNoStrikesOrSpares3() {
        String input = "73";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(10, result);
    }

    @Test
    public void bowling_ShouldCalculateSingleFrame_WhenThereIsASpare() {
        String input = "7/2";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(12, result);
    }

    @Test
    public void bowling_ShouldCalculateSingleFrame_WhenThereIsASpare2() {
        String input = "2/5";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(15, result);
    }

    @Test
    public void bowling_ShouldCalculateSingleFrame_WhenThereIsASpare3() {
        String input = "4/7";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(17, result);
    }

    @Test
    public void bowling_ShouldCalculateOneFrame_WhenThereIsAStrike() {
        String input = "X12";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(16, result);
    }

    @Test
    public void bowling_ShouldCalculateOneFrame_WhenThereIsAStrike2() {
        String input = "X37";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(30, result);
    }

    @Test
    public void bowling_ShouldCalculateThreeFrames_WhenThereIsAStrikeFollowedByASpare() {
        String input = "X3/2";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(42, result);
    }

    @Test
    public void bowling_ShouldCalcualateScore_WhenThereIsASpareFollowedByAStrike() {
        String input = "3/X45";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(48, result);
    }

    @Test
    public void bowling_ShouldCalculateScore_WhenThereAreMultipleSpares() {
        String input = "3/3/5";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(28, result);
    }

    @Test
    public void bowling_ShouldCalculateScore_WhenThereAreMultipleStrikes() {
        String input = "XX45";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(52, result);
    }

    @Test
    public void bowling_ShouldCalculateScore_WhenThereIsAStrikeNearTheEnd() {
        String input = "3/X";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(20, result);
    }

    @Test
    public void bowling_ShouldCalculateScore_ForThreeStrikes() {
        String input = "XXX";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(30, result);
    }

    @Test
    public void bowling_ShouldCalculateScore_ForPerfectGame() {
        String input = "XXXXXXXXXXXX";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(300, result);    
    }

    @Test
    public void bowling_ShouldCalculateScore_WhenThereIsGutterBall(){
        String input = "9-";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(9, result);
    }

    @Test
    public void bowling_ShouldCalculateScore_ForGameWithOneGutterInEachFrame() {
        String input = "9-9-9-9-9-9-9-9-9-9-";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(90, result);    
    }

    @Test
    public void bowling_ShouldCalculateScore_ForGameWithOneSpareInEachFrame() {
        String input = "5/5/5/5/5/5/5/5/5/5/5";

        int result = bowling.calculateScore(input);

        Assert.assertEquals(150, result);
    }
}
