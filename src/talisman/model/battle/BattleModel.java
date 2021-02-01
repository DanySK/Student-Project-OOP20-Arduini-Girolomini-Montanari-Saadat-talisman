package talisman.model.battle;

/**
 * Interface that models battles.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleModel {
    /**
     * Checks if one of the players decides to evade the battle.
     * @return true if one of them evades
     */
    boolean checkEvade(); 

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
