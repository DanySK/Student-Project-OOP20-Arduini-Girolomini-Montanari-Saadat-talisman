package talisman.model.board.action;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Optional;

import talisman.model.board.BoardPawn;

/**
 * An action that checks if the player has a specific item.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanRequireItemAction implements TalismanCellAction {
    private static final String DESCRIPTION_FORMAT = "If you have a %s then:" + System.lineSeparator() + "- %s"
            + System.lineSeparator() + "otherwise:" + System.lineSeparator() + "- %s";

    private final int item;
    // Saved as optional, since it may only have a success or failure
    // consequence
    private transient Optional<TalismanCellAction> successAction;
    private transient Optional<TalismanCellAction> failedAction;

    public TalismanRequireItemAction(final int item, final TalismanCellAction successAction,
            final TalismanCellAction failedAction) {
        this.item = item;
        this.successAction = Optional.ofNullable(successAction);
        this.failedAction = Optional.ofNullable(failedAction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanRequireItemAction.DESCRIPTION_FORMAT, this.getItem(),
                this.getActionDescription(this.successAction), this.getActionDescription(this.failedAction));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final int player) {
        // TODO: Check for item
        if (true) {
            this.successAction.ifPresent(a -> a.applyTo(player));
        } /*
           * else { this.failedAction.ifPresent(a -> a.applyTo(playerPawn)); }
           */
    }

    /**
     * Gets the required item.
     * 
     * @return the item's index
     */
    public int getItem() {
        return this.item;
    }

    private String getActionDescription(final Optional<TalismanCellAction> action) {
        return action.isPresent() ? action.get().getDescription() : TalismanCellAction.NO_ACTION_DESCRIPTION;
    }

    private void readObject(final ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
        // I use two bytes as flags to check for consequence actions
        if (stream.read() == TalismanCellAction.SERIALIZED_PRESENT) {
            this.successAction = Optional.ofNullable((TalismanCellAction) stream.readObject());
        } else {
            this.successAction = Optional.empty();
        }
        if (stream.read() == TalismanCellAction.SERIALIZED_PRESENT) {
            this.failedAction = Optional.ofNullable((TalismanCellAction) stream.readObject());
        } else {
            this.failedAction = Optional.empty();
        }
    }

    private void writeObject(final ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        // First i write the flag, then the action (if present)
        if (this.successAction.isPresent()) {
            stream.write(TalismanCellAction.SERIALIZED_PRESENT);
            stream.writeObject(this.successAction.get());
        } else {
            stream.write(TalismanCellAction.SERIALIZED_MISSING);
        }
        if (this.failedAction.isPresent()) {
            stream.write(TalismanCellAction.SERIALIZED_PRESENT);
            stream.writeObject(this.failedAction.get());
        } else {
            stream.write(TalismanCellAction.SERIALIZED_MISSING);
        }
    }
}
