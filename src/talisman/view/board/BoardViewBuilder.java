package talisman.view.board;

import java.util.LinkedList;
import java.util.List;

import talisman.view.board.BoardCellView.CellType;

/**
 * Builder used to compose a view.
 * 
 * @author Alberto Arduini
 *
 */
public final class BoardViewBuilder {
    private final List<BoardCellView> cells;
    private final List<BoardSectionView> sections;
    private boolean built;

    /**
     * Creates a new builder.
     */
    public BoardViewBuilder() {
        this.cells = new LinkedList<BoardCellView>();
        this.sections = new LinkedList<BoardSectionView>();
        this.built = false;
    }

    public BoardViewBuilder addCell(final String imagePath, final String text, final CellType type) {
        return this.addCell(BoardCellView.create(imagePath, text, type));
    }

    public BoardViewBuilder addCell(final BoardCellView cell) {
        this.checkNotBuilt();
        this.cells.add(cell);
        return this;
    }

    public BoardViewBuilder finalizeSection() {
        this.checkNotBuilt();
        this.sections.add(BoardSectionView.create(cells));
        this.cells.clear();
        return this;
    }

    public BoardView build() {
        this.checkNotBuilt();
        this.built = true;
        return BoardView.create(this.sections);
    }

    private void checkNotBuilt() {
        if (this.built) {
            throw new IllegalStateException("Builder is aready finalized");
        }
    }
}
