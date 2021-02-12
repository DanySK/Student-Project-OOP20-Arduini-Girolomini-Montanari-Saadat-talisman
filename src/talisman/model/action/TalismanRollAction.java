package talisman.model.action;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import talisman.model.battle.CharacterInfo;
import talisman.model.battle.PlayerInfos;
import talisman.model.board.BoardPawn;
import talisman.util.DiceType;
import talisman.util.Utils;

/**
 * Action for rolling a dice, based on a statistic if needed.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanRollAction extends TalismanAmountAction {
    private static final long serialVersionUID = 4657209105775876617L;
    private static final String SINGLE_ACTION_DESCRIPTION_FORMAT = "- %s";
    private static final String ABSOLUTE_DESCRIPTION_FORMAT = "Roll 1 dice, if the result is at least %d then:"
            + System.lineSeparator() + TalismanRollAction.SINGLE_ACTION_DESCRIPTION_FORMAT
            + System.lineSeparator() + "otherwise:"
            + System.lineSeparator() + TalismanRollAction.SINGLE_ACTION_DESCRIPTION_FORMAT;
    private static final String RELATIVE_DESCRIPTION_FORMAT = "Roll 1 dice on %s, if the result is at least %d then:"
            + System.lineSeparator() + TalismanRollAction.SINGLE_ACTION_DESCRIPTION_FORMAT
            + System.lineSeparator() + "otherwise:"
            + System.lineSeparator() + TalismanRollAction.SINGLE_ACTION_DESCRIPTION_FORMAT;

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
            return super.toString().toLowerCase(Locale.ENGLISH);
        }
    }

    private final RollStatistic statistic;
    private final TalismanAction successAction;
    private final TalismanAction failedAction;
    private int lastResult;

    /**
     * Creates a new roll action.
     * 
     * @param amount        the minimum amount to reach
     * @param statistic     the statistic to base the roll on
     * @param successAction what to do on success
     * @param failedAction  what to do on failuer
     */
    public TalismanRollAction(final int amount, final RollStatistic statistic, final TalismanAction successAction,
            final TalismanAction failedAction) {
        super(amount);
        this.statistic = statistic;
        this.successAction = Objects.requireNonNull(successAction);
        this.failedAction = Objects.requireNonNull(failedAction);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        if (this.getStatistic() == RollStatistic.ABSOLUTE) {
            return String.format(TalismanRollAction.ABSOLUTE_DESCRIPTION_FORMAT, this.getAmount(),
                    this.successAction.getDescription(), this.failedAction.getDescription());
        } else {
            return String.format(TalismanRollAction.RELATIVE_DESCRIPTION_FORMAT, this.getStatistic(), this.getAmount(),
                    this.successAction.getDescription(), this.failedAction.getDescription());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final int player) {
        this.lastResult = Utils.rollDice(DiceType.SEVEN);
        int actualValue = this.getResult();
        final CharacterInfo playerStatistics = PlayerInfos.getPlayer(player).getCurrentCharacter();
        switch (this.getStatistic()) {
        case CRAFT:
            actualValue += playerStatistics.getCraft();
            break;
        case FAITH:
            actualValue += playerStatistics.getFate();
            break;
        case HEALTH:
            // actualValue += playerStatistics.getHealth();
            break;
        case STRENGTH:
            actualValue += playerStatistics.getStrength();
            break;
        default:
            break;
        }
        if (actualValue >= this.getAmount()) {
            this.successAction.applyTo(player);
        } else {
            this.failedAction.applyTo(player);
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
}
