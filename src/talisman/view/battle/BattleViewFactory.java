package talisman.view.battle;

import talisman.controller.battle.BattleController;

/**
 * Builder used to compose the battle view.
 * 
 * @author Alice Girolomini
 *
 */
public class BattleViewFactory {
    private BattleController controller;
    private boolean built;

    /**
     * Initializes the battle's builder.
     * 
     * @param controller - the battle's controller
     */
    public BattleViewFactory(final BattleController controller) {
        this.controller = controller;
        this.built = false;
    }

    /**
     * Creates the top view.
     * 
     * @return  the view
     */
    public BattleTopView createTopView() {
        BattleTopView view = BattleTopView.create();
        return view;
    }

    /**
     * Creates the center view.
     * 
     * @param controller - the battle's controller
     * @return  the view
     */
    public BattleCenterView createCenterView(final BattleController controller) {
        BattleCenterView view = BattleCenterView.create(this.controller);
        return view;
    }

    /**
     * Creates the bottom view.
     * 
     * @return  the view
     */
    public BattleBottomView createBottomView() {
        BattleBottomView view = BattleBottomView.create();
        return view;
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
