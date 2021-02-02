package talisman.view.board;

public interface BoardCellView {
    /**
     * Specifies which edges of the cell is on the outside.
     * 
     * @author Alberto Arduini
     *
     */
    enum CellType {
        LEFT, RIGHT, UP, DOWN, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT,
    }

    /**
     * Get the cell x position.
     * 
     * @return the x position
     */
    int getX();

    /**
     * Get the cell y position.
     * 
     * @return the y position
     */
    int getY();

    /**
     * Creates a new cell.
     * 
     * @param imagePath   the path to the background image
     * @param text        the text on the cell
     * @param type the orientation of the cell
     * @return the created cell
     */
    static BoardCellView create(final String imagePath, final String text, final CellType type) {
        return new BoardCellViewImpl(imagePath, text, type);
    }
}
