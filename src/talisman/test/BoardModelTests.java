package talisman.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import talisman.model.board.TalismanBoardImpl;
import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardCell;
import talisman.model.board.TalismanBoardPawn;
import talisman.model.board.TalismanBoardSection;
import talisman.model.board.TalismanBoardSectionImpl;
import talisman.model.board.TalismanCellType;

/**
 * Tests the talisman board's model.
 * 
 * @author Alberto Arduini
 *
 */
public class BoardModelTests {
    /**
     * Tests the board's capability of moving a pawn.
     */
    @Test
    public void testMovePawn() {
        final TalismanBoard board = this.createBoard(2, 4, 1);
        // Move to cell of index two
        board.movePawnTo(0, 2);
        Assertions.assertEquals(2, board.getPawnCellIndex(0));
        // Move to cell if index one
        board.movePawnTo(0, 1);
        Assertions.assertEquals(1, board.getPawnCellIndex(0));
        // Move to first cell of section of index 1
        board.changePawnSection(0, 1);
        Assertions.assertEquals(0, board.getPawnCellIndex(0));
        Assertions.assertEquals(1, board.getPawnSectionIndex(0));
        // Move to cell of index 3 of section of index 0
        board.changePawnSection(0, 0, 3);
        Assertions.assertEquals(3, board.getPawnCellIndex(0));
        Assertions.assertEquals(0, board.getPawnSectionIndex(0));
    }

    /**
     * Creates a test board.
     * 
     * @param sectionsCount the number of sections
     * @param cellsCount    the number of cells of every section
     * @param pawnsCount    the number of pawns
     * @return the created board
     */
    private TalismanBoard createBoard(final int sectionsCount, final int cellsCount, final int pawnsCount) {
        final List<TalismanBoardCell> cells = new ArrayList<>();
        for (int i = 0; i < cellsCount; i++) {
            cells.add(new TalismanBoardCell("", "Cell " + i, TalismanCellType.BIOME, Set.of()));
        }
        final List<TalismanBoardSection> sections = new ArrayList<>();
        for (int i = 0; i < sectionsCount; i++) {
            sections.add(new TalismanBoardSectionImpl(List.copyOf(cells)));
        }
        final List<TalismanBoardPawn> pawns = new ArrayList<>();
        for (int i = 0; i < pawnsCount; i++) {
            pawns.add(new TalismanBoardPawn(""));
        }
        return new TalismanBoardImpl(sections, pawns);
    }
}
