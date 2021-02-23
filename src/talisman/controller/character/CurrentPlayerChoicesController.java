package talisman.controller.character;

import java.util.EventListener;

import talisman.Controllers;
import talisman.view.CurrentPlayerChoicesWindow;

/**
 * Interface that controls the current player's choices.
 * 
 * @author Alice Girolomini
 *
 */
public interface CurrentPlayerChoicesController {

    /**
     * Used to send an event for when any action done by the controller is ended.
     * 
     * @author Alberto Arduini
     *
     */
    public static interface EventEndedListener extends EventListener {
        /**
         * Called on event end.
         */
        void eventEnded();
    }

    /**
     * Checks whether the player rolled the dice or not.
     * 
     * @return true if the player rolled the dice
     */
    boolean checkRoll();

    /**
     * Checks if there are available opponents.
     * 
     * @return true if there are available opponents
     */
    boolean checkOpponents();

    /**
     * Rolls the dice.
     * 
     * @return the result
     */
    int getDiceRoll();

    /**
     * Gets the current player's index.
     * 
     * @return the index
     */
    int getCurrentPlayerIndex();

    /**
     * Moves the current player's pawn.
     */
    void movePawn();

    /**
     * Passes the turn.
     */
    void passTurn();

    /**
     * Applies the cell event.
     */
    void cellEvent();

    /**
     * Opens the OpponentChoiceWindow and starts the fight.
     */
    void challengeCharacter();

    /**
     * Sets the listener waiting for events to end.
     * 
     * @param listener the listener
     */
    void setEventEndedListener(EventEndedListener listener);

    /**
     * Skips the current turn.
     */
    static void skipTurn() {
        Controllers.getCharactersController()
                .setCurrentPlayer(Controllers.getCharactersController().getCurrentPlayer().getIndex() + 1);
        CurrentPlayerChoicesWindow.show(CurrentPlayerChoicesController
                .create(Controllers.getCharactersController().getCurrentPlayer().getIndex()));
    }

    /**
     * Creates the current player's controller.
     * 
     * @param index - index of the current player
     * @return the controller
     */
    static CurrentPlayerChoicesController create(int index) {
        return new CurrentPlayerChoicesControllerImpl(index);
    }
}
