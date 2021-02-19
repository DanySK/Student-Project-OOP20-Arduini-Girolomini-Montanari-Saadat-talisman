package talisman;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import talisman.controller.cards.TalismanCardController;

import talisman.model.cards.DeckType;
import talisman.model.cards.TalismanDeckFactory;

import talisman.util.GameSetupUtil;

import talisman.view.menu.MainMenuWindow;

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
        final JPanel card = (JPanel) TalismanCardController.createView(TalismanDeckFactory.createDeck(DeckType.ADVENTURE).draw());
        thirdWindow.getContentPane().add(card, thirdconstraint);
        thirdWindow.pack();
        thirdWindow.setResizable(false);
        thirdWindow.setVisible(true);
        // test battle view
        final JFrame secondWindow = new JFrame();
        final LayoutManager secondLayout = new GridBagLayout();
        final GridBagConstraints secondConstraint = new GridBagConstraints();
        secondConstraint.gridx = 0;
        secondConstraint.gridy = 0;
        secondConstraint.fill = GridBagConstraints.BOTH;
        secondWindow.setLayout(secondLayout);
        secondWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //final JPanel swingBattleTopView = new BattleTopViewImpl();
        //final JPanel swingBattleCenterView = new BattleCenterViewImpl();
        //final JPanel swingBattleBottomView = new BattleBottomViewImpl();
        //secondWindow.getContentPane().add(swingBattleTopView, secondConstraint);
        secondConstraint.gridx = 0;
        secondConstraint.gridy = 1;
        //secondWindow.getContentPane().add(swingBattleCenterView, secondConstraint);
        secondConstraint.gridx = 0;
        secondConstraint.gridy = 2;
        //secondWindow.getContentPane().add(swingBattleBottomView, secondConstraint);
        secondWindow.pack();
        secondWindow.setResizable(false);
        secondWindow.setVisible(true);


    }

    private void showMainMenu() {
        this.mainMenu.setVisible(true);
    }

    public static void main(final String[] args) {
        new App().run();
    }
}
