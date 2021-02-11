package talisman.model.action;

import talisman.model.board.BoardPawn;

/**
 * An action that damages or heals a player by a fixed amount.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanDamageAction extends TalismanAmountAction {
    private static final String DESCRIPTION_FORMAT = "Get %s by %d points";
    private static final String DAMAGE_NAME = "damaged";
    private static final String HEAL_NAME = "healed";

    /**
     * Create a new damage action.
     * 
     * @param amount how much to damage or heal the player
     */
    public TalismanDamageAction(final int amount) {
        super(amount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanDamageAction.DESCRIPTION_FORMAT,
                this.getAmount() < 0 ? TalismanDamageAction.DAMAGE_NAME : TalismanDamageAction.HEAL_NAME,
                this.getAmount());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final int player) {
        // TODO: Apply damage or heal
    }
}
