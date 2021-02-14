package talisman.model.action;

import java.util.Objects;

/**
 * An action that checks if the player has a specific item.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanRequireItemAction implements TalismanAction {
    private static final long serialVersionUID = 3944869345872798127L;
    private static final String DESCRIPTION_FORMAT = "If you have a %s then:" + System.lineSeparator() + "- %s"
            + System.lineSeparator() + "otherwise:" + System.lineSeparator() + "- %s";

    private final int item;
    private final TalismanAction successAction;
    private final TalismanAction failedAction;

    public TalismanRequireItemAction(final int item, final TalismanAction successAction,
            final TalismanAction failedAction) {
        this.item = Objects.requireNonNull(item);
        this.successAction = Objects.requireNonNull(successAction);
        this.failedAction = Objects.requireNonNull(failedAction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanRequireItemAction.DESCRIPTION_FORMAT, this.getItem(),
                this.successAction.getDescription(), this.failedAction.getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply() {
        // TODO: Check for item
        final boolean hasItem = true;
        if (hasItem) {
            this.successAction.apply();
        } else {
            this.failedAction.apply();
        }
    }

    /**
     * Gets the required item.
     * 
     * @return the item's index
     */
    public int getItem() {
        return this.item;
    }
}
