package talisman.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import talisman.Controllers;

import talisman.model.action.TalismanAction;
import talisman.model.action.TalismanMoveAction;
import talisman.model.action.TalismanPayAction;
import talisman.model.board.BoardPawn;
import talisman.model.character.CharacterModelImpl;

import talisman.test.util.BoardTestUtils;

public class BoardActionTests {
    private static final int SECTION_COUNT = 3;
    private static final int CELL_COUNT = 3;
    private static final int STARTING_GOLD = 1;

    @Test
    public void testMoveAction() {
        final BoardPawn pawn = BoardTestUtils.setupControllers(BoardActionTests.SECTION_COUNT,
                BoardActionTests.CELL_COUNT, 1, this.createStartingCharacterInfo()).getCharacterPawn(0);
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

    @Test
    public void testPayAction() {
        final BoardPawn pawn = BoardTestUtils.setupControllers(BoardActionTests.SECTION_COUNT,
                BoardActionTests.CELL_COUNT, 1, this.createStartingCharacterInfo()).getCharacterPawn(0);
        final TalismanAction action = new TalismanPayAction(1, new TalismanMoveAction(2, 3));
        // gold: 0, should move pawn to 2,3
        action.apply();
        Assertions.assertEquals(BoardActionTests.STARTING_GOLD - 1,
                ((CharacterModelImpl) Controllers.getCharactersController().getCurrentPlayer().getCurrentCharacter())
                        .getGold());
        Assertions.assertEquals(2, pawn.getPositionSection());
        Assertions.assertEquals(3, pawn.getPositionCell());
    }

    private CharacterModelImpl createStartingCharacterInfo() {
        return new CharacterModelImpl(0, 0, 0, BoardActionTests.STARTING_GOLD, 0);
    }
}
