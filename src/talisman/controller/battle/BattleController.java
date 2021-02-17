package talisman.controller.battle;

import talisman.model.battle.BattleModel;
import talisman.model.character.CharacterModel;

/**
 * A MVC controller for the battle.
 * 
 * @author Alice Girolomini
 */
public interface BattleController {
    
    BattleModel getBattle();
    
    CharacterModel getFirstCharacter();
    
    CharacterModel getSecondCharacter();
    
    void requestedFate();

    int updateRoll(int i);

    int udpateScore(int i);
    
    void requestedAttack();

}
