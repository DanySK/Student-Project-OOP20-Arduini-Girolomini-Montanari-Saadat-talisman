package talisman.model.action;

import java.util.List;

/**
 * Action that lets the user choose between sub-actions.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanActionChoiceAction extends TalismanChoiceAction<TalismanAction> {
    private static final long serialVersionUID = 2629235500890871339L;
    private static final String DESCRIPTION_FORMAT = "Choose between:";
    private static final String SINGLE_ACTION_DESCRIPTION_FORMAT = "- %s";

    private final transient List<TalismanAction> actions;

    /**
     * Creates a new choice actions.
     * 
     * @param actions    the list of possible actions
     */
    public TalismanActionChoiceAction(final List<TalismanAction> actions) {
        this.actions = List.copyOf(actions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanAction getChoice(final int index) {
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
    protected boolean applyChoice(final int choice) {
        if (!this.getChoice(choice).canBeApplied()) {
            return false;
        }
        this.getChoice(choice).apply();
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getChoicesCount() {
        return this.actions.size();
    }
}
