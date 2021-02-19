package talisman.controller.board;

import java.util.HashSet;
import java.util.Set;

import talisman.Controllers;

import talisman.model.board.BoardCell;
import talisman.model.board.BoardPawn;
import talisman.model.board.BoardSection;
import talisman.model.board.PopulatedBoard;

import talisman.view.board.PopulatedBoardView;

public class PopulatedBoardControllerImpl<B extends PopulatedBoard<S, C, P>, S extends BoardSection<C>, C extends BoardCell, P extends BoardPawn>
        extends BoardControllerImpl<B> implements PopulatedBoardController<B, S, C, P> {

    /**
     * Creates a new controller.
     * 
     * @param board the board model to control
     * @param view  the board view
     */
    public PopulatedBoardControllerImpl(final B board, final PopulatedBoardView view) {
        super(board, view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PopulatedBoardView getView() {
        return (PopulatedBoardView) super.getBoard();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveCharacterCell(final int player, final int cell) {
        this.getBoard().movePawnTo(player, cell);
        this.updatePawnViewPosition(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveCharacterSection(final int player, final int section, final int cell) {
        this.getBoard().changePawnSection(player, section, cell);
        this.updatePawnViewPosition(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public S getCharacterSection(final int player) {
        final int sectionIndex = this.getBoard().getPawnSectionIndex(player);
        return this.getBoard().getSection(sectionIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public C getCharacterCell(final int player) {
        final int cellIndex = this.getBoard().getPawnCellIndex(player);
        return this.getCharacterSection(player).getCell(cellIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public P getCharacterPawn(final int player) {
        return this.getBoard().getPawn(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<P> getCharactersInCell(final int section, final int cell) {
        final Set<P> pawns = new HashSet<>();
        for (int i = 0; i < Controllers.getCharactersController().getActivePlayers(); i++) {
            final P pawn = this.getCharacterPawn(i);
            if (pawn.getPositionCell() == cell && pawn.getPositionSection() == section) {
                pawns.add(pawn);
            }
        }
        return pawns;
    }

    /**
     * Updates the positions in the view of all pawns, to reflect changes in the
     * respective pawns model.
     */
    protected void updatePawnsViewPosition() {
        for (int i = 0; i < this.getBoard().getPawnCount(); i++) {
            this.updatePawnViewPosition(i);
        }
    }

    private void updatePawnViewPosition(final int index) {
        final P pawn = this.getCharacterPawn(index);
        this.getView().movePawnToCell(index, pawn.getPositionSection(), pawn.getPositionCell());
    }
}
