package talisman;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.LayoutManager;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import talisman.controller.board.TalismanBoardController;

import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardFactory;
import talisman.model.board.TalismanBoardPawn;
import talisman.util.ViewUtils;
import talisman.view.DebugView;
import talisman.view.battle.BattleTopViewImpl;
import talisman.view.board.PopulatedBoardView;
import talisman.view.board.PopulatedBoardViewBuilder;

public final class App {
    private static final int START_WINDOW_SIZE_X = 1280;
    private static final int START_WINDOW_SIZE_Y = 720;

    private static final boolean SHOW_DEBUG = false;

    private App() {
    }

    private void run() {
        // Hard-coded swing GUI for testing
        final JFrame window = new JFrame();
        final LayoutManager layout = new GridBagLayout();
        window.setLayout(layout);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(START_WINDOW_SIZE_X, START_WINDOW_SIZE_Y);
        final TalismanBoardController boardController = this.createBoard();
        final PopulatedBoardView boardView = boardController.getView();
        final JPanel swingBoardView = (JPanel) boardView;
        final int edgeSize = Integer.min(START_WINDOW_SIZE_X, START_WINDOW_SIZE_Y);
        swingBoardView.setSize(edgeSize, edgeSize);
        final GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.NONE;
        window.getContentPane().add(swingBoardView, constraint);
        window.pack();
        window.setResizable(false);
        window.setVisible(true);

        if (App.SHOW_DEBUG) {
            final DebugView debugView = new DebugView(boardController);
            debugView.setVisible(true);
        }

        //test battle view
        final JFrame secondWindow = new JFrame();
        final LayoutManager secondLayout = new GridBagLayout();
        final GridBagConstraints secondConstraint = new GridBagConstraints();
        secondConstraint.gridx = 0;
        secondConstraint.gridy = 0;
        secondConstraint.fill = GridBagConstraints.BOTH;
        secondWindow.setLayout(secondLayout);
        secondWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final JPanel swingBattleView = new BattleTopViewImpl();
        secondWindow.getContentPane().add(swingBattleView, secondConstraint);
        secondWindow.pack();
        secondWindow.setResizable(false);
        secondWindow.setVisible(true);
    }

    private TalismanBoardController createBoard() {
        // TODO: change to models created from the menu
        final List<TalismanBoardPawn> pawns = List
                .of(TalismanBoardPawn.createPawn(ViewUtils.getDevImagePath(ViewUtils.DEV_PAWN_IMAGE_NAME, true), 0));
        final TalismanBoard board = TalismanBoardFactory.createDefaultBoardModel(pawns);
        final PopulatedBoardViewBuilder viewBuilder = new PopulatedBoardViewBuilder();
        return TalismanBoardController.create(board, viewBuilder.buildFromModel(board));
    }

    public static void main(final String[] args) {
        new App().run();
    }
}
