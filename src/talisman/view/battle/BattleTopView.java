package talisman.view.battle;

/**
 * An interface for the top view of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleTopView {
    /**
     * creates the top view of the battle.
     * 
     *@return the top view
     */
    static BattleTopView create() {
        return new BattleTopViewImpl();
    }
}
