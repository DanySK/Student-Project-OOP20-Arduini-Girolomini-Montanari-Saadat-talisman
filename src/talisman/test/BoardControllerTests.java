package talisman.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import talisman.test.util.BoardTestUtils;

import talisman.controller.board.TalismanBoardController;

/**
 * Tests the talisman board's controller.
 * 
 * @author Alberto Arduini
 *
 */
public class BoardControllerTests {
    /**
     * Tests the controller's capability of moving a pawn using the contained board.
     */
    @Test
    public void testMovePawn() {
        final TalismanBoardController controller = BoardTestUtils.createController(2, 4, 1);
        // Move to cell of index two
        controller.moveCharacterCell(0, 2);
        Assertions.assertEquals(2, controller.getBoard().getPawnCellIndex(0));
        // Move to cell if index one
        controller.moveCharacterCell(0, 1);
        Assertions.assertEquals(1, controller.getBoard().getPawnCellIndex(0));
        // Move to first cell of section of index 1
        controller.moveCharacterSection(0, 1);
        Assertions.assertEquals(0, controller.getBoard().getPawnCellIndex(0));
        Assertions.assertEquals(1, controller.getBoard().getPawnSectionIndex(0));
        // Move to cell of index 3 of section of index 0
        controller.moveCharacterSection(0, 0, 3);
        Assertions.assertEquals(3, controller.getBoard().getPawnCellIndex(0));
        Assertions.assertEquals(0, controller.getBoard().getPawnSectionIndex(0));
    }
}
