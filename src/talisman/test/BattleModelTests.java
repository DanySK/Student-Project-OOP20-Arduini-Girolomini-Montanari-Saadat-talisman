package talisman.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import talisman.model.battle.BattleModelImpl;

/**
 * Tests the battles.
 * 
 * @author Alice Girolomini
 *
 */
public class BattleModelTests {
    /**
     * Tests a basic battle between two character.
     */
    @Test
    public void testBasicBattle() {
        //Initialization of the two opponents
        int first = 3;
        int second = 1;
        final BattleModelImpl battle = new BattleModelImpl(first, second);
        Assertions.assertEquals(false, battle.isEnded());
        //first rolls the die
        battle.firstDiceRoll();
        first = first + battle.getFirstDice();
        //second rolls the die
        battle.secondDiceRoll();
        second = second + battle.getSecondDice();
        //adds the dice to the initial strength or craft 
        battle.addScore();
        battle.compareScore();
        Assertions.assertEquals(first, battle.getFirstScore());
        Assertions.assertEquals(second, battle.getSecondScore());
        Assertions.assertEquals(true, battle.isEnded());
    }

    /**
     * Tests a battle where on of the two players evades.
     */
    @Test
    public void testEvadeCase() {
        //Initialization of the two opponents
        int first = 3;
        int second = 0;
        final BattleModelImpl battle = new BattleModelImpl(first, second);
        Assertions.assertEquals(false, battle.isEnded());
        battle.checkEvade();
        Assertions.assertEquals(true, battle.isEnded());
        System.out.println(battle.getState());
    }
}
