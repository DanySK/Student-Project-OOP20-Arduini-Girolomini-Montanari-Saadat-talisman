package talisman.model.board;

import java.util.*;

import talisman.util.CellType;

/**
 * A cell of the talisman board.
 * 
 * @author Alberto Arduini
 *
 */
public final class TalismanBoardCell extends BoardCellImpl {
    private final TalismanCellType type;
    private final Set<TalismanCellAction> actions;

    /**
     * Constructs a new talisman board cell.
     * 
     * @param imagePath   the path to the cell's image
     * @param text        the cell's text
     * @param orientation the cell's orientation
     * @param type        the cell's type
     * @param actions     a collection of the cell's actions
     */
    public TalismanBoardCell(final String imagePath, final String text, final CellType orientation,
            final TalismanCellType type, final Collection<TalismanCellAction> actions) {
        super(imagePath, text, orientation);
        this.type = type;
        this.actions = Set.copyOf(actions);
    }

    /**
     * Gets the talisman cell's type.
     * 
     * @return The cell's type
     */
    public TalismanCellType getTalismanType() {
        return this.type;
    }

    /**
     * Gets the cell's actions.
     * 
     * @return The cell's actions
     */
    public Set<TalismanCellAction> getActions() {
        return this.actions;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getText() {
        String text = super.getText();
        for (TalismanCellAction action : this.getActions()) {
            text = text + System.lineSeparator() + action.getDescription();
        }
        return text;
    }

    /**
     * Applies all the actions of this cell the the specified player.
     * 
     * @param player The index of the player to which the actions will apply
     */
    public void applyActionsTo(final int player) {
        this.getActions().stream().forEach(a -> a.applyTo(player));
    }

    /**
     * Constructs a new cell.
     * 
     * @param imagePath   the path to the cell's image
     * @param text        the cell's text
     * @param orientation the cell's orientation
     * @param type        the cell's type
     * @param actions     a collection of the cell's actions
     * @return the created cell
     */
    public static TalismanBoardCell createCell(final String imagePath, final String text, final CellType orientation,
            final TalismanCellType type, final Collection<TalismanCellAction> actions) {
        return new TalismanBoardCell(imagePath, text, orientation, type, actions);
    }
}
