package talisman.model.action;

import talisman.controller.character.CurrentPlayerChoicesController;

/**
 * Models an action that skips to the next player turn.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanSkipTurnAction implements TalismanAction {
    /**
     * Gets what to show if no action is present.
     */
    private static final String DESCRIPTION = "Skip your turn";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return TalismanSkipTurnAction.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply() {
        CurrentPlayerChoicesController.skipTurn();
    }
}
