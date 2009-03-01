public class BowlingCalculator {


    public int calculate(String input) {
        int result = 0;
        char[] rolls = input.toCharArray();
        for (int i = 0; i < rolls.length; i++) {
            char roll = rolls[i];
            if (roll == '/') {
                result += 10 -
                        calculateSingleRoll(getPrevRoll(rolls, i)) +
                        calculateSingleRoll(getNextRoll(rolls, i));
                if (rolls.length == i + 2) {
                    return result;
                }
            } else if (roll == 'X') {
                if (getTwoRollsAhead(rolls, i) == '/') {
                    result += 20;
                } else {
                    result += 10 +
                            calculateSingleRoll(getNextRoll(rolls, i)) +
                            calculateSingleRoll(getTwoRollsAhead(rolls, i));
                }
                if (rolls.length == i + 3) {
                    return result;
                }
            } else {
                result += calculateSingleRoll(roll);
            }
        }
        return result;
    }

    private char getTwoRollsAhead(char[] rolls, int i) {
        return rolls[i + 2];
    }

    private char getPrevRoll(char[] rolls, int i) {
        return rolls[i - 1];
    }

    private char getNextRoll(char[] rolls, int i) {
        return rolls[i + 1];
    }

    private int calculateSingleRoll(char roll) {
        if (roll == 'X') {
            return 10;
        }
        if (roll == '-') {
            return 0;
        }
        return Integer.parseInt(String.valueOf(roll));
    }
}
