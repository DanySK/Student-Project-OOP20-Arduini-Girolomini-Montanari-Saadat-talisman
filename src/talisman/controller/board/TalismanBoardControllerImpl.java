package talisman.controller.board;

import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardCell;
import talisman.model.board.TalismanBoardSection;

/**
 * The implementation of a basic MVC controller for a TalismanBoard.
 * 
 * @author Alberto Arduini
 *
 */
public final class TalismanBoardControllerImpl implements TalismanBoardController {
    private final TalismanBoard board;

    /**
     * Creates a new controller.
     * 
     * @param board the board model to control
     */
    public TalismanBoardControllerImpl(final TalismanBoard board) {
        this.board = board;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveCharacterCell(final int player, final int cell) {
        this.getBoard().movePawnTo(player, cell);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveCharacterSection(final int player, final int section, final int cell) {
        this.getBoard().changePawnSection(player, section, cell);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanBoardSection getCharacterSection(final int player) {
        final int sectionIndex = this.getBoard().getPawnSectionIndex(player);
        return this.getBoard().getSection(sectionIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanBoardCell getCharacterCell(final int player) {
        final int cellIndex = this.getBoard().getPawnCellIndex(player);
        return this.getCharacterSection(player).getCell(cellIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyCharacterCellActions(final int player) {
        this.getCharacterCell(player).applyActionsTo(player);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanBoard getBoard() {
        return this.board;
    }

}
