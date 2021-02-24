package talisman.view.cards;

import java.util.List;

import talisman.model.cards.Card;

public interface TalismanDeckView {
    static TalismanCardView create(final List<Card> deck) {
        return new TalismanDeckViewImpl(deck).createDeckView();
    }
}
