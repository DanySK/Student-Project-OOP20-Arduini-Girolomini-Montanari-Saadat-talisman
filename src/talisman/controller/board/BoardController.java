package talisman.controller.board;

import talisman.model.board.Board;

/**
 * A MVC controller for a board.
 * 
 * @author Alberto Arduini
 *
 * @param <B>
 */
public interface BoardController<B extends Board<?, ?>> {
    /**
     * Gets the board controlled by this controller.
     * 
     * @return the board
     */
    B getBoard();
}
