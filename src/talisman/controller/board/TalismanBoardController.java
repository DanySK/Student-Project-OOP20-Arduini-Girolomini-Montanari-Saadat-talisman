package talisman.controller.board;

import talisman.view.board.TalismanBoardView;

import java.util.Set;
import java.util.stream.Collectors;

import talisman.Controllers;
import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardSection;
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
