package talisman.model.cards;
/**
 * Interface that models a deck.
 * 
 * @author Abtin Saadat
 * 
 */
public interface Deck {
    /**
     * 
     * @return The drawn card.
     */
    Card draw();
    /**
     * 
     * @return The number of cards in the deck.
     */
    int getNumberOfCards();
    DeckType getType();
    void shuffle();
}
