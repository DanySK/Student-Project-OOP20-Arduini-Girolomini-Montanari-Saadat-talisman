package talisman.model.action;

import talisman.Controllers;
import talisman.model.cards.CardImpl;

/**
 * An action that gives an item to a player.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanGiveItemAction extends TalismanActionImpl {
    private static final long serialVersionUID = -428031478841638174L;

    private static final String DESCRIPTION_FORMAT = "You gain a %s";

    private final CardImpl item;

    public TalismanGiveItemAction(final CardImpl item) {
        this.item = item;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return String.format(TalismanGiveItemAction.DESCRIPTION_FORMAT, this.getItem().getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void apply() {
        Controllers.getCharactersController().getCurrentPlayer().getCurrentCharacter().getInventory()
                .addCard(this.getItem());
        this.actionEnded();
    }

    /**
     * Gets the item that will be given.
     * 
     * @return the item's index
     */
    public CardImpl getItem() {
        return this.item;
    }
}
