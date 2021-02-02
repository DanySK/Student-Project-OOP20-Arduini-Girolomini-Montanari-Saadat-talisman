package talisman.view.board;

import java.awt.Component;
import java.util.List;

import javax.swing.JPanel;

/**
 * A swing implementation of a board section.
 * 
 * @author Alberto Arduini
 *
 */
public class BoardSectionViewImpl extends JPanel implements BoardSectionView {
    private final List<BoardCellView> cells;

    /**
     * Creates a new section.
     * 
     * @param cells the cells that the section contains
     */
    public BoardSectionViewImpl(final List<BoardCellView> cells) {
        this.cells = List.copyOf(cells);
        for (final BoardCellView cell : this.cells) {
            // I take as granted that the cells use the swing implementation
            // (Also we can't have a GUI with mixed frameworks, so if the section is using
            // swing then the cells must too)
            this.add((Component) cell);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BoardCellView getCell(final int cellIndex) {
        return this.cells.get(cellIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCellPositionX(final int cellIndex) {
        return this.getCell(cellIndex).getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCellPositionY(final int cellIndex) {
        return this.getCell(cellIndex).getY();
    }
}
