package talisman.model.board.action;

import talisman.model.board.BoardPawn;

/**
 * A action that makes the player battle with an enemy.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanFightAction implements TalismanCellAction {
    private static final String DESCRIPTION_FORMAT = "You have to fight a %s";
    private final int enemy;

    /**
     * Creates a new fight action.
     * 
     * @param enemy the index of the enemy in the enemies list to fight
     */
    public TalismanFightAction(final int enemy) {
        this.enemy = enemy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanFightAction.DESCRIPTION_FORMAT, enemy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyTo(final BoardPawn playerPawn) {
        // TODO: Start fight
    }

    /**
     * Gets the enemy to fight.
     * 
     * @return the index of the enemy in the enemies list
     */
    public int getEntityIndex() {
        return this.enemy;
    }
}
