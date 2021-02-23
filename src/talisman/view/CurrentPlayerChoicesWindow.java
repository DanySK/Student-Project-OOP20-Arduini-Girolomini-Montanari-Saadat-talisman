package talisman.view;

import talisman.controller.character.CurrentPlayerChoicesController;

/**
 * Interface of the view used to display the player's choices.
 * 
 * @author Alice Girolomini
 *
 */
public interface CurrentPlayerChoicesWindow {
    /**
     * Shows the window used to display the player's choices.
     *
     * @param controller - the controller of the player's choices
     */
    static void show(CurrentPlayerChoicesController controller) {
        new CurrentPlayerChoicesWindowImpl(controller);
    }
}
