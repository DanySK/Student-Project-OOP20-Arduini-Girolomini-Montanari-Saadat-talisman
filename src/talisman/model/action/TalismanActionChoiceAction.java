package talisman.model.action;

import java.util.List;

/**
 * Action that lets the user choose between sub-actions. It has the option to
 * have an empty action as the first one.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanActionChoiceAction extends TalismanChoiceAction<TalismanAction> {
    private static final long serialVersionUID = 2629235500890871339L;
    private static final String DESCRIPTION_FORMAT = "Choose between:";
    private static final String SINGLE_ACTION_DESCRIPTION_FORMAT = "- %s";

    private final transient List<TalismanAction> actions;
    private final boolean hasNothing;

    /**
     * Creates a new choice actions.
     * 
     * @param actions    the list of possible actions
     * @param hasNothing if there should be the choice of not doing anything
     */
    public TalismanActionChoiceAction(final List<TalismanAction> actions, final boolean hasNothing) {
        this.actions = List.copyOf(actions);
        this.hasNothing = hasNothing;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanAction getChoice(final int index) {
        if (index == 0 && this.hasNothing()) {
            return null;
        }
        return this.actions.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getChoiceDescription(final int index) {
        return String.format(TalismanActionChoiceAction.SINGLE_ACTION_DESCRIPTION_FORMAT,
                this.getChoice(index).getDescription());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getDescriptionFormat() {
        return TalismanActionChoiceAction.DESCRIPTION_FORMAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean applyChoice(final int player, final int choice) {
        if (choice == 0 && this.hasNothing()) {
            return true;
        }
        if (!this.getChoice(choice + 1).canBeApplied(player)) {
            return false;
        }
        this.getChoice(choice + 1).applyTo(player);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getChoicesCount() {
        return this.actions.size();
    }

    /**
     * Does this choice action provide an empty option (where the player doens't do
     * anything)?
     * 
     * @return if the option is available
     */
    public boolean hasNothing() {
        return this.hasNothing;
    }
}
