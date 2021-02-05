package talisman.model.battle;

import java.util.Random;

/**
 * Implementation of battle model.
 * 
 * @author Alice Girolomini
 *
 */

public class BattleModelImpl implements BattleModel {
    private static final int MAXDICEVALUE = 7;
    private int firstCharScore;
    private int secondCharScore;
    private int firstDice;
    private int secondDice;
    private final Random rand = new Random();
    private BattleState currentState;
    private boolean end;

    /**
     * Creates a new battle model.
     * 
     * @param firstCharScore the initial strength or craft of the first player
     * @param secondCharScore the initial strength or craft of the second player
     */
    public BattleModelImpl(final int firstCharScore, final int secondCharScore) {
        this.firstCharScore = firstCharScore;
        this.secondCharScore = secondCharScore;
        this.firstDice = 0;
        this.secondDice = 0;
        this.currentState = BattleState.START;
        this.end = false;
    }
    /**
     *  Calculates the dice roll of the first player.
     */
    public void firstDiceRoll() {
        int result = 0;
        while (result == 0) {
            result = rand.nextInt(MAXDICEVALUE);
        }
        this.firstDice = result;
    }

    /**
     *  Calculates the dice roll of the second player.
     */
    public void secondDiceRoll() {
        int result = 0;
        while (result == 0) {
            result = rand.nextInt(MAXDICEVALUE);
        }
        this.secondDice = result;
    }

    /**
     * Checks if one of the players decides to evade the battle.
     * @return true if one of them evades
     */
    public boolean checkEvade() {
        if (this.firstCharScore == 0 || this.secondCharScore == 0) {
            this.currentState = BattleState.EVADE;
            this.end = true;
            return true;
        }
        return false;
    }

    /**
     * Compares the scores of the players.
     */
    public void compareScore() {
        if (this.firstCharScore > this.secondCharScore) {
            this.currentState = BattleState.FIRST;
        } else if (this.firstCharScore < this.secondCharScore) {
            this.currentState = BattleState.SECOND;
        } else if (this.firstCharScore == this.secondCharScore) {
            this.currentState = BattleState.STAND_OFF;
        }
        this.end = true;
    }

    /**
     * Checks whether the battle is ended or not.
     * 
     * @return true if the battle is ended
     */
    public boolean isEnded() {
        return this.end;
    }

    /**
     * Adds the dice result to the initial score of the player.
     */
    public void addScore() {
        this.firstCharScore = this.firstCharScore + this.firstDice;
        this.secondCharScore = this.secondCharScore + this.secondDice;
    }

    /**
     * Gets the current state of the battle.
     * 
     * @return the current BattleState
     */
    public BattleState getState() {
        return this.currentState;
    }

    /**
     * Gets the current score of the first player.
     * 
     * @return the value
     */
    public int getFirstScore() {
        return this.firstCharScore;
    }

    /**
     * Gets the current score of the second player.
     * 
     * @return the value
     */
    public int getSecondScore() {
        return this.secondCharScore;
    }

    /**
     * Gets the value of the last die roll of the first player.
     * 
     * @return the value
     */
    public int getFirstDice() {
        return this.firstDice;
    }

    /**
     * Gets the value of the last die roll of the second player.
     * 
     * @return the value
     */
    public int getSecondDice() {
        return this.secondDice;
    }
}
