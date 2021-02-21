package talisman.controller.board;

import java.util.Objects;
import java.util.Optional;

import talisman.Controllers;
import talisman.controller.cards.TalismanCardController;
import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardCell;
import talisman.model.board.TalismanBoardPawn;
import talisman.model.board.TalismanBoardSection;

import talisman.model.cards.Card;

import talisman.view.board.TalismanBoardView;
import talisman.view.cards.TalismanCardView;

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
        final TalismanCardView cardView = TalismanCardController.createView(card);
        final int playerIndex = Controllers.getCharactersController().getCurrentPlayer().getIndex();
        this.getCharacterCell(playerIndex).setCard(Objects.requireNonNull(card));
        final TalismanBoardPawn currentPawn = this.getCharacterPawn(playerIndex);
        this.getView().addOverlayedCard(currentPawn.getPositionSection(), currentPawn.getPositionCell(), cardView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Card> collectCurrentCharacterCellCard() {
        final int playerIndex = Controllers.getCharactersController().getCurrentPlayer().getIndex();
        final TalismanBoardCell cell = this.getCharacterCell(playerIndex);
        final Optional<Card> card = cell.getCard();
        cell.clearCard();
        final TalismanBoardPawn currentPawn = this.getCharacterPawn(playerIndex);
        this.getView().removeOverlayedCard(currentPawn.getPositionSection(), currentPawn.getPositionCell());
        return card;
    }
}
