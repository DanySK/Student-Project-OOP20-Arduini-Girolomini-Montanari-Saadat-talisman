package talisman.view.battle;

public interface BattleTopView {
    
    static BattleTopView create(final String imagePath) {
        return new BattleTopViewImpl(imagePath);
    }
}
