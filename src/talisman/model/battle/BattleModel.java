package talisman.model.battle;


/**
 * Interface that models battles.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleModel {
    /**
     *  Calculates the opponent's dice roll.
     *
     *  @param character - the opponent
     */
    void diceRoll(int character);

    /**
     * Checks whether one of the opponents decided to escape from the battle.
     * @return true if one of them evades
     */
    boolean checkEvade(); 

    /**
     * Compares the opponents' scores.
     */
    void compareScore();

    /**
     * Checks whether the battle is ended or not.
     * 
     * @return true if the battle is ended
     */
    boolean isEnded();

    /**
     * Gets the current state of the battle.
     * 
     * @return the current BattleState
     */
    BattleState getState();

    /**
     * Gets the current score for the specified character.
     * 
     * @param character - the character
     * @return the value
     */
    int getScore(int character);

    /**
     * Gets the value of the last dice roll from the specified opponent.
     * 
     * @param character - the opponent
     * @return the value
     */
    int getDiceRoll(int character);
 

    /**
     * Sets the opponent's score.
     * 
     * @param character - the opponent
     * @param value - the value to be set
     */
    void setScore(int character, int value);
}
