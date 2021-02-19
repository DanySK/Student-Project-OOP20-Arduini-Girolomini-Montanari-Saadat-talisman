package talisman.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import talisman.test.util.BoardTestUtils;

import talisman.controller.board.TalismanBoardController;
import talisman.model.character.CharacterModelImpl;

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
        final TalismanBoardController controller = BoardTestUtils.setupControllers(2, 4, 1,
                new CharacterModelImpl(0, 0, 0, 0, 0));
        // Move to cell of index two
        controller.moveCharacterCell(0, 2);
        // The player is now in cell 2, section 0
        this.assertCellAndSection(controller, 0, 2, 0);
        // Move to cell if index one
        controller.moveCharacterCell(0, 1);
        // The player is now in cell 1, section 0
        this.assertCellAndSection(controller, 0, 1, 0);
        // Move to first cell of section of index 1
        controller.moveCharacterSection(0, 1);
        // The player is now in cell 0, section 1
        this.assertCellAndSection(controller, 0, 0, 1);
        // Move to cell of index 3 of section of index 0
        controller.moveCharacterSection(0, 0, 3);
        // The player is now in cell 3, section 0
        this.assertCellAndSection(controller, 0, 3, 0);
    }

    private void assertCellAndSection(final TalismanBoardController controller, final int player, final int cell,
            final int section) {
        // Check cell index
        Assertions.assertEquals(cell, controller.getBoard().getPawnCellIndex(player));
        // Check cell instance
        Assertions.assertEquals(controller.getBoard().getCell(section, cell), controller.getCharacterCell(player));
        // Check section index
        Assertions.assertEquals(section, controller.getBoard().getPawnSectionIndex(player));
        // Check section instance
        Assertions.assertEquals(controller.getBoard().getSection(section), controller.getCharacterSection(player));
    }
}
