package talisman.controller.cards;

import talisman.model.cards.Card;
import talisman.view.cards.TalismanCardView;

public class TalismanCardControllerImpl implements TalismanCardController {

    public static final TalismanCardView createView(final Card card) {
        // TODO Auto-generated method stub
        return TalismanCardView.create(card.getImagePath(), card.getText());
    }

}
