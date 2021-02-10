package talisman.util;

import java.util.Random;

public class Utils {

    private final static Random rand = new Random();

    public static int rollDice(DiceType diceType) {
        int result = 0;
        while (result == 0) {
            result = rand.nextInt(diceType.getFaces());
        }
        return result;
    }
}
