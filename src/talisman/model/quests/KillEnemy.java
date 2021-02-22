package talisman.model.quests;

/**
 * Kill 1 enemy to complete this quest
 *
 * @author Enrico Maria Montanari
 */
public class KillEnemy extends TalismanQuest{

    /**
     * Gets a description of the objective of the current quest
     *
     * @return the description
     */
    @Override
    public String toString(){

        return "Kill 1 enemy";
    }
}
