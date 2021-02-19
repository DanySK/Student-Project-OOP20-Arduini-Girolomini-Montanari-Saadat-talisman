package talisman.model.action;

import talisman.Controllers;
import talisman.model.board.TalismanBoardCell;

/**
 * An action that makes the player draw a given amount of cards.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanDrawCardAction implements TalismanAction {
    private static final String DESCRIPTION_FORMAT = "Draw a card if there isn't already one in this space";

    /**
     * Creates a new draw card action.
     */
    public TalismanDrawCardAction() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanDrawCardAction.DESCRIPTION_FORMAT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply() {
        // TODO: draw card from deck
        Controllers.getBoardController().setCurrentCharacterCellCard(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canBeApplied() {
        final int playerIndex = Controllers.getCharactersController().getCurrentPlayer().getIndex();
        return !Controllers.getBoardController().getCharacterCell(playerIndex).getCard().isPresent();
    }
}
