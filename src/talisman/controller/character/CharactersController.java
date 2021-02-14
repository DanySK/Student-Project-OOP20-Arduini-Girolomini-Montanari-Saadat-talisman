package talisman.controller.character;

import talisman.model.character.CharacterModelImpl;
import talisman.model.character.PlayerModel;

public interface CharactersController {

    PlayerModel getCurrentPlayer();

    void setCurrentPlayer(int index);

    void addPlayer(CharacterModelImpl character);

    void removePlayer(int index);
}
