package talisman.controller.cards;

import talisman.model.cards.Card;
import talisman.view.cards.TalismanDeckView;

public interface TalismanDeckController {
    Card draw();
    void shuffle();
    TalismanDeckView createView();
}
