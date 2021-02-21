package talisman.util;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import talisman.Controllers;

import talisman.controller.board.TalismanBoardController;
import talisman.controller.board.TalismanBoardControllerFactory;
import talisman.controller.cards.TalismanDeckControllerImpl;
import talisman.controller.character.CharacterControllerImpl;
import talisman.controller.character.CharactersController;
import talisman.model.cards.DeckImpl;
import talisman.model.cards.DeckType;
import talisman.model.cards.TalismanDeckFactory;
import talisman.model.character.CharacterModel;
import talisman.model.character.CharacterModelImpl;
import talisman.model.menu.PlayerInfo;

import talisman.view.DebugView;
import talisman.view.GameWindow;

/**
 * Class used to start a new game. It functions as a bridge between the setup
 * menu entities and their respective game counterparts.
 * 
 * @author Alberto Arduini
 *
 */
public final class GameSetupUtil {
    private static final int STARTING_GOLD = 1;
    private static final int STARTING_HEALTH = 4;
    private static final boolean SHOW_DEBUG = true;
    private static final GameSetupUtil SINGLETON = new GameSetupUtil();

    private GameWindow mainWindow;
    private boolean ready;
    private EndedListener endedListener;

    /**
     * Listener used to wait for the game to end.
     * 
     * @author Alberto Arduini
     *
     */
    public interface EndedListener extends EventListener {
        /**
         * Called when the game ends.
         */
        void gameEnded();
    }

    private GameSetupUtil() {
        this.ready = false;
    }

    /**
     * Setups a new game.
     * 
     * @param playerInfos the list of players
     * @return this utility
     */
    public GameSetupUtil setupGame(final List<PlayerInfo> playerInfos) {
        // Setup character controller
        final CharactersController charactersController = new CharacterControllerImpl();
        Controllers.setCharactersController(charactersController);
        final int playerCount = playerInfos.size();
        final List<CharacterModel> characters = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            final CharacterModelImpl character = this.createIngameCharacter(playerInfos.get(i));
            characters.add(character);
            Controllers.getCharactersController().addPlayer(character);
        }

        // Setup board controller
        final TalismanBoardController boardController = TalismanBoardControllerFactory.createController(characters);
        Controllers.setBoardController(boardController);

        // Setup decks
        Controllers.setDeckController(new TalismanDeckControllerImpl(DeckType.ADVENTURE));

        // Setup window
        this.mainWindow = new GameWindow(boardController.getView());

        this.ready = true;
        return this;
    }

    /**
     * Starts the currently prepared game.
     * 
     * @return this utility
     */
    public GameSetupUtil startGame() {
        if (!this.ready) {
            throw new IllegalStateException("The game needs to be prepared with setupGame before starting");
        }

        this.mainWindow.setVisible(true);

        if (GameSetupUtil.SHOW_DEBUG) {
            final DebugView debugView = new DebugView(Controllers.getBoardController());
            debugView.setVisible(true);
        }
        return this;
    }

    /**
     * sets the listener that is waiting for the game to end.
     * 
     * @param endedListener the listener
     * @return this utility
     */
    public GameSetupUtil setClosedListener(final EndedListener endedListener) {
        this.endedListener = endedListener;
        return this;
    }

    /**
     * Ends the current game.
     * 
     * @return this utility
     */
    public GameSetupUtil endGame() {
        this.mainWindow.close();
        Controllers.reset();
        this.ready = false;
        this.endedListener.gameEnded();
        return this;
    }

    private CharacterModelImpl createIngameCharacter(final PlayerInfo playerInfo) {
        // TODO: get statistics from the character
        return new CharacterModelImpl(GameSetupUtil.STARTING_HEALTH, 0, 0, GameSetupUtil.STARTING_GOLD, 0);
    }

    /**
     * Gets the singleton instance of this utility.
     * 
     * @return the singleton instance
     */
    public static GameSetupUtil getSingleton() {
        return GameSetupUtil.SINGLETON;
    }
}
