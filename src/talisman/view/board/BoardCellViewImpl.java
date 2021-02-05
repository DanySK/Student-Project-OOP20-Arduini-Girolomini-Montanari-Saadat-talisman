package talisman.view.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.JPanel;

import talisman.util.CellType;
import talisman.view.ImagePanel;

/**
 * An implementation for a swing-based cell view.
 * 
 * * @author Alberto Arduini
 *
 */
// getX and getY do not get overridden since they are already define in JComponent
public final class BoardCellViewImpl extends ImagePanel implements BoardCellView {
    private final JLabel textLabel;
    private final JPanel textBackground;
    private final CellType type;

    /**
     * Creates a new cell.
     * 
     * @param imagePath the path to the background image
     * @param text      the text on the cell
     * @param type      the type of the cell
     */
    public BoardCellViewImpl(final String imagePath, final String text, final CellType type) {
        super(imagePath);
        this.type = type;
        final LayoutManager layout = new BorderLayout();
        this.setLayout(layout);
        this.textBackground = new JPanel();
        this.textBackground.setBackground(Color.BLACK);
        this.add(this.textBackground, BorderLayout.PAGE_END);
        this.textLabel = new JLabel();
        this.textLabel.setText(text);
        this.textLabel.setForeground(Color.WHITE);
        this.textBackground.add(this.textLabel);
        Dimension textSize = this.textLabel.getMinimumSize();
        if (textSize == null) {
            textSize = this.textLabel.getSize();
        }
        this.setMinimumSize(new Dimension((int) textSize.getWidth(), (int) textSize.getWidth()));
        this.setPreferredSize(new Dimension((int) textSize.getWidth(), (int) textSize.getWidth()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CellType getCellType() {
        return this.type;
    }
}
