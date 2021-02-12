package talisman.model.action;

/**
 * Action that lets the user choose between sub-actions. It has the option to
 * have an empty action as the first one.
 * 
 * @author Alberto Arduini
 * 
 * @param <X> the type of item to be chosen
 *
 */
public abstract class TalismanChoiceAction<X> implements TalismanAction {
    private static final long serialVersionUID = 6981329627204017530L;

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final int player) {
        boolean applied = false;
        do {
            // TODO: Ask user
            final int reply = 0;
            if (reply < 0 || reply >= this.getChoicesCount()) {
                continue;
            }
            applied = this.applyChoice(player, reply);
            // The loop is used to check if the choice is valid and if it has been applied
        } while (!applied);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        String description = this.getDescriptionFormat();
        for (int i = 0; i < this.getChoicesCount(); i++) {
            description = description.concat(System.lineSeparator() + this.getChoiceDescription(i));
        }
        return description;
    }

    /**
     * Gets the choice at the given index.
     * 
     * @param index the choice index
     * 
     * @return the choice object
     */
    public abstract X getChoice(int index);

    /**
     * Gets the description of the choice at the given index.
     * 
     * @param index the choice index
     * 
     * @return the choice object
     */
    public abstract String getChoiceDescription(int index);

    /**
     * Gets the format of the description.
     * 
     * @return the description format
     */
    protected abstract String getDescriptionFormat();

    /**
     * Applies the given choice on the given player index.
     * 
     * @param player the player index
     * @param choice the choice index
     * 
     * @return if the choice has been applied or not
     */
    protected abstract boolean applyChoice(int player, int choice);

    /**
     * Gets the actions count, excluding the empty one.
     * 
     * @return the actions count
     */
    public abstract int getChoicesCount();
}
