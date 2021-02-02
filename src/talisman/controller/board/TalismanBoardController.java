package talisman.controller.board;

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
public interface TalismanBoardController extends PopulatedBoardController<TalismanBoard, TalismanBoardSection, TalismanBoardCell, TalismanBoardPawn> {
    /**
     * Creates a talisman board controller from a given board model.
     * 
     * @param board the board model instance
     * @return the controller
     */
    static TalismanBoardController createFromBoard(final TalismanBoard board) {
        return new TalismanBoardControllerImpl(board);
    }
}
