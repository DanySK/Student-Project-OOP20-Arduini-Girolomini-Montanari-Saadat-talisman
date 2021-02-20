package talisman.view.cards;

import talisman.model.cards.Deck;

public interface TalismanDeckView {
    static TalismanCardView create(final Deck deck) {
        return new TalismanDeckViewImpl.createView(deck);
    }
}
