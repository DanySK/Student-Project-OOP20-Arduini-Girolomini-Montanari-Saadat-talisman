package talisman.model.action;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.List;
import java.util.Optional;

import talisman.model.board.BoardPawn;

/**
 * Action that lets the user choose between sub-actions. It has the option to
 * have an empty action as the first one.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanChoiceAction implements TalismanAction {
    private static final long serialVersionUID = 4657209105775876617L;
    private static final String DESCRIPTION_FORMAT = "Choose between:";
    private static final String SINGLE_ACTION_DESCRIPTION_FORMAT = System.lineSeparator() + "- %s";

    private transient List<TalismanAction> actions;
    private final boolean hasNothing;

    /**
     * Creates a new choice actions.
     * 
     * @param actions    the list of possible actions
     * @param hasNothing if there should be the choice of not doing anything
     */
    public TalismanChoiceAction(final List<TalismanAction> actions, final boolean hasNothing) {
        this.actions = List.copyOf(actions);
        this.hasNothing = hasNothing;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        String description = TalismanChoiceAction.DESCRIPTION_FORMAT;
        if (this.hasNothing) {
            description = description.concat(this.getActionDescription(Optional.empty()));
        }
        for (final TalismanAction action : this.actions) {
            description = description.concat(this.getActionDescription(Optional.ofNullable(action)));
        }
        return description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final int player) {
        boolean applied = false;
        do {
            // TODO: Ask user
            final int reply = 0;
            if (reply == -1) {
                break;
            }
            final TalismanAction action = this.actions.get(reply);
            if (action.canBeApplied(player)) {
                action.applyTo(player);
                applied = true;
            }
            // I need a loop, since not all actions could be applied, so i need to check if
            // the chosen one is applied before continuing
        } while (!applied);
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

    /**
     * Gets the action available at the current index.
     * 
     * @param index the action index
     * @return the action instance
     */
    public TalismanAction getAction(final int index) {
        return this.actions.get(index);
    }

    /**
     * Gets the actions count, excluding the empty one.
     * 
     * @return the actions count
     */
    public int getActionCount() {
        return this.actions.size();
    }

    private String getActionDescription(final Optional<TalismanAction> action) {
        return String.format(TalismanChoiceAction.SINGLE_ACTION_DESCRIPTION_FORMAT,
                action.isPresent() ? action.get().getDescription() : TalismanAction.NO_ACTION_DESCRIPTION);
    }
}
