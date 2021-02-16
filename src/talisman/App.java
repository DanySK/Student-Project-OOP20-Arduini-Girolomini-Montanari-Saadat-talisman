package talisman;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import talisman.util.GameSetupUtil;

import talisman.view.battle.BattleBottomViewImpl;
import talisman.view.battle.BattleCenterViewImpl;
import talisman.view.battle.BattleTopViewImpl;

import talisman.view.menu.MainMenuWindow;

public final class App {
    private final MainMenuWindow mainMenu;

    private App() {
        this.mainMenu = new MainMenuWindow();
        GameSetupUtil.getSingleton().setClosedListener(this::showMainMenu);
    }

    private void run() {
        this.showMainMenu();

        // test battle view
        final JFrame secondWindow = new JFrame();
        final LayoutManager secondLayout = new GridBagLayout();
        final GridBagConstraints secondConstraint = new GridBagConstraints();
        secondConstraint.gridx = 0;
        secondConstraint.gridy = 0;
        secondConstraint.fill = GridBagConstraints.BOTH;
        secondWindow.setLayout(secondLayout);
        secondWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final JPanel swingBattleTopView = new BattleTopViewImpl();
        final JPanel swingBattleCenterView = new BattleCenterViewImpl();
        final JPanel swingBattleBottomView = new BattleBottomViewImpl();
        secondWindow.getContentPane().add(swingBattleTopView, secondConstraint);
        secondConstraint.gridx = 0;
        secondConstraint.gridy = 1;
        secondWindow.getContentPane().add(swingBattleCenterView, secondConstraint);
        secondConstraint.gridx = 0;
        secondConstraint.gridy = 2;
        secondWindow.getContentPane().add(swingBattleBottomView, secondConstraint);
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
