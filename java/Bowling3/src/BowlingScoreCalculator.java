public class BowlingScoreCalculator {
    public int calculate(String input) {
        int result = 0;
        for (int i = 0; i < input.toCharArray().length; i++) {
            char roll = input.toCharArray()[i];
            if (roll == 'X') {
                int numberOfBonusRolls = 2;
                result += calculateStrike(input.charAt(i+1), input.charAt(i+2));
                if (isLastFrame(input, i, numberOfBonusRolls)) {
                    return result;
                }
            } else if (roll == '/') {
                int numberOfBonusRolls = 1;
                result += calculateSpare(input.charAt(i - 1), input.charAt(i + 1));
                if (isLastFrame(input, i, numberOfBonusRolls)) {
                    return result;
                }
            } else {
                result += calculateRoll(roll);
            }
        }
        return result;
    }

    private boolean isLastFrame(String input, int i, int numberOfBonusRolls) {
        return input.length() == i + numberOfBonusRolls + 1;
    }

    private int calculateSpare(char prevRoll, char nextRoll) {
        return 10 - calculateRoll(prevRoll) + calculateRoll(nextRoll);
    }

    private int calculateStrike(char nextRoll, char lastRoll) {
        return 10 + calculateRoll(nextRoll)
                + calculateRoll(lastRoll);
    }

    private int calculateRoll(char roll) {
        if (roll == 'X') {
            return 10;
        }
        else if (roll == '-') {
            return 0;
        }
        return Integer.parseInt(String.valueOf(roll));
    }
}
