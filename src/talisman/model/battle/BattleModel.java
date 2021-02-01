package talisman.model.battle;

/**
 * Inteface that models battles.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleModel {
    /**
     * Calculates the dice roll of the first player.
     */
    void firstDiceRoll();

    /**
     * Calculates the dice roll of the second player.
     */
    void secondDiceRoll();

    /**
     * Compares the scores of the players.
     */
    void compareScore();

    /**
     * Checks whether the battle is ended or not.
     * 
     * @return true if the battle is ended
     */
    boolean isEnded();

    /**
     * Adds the dice result to the initial score of the player.
     */
    void addScore();

    /**
     * Gets the current state of the battle.
     * 
     * @return the current BattleState
     */
    BattleState getState();
}
