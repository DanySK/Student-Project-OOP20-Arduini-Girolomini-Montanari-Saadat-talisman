package talisman.view.battle;

/**
 * Builder used to compose the battle view.
 * 
 * @author Alice Girolomini
 *
 */
public class BattleViewBuilder {
    private boolean built;

    /**
     * Initializes the battle's builder.
     * 
     */
    public BattleViewBuilder() {
        this.built = false;
    }

    /**
     * Creates the top view.
     * 
     */
    public void createTopView() {
        BattleTopView.create();
    }

    /**
     * Creates the center view.
     * 
     */
    public void createCenterView() {
        BattleCenterView.create();
    }

    /**
     * Creates the bottom view.
     * 
     */
    public void createBottomView() {
        BattleBottomView.create();
    }

    /**
     * Checks whether the view is built.
     * 
     * @return true if the battle's view is ready
     */
    boolean isBuilt() {
        return this.built;
    }

}
