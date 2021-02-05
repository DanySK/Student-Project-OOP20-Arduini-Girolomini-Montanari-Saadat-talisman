package talisman.view.board;

import java.util.List;

/**
 * A swing implementation for a MVC view for a populated board.
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
        this.pawns = pawns;
    }

    /**
     * Moves the given pawn to a new position.
     * 
     * @param index the pawn's index
     * @param x     the new X position
     * @param y     the new Y position
     */
    @Override
    public void movePawnTo(final int index, final int x, final int y) {
        this.getPawn(index).setPosition(x, y);
    }

    /**
     * Gets the pawn view at the given index.
     * 
     * @param index the pawn's index
     * @return the pawn view instance
     */
    @Override
    public PawnView getPawn(final int index) {
        return this.pawns.get(index);
    }

}
