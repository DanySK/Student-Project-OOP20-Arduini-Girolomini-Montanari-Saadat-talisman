package talisman.controller.board;

import talisman.view.board.PopulatedBoardView;
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
     * Creates a talisman board controller from a given board model.
     * 
     * @param board the board model to control
     * @param view  the board view
     * @return the controller
     */
    static TalismanBoardController create(final TalismanBoard board, final PopulatedBoardView view) {
        return new TalismanBoardControllerImpl(board, view);
    }
}
