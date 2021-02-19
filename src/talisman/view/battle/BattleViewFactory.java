package talisman.view.battle;

import talisman.controller.battle.BattleController;

/**
 * Factory used to create the view of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public class BattleViewFactory {
    private BattleController controller;

    /**
     * Initializes the factory.
     * 
     * @param controller - the controller of the battle
     */
    public BattleViewFactory(final BattleController controller) {
        this.controller = controller;
    }

    /**
     * Creates the top view.
     * 
     * @param controller - the controller of the battle
     * @return  the view
     */
    public BattleTopView createTopView(final BattleController controller) {
        BattleTopView view = BattleTopView.create(controller);
        return view;
    }

    /**
     * Creates the center view.
     * 
     * @param controller - the controller of the battle
     * @param topView - the top view of the battle
     * @param bottomView - the bottom view of the battle
     * @return  the view
     */
    public BattleCenterView createCenterView(final BattleController controller, final BattleTopView topView, final BattleBottomView bottomView) {
        BattleCenterView view = BattleCenterView.create(this.controller, topView, bottomView);
        return view;
    }

    /**
     * Creates the bottom view.
     * 
     * @param controller - the controller of the battle
     * @return  the view
     */
    public BattleBottomView createBottomView(final BattleController controller) {
        BattleBottomView view = BattleBottomView.create(controller);
        return view;
    }

}
