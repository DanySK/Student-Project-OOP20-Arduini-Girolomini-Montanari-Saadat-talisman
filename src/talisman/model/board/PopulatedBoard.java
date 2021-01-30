package talisman.model.board;

/**
 * A board populated with pawns.
 * 
 * @author Alberto Arduini
 *
 * @param <S> The type of sections
 * @param <C> The type of cells
 * @param <P> The type of pawns
 */
public interface PopulatedBoard<S extends BoardSection<C>, C extends BoardCell, P extends BoardPawn>
        extends Board<S, C> {
    /**
     * Moves the pawn of the specified player's index at the specified cell in the
     * current pawn's section.
     * 
     * @param playerIndex the pawn's player index
     * @param cell        the destination cell
     */
    void movePawnTo(int playerIndex, int cell);

    /**
     * Moves the pawn of the specified player's index at the specified section and
     * on the specified cell in the new section.
     * 
     * @param playerIndex the pawn's player index
     * @param section     the new section
     * @param cell        the cell in the new section
     */
    void changePawnSection(int playerIndex, int section, int cell);

    /**
     * Moves the pawn of the specified player's index at the first cell of the
     * specified section.
     * 
     * @param playerIndex the pawn's player index
     * @param section     the new section
     */
    default void changePawnSection(int playerIndex, int section) {
        this.changePawnSection(playerIndex, section, 0);
    }

    /**
     * Obtains the pawn associated with the player with the specified index.
     * 
     * @param playerIndex the player index
     * @return the player's pawn
     */
    P getPawn(int playerIndex);

    /**
     * Obtains the section on witch a pawn is on.
     * 
     * @param playerIndex the pawn's player index
     * @return the section index
     */
    int getPawnSectionIndex(int playerIndex);

    /**
     * Obtains the cell on witch a pawn is on.
     * 
     * @param playerIndex the pawn's player index
     * @return the section index
     */
    int getPawnCellIndex(int playerIndex);
}
