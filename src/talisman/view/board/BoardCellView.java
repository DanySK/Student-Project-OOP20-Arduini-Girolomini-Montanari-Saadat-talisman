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
     * Creates a new cell.
     * 
     * @param imagePath   the path to the background iamge
     * @param text        the text on the cell
     * @param orientation the orientation of the cell
     * @return the created cell
     */
    static BoardCellView create(final String imagePath, final String text, final CellType type) {
        return new BoardCellViewImpl(imagePath, text, type);
    }
}
