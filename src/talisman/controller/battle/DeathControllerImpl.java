package talisman.controller.battle;

import talisman.controller.board.TalismanBoardController;
import talisman.controller.character.CharactersController;
import talisman.model.character.CharacterModel;

/**
 * The implementation of a MVC controller for the character's death.
 * 
 * @author Alice Girolomini
 *
 */
public class DeathControllerImpl implements DeathController {
    private final CharactersController characterController;
    private final TalismanBoardController boardController;

    public DeathControllerImpl(final CharactersController characterController, final TalismanBoardController boardController) {
        this.characterController = characterController;
        this.boardController = boardController;
    }

    private boolean checkHealth() {
        return (this.characterController.getCurrentPlayer().getCurrentCharacter().getHealth() == 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void death() {
        CharacterModel character = this.characterController.getCurrentPlayer().getCurrentCharacter();
        if (checkHealth()) {
            initializeCharacterInfo(character);
            initializeCharacterPosition(this.characterController.getCurrentPlayer().getIndex());
        }
    }

    private void initializeCharacterInfo(final CharacterModel character) {
    }

    private void initializeCharacterPosition(final int index) {
        this.boardController.moveCharacterSection(index, 0, 0);
    }

}
