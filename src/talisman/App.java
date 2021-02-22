package talisman;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import talisman.controller.battle.BattleController;
import talisman.controller.battle.BattleControllerImpl;
import talisman.controller.cards.TalismanCardController;
import talisman.model.battle.BattleModel;
import talisman.model.battle.BattleModelImpl;
import talisman.model.battle.EnemyModel;
import talisman.model.battle.StrengthEnemy;
import talisman.model.cards.Deck;
import talisman.model.cards.DeckType;
import talisman.model.cards.TalismanDeckFactory;
import talisman.model.character.CharacterModel;
import talisman.model.character.CharacterModelImpl;
import talisman.util.GameSetupUtil;
import talisman.view.BattleWindow;
import talisman.view.OpponentChoiceWindow;
import talisman.view.battle.BattleBottomView;
import talisman.view.battle.BattleBottomViewImpl;
import talisman.view.battle.BattleCenterView;
import talisman.view.battle.BattleCenterViewImpl;
import talisman.view.battle.BattleTopView;
import talisman.view.battle.BattleTopViewImpl;
import talisman.view.menu.MainMenuWindow;

import javax.swing.*;
import java.awt.*;

public final class App {
    private final MainMenuWindow mainMenu;

    private App() {
        this.mainMenu = new MainMenuWindow();
        GameSetupUtil.getSingleton().setClosedListener(this::showMainMenu);
    }

    private void run() {
        this.showMainMenu();
        // test card view
        final JFrame thirdWindow = new JFrame();
        final LayoutManager thirdlayout = new GridBagLayout();
        final GridBagConstraints thirdconstraint = new GridBagConstraints();
        thirdconstraint.gridx = 0;
        thirdconstraint.gridy = 0;
        thirdconstraint.fill = GridBagConstraints.BOTH;
        thirdWindow.setLayout(thirdlayout);
        thirdWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Deck deck = TalismanDeckFactory.createDeck(DeckType.ADVENTURE);
        deck.shuffle();
        final JPanel card = (JPanel) TalismanCardController.createView(deck.draw());
        thirdWindow.getContentPane().add(card, thirdconstraint);
        thirdWindow.pack();
        thirdWindow.setResizable(false);
        thirdWindow.setVisible(true);
        // test battle view
        CharacterModel character1 = new CharacterModelImpl(1, 2, 3, 4, 0);
        CharacterModel character2 = new CharacterModelImpl(6, 7, 8, 9, 10);
        EnemyModel enemy1 = new StrengthEnemy(9, "Troll");
        BattleModel battle = new BattleModelImpl(character1.getStrength(), enemy1.getStrength());
        BattleController controller = new BattleControllerImpl(character1, enemy1, battle);
        new BattleWindow(controller);
        //test opponent window
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
        OpponentChoiceWindow.show(list);

    }

    private void showMainMenu() {
        this.mainMenu.setVisible(true);
    }

    public static void main(final String[] args) {
        new App().run();
    }
}
