package talisman.model.board.action;

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
public class TalismanChoiceAction implements TalismanCellAction {
    private static final long serialVersionUID = 4657209105775876617L;
    private static final String DESCRIPTION_FORMAT = "Choose between:";
    private static final String SINGLE_ACTION_DESCRIPTION_FORMAT = System.lineSeparator() + "- %s";

    private transient List<TalismanCellAction> actions;
    private final boolean hasNothing;

    /**
     * Creates a new choice actions.
     * 
     * @param actions    the list of possible actions
     * @param hasNothing if there should be the choice of not doing anything
     */
    public TalismanChoiceAction(final List<TalismanCellAction> actions, final boolean hasNothing) {
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
        for (final TalismanCellAction action : this.actions) {
            description = description.concat(this.getActionDescription(Optional.ofNullable(action)));
        }
        return description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final BoardPawn playerPawn) {
        boolean applied = false;
        do {
            // TODO: Ask user
            final int reply = 0;
            if (reply == -1) {
                break;
            }
            final TalismanCellAction action = this.actions.get(reply);
            if (action.canBeApplied(playerPawn)) {
                action.applyTo(playerPawn);
                applied = true;
            }
            // I need a loop, since not all actions cuold be applied, so i need to check if
            // the chosen one is applied before continuing
        } while (!applied);
    }

    private String getActionDescription(final Optional<TalismanCellAction> action) {
        return String.format(TalismanChoiceAction.SINGLE_ACTION_DESCRIPTION_FORMAT,
                action.isPresent() ? action.get().getDescription() : TalismanCellAction.NO_ACTION_DESCRIPTION);
    }
}
