package talisman.model.battle;

/**
 * Implementation of enemy's informations in the battle.
 * 
 * @author Alice Girolomini
 *
 */
public class EnemyInfoImpl implements CharacterInfo {
    private int strength;
    private int craft;
    private int fate;

    /**
     * Creates the enemy's informations.
     * 
     * @param strength - the initial strength value
     * @param craft - the initial craft value
     * @param fate - the initial fate coin number
     */
    public EnemyInfoImpl(final int strength, final int craft, final int fate) {
        this.strength = strength;
        this.craft = craft;
        this.fate = fate;
    }

    /**
     * Gets the number of strength points.
     * 
     * @return the value
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * Gets the number of craft points.
     * 
     * @return the value
     */
    public int getCraft() {
        return this.craft;
    }

    /**
     * Gets the number of fate coins.
     * 
     * @return the value
     */
    public int getFate() {
        return this.fate;
    }

    /**
     * Sets strength points value.
     * 
     @param points - the value to be set
     */
    public void setStrength(final int points) {
        this.strength = points;
    }

    /**
     * Sets craft points value.
     * 
     @param points - the value to be set
     */
    public void setCraft(final int points) {
        this.craft = points;
    }

    /**
     * Sets Fate points value.
     * 
     @param coins - the value to be set
     */
    public void setFate(final int coins) {
        this.fate = coins;
    }
}
