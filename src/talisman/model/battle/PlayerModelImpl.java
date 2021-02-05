package talisman.model.battle;

/**
 * Implementation of the player.
 * 
 * @author Alice Girolomini
 *
 */
public class PlayerModelImpl implements PlayerModel {
    private int numPlayers;
    private int id;
    private CharacterInfo currentCharacter;
    private boolean crown;

    /**
     * Creates the enemy's informations.
     * 
     * @param numPlayers the number of active players
     * @param character the current character's information assigned to the player
     */
    public PlayerModelImpl(final int numPlayers, final CharacterInfo character) {
        this.numPlayers = numPlayers;
        this.currentCharacter = character;
        this.crown = false;
    }

    /**
     * Handles the death of a character.
     */
    public void death() {
        
        
    }

    /**
     * Handles the death of a character and its resurrection.
     */
    public void deathAndRes() {
        // TODO Auto-generated method stub
        
    }

}
