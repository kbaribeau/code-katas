public class Roll {
    private char roll;

    public Roll(char roll) {
        this.roll = roll;
    }

    public boolean isSpare() {
        return roll == '/';
    }

    public boolean isStrike() {
        return roll == 'X';
    }

    public int score() {
        if (roll == '-') {
            return 0;
        }
        if (isStrike()) {
            return 10;
        }
        if (isSpare()) {
            return 0;
        }
        return Integer.valueOf(String.valueOf(roll));
    }
}
