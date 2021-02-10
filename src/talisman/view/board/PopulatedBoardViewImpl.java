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
        this.getPawn(index).setPosition(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PawnView getPawn(final int index) {
        return this.pawns.get(index);
    }
}
