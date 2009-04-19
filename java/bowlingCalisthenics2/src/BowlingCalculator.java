public class BowlingCalculator {


    public int calculate(String input) {
        int result = 0;
        Rolls rolls = new Rolls(input.toCharArray());
        for (int i = 0; i < rolls.length(); i++) {
            Roll roll = rolls.rollAt(i);
            if (roll.isSpare()) {

                result += 10 -
                        rolls.rollAt(i - 1).score() +
                        rolls.rollAt(i + 1).score();
                if (rolls.length() == i + 2) {
                    return result;
                }
            } else if (roll.isStrike()) {
                Roll twoRollsFromNow = rolls.rollAt(i + 2);
                if (twoRollsFromNow.isSpare()) {
                    result += 20;
                } else {

                    result += 10 +
                            rolls.rollAt(i + 1).score() +
                            twoRollsFromNow.score();
                }
                if (rolls.length() == i + 3) {
                    return result;
                }
            } else {

                result += roll.score();
            }
        }
        return result;
    }

}
