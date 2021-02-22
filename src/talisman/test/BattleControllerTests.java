package talisman.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import talisman.Controllers;
import talisman.controller.battle.BattleController;
import talisman.controller.battle.BattleControllerImpl;
import talisman.controller.battle.DeathController;
import talisman.controller.battle.DeathControllerImpl;
import talisman.model.battle.BattleModel;
import talisman.model.battle.BattleModelImpl;
import talisman.model.battle.BattleState;
import talisman.model.battle.EnemyModel;
import talisman.model.battle.StrengthEnemy;
import talisman.model.character.CharacterModel;
import talisman.model.character.CharacterModelImpl;

/**
 * Tests the controllers of the battle.
 * 
 * @author Alice Girolomini
 *
 */
public class BattleControllerTests {
    /**
     * Tests a basic battle betwwen two characters.
     */
    @Test
    public void testBattleController() {
        //Initialization of the two characters
        CharacterModel firstCharacter = new CharacterModelImpl(2, 2, 3, 4, 0);
        CharacterModel secondCharacter = new CharacterModelImpl(3, 2, 1, 1, 4);
        final BattleModel battle = new BattleModelImpl(firstCharacter.getStrength(), secondCharacter.getStrength());
        final BattleController controller = new BattleControllerImpl(firstCharacter, secondCharacter, battle);
        Assertions.assertEquals(false, battle.isEnded());
        //first rolls the die
        battle.diceRoll(1);
        //second rolls the die
        battle.diceRoll(2);
        //adds the roll to the initial score
        Assertions.assertEquals(controller.requestedAttack(), battle.getScore(1));
        Assertions.assertEquals(controller.requestedAttack(), battle.getScore(2));
        Assertions.assertEquals(true, battle.isEnded());
    }

    /**
     * Tests the character's death.
     */
    @Test
    public void testDeathController() {
        //Initialization of opponents
        CharacterModel character = new CharacterModelImpl(1, 1, 3, 4, 0);
        EnemyModel enemy = new StrengthEnemy(10, "Wild Boar");
        final BattleModel battle = new BattleModelImpl(character.getStrength(), enemy.getStrength());
        final BattleController controller = new BattleControllerImpl(character, enemy, battle);
        Assertions.assertEquals(false, battle.isEnded());
        //first rolls the die
        battle.diceRoll(1);
        //second rolls the die
        battle.diceRoll(2);
        //adds the roll to the initial score
        Assertions.assertEquals(controller.requestedAttack(), battle.getScore(1));
        Assertions.assertEquals(controller.requestedAttack(), battle.getScore(2));
        //Assertions.assertEquals(BattleState.SECOND, controller.getResult());
        //Assertions.assertEquals(0, Controllers.getBoardController().getCharacterPawn(1).getPositionCell());
        //Assertions.assertEquals(0, Controllers.getBoardController().getCharacterPawn(1).getPositionSection());
    }
}
