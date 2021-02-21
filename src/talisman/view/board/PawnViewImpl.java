package talisman.view.board;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.SwingUtilities;

import talisman.util.SwingViewUtils;
import talisman.view.ImagePanel;

/**
 * Swing implementation of a pawn MVC view.
 * 
 * @author Alberto Arduini
 *
 */
public class PawnViewImpl extends ImagePanel implements PawnView {
    private static final long serialVersionUID = 1L;
    private static final int SIZE = 50;

    /**
     * Creates a new pawn.
     * 
     * @param imagePath the path to the pawn's image
     */
    public PawnViewImpl(final String imagePath) {
        super(imagePath);
        final Dimension size = new Dimension(PawnViewImpl.SIZE, PawnViewImpl.SIZE);
        this.setOpaque(false);
        this.setSize(size);
        this.setMaximumSize(size);
        this.setPreferredSize(size);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void moveToCell(final BoardCellView cell) {
        if (this.getParent() != null) {
            ((BoardCellView) this.getParent()).removePawn(this);
        }
        cell.addPawn(this);
        this.revalidate();
    }
}
