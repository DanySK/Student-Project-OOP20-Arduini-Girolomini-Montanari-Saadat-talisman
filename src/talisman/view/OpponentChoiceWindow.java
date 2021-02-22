package talisman.view;

import java.util.List;
/**
 * Interface of the view used to select an opponent to fight.
 * 
 * @author Alice Girolomini
 *
 */
public interface OpponentChoiceWindow {
    /**
     * Shows the window used to select an opponent to fight.
     * 
     * @param players - the indexes of the players in the same cell
     */
    static void show(final List<Integer> players) {
        new OpponentChoiceWindowImpl(players);
    }
}
