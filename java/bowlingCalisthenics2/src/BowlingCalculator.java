public class BowlingCalculator {


    public int calculate(String input) {
        int result = 0;
        RollCollection rollCollection = new RollCollection(input.toCharArray());
        for (int i = 0; i < rollCollection.length(); i++) {
            Roll roll = rollCollection.rollAt(i);
            if (roll.isSpare()) {

                result += 10 -
                        rollCollection.rollAt(i - 1).score() +
                        rollCollection.rollAt(i + 1).score();
                if (rollCollection.rollInLastFrame(i)) {
                    return result;
                }
            } else if (roll.isStrike()) {
                Roll twoRollsFromNow = rollCollection.rollAt(i + 2);
                if (twoRollsFromNow.isSpare()) {
                    result += 20;
                } else {

                    result += 10 +
                            rollCollection.rollAt(i + 1).score() +
                            twoRollsFromNow.score();
                }
                if (rollCollection.rollInLastFrame(i)) {
                    return result;
                }
            } else {
                result += roll.score();
            }
        }
        return result;
    }

}
