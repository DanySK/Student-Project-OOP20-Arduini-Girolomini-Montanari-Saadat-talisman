package talisman.view.battle;

public interface BattleBottomView {
    
    static BattleBottomView create(final String imagePath) {
        return new BattleBottomViewImpl(imagePath);
    }

}
