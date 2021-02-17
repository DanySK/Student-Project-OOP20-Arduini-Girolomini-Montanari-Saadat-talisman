package talisman.controller.battle;

import talisman.model.battle.BattleModel;
import talisman.model.character.CharacterModel;
import talisman.view.battle.BattleBottomView;
import talisman.view.battle.BattleCenterView;
import talisman.view.battle.BattleTopView;

public class BattleControllerImpl implements BattleController{
    private final BattleModel model;
    private final CharacterModel firstCharacter;
    private final CharacterModel secondCharacter;
    private int turn;

    public BattleControllerImpl(CharacterModel firstCharacter, CharacterModel secondCharacter) {
        this.firstCharacter = firstCharacter;
        this.secondCharacter = secondCharacter;
        this.model = model;
        this.turn = 0
    }
    @Override
    public BattleModel getBattle() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CharacterModel getFirstCharacter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CharacterModel getSecondCharacter() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateFate() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int updateRoll(int i) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int udpateScore(int i) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void requestedFate() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void requestedAttack() {
        // TODO Auto-generated method stub
        
    }

}
