package talisman.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import talisman.controller.board.TalismanBoardController;

import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardCell;
import talisman.model.board.TalismanBoardPawn;
import talisman.model.board.TalismanBoardSection;
import talisman.model.board.TalismanCellType;
import talisman.util.CellType;
import talisman.view.board.BoardView;

public final class BoardTestUtils {
    private BoardTestUtils() {
    }

    /**
     * Creates a test board.
     * 
     * @param sectionsCount the number of sections
     * @param cellsCount    the number of cells of every section
     * @param pawnsCount    the number of pawns
     * @return the created board
     */
    public static TalismanBoard createBoard(final int sectionsCount, final int cellsCount, final int pawnsCount) {
        final List<TalismanBoardCell> cells = new ArrayList<>();
        for (int i = 0; i < cellsCount; i++) {
            cells.add(TalismanBoardCell.createCell("", "Cell " + i, CellType.DOWN, TalismanCellType.BIOME, Set.of()));
        }
        final List<TalismanBoardSection> sections = new ArrayList<>();
        for (int i = 0; i < sectionsCount; i++) {
            sections.add(TalismanBoardSection.createSection(List.copyOf(cells)));
        }
        final List<TalismanBoardPawn> pawns = new ArrayList<>();
        for (int i = 0; i < pawnsCount; i++) {
            pawns.add(TalismanBoardPawn.createPawn(""));
        }
        return TalismanBoard.createBoard(sections, pawns);
    }

    /**
     * Creates a test controller with a test board.
     * 
     * @param sectionsCount the number of sections
     * @param cellsCount    the number of cells of every section
     * @param pawnsCount    the number of pawns
     * @return the created controller
     */
    public static TalismanBoardController createController(final int sectionsCount, final int cellsCount, final int pawnsCount) {
        final TalismanBoard board = BoardTestUtils.createBoard(sectionsCount, cellsCount, pawnsCount);
        // I don't care about testing the view, so I create an empty one
        return TalismanBoardController.create(board, BoardView.create(List.of(), 0));
    }
}
