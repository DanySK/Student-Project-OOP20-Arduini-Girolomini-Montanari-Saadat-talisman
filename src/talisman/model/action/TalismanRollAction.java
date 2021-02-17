package talisman.model.action;

import java.util.List;
import java.util.Objects;

import talisman.Controllers;
import talisman.model.action.TalismanRollActionSection.ApplyResult;
import talisman.model.character.CharacterModelImpl;

import talisman.util.DiceType;
import talisman.util.Utils;

/**
 * Action for rolling a dice, based on a statistic if needed.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanRollAction implements TalismanAction {
    private static final long serialVersionUID = 2847596850734221682L;
    private static final String ABSOLUTE_DESCRIPTION_FORMAT = "Roll 1 dice,";
    private static final String RELATIVE_DESCRIPTION_FORMAT = "Roll 1 dice on %s,";
    private static final String OPTION_FORMAT = System.lineSeparator() + "if the result is at least %d then: %s";
    private static final String LAST_OPTION_FORMAT = System.lineSeparator() + "otherwise: %s";

    private final TalismanActionStatistic statistic;
    private final List<TalismanRollActionSection> sections;
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
        this(statistic, List.of(new TalismanRollActionSection(0, Objects.requireNonNull(failedAction)),
                new TalismanRollActionSection(amount, Objects.requireNonNull(successAction))));
    }

    /**
     * Creates a new roll action.
     * 
     * @param statistic      the statistic to base the roll on
     * @param resultSections the sections that indicate the possible actions base on
     *                       the results
     */
    public TalismanRollAction(final TalismanActionStatistic statistic,
            final List<TalismanRollActionSection> resultSections) {
        this.statistic = statistic;
        this.sections = List.copyOf(resultSections);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (this.getStatistic() == TalismanActionStatistic.NONE) {
            stringBuilder.append(String.format(TalismanRollAction.ABSOLUTE_DESCRIPTION_FORMAT));
        } else {
            stringBuilder.append(String.format(TalismanRollAction.RELATIVE_DESCRIPTION_FORMAT, this.getStatistic()));
        }
        for (int i = 0; i < this.sections.size() - 1; i++) {
            final TalismanRollActionSection section = this.sections.get(i);
            stringBuilder.append(String.format(TalismanRollAction.OPTION_FORMAT, section.getFromValue(),
                    section.getAction().getDescription()));
        }
        final TalismanRollActionSection finalSection = this.sections.get(this.sections.size() - 1);
        stringBuilder.append(String.format(TalismanRollAction.LAST_OPTION_FORMAT, finalSection.getFromValue(),
                finalSection.getAction().getDescription()));
        return stringBuilder.toString();
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
        for (final TalismanRollActionSection section : this.sections) {
            if (section.apply(actualValue) != ApplyResult.VALUE_NOT_ENOUGH) {
                break;
            }
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
