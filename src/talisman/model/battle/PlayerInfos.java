package talisman.model.battle;

import java.util.List;

/**
 * Implementation  .
 * 
 * @author Alice Girolomini
 *
 */
public final class PlayerInfos {

    private static List<PlayerModel> players;

    private PlayerInfos(final List<PlayerModel> players) {
        PlayerInfos.players = players;
    }
    static PlayerModel getPlayer(final int index) {
        return PlayerInfos.players.get(index);
    }

    static int addPlayer(final PlayerModel player) {
        PlayerInfos.players.add(player);
        return PlayerInfos.players.indexOf(player);
    }
}
