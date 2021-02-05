package talisman.model.battle;

/**
 * Interface that models the player.
 * 
 * @author Alice Girolomini
 *
 */
public interface PlayerModel {
    /**
     * Handles the death of a character.
     */
     void death();

     /**
      * Handles the death of a character and its resurrection.
      */
     void deathAndRes();

}
