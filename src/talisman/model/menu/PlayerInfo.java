package talisman.model.menu;

/**
 * Used to store the informations for players that are ready to start a game.
 * 
 * @author Alberto Arduini
 *
 */
public class PlayerInfo {
    private final int character;

    /**
     * Creates a new player info.
     * 
     * @param character the index of the character that the player has selected.
     */
    public PlayerInfo(final int character) {
        this.character = character;
    }

    /**
     * Gets which character this player has selected.
     * 
     * @return the character index
     */
    public int getCharacter() {
        return this.character;
    }
}
