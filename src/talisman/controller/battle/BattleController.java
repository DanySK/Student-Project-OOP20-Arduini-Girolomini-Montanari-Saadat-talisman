package talisman.controller.battle;

import talisman.model.battle.BattleModel;

/**
 * A MVC controller for the battle.
 * 
 * @author Alice Girolomini
 */
public interface BattleController {
    
    BattleModel getBattle();
    
    void updateFate();

    int updateRoll(int i);

    int udpateScore(int i);

}
