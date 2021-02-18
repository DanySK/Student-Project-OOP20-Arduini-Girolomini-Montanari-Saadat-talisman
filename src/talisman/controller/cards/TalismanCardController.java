package talisman.controller.cards;

import talisman.model.cards.Card;
import talisman.view.cards.TalismanCardView;

public interface TalismanCardController {
    static TalismanCardView createView(Card card) {
        // TODO Auto-generated method stub
        return TalismanCardControllerImpl.createView(card);
    }
}
