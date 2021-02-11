package talisman.view.board;

import java.awt.Component;
import java.awt.Point;
import java.util.List;

import javax.swing.SwingUtilities;

/**
 * A swing implementation for a populated board view.
 * 
 * @author Alberto Arduini
 *
 */
public class PopulatedBoardViewImpl extends BoardViewImpl implements PopulatedBoardView {
    private final List<PawnView> pawns;

    /**
     * Creates a new board.
     * 
     * @param sections    the board sections
     * @param mainSection the main board section index
     * @param pawns       the pawns
     */
    public PopulatedBoardViewImpl(final List<BoardSectionView> sections, final int mainSection,
            final List<PawnView> pawns) {
        super(sections, mainSection);
        this.pawns = List.copyOf(pawns);
        this.pawns.forEach(p -> {
            this.add((Component) p, 0);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void movePawnTo(final int index, final int x, final int y) {
        SwingUtilities.invokeLater(() -> {
            this.getPawn(index).setPosition(x, y);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void movePawnToCell(final int index, final int section, final int cell) {
        final BoardCellView cellInstance = this.getSection(section).getCell(cell);
        this.movePawnTo(index, cellInstance.getCellX(), cellInstance.getCellY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PawnView getPawn(final int index) {
        return this.pawns.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisible(final boolean visible) {
        super.setVisible(visible);
        if (visible) {
            this.boardUpdated();
        }
    }
}
