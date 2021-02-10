package talisman.model.cards;

import java.util.List;

public class DeckImpl implements Deck {
    private List<Card> cards;

    public DeckImpl() {
        cards = TalismanDeckFactory.createDeck();
    }
    public List<Card> getCards() {
        return cards;
    }
    @Override
    public Card draw() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int getNumberOfCards() {
        return cards.size();
    }
}
