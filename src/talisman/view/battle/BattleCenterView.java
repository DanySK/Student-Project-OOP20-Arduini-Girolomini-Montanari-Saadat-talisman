package talisman.view.battle;

public interface BattleCenterView {

    static BattleCenterView create(final String imagePath) {
        return new BattleCenterViewImpl();
    }
}
