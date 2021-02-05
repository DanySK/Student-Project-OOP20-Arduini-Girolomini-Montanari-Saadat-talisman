package talisman.model.board;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import talisman.util.Pair;

/**
 * Implements a board for talisman.
 * 
 * @author Alberto Arduini
 */
public class TalismanBoardImpl implements TalismanBoard {
    private final List<TalismanBoardSection> sections;
    private final List<TalismanBoardPawn> characterPawns;

    /**
     * Creates a new talisman board.
     * 
     * @param sections       the sections that the board contains
     * @param characterPawns the player pawns
     */
    public TalismanBoardImpl(final List<TalismanBoardSection> sections, final List<TalismanBoardPawn> characterPawns) {
        super();
        this.sections = List.copyOf(sections);
        this.characterPawns = List.copyOf(characterPawns);
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
    public TalismanBoardSection getSection(final int index) {
        return this.sections.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void movePawnTo(final int playerIndex, final int cell) {
        final int oldSection = this.getPawn(playerIndex).getPositionSection();
        this.getPawn(playerIndex).setPosition(oldSection, cell);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void changePawnSection(final int playerIndex, final int section, final int cell) {
        this.getPawn(playerIndex).setPosition(section, cell);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPawnCount() {
        return this.characterPawns.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TalismanBoardPawn getPawn(final int playerIndex) {
        return this.characterPawns.get(playerIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPawnSectionIndex(final int playerIndex) {
        return this.getPawn(playerIndex).getPositionSection();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPawnCellIndex(final int playerIndex) {
        return this.getPawn(playerIndex).getPositionCell();
    }
}
