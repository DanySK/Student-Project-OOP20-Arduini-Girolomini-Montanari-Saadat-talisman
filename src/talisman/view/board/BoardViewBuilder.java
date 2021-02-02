package talisman.view.board;

import java.util.LinkedList;
import java.util.List;

import talisman.util.CellType;

/**
 * Builder used to compose a view.
 * 
 * @author Alberto Arduini
 *
 */
public final class BoardViewBuilder {
    private final List<BoardCellView> cells;
    private final List<BoardSectionView> sections;
    private int mainSection;
    private boolean built;

    /**
     * Creates a new builder.
     */
    public BoardViewBuilder() {
        this.cells = new LinkedList<BoardCellView>();
        this.sections = new LinkedList<BoardSectionView>();
        this.built = false;
    }

    /**
     * Adds a new cell to the current section.
     * 
     * @param imagePath the path to the cell's image
     * @param text      the cell's text
     * @param type      the cell's type
     * @return the builder
     */
    public BoardViewBuilder addCell(final String imagePath, final String text, final CellType type) {
        return this.addCell(BoardCellView.create(imagePath, text, type));
    }

    /**
     * Adds a new cell to the current section.
     * 
     * @param cell the cell instance to add
     * @return the builder
     */
    public BoardViewBuilder addCell(final BoardCellView cell) {
        this.checkNotBuilt();
        this.cells.add(cell);
        return this;
    }
    
    public BoardViewBuilder setAsMainSection() {
        this.checkNotBuilt();
        this.mainSection = this.sections.size();
        return this;
    }

    /**
     * Finalizes the current board section with the current cells, and starts the
     * creation of a new section.
     * 
     * @return the builder
     */
    public BoardViewBuilder finalizeSection() {
        this.checkNotBuilt();
        this.sections.add(BoardSectionView.create(cells));
        this.cells.clear();
        return this;
    }

    /**
     * Finalizes the current board section with the current cells, and starts the
     * creation of a new section.
     * 
     * @param parentSectionIndex the parent section's index
     * @return the builder
     */
    public BoardViewBuilder finalizeSectionAndInsertInto(final int parentSectionIndex) {
        this.checkNotBuilt();
        final BoardSectionView section = BoardSectionView.create(cells);
        this.sections.add(section);
        this.cells.clear();
        this.sections.get(parentSectionIndex).setContainedSection(section);
        return this;
    }

    /**
     * Completes the view and returns it. After this call the builder will become unusable.
     * 
     * @return the created view
     */
    public BoardView build() {
        this.checkNotBuilt();
        this.built = true;
        return BoardView.create(this.sections, this.mainSection);
    }

    private void checkNotBuilt() {
        if (this.built) {
            throw new IllegalStateException("Builder is aready finalized");
        }
    }
}
