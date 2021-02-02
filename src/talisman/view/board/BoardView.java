package talisman.view.board;

import java.util.List;

/**
 * Interface for a view of a game board.
 * 
 * @author Alberto Arduini
 */
public interface BoardView {
    /**
     * Gets the section at the given index.
     * 
     * @param sectionIndex the section index
     * @return the section instance
     */
    BoardSectionView getSection(int sectionIndex);
    /**
     * Creates a new view from a list of sections.
     * 
     * @param sections the contained sections
     * @return the created view
     */
    static BoardView create(final List<BoardSectionView> sections) {
        return new BoardViewImpl(sections);
    }
}
