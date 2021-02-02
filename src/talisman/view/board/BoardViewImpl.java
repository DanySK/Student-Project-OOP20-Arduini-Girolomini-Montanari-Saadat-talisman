package talisman.view.board;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;

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
     * @param sections    the sections that this board contains
     * @param mainSection the index of the most external section
     */
    public BoardViewImpl(final List<BoardSectionView> sections, final int mainSection) {
        this.sections = List.copyOf(sections);
        final LayoutManager layout = new BorderLayout();
        this.setLayout(layout);
        // Like for the sections cells, I take as granted that the sections use the
        // swing implementation.
        // Still, the most generic type is used in case the actual type of component
        // changes.
        this.add((Component) this.sections.get(mainSection), BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSectionCount() {
        return this.sections.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BoardSectionView getSection(final int sectionIndex) {
        return this.sections.get(sectionIndex);
    }
}
