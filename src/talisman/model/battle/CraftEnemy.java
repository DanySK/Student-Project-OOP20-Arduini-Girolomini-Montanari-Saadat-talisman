package talisman.model.battle;

/**
 * Implementation of craft enemy's informations in battle.
 * 
 * @author Alice Girolomini
 *
 */
public class CraftEnemy implements EnemyModel {
    private int craft;

    /**
     * Initializes the enemie's craft.
     * 
     * @param craft - enemie's craft
     */
    public CraftEnemy(final int craft) {
        this.craft = craft;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getStrength() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCraft() {
        return this.craft;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFate() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStrength(final int points) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCraft(final int points) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFate(final int coins) {

    }

}
