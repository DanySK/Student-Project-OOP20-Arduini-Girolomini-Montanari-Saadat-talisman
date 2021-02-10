package talisman.view;

import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import talisman.controller.board.TalismanBoardController;

public class DebugView extends JFrame {
    public DebugView(final TalismanBoardController board) {
        final LayoutManager layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(layout);

        this.add(new DebugBoardView(board));
        this.setResizable(false);
        this.pack();
    }
}
