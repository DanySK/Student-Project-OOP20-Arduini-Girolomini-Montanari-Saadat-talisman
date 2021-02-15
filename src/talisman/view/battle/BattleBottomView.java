package talisman.view.battle;

/**
 * An interface for the bottom view of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public interface BattleBottomView {
    /**
     * creates the bottom view of the battle.
     * 
     *@return the bottom view
     */
    static BattleBottomView create() {
        return new BattleBottomViewImpl();
    }

}
