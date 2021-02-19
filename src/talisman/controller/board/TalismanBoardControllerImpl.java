package talisman.controller.board;

import java.util.Objects;
import java.util.Optional;

import talisman.Controllers;

import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardCell;
import talisman.model.board.TalismanBoardPawn;
import talisman.model.board.TalismanBoardSection;

import talisman.model.cards.Card;

import talisman.view.board.TalismanBoardView;

/**
 * The implementation of a basic MVC controller for a TalismanBoard.
 * 
 * @author Alberto Arduini
 *
 */
public final class TalismanBoardControllerImpl
        extends PopulatedBoardControllerImpl<TalismanBoard, TalismanBoardSection, TalismanBoardCell, TalismanBoardPawn>
        implements TalismanBoardController {
    /**
     * Creates a new controller.
     * 
     * @param board the board model to control
     * @param view  the board view
     */
    public TalismanBoardControllerImpl(final TalismanBoard board, final TalismanBoardView view) {
        super(board, view);
        this.getView().addUpdateListener(() -> {
            this.updatePawnsViewPosition();
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanBoardView getView() {
        return (TalismanBoardView) super.getView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyCurrentPlayerCellActions() {
        final int playerIndex = Controllers.getCharactersController().getCurrentPlayer().getIndex();
        this.getCharacterCell(playerIndex).applyActions();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCurrentCharacterCellCard(final Card card) {
        this.getCharacterCell(Controllers.getCharactersController().getCurrentPlayer().getIndex()).setCard(Objects.requireNonNull(card));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Card> collectCurrentCharacterCellCard() {
        final TalismanBoardCell cell = this.getCharacterCell(Controllers.getCharactersController().getCurrentPlayer().getIndex());
        final Optional<Card> card = cell.getCard();
        cell.clearCard();
        return card;
    }
}
