package talisman.model.action;

import talisman.model.battle.PlayerInfos;
import talisman.model.board.BoardPawn;

/**
 * An action that adds or removes gold from a player.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanPayGoldAction extends TalismanAmountAction {
    private static final String PAY_DESCRIPTION_FORMAT = "Pay %d gold";
    private static final String PAYED_DESCRIPTION_FORMAT = "Receive %d gold";

    /**
     * Create a new pay gold action.
     * 
     * @param amount how much gold the player has to pay or get payed
     */
    public TalismanPayGoldAction(final int amount) {
        super(amount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(this.getAmount() < 0 ? TalismanPayGoldAction.PAY_DESCRIPTION_FORMAT
                : TalismanPayGoldAction.PAYED_DESCRIPTION_FORMAT, this.getAmount());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final int player) {
        final int currentValue = this.getCurrentPlayerGold(player);
        PlayerInfos.getPlayer(player).getCurrentCharacter().setGold(currentValue + this.getAmount());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canBeApplied(final int player) {
        return this.getCurrentPlayerGold(player) + this.getAmount() >= 0;
    }

    private int getCurrentPlayerGold(final int player) {
        return PlayerInfos.getPlayer(player).getCurrentCharacter().getGold();
    }
}
