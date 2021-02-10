package talisman.model.board.action;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;
import java.util.Random;

import talisman.model.board.BoardPawn;

/**
 * Action for rolling a dice, based on a statistic if needed.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanRollAction extends TalismanAmountAction {
    private static final long serialVersionUID = 4657209105775876617L;
    private static final String ABSOLUTE_DESCRIPTION_FORMAT = "Roll 1 dice, if the result is at least %d then:"
            + System.lineSeparator() + "- %s" + System.lineSeparator() + "otherwise:" + System.lineSeparator() + "- %s";
    private static final String RELATIVE_DESCRIPTION_FORMAT = "Roll 1 dice on %s, if the result is at least %d then:"
            + System.lineSeparator() + "- %s" + System.lineSeparator() + "otherwise:" + System.lineSeparator() + "- %s";
    private static final int DICE_MAX_VALUE = 6;

    /**
     * Decides which statistic should be used when checking for a roll.
     * 
     * @author Alberto Arduini
     *
     */
    public enum RollStatistic {
        /**
         * 
         */
        ABSOLUTE, HEALTH, FAITH, CRAFT, STRENGTH;

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    private final RollStatistic statistic;
    // Saved as optional, since a roll may only have a success or failure
    // consequence
    private transient Optional<TalismanCellAction> successAction;
    private transient Optional<TalismanCellAction> failedAction;
    private final Random rng;
    private int lastResult;

    /**
     * Creates a new roll action.
     * 
     * @param amount        the minimum amount to reach
     * @param statistic     the statistic to base the roll on
     * @param successAction what to do on success
     * @param failedAction  what to do on failuer
     */
    public TalismanRollAction(final int amount, final RollStatistic statistic, final TalismanCellAction successAction,
            final TalismanCellAction failedAction) {
        super(amount);
        this.statistic = statistic;
        this.successAction = Optional.ofNullable(successAction);
        this.failedAction = Optional.ofNullable(failedAction);
        this.rng = new Random();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        if (this.getStatistic() == RollStatistic.ABSOLUTE) {
            return String.format(TalismanRollAction.ABSOLUTE_DESCRIPTION_FORMAT, this.getAmount(),
                    this.getActionDescription(successAction), this.getActionDescription(failedAction));
        } else {
            return String.format(TalismanRollAction.RELATIVE_DESCRIPTION_FORMAT, this.getStatistic(), this.getAmount(),
                    this.getActionDescription(successAction), this.getActionDescription(failedAction));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final BoardPawn playerPawn) {
        this.lastResult = rng.nextInt(DICE_MAX_VALUE) + 1;
        final int actualValue = this.lastResult; // TODO: Add statistic, once the players list is done
        if (actualValue >= this.getAmount()) {
            this.successAction.ifPresent(a -> a.applyTo(playerPawn));
        } else {
            this.failedAction.ifPresent(a -> a.applyTo(playerPawn));
        }
    }

    /**
     * Gets which statistic should be used for this throw.
     * 
     * @return the statistic
     */
    public RollStatistic getStatistic() {
        return this.statistic;
    }

    /**
     * Gets the last throw result.
     * 
     * @return the roll result
     */
    public int getResult() {
        return this.lastResult;
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
