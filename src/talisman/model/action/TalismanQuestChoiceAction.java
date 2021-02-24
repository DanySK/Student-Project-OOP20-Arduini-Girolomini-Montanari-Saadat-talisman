package talisman.model.action;

import java.util.List;

import talisman.Controllers;
import talisman.model.quests.TalismanQuest;

/**
 * Models an action that lets the player choose a quest, if he can and if he
 * wants to.
 * 
 * @author Alberto Arduini
 */
public class TalismanQuestChoiceAction extends TalismanChoiceAction<TalismanQuest> {
    private static final long serialVersionUID = 2235915833077645617L;
    private static final String DESCRIPTION_FORMAT = "You may take a quest:";
    private static final String QUEST_DESCRIPTION_FORMAT = "- %s ";

    private final List<TalismanQuest> quests;

    /**
     * Creates a new quest choice action.
     * 
     * @param quests the list of the possible quests
     */
    public TalismanQuestChoiceAction(final List<TalismanQuest> quests) {
        super();
        this.quests = List.copyOf(quests);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanQuest getChoice(final int index) {
        return this.quests.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getChoiceDescription(final int index) {
        return String.format(TalismanQuestChoiceAction.QUEST_DESCRIPTION_FORMAT, this.quests.get(index));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Boolean isChoiceEnabled(final int index) {
        return true;
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
            // TODO: start quest
            // Controllers.getCharactersController().getCurrentPlayer().
        }
        this.actionEnded();
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getChoicesCount() {
        return this.quests.size();
    }
}
