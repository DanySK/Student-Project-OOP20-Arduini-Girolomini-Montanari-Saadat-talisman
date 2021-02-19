package talisman.model.character;

/**
 * Interface that models the player.
 * 
 * @author Alice Girolomini
 *
 */
public interface PlayerModel {
    /**
     * Gets the player's id.
     * 
     * @return the value
     */
    int getIndex();

    /**
     * Gets the count of all active players.
     * 
     * @return the value
     */
    int getNumPlayers();

    /**
     * Gets the information of the current character assigned to the player.
     * 
     * @return the value
     */
    CharacterModel getCurrentCharacter();

    /**
     * Sets id.
     * 
     @param id - the value to be set
     */
    void setIndex(int id);

    /**
     * Sets the current number of active players.
     * 
     @param number - the value to be set
     */
    void setNumPlayers(int number);

    /**
     * Sets the current character assigned to the player.
     * 
     @param character - the character to be set
     */
    void setCurrentCharacter(CharacterModelImpl character);

    /**
     * Checks whether the players has the crown of command.
     * @return true if the player has the crown
     */
    boolean hasCrown();

}
