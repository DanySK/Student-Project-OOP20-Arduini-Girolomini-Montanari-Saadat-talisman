package talisman.util;

import java.io.Serializable;

/**
 * Represents a pair of non-homogeneous items.
 * 
 * @author Alberto Arduini
 *
 * @param <X> type of the first item
 * @param <Y> type of the second item
 */
public class Pair<X, Y> implements Serializable {
    private static final long serialVersionUID = -5832869251083868792L;

    private final X x;
    private final Y y;

    /**
     * Creates a new pair.
     * 
     * @param x the first item
     * @param y the second item
     */
    public Pair(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the first item.
     * 
     * @return the item
     */
    public final X getX() {
        return x;
    }

    /**
     * Gets the second item.
     * 
     * @return the item
     */
    public final Y getY() {
        return y;
    }
}
