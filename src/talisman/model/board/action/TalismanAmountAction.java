package talisman.model.board.action;

public abstract class TalismanAmountAction implements TalismanCellAction {
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
