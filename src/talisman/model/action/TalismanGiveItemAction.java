package talisman.model.action;

/**
 * An action that gives an item to a player.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanGiveItemAction implements TalismanAction {
    private static final long serialVersionUID = -428031478841638174L;

    private static final String DESCRIPTION_FORMAT = "You gain a %s";

    private final int item;

    public TalismanGiveItemAction(final int item) {
        this.item = item;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanGiveItemAction.DESCRIPTION_FORMAT, this.getItem());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply() {
        // TODO: give item
    }

    /**
     * Gets the item that will be given.
     * 
     * @return the item's index
     */
    public int getItem() {
        return this.item;
    }
}
