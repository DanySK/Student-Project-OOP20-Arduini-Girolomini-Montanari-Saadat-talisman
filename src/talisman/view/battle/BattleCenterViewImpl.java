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

import talisman.view.ImagePanel;

/**
 * Swing implementation of the battle's center view.
 * 
 * @author Alice Girolomini
 */
public class BattleCenterViewImpl extends JPanel implements BattleCenterView {
    private final JButton attackButton;
    private final JButton fateButton;
    private final JButton magicButton;
    
    public BattleCenterViewImpl() {
        LayoutManager layout = new GridBagLayout();
        this.setLayout(layout);
        this.attackButton = new JButton(new ImageIcon("res/imgs/battle/attackButton.png"));
        this.fateButton = new JButton(new ImageIcon("res/imgs/battle/fateButton.png"));
        this.magicButton = new JButton(new ImageIcon("res/imgs/battle/magicButton.png"));
        this.add(attackButton, this.setConstraints(1, 2, 1));
        this.add(new JLabel("Attack"), this.setConstraints(1, 1, 1));
        this.add(fateButton, this.setConstraints(1, 5, 1));
        this.add(new JLabel("Fate"), this.setConstraints(1, 4, 1));
        GridBagConstraints c = this.setConstraints(3, 2, 1);
        c.anchor = GridBagConstraints.EAST;
        this.add(magicButton, c);
        c.gridy = 1;
        this.add(new JLabel("Magic"), c);
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
