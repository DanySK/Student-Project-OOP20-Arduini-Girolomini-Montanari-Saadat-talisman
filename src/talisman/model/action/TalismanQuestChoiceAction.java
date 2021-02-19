package talisman.model.action;

import java.util.List;

/**
 * Models an action that lets the player choose a quest, if he can and if he
 * wants to.
 * 
 * @author Alberto Arduini
 *
 * @param <X>
 */
// TODO: Set X to the quest type
public class TalismanQuestChoiceAction<X> extends TalismanChoiceAction<X> {
    private static final String DESCRIPTION_FORMAT = "You may take a quest:";
    private static final String QUEST_DESCRIPTION_FORMAT = "- %s";

    private final List<X> quests;

    /**
     * Creates a new quest choice action.
     * 
     * @param quests the list of the possible quests
     */
    public TalismanQuestChoiceAction(final List<X> quests) {
        super();
        this.quests = List.copyOf(quests);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X getChoice(final int index) {
        return this.quests.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getChoiceDescription(final int index) {
        // TODO: Print quest description
        return String.format(TalismanQuestChoiceAction.QUEST_DESCRIPTION_FORMAT, Integer.toString(index));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getDescriptionFormat() {
        return TalismanQuestChoiceAction.DESCRIPTION_FORMAT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean applyChoice(final int choice) {
        if (choice == 0) {
            return true;
        }
        // TODO: Start quest
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getChoicesCount() {
        return this.quests.size();
    }
}
