package talisman.view.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

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
    private static final int SIZE_X = 275;
    private static final int SIZE_Y = 150;
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
        final LayoutManager layout = new OverlayLayout(this);
        this.setLayout(layout);
        final JTextArea textArea = new JTextArea(1, 1);
        textArea.setText(text);
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.BLACK);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        this.add(textArea);
        final Dimension cellSize = new Dimension(BoardCellViewImpl.SIZE_X, BoardCellViewImpl.SIZE_Y);
        this.setMinimumSize(cellSize);
        this.setPreferredSize(cellSize);
        this.setMaximumSize(cellSize);
        final Dimension textSize = new Dimension(BoardCellViewImpl.SIZE_X, textArea.getPreferredSize().height);
        textArea.setMinimumSize(textSize);
        textArea.setPreferredSize(textSize);
        textArea.setMaximumSize(textSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPawn(final PawnView pawn) {
        this.addPawn((PawnViewImpl) pawn);
    }

    /**
     * Adds a pawn from the cell.
     * 
     * @param pawn the pawn to add
     */
    public void addPawn(final PawnViewImpl pawn) {
        this.add(pawn, 0);
        this.repaint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePawn(final PawnView pawn) {
        this.removePawn((PawnViewImpl) pawn);
    }

    /**
     * Removes a pawn from the cell.
     * 
     * @param pawn the pawn to remove
     */
    public void removePawn(final PawnViewImpl pawn) {
        this.remove(pawn);
        this.repaint();
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
    public boolean isOptimizedDrawingEnabled() {
        return false;
    }
}
