package talisman.model.battle;

import java.util.ArrayList;
import talisman.model.character.PlayerModel;

import java.util.List;

/**
 * A class that helps accessing player's informations.
 * 
 * @author Alice Girolomini
 *
 */
public final class PlayerInfos {

    private static List<PlayerModel> players = new ArrayList<>();

    private PlayerInfos() {

    }

    /**
     * Gets the player at the specified index.
     * 
     * @param index - index of the player
     * 
     * @return the player
     */
    public static PlayerModel getPlayer(final int index) {
        return PlayerInfos.players.get(index);
    }

    /**
     * Adds the player to the player's list.
     * 
     * @param player - the player to be add
     * 
     * @return the index of the new player
     */
    public static int addPlayer(final PlayerModel player) {
        PlayerInfos.players.add(player);
        return PlayerInfos.players.indexOf(player);
    }

    /**
     * Gets the number of active players.
     * 
     * @return the value
     */
    public static int getPlayerCount() {
        return PlayerInfos.players.size();
    }
}
