package talisman.view.battle;


import talisman.controller.battle.BattleController;

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
    static BattleCenterView create(BattleController controller) {
        return new BattleCenterViewImpl(controller);
    }
}
