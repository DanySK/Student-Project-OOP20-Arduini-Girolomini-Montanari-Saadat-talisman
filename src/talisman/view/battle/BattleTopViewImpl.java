package talisman.view.battle;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import talisman.view.ImagePanel;

/**
 * Swing implementation of the battle's top view.
 * 
 * @author Alice Girolomini
 */
public class BattleTopViewImpl extends JPanel implements BattleTopView {
    private final JLabel firstCharDamage;
    private final JLabel secondCharDamage;

    public BattleTopViewImpl() {
        LayoutManager layout = new GridBagLayout();
        this.setLayout(layout);
        this.firstCharDamage = new JLabel("0");
        this.secondCharDamage = new JLabel("0");
        this.add(firstCharDamage, this.setConstraints(16, 15, 1));
        this.add(secondCharDamage, this.setConstraints(41, 15, 1));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/banner.png")), this.setConstraints(20, 10, 1));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/sword.png")), this.setConstraints(5, 15, 1));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/sword.png")), this.setConstraints(30, 15, 1));
        this.setBackground(Color.darkGray);
    }

    private GridBagConstraints setConstraints(final int x, final int y, final int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5 ,5);
        return c;
    }
}
