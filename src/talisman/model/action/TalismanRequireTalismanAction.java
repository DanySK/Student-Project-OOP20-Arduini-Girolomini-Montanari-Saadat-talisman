package talisman.model.action;

import java.util.Objects;

/**
 * An action that checks if the player has a specific item.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanRequireTalismanAction implements TalismanAction {
    private static final long serialVersionUID = 3944869345872798127L;
    private static final String DESCRIPTION_FORMAT = "If you have a talisman then: %s; " + System.lineSeparator()
            + "otherwise: %s";

    private final TalismanAction successAction;
    private final TalismanAction failedAction;

    public TalismanRequireTalismanAction(final TalismanAction successAction, final TalismanAction failedAction) {
        this.successAction = Objects.requireNonNull(successAction);
        this.failedAction = Objects.requireNonNull(failedAction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanRequireTalismanAction.DESCRIPTION_FORMAT, this.successAction.getDescription(),
                this.failedAction.getDescription());
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
}
