package talisman.controller.board;

import talisman.model.board.PopulatedBoard;
import talisman.model.board.BoardSection;
import talisman.model.board.BoardCell;
import talisman.model.board.BoardPawn;

/**
 * A MVC controller for a populated board model.
 * 
 * @author Alberto Arduini
 *
 * @param <B> The board type
 * @param <S> The section type
 * @param <C> The cell type
 */
public interface PopulatedBoardController<B extends PopulatedBoard<S, C, ?>, S extends BoardSection<C>, C extends BoardCell>
        extends BoardController<B> {
    /**
     * Moves the character of the specified player in the specified cell.
     * 
     * @param player the player's index
     * @param cell   the destination cell
     */
    void moveCharacterCell(int player, int cell);

    /**
     * Moves a character in the first cell of another section.
     * 
     * @param player  the player's index
     * @param section the destination section
     */
    default void moveCharacterSection(int player, int section) {
        this.moveCharacterSection(player, section, 0);
    }

    /**
     * Moves a character in the specified cell and section.
     * 
     * @param player  the player's index
     * @param section the destination section
     * @param cell    the destination cell
     */
    void moveCharacterSection(int player, int section, int cell);

    /**
     * Gets the section on which the player is.
     * 
     * @param player the player's index
     * @return the section
     */
    S getCharacterSection(int player);

    /**
     * Gets the cell on which the player is.
     * 
     * @param player the player's index
     * @return the cell
     */
    C getCharacterCell(int player);

    /**
     * Applies the actions of the cell on which the specified player is.
     * 
     * @param player the index of the player to which the action will apply
     */
    void applyCharacterCellActions(int player);
}
