public class OffByN implements CharacterComparator {

    /**
     * Returns true if characters are equal by the rules of the implementing class.
     *
     * @param x
     * @param y
     */
    int n;

    public OffByN(int nn) {
        n = nn;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if (x - y == n || x - y == -n) return true;
        return false;
    }
}
