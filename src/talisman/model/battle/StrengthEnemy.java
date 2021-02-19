package talisman.model.battle;

/**
 * Implementation of strength enemy's informations in battle.
 * 
 * @author Alice Girolomini
 *
 */
public class StrengthEnemy implements EnemyModel {
    private int strength;

    /**
     * Initializes the enemie's strength.
     * 
     * @param strength - enemie's strength
     */
    public StrengthEnemy(final int strength) {
        this.strength = strength;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getStrength() {
        return this.strength;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCraft() {
        return 0;
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
