package talisman.model.board;

/**
 * A board populated with pawns
 * @author Alberto Arduini
 *
 * @param <S> The type of sections
 * @param <C> The type of cells
 * @param <P> The type of pawns
 */
public interface PopulatedBoard<S extends BoardSection<C>, C extends BoardCell, P extends BoardPawn> extends Board<S, C> {
	/**
	 * Moves the pawn of the specified player's index at the specified cell in the current pawn's section
	 * @param playerIndex the pawn's player index
	 * @param cell the destination cell
	 */
	void movePawnTo(final int playerIndex, final int cell);
	/**
	 * Moves the pawn of the specified player's index at the specified section and on the specified cell in the new section
	 * @param playerIndex the pawn's player index
	 * @param section the new section
	 * @param cell the cell in the new section
	 */
	void changePawnSection(final int playerIndex, final int section, final int cell);
	P getPawn(final int playerIndex);
}
