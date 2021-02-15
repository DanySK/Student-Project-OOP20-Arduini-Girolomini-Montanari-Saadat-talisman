package talisman.view.battle;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Swing implementation of the battle's bottom view.
 * 
 * @author Alice Girolomini
 */
public class BattleBottomViewImpl extends JPanel implements BattleBottomView {
    private final JButton diceButton;
    private final JLabel firstRoll;
    private final JLabel secondRoll;
    
    public BattleBottomViewImpl() {
        LayoutManager layout = new GridBagLayout();
        this.setLayout(layout);
        this.firstRoll = new JLabel("0");
        this.secondRoll = new JLabel("0");
        this.diceButton = new JButton(new ImageIcon("res/imgs/battle/diceButton.png"));
        this.add(new JLabel("Dice"), this.setConstraints(1, 0, 1));
        this.add(diceButton, this.setConstraints(1, 1, 1));
        this.add(firstRoll, this.setConstraints(2, 1, 1));
        this.add(new JLabel("Roll dice 1:"), this.setConstraints(2, 0, 1));
        this.add(secondRoll, this.setConstraints(3, 1, 1));
        this.add(new JLabel("Roll dice 2:"), this.setConstraints(3, 0, 1));
        this.setBackground(Color.darkGray);
    }

    private GridBagConstraints setConstraints(final int x, final int y, final int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 5, 5, 5);
        return c;
    }

}
