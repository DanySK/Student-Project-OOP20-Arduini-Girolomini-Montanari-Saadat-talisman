package talisman.model.character;

/**
 * Implementation of the player.
 * 
 * @author Alice Girolomini
 *
 */
public class PlayerModelImpl implements PlayerModel {
    private int numPlayers;
    private int id;
    private CharacterModelImpl currentCharacter;
    private boolean crown;

    /**
     * Creates the enemy's informations.
     * 
     * @param numPlayers - the number of active players
     * @param id - the player's id
     * @param character - the current character's information assigned to the player
     */
    public PlayerModelImpl(final int numPlayers, final int id, final CharacterModelImpl character) {
        this.numPlayers = numPlayers;
        this.id = id;
        this.currentCharacter = character;
        this.crown = false;
    }

    /**
     * Gets the player's id.
     * 
     * @return the value
     */
    public int getIndex() {
        return this.id;
    }

    /**
     * Gets the count of all active players.
     * 
     * @return the value
     */
    public int getNumPlayers() {
        return this.numPlayers;
    }

    /**
     * Gets the information of the current character assigned to the player.
     * 
     * @return the value
     */
    public CharacterModelImpl getCurrentCharacter() {
        return this.currentCharacter;
    }

    /**
     * Sets id.
     * 
     @param id - the value to be set
     */
    public void setIndex(final int id) {
        this.id = id;
    }

    /**
     * Sets the current number of active players.
     * 
     @param number - the value to be set
     */
    public void setNumPlayers(final int number) {
        this.numPlayers = number;
    }

    /**
     * Sets the current character assigned to the player.
     * 
     @param character - the character to be set
     */
    public void setCurrentCharacter(final CharacterModelImpl character) {
        this.currentCharacter = character;
    }

    /**
     * Checks whether the players has the crown of command.
     * @return true if the player has the crown
     */
    public boolean hasCrown() {
        return this.crown;
    }

}
