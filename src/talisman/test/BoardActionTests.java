package talisman.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import talisman.Controllers;

import talisman.controller.board.TalismanBoardController;
import talisman.controller.character.CharacterControllerImpl;

import talisman.model.action.TalismanAction;
import talisman.model.action.TalismanMoveAction;
import talisman.model.board.BoardPawn;
import talisman.model.character.CharacterModelImpl;

import talisman.test.util.BoardTestUtils;

public class BoardActionTests {
    private static final int SECTION_COUNT = 3;
    private static final int CELL_COUNT = 3;

    @Test
    public void testMoveAction() {
        final BoardPawn pawn = this.setupControllers().getCharacterPawn(0);
        TalismanAction action = new TalismanMoveAction(2, 3);
        // 0,0 -> 2,3
        action.apply();
        Assertions.assertEquals(2, pawn.getPositionSection());
        Assertions.assertEquals(3, pawn.getPositionCell());
        // 2,3 -> 1,1
        action = new TalismanMoveAction(1, 1);
        action.apply();
        Assertions.assertEquals(1, pawn.getPositionSection());
        Assertions.assertEquals(1, pawn.getPositionCell());
    }

    private TalismanBoardController setupControllers() {
        Controllers.reset();
        Controllers.setBoardController(
                BoardTestUtils.createController(BoardActionTests.SECTION_COUNT, BoardActionTests.CELL_COUNT, 1));
        Controllers.setCharactersController(new CharacterControllerImpl());
        Controllers.getCharactersController().addPlayer(new CharacterModelImpl(0, 0, 0, 0, 0));
        return Controllers.getBoardController();
    }
}
