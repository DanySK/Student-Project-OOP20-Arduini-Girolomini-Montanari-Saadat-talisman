package talisman;

import talisman.controller.board.TalismanBoardController;

public final class Controllers {
    private static TalismanBoardController boardController;

    private Controllers() {
    }

    public static TalismanBoardController getBoardController() {
        return Controllers.boardController;
    }

    public static void setBoardController(final TalismanBoardController controller) {
        if (Controllers.boardController == null) {
            throw new IllegalStateException("The controller was already assigned");
        }
        Controllers.boardController = controller;
    }

    public static void reset() {
        Controllers.boardController = null;
    }
}
