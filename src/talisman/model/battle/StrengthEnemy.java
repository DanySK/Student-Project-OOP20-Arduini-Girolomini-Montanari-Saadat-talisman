package talisman.model.battle;

/**
 * Implementation of enemy's informations in battle.
 * 
 * @author Alice Girolomini
 *
 */
public class StrengthEnemy implements EnemyModel {
    private int strength;

    public StrengthEnemy(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getCraft() {
        return 0;
    }

    public int getFate() {
        return 0;
    }

    public void setStrength(int points) {

    }

    public void setCraft(int points) {

    }

    public void setFate(int coins) {

    }

}
