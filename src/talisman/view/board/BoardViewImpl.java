package talisman.view.board;

import java.awt.Component;
import java.util.List;

import javax.swing.JPanel;

/**
 * A swing implementation of a view for a board.
 * 
 * @author Alberto Arduini
 *
 */
public class BoardViewImpl extends JPanel implements BoardView {
    private final List<BoardSectionView> sections;

    /**
     * Creates a new board view.
     * 
     * @param sections the sections that this board contains
     */
    public BoardViewImpl(final List<BoardSectionView> sections) {
        this.sections = List.copyOf(sections);
        for (final BoardSectionView section : this.sections) {
            // Like for the sections cells, I take as granted that the sections use the
            // swing implementation
            this.add((Component) section);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BoardSectionView getSection(final int sectionIndex) {
        return this.sections.get(sectionIndex);
    }
}
