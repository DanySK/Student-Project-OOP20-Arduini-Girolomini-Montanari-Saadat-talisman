package talisman.model.board.action;

import java.io.Serializable;

import talisman.model.board.BoardPawn;

/**
 * Interface for actions that will be applied to a player when it reaches a cell.
 * 
 * @author Alberto Arduini
 *
 */
public interface TalismanCellAction extends Serializable {
    /**
     * Obtains the action's description.
     * 
     * @return the description
     */
    String getDescription();

    /**
     * Applies the action to the specified player.
     * 
     * @param playerPawn the pawn of the player on which the action will execute
     */
    void applyTo(BoardPawn playerPawn);
}
