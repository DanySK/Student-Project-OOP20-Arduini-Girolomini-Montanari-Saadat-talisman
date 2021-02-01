package talisman.model.battle;

/**
 *  Different states of a battle. 
 *  @author Alice Girolomini
 */

public enum BattleState {
    /**
     *  The battle begins. 
     */
    START,
    /**
     *  First player wins. 
     */
    FIRST,
    /**
     *  Second player wins. 
     */
    SECOND,
    /**
     *  Stand-off. 
     */
    STAND_OFF,
    /**
     *  One player chooses to evade the battle. 
     */
    EVADE
}
