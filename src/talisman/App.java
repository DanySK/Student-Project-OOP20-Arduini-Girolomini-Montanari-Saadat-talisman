package talisman;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import talisman.controller.cards.TalismanCardController;
import talisman.controller.character.CurrentPlayerChoicesController;
import talisman.model.cards.Deck;
import talisman.model.cards.DeckType;
import talisman.model.cards.TalismanDeckFactory;
import talisman.util.GameSetupUtil;
import talisman.view.CurrentPlayerChoicesWindow;
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

        //test CurrentPlayerChoicesWindow
        CurrentPlayerChoicesWindow.show(CurrentPlayerChoicesController.create(0));

    }

    private void showMainMenu() {
        this.mainMenu.setVisible(true);
    }

    public static void main(final String[] args) {
        new App().run();
    }
}
