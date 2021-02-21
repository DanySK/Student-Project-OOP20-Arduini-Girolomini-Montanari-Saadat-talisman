package talisman;

import java.util.HashMap;
import java.util.Map;

import talisman.controller.board.TalismanBoardController;
import talisman.controller.cards.TalismanDeckController;
import talisman.controller.character.CharactersController;

import talisman.model.cards.DeckType;

/**
 * Static utility class that holds references to all the controllers that should
 * be accessed statically. It also prevents multiple controller instances
 * assignments during a game.
 * 
 * @author Alberto Arduini
 *
 */
public final class Controllers {
    private static TalismanBoardController boardController;
    private static CharactersController charactersController;
    private static Map<DeckType, TalismanDeckController> deckControllers = new HashMap<>();

    private Controllers() {
    }

    /**
     * Gets the active board controller.
     * 
     * @return the controller
     */
    public static TalismanBoardController getBoardController() {
        return Controllers.boardController;
    }

    /**
     * Gets the active characters controller.
     * 
     * @return the controller
     */
    public static CharactersController getCharactersController() {
        return Controllers.charactersController;
    }

    /**
     * Gets the active deck controller for the given deck type.
     * 
     * @param type the type of deck
     * 
     * @return the controller
     */
    public static TalismanDeckController getDeckController(final DeckType type) {
        return Controllers.deckControllers.get(type);
    }

    /**
     * Sets the active board controller.
     * 
     * @param controller the controller to set
     * 
     * @throws IllegalStateException if the controller is already assigned
     */
    public static void setBoardController(final TalismanBoardController controller) {
        if (Controllers.boardController != null) {
            throw new IllegalStateException("The controller was already assigned");
        }
        Controllers.boardController = controller;
    }

    /**
     * Sets the active character controller.
     * 
     * @param controller the controller to set
     * 
     * @throws IllegalStateException if the controller is already assigned
     */
    public static void setCharactersController(final CharactersController controller) {
        if (Controllers.charactersController != null) {
            throw new IllegalStateException("The controller was already assigned");
        }
        Controllers.charactersController = controller;
    }

    /**
     * Sets the active deck controller for the given deck type.
     * 
     * @param controller the controller to set
     * 
     * @throws IllegalStateException if the controller is already assigned
     */
    // TODO: get deck type
    public static void setDeckController(final TalismanDeckController controller) {
        if (Controllers.deckControllers.containsKey(DeckType.ADVENTURE)) {
            throw new IllegalStateException("The controller was already assigned");
        }
        Controllers.deckControllers.put(DeckType.ADVENTURE, controller);
    }

    /**
     * Resets the controller references. This should be called when ending a game.
     */
    public static void reset() {
        Controllers.boardController = null;
        Controllers.charactersController = null;
        Controllers.deckControllers.clear();
    }
}
