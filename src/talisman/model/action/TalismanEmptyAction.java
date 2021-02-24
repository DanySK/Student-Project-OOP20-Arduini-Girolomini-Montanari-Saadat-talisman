package talisman.model.action;

/**
 * Models an ampty action.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanEmptyAction  extends TalismanActionImpl {
    /**
     * Gets what to show if no action is present.
     */
    private static final String DESCRIPTION = "Do nothing";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return TalismanEmptyAction.DESCRIPTION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply() {
        this.actionEnded();
    }
}
