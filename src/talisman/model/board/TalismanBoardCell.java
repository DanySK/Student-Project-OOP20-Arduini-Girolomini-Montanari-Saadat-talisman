package talisman.model.board;

import java.util.*;
import java.util.stream.*;

/**
 * A cell of the talisman board
 * 
 * @author Alberto Arduini
 *
 */
public final class TalismanBoardCell extends BoardCellImpl {
	private final TalismanCellType type;
	private final Set<TalismanCellAction> actions;
	/**
	 * Constructs a new talisman board cell
	 * @param imagePath the path to the cell's image
	 * @param text the cell's text
	 * @param type the cell's type
	 * @param actions a collection of the cell's actions
	 */
	public TalismanBoardCell(final String imagePath, final String text, final TalismanCellType type, final Collection<TalismanCellAction> actions) {
		super(imagePath, text);
		this.type = type;
		this.actions = Set.copyOf(actions);
	}
	public TalismanCellType getType() {
		return this.type;
	}
	public Set<TalismanCellAction> getActions() {
		return this.actions;
	}
	public void applyActionsTo(final int player) {
		this.getActions().stream().forEach(a -> a.applyTo(player));
	}
}
