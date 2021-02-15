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
    private static final int INSETSVALUE = 5;
    private static final int XCOORDINATEIMAGE = 5;
    private static final int XCOORDINATELABEL = 6;
    private final JLabel firstCharDamage;
    private final JLabel secondCharDamage;

    /**
     * Initializes the battle's top view.
     * 
     */
    public BattleTopViewImpl() {
        LayoutManager layout = new GridBagLayout();
        this.setLayout(layout);
        this.firstCharDamage = new JLabel("0");
        this.secondCharDamage = new JLabel("0");
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
     * Gets the attack score of the first character.
     * 
     *@return the value
     */
    public int getFirstAttackScore() {
        return Integer.parseInt(this.firstCharDamage.getText());
    }

    /**
     * Gets the attack score of the second character.
     * 
     *@return the value
     */
    public int getSecondAttackScore() {
        return Integer.parseInt(this.secondCharDamage.getText());
    }

    /**
     * Sets the value of the attack score for the first character.
     * 
     *@param value - the value to be set
     */
    public void setFirstAttackScore(final int value) {
        this.firstCharDamage.setText(String.valueOf(value));
    }

    /**
     * Sets the value of the attack score for the second character.
     * 
     *@param value - the value to be set
     */
    public void setSecondAttackScore(final int value) {
        this.secondCharDamage.setText(String.valueOf(value));
    }
}
