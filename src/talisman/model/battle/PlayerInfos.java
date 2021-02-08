package talisman.model.battle;

import java.util.List;

/**
 * A class that helps accessing player's informations.
 * 
 * @author Alice Girolomini
 *
 */
public final class PlayerInfos {

    private static List<PlayerModel> players;

    /**
     * Creates player's informations.
     * 
     * @param players - list of active players
     */
    private PlayerInfos(final List<PlayerModel> players) {
        PlayerInfos.players = players;
    }

    /**
     * Gets the player at the specified index.
     * 
     * @param index - index of the player
     * 
     * @return the player
     */
    static PlayerModel getPlayer(final int index) {
        return PlayerInfos.players.get(index);
    }

    /**
     * Adds the player to the player's list.
     * 
     * @param player - the player to be add
     * 
     * @return the index of the new player
     */
    static int addPlayer(final PlayerModel player) {
        PlayerInfos.players.add(player);
        return PlayerInfos.players.indexOf(player);
    }
}
