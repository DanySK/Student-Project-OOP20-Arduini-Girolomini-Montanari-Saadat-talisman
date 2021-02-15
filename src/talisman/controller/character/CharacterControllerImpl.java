package talisman.controller.character;

import talisman.model.character.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the MVC controller for the players
 *
 * @author Enrico Maria Montanari
 */
public class CharacterControllerImpl implements CharactersController {

    private int currentPlayer;
    private int activePlayers;

    public CharacterControllerImpl(){

        currentPlayer = 0;
        activePlayers = 0;
    }

    @Override
    public PlayerModel getCurrentPlayer() {

        return Players.getPlayer(currentPlayer);
    }

    @Override
    public void setCurrentPlayer(int index) {

        if (index >= activePlayers) currentPlayer = 0;
        else currentPlayer = index;
    }

    @Override
    public void addPlayer(CharacterModelImpl character) {

        Players.addPlayer(character, ++activePlayers);
    }

    @Override
    public void removePlayer(int index) {

        Players.removePlayer(index);
        activePlayers--;
    }

    @Override
    public int getActivePlayers(){

        return activePlayers;
    }
}

/**
 * Utility class to store all registered players in the game
 *
 * @author Enrico Maria Montanari
 */
class Players {

    private static List<PlayerModel> players = new ArrayList<>();
    private static int lastId = 0;

    static void addPlayer(CharacterModelImpl character, int activePlayers){

        players.add(new PlayerModelImpl(activePlayers, lastId++, character));
    }

    static PlayerModel getPlayer(int index){

        return players.get(index);
    }

    static void removePlayer(int index){

        players.remove(index);
        lastId--;
    }
}
