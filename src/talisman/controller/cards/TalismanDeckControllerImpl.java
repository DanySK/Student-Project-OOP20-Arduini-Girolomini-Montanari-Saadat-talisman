package talisman.controller.cards;

import talisman.model.cards.Card;
import talisman.model.cards.Deck;
import talisman.model.cards.DeckType;
import talisman.model.cards.TalismanDeckFactory;
import talisman.view.cards.TalismanDeckView;

public class TalismanDeckControllerImpl implements TalismanDeckController {
    private Deck deck;
    public TalismanDeckControllerImpl(final DeckType type) {
        this.deck = TalismanDeckFactory.createDeck(type);
    }

    @Override
    public Card draw() {
        return deck.draw();
    }

    @Override
    public void shuffle() {
        // TODO Auto-generated method stub
        deck.shuffle();
    }

    @Override
    public TalismanDeckView createView() {
        // TODO Auto-generated method stub
        return null;
    }

}
