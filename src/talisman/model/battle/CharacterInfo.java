package talisman.model.battle;

/**
 * Interface that models the opponents involved in the battle.
 * 
 * @author Alice Girolomini
 *
 */
public interface CharacterInfo {
    /**
     * Gets the number of strength points.
     * 
     * @return the value
     */
    int getStrength();

    /**
     * Gets the number of craft points.
     * 
     * @return the value
     */
    int getCraft();

    /**
     * Gets the number of fate coins.
     * 
     * @return the value
     */
    int getFate();

    /**
    * Sets strength points value.
    * 
    @param points - the value to be set
    */
    void setStrength(int points);

    /**
     * Sets craft points value.
     * 
     @param points - the value to be set
     */
    void setCraft(int points);

    /**
     * Sets Fate points value.
     * 
     @param coins - the value to be set
     */
    void setFate(int coins);
}
