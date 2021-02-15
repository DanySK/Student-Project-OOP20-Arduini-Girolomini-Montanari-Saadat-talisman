package talisman.view.battle;

/**
 * An interface for the center view of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleCenterView {
    /**
     * creates the center view of the battle.
     * 
     *@return the center view
     */
    static BattleCenterView create() {
        return new BattleCenterViewImpl();
    }
}
