package talisman.view.battle;

import java.awt.event.ActionListener;

/**
 * An interface for the center view of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleCenterView {
    /**
     * Creates the center view of the battle.
     * 
     *@return the center view
     */
    static BattleCenterView create() {
        return new BattleCenterViewImpl();
    }
}
