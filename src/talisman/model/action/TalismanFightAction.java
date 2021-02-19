package talisman.model.action;

/**
 * A action that makes the player battle with an enemy.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanFightAction implements TalismanAction {
    private static final long serialVersionUID = 1L;
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
    public void apply() {
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
