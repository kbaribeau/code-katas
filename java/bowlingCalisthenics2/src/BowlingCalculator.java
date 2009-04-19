public class BowlingCalculator {


    public int calculate(String input) {
        int result = 0;
        char[] rolls = input.toCharArray();
        for (int i = 0; i < rolls.length; i++) {
            Roll roll = new Roll(rolls[i]);
            if (roll.isSpare()) {

                result += 10 -
                        new Roll(rolls[i - 1]).score() +
                        new Roll(rolls[i + 1]).score();
                if (rolls.length == i + 2) {
                    return result;
                }
            } else if (roll.isStrike()) {
                Roll twoRollsFromNow = new Roll(rolls[i + 2]);
                if (twoRollsFromNow.isSpare()) {
                    result += 20;
                } else {

                    result += 10 +
                            new Roll(rolls[i + 1]).score() +
                            twoRollsFromNow.score();
                }
                if (rolls.length == i + 3) {
                    return result;
                }
            } else {

                result += roll.score();
            }
        }
        return result;
    }

}
