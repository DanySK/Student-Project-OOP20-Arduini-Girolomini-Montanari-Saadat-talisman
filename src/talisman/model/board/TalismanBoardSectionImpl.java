package talisman.model.board;

import java.util.*;

/**
 * A section of the talisman board.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanBoardSectionImpl implements TalismanBoardSection {
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
     * {@inheritDoc}
     */
    @Override
    public int getCellCount() {
        return this.cells.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanBoardCell getCell(final int index) {
        return this.cells.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCellPosition(final TalismanBoardCell cell) {
        return this.cells.indexOf(cell);
    }
}
