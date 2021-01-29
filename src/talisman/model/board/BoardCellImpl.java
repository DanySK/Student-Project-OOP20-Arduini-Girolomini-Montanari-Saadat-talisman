package talisman.model.board;

/**
 * Basic implementation of a board cell.
 * 
 * @author Alberto Arduini
 *
 */
public class BoardCellImpl implements BoardCell {
    private final String imagePath;
    private final String text;

    /**
     * Creates a new cell.
     * 
     * @param imagePath the path to the cell image/icon
     * @param text      the text to show on the cell
     */
    public BoardCellImpl(final String imagePath, final String text) {
        this.imagePath = imagePath;
        this.text = text;
    }

    /**
     * Gets the path to the cell image.
     * 
     * @return the image's path
     */
    @Override
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * Gets the cell text or description.
     * 
     * @return the cell's text
     */
    @Override
    public String getText() {
        return this.text;
    }
}
