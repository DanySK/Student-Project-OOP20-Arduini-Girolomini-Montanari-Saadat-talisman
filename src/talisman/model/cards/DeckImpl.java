package talisman.model.cards;

import java.util.List;
import java.util.Queue;

public class DeckImpl implements Deck {
    private final List<Card> cards;
    private final DeckType type;

    public DeckImpl(final DeckType type, final Queue<Card> cards) {
        this.type = type;
        this.cards = List.copyOf(cards);
    }
    /**
     * {@inheritDoc}
     */
    public List<Card> getCards() {
        return this.cards;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Card draw() {
        // TODO Auto-generated method stub
        return null;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumberOfCards() {
        return cards.size();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public DeckType getType() {
        return this.type;
    }
}
