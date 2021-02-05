package talisman.view.board;

/**
 * Interface that models a MVC view for a pawn.
 * 
 * @author Alberto Arduini
 *
 */
public interface PawnView {
    /**
     * Sets the new position for this pawn.
     * 
     * @param x the new X position
     * @param y the new Y position
     */
    void setPosition(int x, int y);

    /**
     * Gets the pawn's X position.
     * 
     * @return the X position
     */
    int getX();

    /**
     * Gets the pawn's X position.
     * 
     * @return the Y position
     */
    int getY();

    /**
     * Constructs a new pawn with the given image.
     * 
     * @param imagePath the path to the pawn's image
     * @return the created Pawn
     */
    static PawnView create(final String imagePath) {
        return new PawnViewImpl(imagePath);
    }
}
