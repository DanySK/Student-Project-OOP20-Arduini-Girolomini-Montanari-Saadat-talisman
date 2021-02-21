package talisman.model.character.defaultCharacters;

import talisman.model.character.CharacterModelImpl;

public class TalismanCharacterFactory {

    public static CharacterModelImpl createAssassinCharacter(){



        return new CharacterModelImpl(Assassin.getHealth(), Assassin.getStrength(), Assassin.getCraft(), 0, Assassin.getFate());
    }
}





