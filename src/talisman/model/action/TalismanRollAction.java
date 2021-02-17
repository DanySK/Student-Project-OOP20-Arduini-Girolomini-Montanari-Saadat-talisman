package talisman.model.action;

import java.util.Objects;

import talisman.Controllers;

import talisman.model.character.CharacterModelImpl;

import talisman.util.DiceType;
import talisman.util.Utils;

/**
 * Action for rolling a dice, based on a statistic if needed.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanRollAction extends TalismanAmountAction {
    private static final long serialVersionUID = 2847596850734221682L;
    private static final String ABSOLUTE_DESCRIPTION_FORMAT = "Roll 1 dice, if the result is at least %d then: %s"
            + System.lineSeparator() + "otherwise: %s";
    private static final String RELATIVE_DESCRIPTION_FORMAT = "Roll 1 dice on %s, if the result is at least %d then: %s"
            + System.lineSeparator() + "otherwise: %s";

    private final TalismanActionStatistic statistic;
    private final TalismanAction successAction;
    private final TalismanAction failedAction;
    private int lastResult;

    /**
     * Creates a new roll action.
     * 
     * @param amount        the minimum amount to reach
     * @param statistic     the statistic to base the roll on
     * @param successAction what to do on success
     * @param failedAction  what to do on failure
     */
    public TalismanRollAction(final int amount, final TalismanActionStatistic statistic,
            final TalismanAction successAction, final TalismanAction failedAction) {
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
        if (this.getStatistic() == TalismanActionStatistic.NONE) {
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
    public void apply() {
        this.lastResult = Utils.rollDice(DiceType.SEVEN);
        int actualValue = this.getResult();
        final CharacterModelImpl playerStatistics = (CharacterModelImpl) Controllers.getCharactersController()
                .getCurrentPlayer().getCurrentCharacter();
        switch (this.getStatistic()) {
        case CRAFT:
            actualValue += playerStatistics.getCraft();
            break;
        case FAITH:
            actualValue += playerStatistics.getFate();
            break;
        case HEALTH:
            actualValue += playerStatistics.getHealth();
            break;
        case STRENGTH:
            actualValue += playerStatistics.getStrength();
            break;
        case GOLD:
            actualValue += playerStatistics.getGold();
        default:
            break;
        }
        if (actualValue >= this.getAmount()) {
            this.successAction.apply();
        } else {
            this.failedAction.apply();
        }
    }

    /**
     * Gets which statistic should be used for this throw.
     * 
     * @return the statistic
     */
    public TalismanActionStatistic getStatistic() {
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
