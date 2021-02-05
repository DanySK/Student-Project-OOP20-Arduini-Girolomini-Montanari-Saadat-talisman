package talisman.view.board;

import java.util.LinkedList;
import java.util.List;

import talisman.util.CellType;

public class PopulatedBoardViewBuilder extends BoardViewBuilder {
    private final List<PawnView> pawns;

    /**
     * Creates a new builder.
     */
    public PopulatedBoardViewBuilder() {
        super();
        this.pawns = new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PopulatedBoardViewBuilder addCell(final String imagePath, final String text, final CellType type) {
        // TODO Auto-generated method stub
        super.addCell(imagePath, text, type);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PopulatedBoardViewBuilder addCell(final BoardCellView cell) {
        // TODO Auto-generated method stub
        super.addCell(cell);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PopulatedBoardViewBuilder setAsMainSection() {
        // TODO Auto-generated method stub
        super.setAsMainSection();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PopulatedBoardViewBuilder finalizeSection() {
        // TODO Auto-generated method stub
        super.finalizeSection();
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PopulatedBoardViewBuilder finalizeSectionAndInsertInto(final int parentSectionIndex) {
        // TODO Auto-generated method stub
        super.finalizeSectionAndInsertInto(parentSectionIndex);
        return this;
    }

    /**
     * Adds a pawn to the board.
     * 
     * @param imagePath the path to the pawn's image
     * @return the builder
     */
    public PopulatedBoardViewBuilder addPawn(final String imagePath) {
        this.checkNotBuilt();
        this.pawns.add(PawnView.create(imagePath));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PopulatedBoardView build() {
        this.checkNotBuilt();
        this.setBuilt(true);
        return PopulatedBoardView.create(this.getSections(), this.getMainSection(), this.pawns);
    }
}
