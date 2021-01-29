package talisman.model.board;

/**
 * Interface that models a board.
 * 
 * @author Alberto Arduini
 *
 * @param <S> The board sections type
 * @param <C> The board cells type
 */
public interface Board<S extends BoardSection<C>, C extends BoardCell> {
    /**
     * Gets the cell instance at the specified section and cell indexes.
     * 
     * @param section the section's index
     * @param index   the cell's index
     * @return the cell instance
     */
    default C getCell(int section, int index) {
        return this.getSection(section).getCell(index);
    }

    /**
     * Gets the section at the specified index.
     * 
     * @param index the section's index
     * @return the section instance
     */
    S getSection(int index);
}
