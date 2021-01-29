package talisman.util;

public class Pair<X, Y> {
    private final X x;
    private final Y y;

    public Pair(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    public final X getX() {
        return x;
    }

    public final Y getY() {
        return y;
    }
}
