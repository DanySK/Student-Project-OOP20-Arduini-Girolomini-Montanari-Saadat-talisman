package talisman.model.board;

import java.io.Serializable;

/**
 * Inteface that modela a cell on a board.
 * 
 * @author Alberto Arduini
 *
 */
public interface BoardCell extends Serializable {
    /**
     * Gets the cell's image path.
     * 
     * @return the image's path
     */
    String getImagePath();

    /**
     * Get the text to show on the cell.
     * 
     * @return the cell's text
     */
    String getText();
}
