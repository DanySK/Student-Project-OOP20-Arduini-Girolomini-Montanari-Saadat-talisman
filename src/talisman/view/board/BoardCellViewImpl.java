package talisman.view.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import talisman.util.CellType;
import talisman.util.SwingViewUtils;
import talisman.view.ImagePanel;

/**
 * An implementation for a swing-based cell view.
 * 
 * * @author Alberto Arduini
 *
 */
public final class BoardCellViewImpl extends ImagePanel implements BoardCellView {
    private static final long serialVersionUID = 1L;
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
        final JTextArea textArea = new JTextArea(1, 1);
        textArea.setText(text);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setAlignmentX(CENTER_ALIGNMENT);
        textArea.setAlignmentY(CENTER_ALIGNMENT);
        textArea.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        this.add(textArea, BorderLayout.PAGE_END);
        final Dimension size = new Dimension(275, 150);
        this.setMinimumSize(size);
        this.setPreferredSize(size);
        this.setMaximumSize(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CellType getCellType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCellX() {
        return SwingViewUtils.getGlobalPosition(this).x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCellY() {
        return SwingViewUtils.getGlobalPosition(this).y;
    }
}
