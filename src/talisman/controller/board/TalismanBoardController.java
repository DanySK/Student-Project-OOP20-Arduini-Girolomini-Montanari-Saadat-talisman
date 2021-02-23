package talisman.controller.board;

import talisman.view.board.TalismanBoardView;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import talisman.Controllers;
import talisman.model.action.ActionEndedListener;
import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardSection;
import talisman.model.cards.Card;
import talisman.model.board.TalismanBoardCell;
import talisman.model.board.TalismanBoardPawn;

/**
 * An interface for MVC controllers for talisman board models.
 * 
 * @author Alberto Arduini
 *
 */
public interface TalismanBoardController
        extends PopulatedBoardController<TalismanBoard, TalismanBoardSection, TalismanBoardCell, TalismanBoardPawn> {
    /**
     * {@inheritDoc}
     */
    @Override
    TalismanBoardView getView();

    /**
     * Applies the actions of the cell where the current player is.
     */
    void applyCurrentPlayerCellActions();

    /**
     * Sets the card that is on top of the cell where the current player is.
     * 
     * @param card the card to set
     */
    void setCurrentCharacterCellCard(Card card);

    /**
     * Removes the card from the cell that is on the current player and returns it,
     * if present.
     * 
     * @return an optional containing the card that was on the cell
     */
    Optional<Card> collectCurrentCharacterCellCard();

    /**
     * Sets the listener waiting for an action to end.
     * 
     * @param listener the listener
     */
    void setActionEndedListener(ActionEndedListener listener);

    /**
     * Gets the characters opponents on the current player cell.
     * 
     * @return the opponents index
     */
    default Set<Integer> getCurrentCharacterOpponents() {
        final int currentIndex = Controllers.getCharactersController().getCurrentPlayer().getIndex();
        final TalismanBoardPawn currentPawn = this.getCharacterPawn(currentIndex);
        final Set<TalismanBoardPawn> allCharacters = this.getCharactersInCell(currentPawn.getPositionSection(),
                currentPawn.getPositionCell());
        return Set.copyOf(allCharacters.stream().map(c -> c.getPlayerIndex()).filter(i -> i != currentIndex)
                .collect(Collectors.toUnmodifiableSet()));
    }

    /**
     * Creates a talisman board controller from a given board model.
     * 
     * @param board the board model to control
     * @param view  the board view
     * @return the controller
     */
    static TalismanBoardController create(final TalismanBoard board, final TalismanBoardView view) {
        return new TalismanBoardControllerImpl(board, view);
    }
}
