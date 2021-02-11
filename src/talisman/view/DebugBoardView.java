package talisman.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import talisman.controller.board.TalismanBoardController;

public class DebugBoardView extends JPanel {
    private static final long serialVersionUID = 1L;

    private final JTextArea selectedPlayerNumber;

    private final JTextArea moveCell;
    private final JTextArea moveSection;

    public DebugBoardView(final TalismanBoardController board) {
        final LayoutManager layout = new GridBagLayout();
        this.setLayout(layout);
        // Player selection
        this.selectedPlayerNumber = new JTextArea("0");
        this.add(new JLabel("Selected player"), this.createConstraint(0, 0));
        this.add(this.selectedPlayerNumber, this.createConstraint(1, 0));
        // Move to section
        this.moveCell = new JTextArea("0");
        this.moveSection = new JTextArea("0");
        this.add(new JLabel("Move to"), this.createConstraint(0, 1));
        this.add(new JLabel("Cell"), this.createConstraint(0, 2));
        this.add(this.moveCell, this.createConstraint(1, 2));
        this.add(new JLabel("Section"), this.createConstraint(0, 3));
        this.add(this.moveSection, this.createConstraint(1, 3));
        this.add(this.createButton("Move",
                (e) -> board.moveCharacterSection(this.parseTextAreaAsInteger(this.selectedPlayerNumber),
                        this.parseTextAreaAsInteger(this.moveSection), this.parseTextAreaAsInteger(this.moveCell))),
                this.createConstraint(1, 4));
    }

    private JButton createButton(final String text, final ActionListener callback) {
        final JButton button = new JButton();
        button.setText(text);
        button.addActionListener(callback);
        return button;
    }

    private GridBagConstraints createConstraint(final int x, final int y) {
        final GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = x;
        constraint.gridy = y;
        constraint.fill = GridBagConstraints.HORIZONTAL;
        return constraint;
    }

    private int parseTextAreaAsInteger(final JTextArea area) {
        return Integer.parseInt(area.getText());
    }
}
