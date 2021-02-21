package talisman.view.battle;

import talisman.controller.battle.BattleController;

/**
 * Factory used to create the view of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public final class BattleViewFactory {

    private BattleViewFactory() {
    }

    /**
     * Creates the battleView view.
     * 
     * @param controller - the controller of the battle
     */
    public static void createBattleView(final BattleController controller) {
        BattleTopView topView = createTopView(controller);
        BattleBottomView bottomView = createBottomView(controller);
        createCenterView(controller, topView, bottomView);
    }

    /**
     * Creates the top view.
     * 
     * @param controller - the controller of the battle
     * @return  the view
     */
    private static BattleTopView createTopView(final BattleController controller) {
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
    private static BattleCenterView createCenterView(final BattleController controller, final BattleTopView topView, final BattleBottomView bottomView) {
        BattleCenterView view = BattleCenterView.create(controller, topView, bottomView);
        return view;
    }

    /**
     * Creates the bottom view.
     * 
     * @param controller - the controller of the battle
     * @return  the view
     */
    private static BattleBottomView createBottomView(final BattleController controller) {
        BattleBottomView view = BattleBottomView.create(controller);
        return view;
    }

}
