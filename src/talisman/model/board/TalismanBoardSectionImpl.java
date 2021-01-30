package talisman.model.board;

import java.util.*;

/**
 * A section of the talisman board.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanBoardSectionImpl implements BoardSection<TalismanBoardCell> {
    private final List<TalismanBoardCell> cells;

    /**
     * Creates a new section containing the specified cells.
     * 
     * @param cells the section's cells
     */
    public TalismanBoardSectionImpl(final List<TalismanBoardCell> cells) {
        this.cells = List.copyOf(cells);
    }

    /**
     * Gets the cell at the specified index.
     * 
     * @param index the cell's index
     */
    @Override
    public TalismanBoardCell getCell(final int index) {
        return this.cells.get(index);
    }

    /**
     * Gets the index of the specified cell.
     * 
     * @param cell the cell
     */
    @Override
    public int getCellPosition(final TalismanBoardCell cell) {
        return this.cells.indexOf(cell);
    }
}
