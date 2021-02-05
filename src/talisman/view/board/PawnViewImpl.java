package talisman.view.board;

import talisman.view.ImagePanel;

/**
 * Swing implementation of a pawn MVC view.
 * 
 * @author Alberto Arduini
 *
 */
public class PawnViewImpl extends ImagePanel implements PawnView {
    public PawnViewImpl(final String imagePath) {
        super(imagePath);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final int x, final int y) {
        this.setLocation(x, y);
    }
}
