package talisman.controller.board;

import java.util.ArrayList;
import java.util.List;

import talisman.Controllers;
import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardFactory;
import talisman.model.board.TalismanBoardPawn;
import talisman.model.character.CharacterModel;

import talisman.util.ViewUtils;

import talisman.view.board.TalismanBoardViewBuilder;

public final class TalismanBoardControllerFactory {
    private TalismanBoardControllerFactory() {
    }

    public static TalismanBoardController createController(final List<CharacterModel> playerCharacters) {
        final List<TalismanBoardPawn> pawns = new ArrayList<>();
        for (int i = 0; i < playerCharacters.size(); i++) {
            final CharacterModel character = playerCharacters.get(i);
            // TODO: Get image from CharacterInfo
            pawns.add(TalismanBoardPawn.createPawn(ViewUtils.getDevImagePath(ViewUtils.DEV_PAWN_IMAGE_NAME, true), i));
        }
        final TalismanBoard board = TalismanBoardFactory.createDefaultBoardModel(pawns);
        final TalismanBoardViewBuilder viewBuilder = new TalismanBoardViewBuilder();
        return TalismanBoardController.create(board, viewBuilder.buildFromModel(board));
    }
}
