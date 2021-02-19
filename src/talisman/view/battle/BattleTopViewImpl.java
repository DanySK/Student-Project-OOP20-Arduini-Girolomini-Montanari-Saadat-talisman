package talisman.view.battle;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import talisman.controller.battle.BattleController;
import talisman.view.ImagePanel;

/**
 * Swing implementation of the top view of the battle.
 * 
 * @author Alice Girolomini
 */
public class BattleTopViewImpl extends JPanel implements BattleTopView {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final int INSETSVALUE = 5;
    private static final int XCOORDINATEIMAGE = 5;
    private static final int XCOORDINATELABEL = 6;
    private final JLabel firstCharDamage;
    private final JLabel secondCharDamage;
    private final BattleController controller;

    /**
     * Initializes the top view of the battle.
     * 
     * @param controller - the controller of the battle
     */
    public BattleTopViewImpl(final BattleController controller) {
        LayoutManager layout = new GridBagLayout();
        this.setLayout(layout);
        this.controller = controller;
        HashMap<Integer, Integer> values = this.controller.initializeScores();
        this.firstCharDamage = new JLabel(values.get(1).toString());
        this.secondCharDamage = new JLabel(values.get(2).toString());
        this.add(this.firstCharDamage, this.setConstraints(2, 2, 1));
        this.add(this.secondCharDamage, this.setConstraints(XCOORDINATELABEL, 2, 1));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/banner.png")), this.setConstraints(3, 0, 1));
        this.add(new JLabel("Attack score 1 :"), this.setConstraints(0, 1, 1));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/sword.png")), this.setConstraints(0, 2, 1));
        this.add(new JLabel("Attack score 2 :"), this.setConstraints(XCOORDINATEIMAGE, 1, 1));
        this.add(new JLabel(new ImageIcon("res/imgs/battle/sword.png")), this.setConstraints(XCOORDINATEIMAGE, 2, 1));
        this.setBackground(Color.darkGray);
    }

    /**
     * Sets new constraints for the specified component.
     * 
     * @param x - the x coordinate of the component
     * @param y - the y coordinate of the component
     * @param width - the width of the component
     *@return the bottom view
     */
    private GridBagConstraints setConstraints(final int x, final int y, final int width) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(INSETSVALUE, INSETSVALUE, INSETSVALUE, INSETSVALUE);
        return c;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getAttackScore(final int character) {
        if (character == 1) {
            return Integer.parseInt(this.firstCharDamage.getText());
        }
        return Integer.parseInt(this.secondCharDamage.getText());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAttackScore(final int character, final int value) {
        if (character == 1) {
            this.firstCharDamage.setText(String.valueOf(value));
        } else {
            this.secondCharDamage.setText(String.valueOf(value));
        }
    }
}
