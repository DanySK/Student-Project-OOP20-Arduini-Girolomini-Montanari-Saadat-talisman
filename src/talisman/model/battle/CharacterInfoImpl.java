package talisman.model.battle;

/**
 * Implementation of character's informations in the battle.
 * 
 * @author Alice Girolomini
 *
 */
public class CharacterInfoImpl implements CharacterInfo {
    private int strength;
    private int craft;
    private int gold;
    private int fate;
    //deck[]

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
     * Gets the number of gold coins.
     * 
     * @return the value
     */
    public int getGold() {
        return this.gold;
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

    /**
     * Sets gold coins number.
     * 
     @param coins - the value to be set
     */
    public void setGold(final int coins) {
        this.gold = coins;
    }
    
    /* Card public getCard() {
        
    }
    public void addCards() {
        
    }*/

}
