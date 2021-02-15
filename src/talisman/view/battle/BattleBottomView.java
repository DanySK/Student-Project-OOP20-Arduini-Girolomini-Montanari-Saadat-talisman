package talisman.view.battle;

/**
 * An interface for the bottom view of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleBottomView {
    /**
     * Gets the attack roll of the first character.
     * 
     *@return the value
     */
    int getFirstAttackRoll();

    /**
     * Gets the attack roll of the first character.
     * 
     *@return the value
     */
    int getSecondAttackRoll();

    /**
     * Sets the attack roll of the first character.
     * 
     *@param value - the result of the dice roll
     */
    void setFirstAttackRoll(int value);

    /**
     * Sets the attack roll of the second character.
     * 
     *@param value - the result of the dice roll
     */
    void setSecondAttackRoll(int value);

    /**
     * creates the bottom view of the battle.
     * 
     *@return the bottom view
     */
    static BattleBottomView create() {
        return new BattleBottomViewImpl();
    }

}
