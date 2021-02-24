package talisman;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import talisman.controller.board.TalismanBoardController;
import talisman.controller.cards.TalismanCardController;
import talisman.controller.character.CharacterControllerImpl;
import talisman.controller.character.CharactersController;
import talisman.controller.character.CurrentPlayerChoicesController;
import talisman.model.cards.Deck;
import talisman.model.cards.DeckType;
import talisman.model.cards.TalismanDeckFactory;
import talisman.model.character.CharacterModelImpl;
import talisman.model.character.PlayerModel;
import talisman.model.character.PlayerModelImpl;
import talisman.model.character.defaultCharacters.TalismanCharacterFactory;
import talisman.test.util.BoardTestUtils;
import talisman.util.GameSetupUtil;
import talisman.view.CurrentPlayerChoicesWindow;
import talisman.view.cards.TalismanDeckView;
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
        final JPanel card = (JPanel) TalismanDeckView.create(deck.getCards());
        thirdWindow.getContentPane().add(card, thirdconstraint);
        thirdWindow.pack();
        thirdWindow.setResizable(false);
        thirdWindow.setVisible(true);

        //test CurrentPlayerChoicesWindow
        TalismanBoardController boardController = BoardTestUtils.createController(2, 10, 2);
        Controllers.setBoardController(boardController);
        PlayerModel player1 = new PlayerModelImpl(1, 0, TalismanCharacterFactory.createAssassinCharacter());
        PlayerModel player2 = new PlayerModelImpl(2, 1, TalismanCharacterFactory.createDruidCharacter());
        CharactersController c = new CharacterControllerImpl();
        Controllers.setCharactersController(c);
        Controllers.getCharactersController().addPlayer((CharacterModelImpl) player1.getCurrentCharacter());
        Controllers.getCharactersController().addPlayer((CharacterModelImpl) player2.getCurrentCharacter());
        Controllers.getCharactersController().setCurrentPlayer(0);
        Controllers.setChoiceController(CurrentPlayerChoicesController.create(0));
    }

    private void showMainMenu() {
        this.mainMenu.setVisible(true);
    }

    public static void main(final String[] args) {
        new App().run();
    }
}
