public class Rolls {
    private char[] rolls;

    public Rolls(char[] rolls) {
        this.rolls = rolls;
    }

    public int length() {
        return rolls.length;
    }

    public Roll rollAt(int i) {
        return new Roll(rolls[i]);
    }
}
