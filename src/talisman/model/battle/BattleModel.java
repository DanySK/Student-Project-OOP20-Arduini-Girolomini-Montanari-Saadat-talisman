package talisman.model.battle;

/**
 * Inteface that models battles.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleModel {
    /**
     * Calculates the dice roll.
     * 
     * @return the result
     */
    int diceRoll();

    /**
     * Compares the scores of the players.
     * 
     * @return void
     */
    int compareScore();

    /**
     * Checks whether the battle is ended or not.
     * 
     * @return true if the battle is ended
     */
    boolean isEnded();

    /**
     * Adds the dice result to the initial score of the player.
     * 
     * @return void
     */
    void addScore();
}
