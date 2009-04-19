public class RollCollection {
    private char[] rolls;

    public RollCollection(char[] rolls) {
        this.rolls = rolls;
    }

    public int length() {
        return rolls.length;
    }

    public Roll rollAt(int i) {
        return new Roll(rolls[i]);
    }

    public boolean rollInLastFrame(int i) {
        if (rollAt(i).isSpare()) {
            return length() == i + 2;
        }
        if (rollAt(i).isStrike()) {
            return length() == i + 3;
        }
        return false;
    }
}
