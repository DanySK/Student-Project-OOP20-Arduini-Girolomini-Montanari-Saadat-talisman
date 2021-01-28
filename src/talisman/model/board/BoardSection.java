package talisman.model.board;

/**
 * A section of a board
 * @author Alberto Arduini
 *
 * @param <C> The type of cells
 */
public interface BoardSection<C extends BoardCell> {
	/**
	 * Gets the cells at the specified index
	 * @param index the cell's index
	 * @return the cell instance
	 */
	C getCell(int index);
	/**
	 * Gets the index of the specified cell instance
	 * @param cell the cell instance
	 * @return the cell's index
	 */
	int getCellPosition(C cell);
}
