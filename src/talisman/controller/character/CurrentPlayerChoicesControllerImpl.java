package talisman.controller.character;

import java.util.ArrayList;
import java.util.List;

import talisman.Controllers;
import talisman.model.character.PlayerModel;
import talisman.util.DiceType;
import talisman.util.Utils;
import talisman.view.CurrentPlayerChoicesWindow;
import talisman.view.OpponentChoiceWindow;

/**
 * Implementation that controls the current player's choices.
 * 
 * @author Alice Girolomini
 * @author Alberto Arduini
 *
 */
public class CurrentPlayerChoicesControllerImpl implements CurrentPlayerChoicesController {
    private final List<Integer> opponents;
    private int currentPlayerIndex;
    private int rollDice;
    private CurrentPlayerChoicesWindow window;

    /**
     * Creates the controller for the current player's choices.
     * 
     * @param index - current player's index
     */
    public CurrentPlayerChoicesControllerImpl(final int index) {
        Controllers.getCharactersController().setCurrentPlayer(index);
        this.opponents = new ArrayList<>();
        this.initializeTurn();
    }

    /**
     * {@inheritDoc}
     */
    public boolean checkRoll() {
        return this.rollDice != 0;
    }

    /**
     * {@inheritDoc}
     */
    public boolean checkOpponents() {
        return !this.opponents.isEmpty();
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
        final int currentPosition = Controllers.getBoardController().getCharacterPawn(this.currentPlayerIndex)
                .getPositionCell();
        if (checkRoll()) {
            Controllers.getBoardController().moveCharacterCell(this.currentPlayerIndex,
                    currentPosition + this.rollDice);
            this.opponents.addAll(Controllers.getBoardController().getCurrentCharacterOpponents());
            this.getView().setInteractible(true);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void passTurn() {
        if (checkRoll()) {
            this.advanceTurn();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cellEvent() {
        if (checkRoll()) {
            Controllers.getBoardController().setActionEndedListener(() -> this.getView().setInteractible(true));
            Controllers.getBoardController().applyCurrentPlayerCellActions();
            Controllers.getBoardController().setActionEndedListener(null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void challengeCharacter() {
        if (checkRoll() && checkOpponents()) {
            OpponentChoiceWindow.show(this.opponents, () -> this.getView().setInteractible(true));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void skipTurn() {
        this.advanceTurn();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CurrentPlayerChoicesWindow getView() {
        return this.window;
    }

    private void initializeTurn() {
        this.currentPlayerIndex = Controllers.getCharactersController().getCurrentPlayer().getIndex();
        this.rollDice = 0;
        this.opponents.clear();
        this.window = CurrentPlayerChoicesWindow.show(this);
    }

    private void advanceTurn() {
        this.getView().closeWindow();
        final PlayerModel player = Controllers.getCharactersController().getCurrentPlayer();
        if (player.hasQuest()) {
            player.resolveActiveQuest();
        }
        Controllers.getCharactersController().setCurrentPlayer(player.getIndex() + 1);
        this.initializeTurn();
    }
}
