package talisman.view.board;

import talisman.util.CellType;

public interface BoardCellView {
    /**
     * Gets the cell's orientation.
     * 
     * @return the cell's orientation type
     */
    CellType getCellType();

    /**
     * Get the cell x position.
     * 
     * @return the x position
     */
    int getCellX();

    /**
     * Get the cell y position.
     * 
     * @return the y position
     */
    int getCellY();

    /**
     * Creates a new cell.
     * 
     * @param imagePath the path to the background image
     * @param text      the text on the cell
     * @param type      the orientation of the cell
     * @return the created cell
     */
    static BoardCellView create(final String imagePath, final String text, final CellType type) {
        return new BoardCellViewImpl(imagePath, text, type);
    }
}
