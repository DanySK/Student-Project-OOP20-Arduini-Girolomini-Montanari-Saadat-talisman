package talisman.model.board.action;

import talisman.model.board.BoardPawn;
import talisman.util.Pair;

/**
 * An action for moving the player to another section and cell.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanMoveAction implements TalismanCellAction {
    private static final long serialVersionUID = 4969624574046845867L;
    private static final String DESCRIPTION_FORMAT = "Move to the %s section and cell %d";
    private static final String[] SECTION_NAMES = new String[] { "outside", "middle", "inner", "crown" };

    private final Pair<Integer, Integer> position;

    /**
     * Creates a new move action.
     * 
     * @param cell    the destination cell index
     * @param section the destination section index
     */
    public TalismanMoveAction(final int cell, final int section) {
        this.position = new Pair<>(cell, section);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanMoveAction.DESCRIPTION_FORMAT, TalismanMoveAction.SECTION_NAMES[this.getSection()],
                this.getCell());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final BoardPawn playerPawn) {
        playerPawn.setPosition(this.getCell(), this.getSection());
    }

    /**
     * Gets the destination cell.
     * 
     * @return the cell index
     */
    public int getCell() {
        return this.position.getX();
    }

    /**
     * Gets the destination section.
     * 
     * @return the section index
     */
    public int getSection() {
        return this.position.getY();
    }
}
