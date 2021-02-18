package talisman.view.cards;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import talisman.model.cards.CardType;
import talisman.util.ViewUtils;
import talisman.view.ImagePanel;

public class TalismanCardViewImpl extends JPanel implements TalismanCardView {
    private ImagePanel image;
    private CardType type;
    private JTextArea text;
    public TalismanCardViewImpl(final String imagePath, final String text, final CardType type) {
        this.image = new ImagePanel(ViewUtils.getPathToCard(type, imagePath, true));
        this.type = type;
        final LayoutManager layout = new BorderLayout();
        this.setLayout(layout);
        this.text = new JTextArea(1, 1);
        this.text.setText(text);
        this.text.setForeground(Color.WHITE);
        this.text.setBackground(Color.BLACK);
        this.text.setLineWrap(true);
        this.text.setWrapStyleWord(true);
        this.text.setEditable(false);
        this.text.setAlignmentX(CENTER_ALIGNMENT);
        this.text.setAlignmentY(CENTER_ALIGNMENT);
        this.text.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.add(this.image);
        this.add(this.text, BorderLayout.PAGE_END);
        final Dimension size = new Dimension(275, 150);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
    }
}
