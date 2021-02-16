package talisman.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import talisman.util.GameSetupUtil;
import talisman.view.board.TalismanBoardView;

/**
 * A window for showing an ongoing the game.
 * 
 * @author Alberto Arduini
 *
 */
public class GameWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private static final int WINDOW_SIZE_X = 1280;
    private static final int WINDOW_SIZE_Y = 720;

    /**
     * Creates a new game window.
     * 
     * @param board the game board to display
     */
    public GameWindow(final TalismanBoardView board) {
        final LayoutManager layout = new GridBagLayout();
        this.setLayout(layout);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setSize(GameWindow.WINDOW_SIZE_X, GameWindow.WINDOW_SIZE_Y);
        this.setResizable(false);

        final GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.fill = GridBagConstraints.NONE;
        this.add((JPanel) board, constraint);

        this.pack();
    }

    /**
     * Closes the game window.
     */
    public void close() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
