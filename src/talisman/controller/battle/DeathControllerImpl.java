package talisman.controller.battle;

import java.util.ArrayList;
import java.util.List;

import talisman.Controllers;
import talisman.controller.board.TalismanBoardController;
import talisman.controller.character.CharactersController;
import talisman.model.character.CharacterModel;
import talisman.model.character.PlayerModelImpl;

/**
 * The implementation of a MVC controller for the character's death.
 * 
 * @author Alice Girolomini
 *
 */
public class DeathControllerImpl implements DeathController {
    private final CharactersController characterController;
    private final TalismanBoardController boardController;
    private final CharacterModel character;

    public DeathControllerImpl(CharacterModel character) {
        this.characterController = Controllers.getCharactersController();
        this.boardController = Controllers.getBoardController();
        this.character = character;
    }

    private boolean checkHealth() {
        return (this.character.getHealth() == 0);
    }

    private int checkPlayer() {
        List<Integer> indexes = new ArrayList<>(this.boardController.getCurrentCharacterOpponents());
        PlayerModelImpl[] players = this.characterController.getPlayers();
        for (int i = 0; i < indexes.size(); i++) {
            if (players[indexes.get(i) - 1].getCurrentCharacter().equals(character)) {
                return indexes.get(i);
            }
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean death() {
        if (checkHealth()) {
            initializeCharacterInfo(this.character);
            initializeCharacterPosition(checkPlayer());
            return true;
        }
        return false;
    }

    private void initializeCharacterInfo(final CharacterModel character) {
        
    }

    private void initializeCharacterPosition(final int index) {
        this.boardController.moveCharacterSection(index, 0, 0);
    }

}
