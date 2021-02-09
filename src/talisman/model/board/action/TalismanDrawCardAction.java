package talisman.model.board.action;

import talisman.model.board.BoardPawn;

/**
 * An action that makes the player draw a given amount of cards.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanDrawCardAction extends TalismanAmountAction {
    private static final String DESCRIPTION_FORMAT = "Draw %d cards";

    /**
     * Creates a new draw card action.
     * 
     * @param amount how may cards to draw
     */
    public TalismanDrawCardAction(final int amount) {
        super(amount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanDrawCardAction.DESCRIPTION_FORMAT, this.getAmount());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final BoardPawn playerPawn) {
        // TODO: Draw cards
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canBeApplied(final BoardPawn playerPawn) {
        // TODO: Check if cell is clear of cards
        return false;
    }
}
