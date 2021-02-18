package talisman.model.battle;

/**
 * Implementation of enemy's informations in battle.
 * 
 * @author Alice Girolomini
 *
 */
public class CraftEnemy implements EnemyModel {
    private int craft;
    
    public CraftEnemy(int craft) {
        this.craft = craft;
    }

    public int getStrength() {
        return 0;
    }

    public int getCraft() {
        return this.craft;
    }

    public int getFate() {
        return 0;
    }

    public void setStrength(final int points) {

    }

    public void setCraft(final int points) {

    }

    public void setFate(final int coins) {

    }

}
