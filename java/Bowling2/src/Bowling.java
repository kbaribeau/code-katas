public class Bowling {
    public int calculateScore(String input) {
        int result = 0;

        for (int i = 0; i < input.toCharArray().length; i++) {
            char roll = input.toCharArray()[i];
            if (roll == '/') {
                char nextRoll = input.charAt(i + 1);
                char prevRoll = input.charAt(i - 1);
                int thisRollValue = 10 - calculateSingleRoll(prevRoll);
                result += nextRoll == 'X' ? thisRollValue + 10 : thisRollValue + calculateSingleRoll(nextRoll);
                if (input.length() == i+2) {
                    break;
                }
            } else if (roll == 'X') {
                result += calculateStrike(input, i);
            } else {
                result += calculateSingleRoll(roll);
            }
        }
        return result;
    }

    private int calculateStrike(String input, int indexOfStrike) {
        if (indexOfStrike + 1 >= input.length() ||
                indexOfStrike + 2 >= input.length()) {
            return 0;
        }

        char twoRollsLater = input.charAt(indexOfStrike + 2);
        if (twoRollsLater == '/') {
            return 30;
        }

        char nextRoll = input.charAt(indexOfStrike + 1);
        if (nextRoll == 'X' && twoRollsLater == 'X') {
            return 30;
        }

        return 10 +
                (nextRoll == 'X' ? 10 : calculateSingleRoll(nextRoll)) +
                calculateSingleRoll(twoRollsLater);
    }

    private int calculateSingleRoll(char roll) {
        return roll == '-' ? 0 : Integer.parseInt(String.valueOf(roll));
    }
}
