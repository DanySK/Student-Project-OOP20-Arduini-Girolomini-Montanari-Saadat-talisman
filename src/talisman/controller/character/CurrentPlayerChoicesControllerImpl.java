package talisman.controller.character;

import java.util.ArrayList;
import java.util.List;

import talisman.Controllers;
import talisman.util.DiceType;
import talisman.util.Utils;
import talisman.view.CurrentPlayerChoicesWindow;
import talisman.view.OpponentChoiceWindow;

/**
 * Implementation that controls the current player's choices.
 * 
 * @author Alice Girolomini
 *
 */
public class CurrentPlayerChoicesControllerImpl implements CurrentPlayerChoicesController {
    private final int currentPlayerIndex;
    private int rollDice; 
    private final List<Integer> opponents  = new ArrayList<>();
    /**
     * Creates the controller for the current player's choices.
     * 
     * @param index - current player's index
     */
    public CurrentPlayerChoicesControllerImpl(final int index) {
        this.currentPlayerIndex = index;
        this.rollDice = 0;
        //this.opponents = new ArrayList<>(Controllers.getBoardController().getCurrentCharacterOpponents());
    }

    /**
     * {@inheritDoc}
     */
    public boolean checkRoll() {
        return (this.rollDice != 0);
    }

    /**
     * {@inheritDoc}
     */
    public boolean checkOpponents() {
        return !(this.opponents.isEmpty());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDiceRoll() {
        this.rollDice = Utils.rollDice(DiceType.SEVEN);
        return this.rollDice;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCurrentPlayerIndex() {
        return this.currentPlayerIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void movePawn() {
        int currentPosition = Controllers.getBoardController().getCharacterPawn(this.currentPlayerIndex).getPositionCell();
        if (checkRoll()) {
            Controllers.getBoardController().moveCharacterCell(this.currentPlayerIndex, currentPosition + this.rollDice);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void passTurn() {
        if (checkRoll()) {
            Controllers.getCharactersController().setCurrentPlayer(this.currentPlayerIndex + 1);
            CurrentPlayerChoicesWindow.show(CurrentPlayerChoicesController.create(Controllers.getCharactersController().getCurrentPlayer().getIndex()));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cellEvent() {
        if (checkRoll()) {
            Controllers.getBoardController().applyCurrentPlayerCellActions();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void challengeCharacter() {
        if (checkRoll() && checkOpponents()) {
            OpponentChoiceWindow.show(this.opponents);
        }
    }

}
