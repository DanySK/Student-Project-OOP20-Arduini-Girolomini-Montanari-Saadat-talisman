package talisman.view.board;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.SwingUtilities;

import talisman.view.ImagePanel;

/**
 * Swing implementation of a pawn MVC view.
 * 
 * @author Alberto Arduini
 *
 */
public class PawnViewImpl extends ImagePanel implements PawnView {
    private static final int SIZE = 50;

    /**
     * Creates a new pawn.
     * 
     * @param imagePath the path to the pawn's image
     */
    public PawnViewImpl(final String imagePath) {
        super(imagePath);
        final Dimension size = new Dimension(PawnViewImpl.SIZE, PawnViewImpl.SIZE);
        SwingUtilities.invokeLater(() -> {
            this.setOpaque(false);
            this.setSize(size);
            this.setMaximumSize(size);
            this.setMinimumSize(size);
            });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final int x, final int y) {
        final Point position = SwingUtilities.convertPoint(SwingUtilities.getRoot(this), x, y, this.getParent());
        SwingUtilities.invokeLater(() -> this.setLocation(position));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPawnX() {
        final Component root = SwingUtilities.getRoot(this);
        if (!root.isVisible()) {
            return 0;
        }
        return SwingUtilities.convertPoint(this.getParent(), this.getLocation(), null).x;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPawnY() {
        final Component root = SwingUtilities.getRoot(this);
        if (!root.isVisible()) {
            return 0;
        }
        return SwingUtilities.convertPoint(this.getParent(), this.getLocation(), null).y;
    }
}
