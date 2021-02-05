package talisman.model.board.action;

public abstract class TalismanAmountAction implements TalismanCellAction {
    private static final long serialVersionUID = 834721071654192282L;

    private final int amount;

    public TalismanAmountAction(final int amount) {
        this.amount = amount;
    }

    /**
     * Gets the amount associated with this action.
     * 
     * @return the amount
     */
    public int getAmount() {
        return this.amount;
    }

}
