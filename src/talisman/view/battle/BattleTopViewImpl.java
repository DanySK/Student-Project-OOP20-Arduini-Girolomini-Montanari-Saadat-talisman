package talisman.view.battle;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import talisman.view.ImagePanel;

/**
 * Swing implementation of the battle's top view.
 * 
 * @author Alice Girolomini
 */
public class BattleTopViewImpl extends ImagePanel implements BattleTopView {
    private final JLabel firstCharDamage;
    private final JLabel secondCharDamage;

    public BattleTopViewImpl() {
        super("res/imgs/battle/background.png");
        LayoutManager layout = new GridBagLayout();
        this.setLayout(layout);
        this.firstCharDamage = new JLabel("0");
        this.secondCharDamage = new JLabel("0");
        this.add(firstCharDamage, this.setConstraints(16, 15, 10));
        this.add(secondCharDamage, this.setConstraints(41, 15, 10));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/banner.png")), this.setConstraints(20, 10, 10));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/sword.png")), this.setConstraints(5, 15, 10));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/sword.png")), this.setConstraints(30, 15, 10));
        this.setBackground(Color.darkGray);
    }

    private GridBagConstraints setConstraints(final int x, final int y, final int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.insets = new Insets(5, 5, 5 ,5);
        return c;
    }
}
