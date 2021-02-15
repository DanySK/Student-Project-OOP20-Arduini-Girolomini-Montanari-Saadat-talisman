package talisman.view.battle;

/**
 * An interface for the top view of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleTopView {
    /**
     * Gets the attack score of the first character.
     * 
     *@return the value
     */
    int getFirstAttackScore();

    /**
     * Gets the attack score of the second character.
     * 
     *@return the value
     */
    int getSecondAttackScore();

    /**
     * Sets the value of the attack score for the first character.
     * 
     *@param value - the value to be set
     */
    void setFirstAttackScore(int value);

    /**
     * Sets the value of the attack score for the second character.
     * 
     *@param value - the value to be set
     */
    void setSecondAttackScore(int value);

    /**
     * creates the top view of the battle.
     * 
     *@return the top view
     */
    static BattleTopView create() {
        return new BattleTopViewImpl();
    }
}
