package talisman.model.cards;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import talisman.model.action.*;
import talisman.util.PathUtils;

/**
 * A class that generates that generates the needed decks.
 * 
 * @author Abtin Saadat
 *
 */
public final class TalismanDeckFactory {
    private TalismanDeckFactory() {
    }
    /**
     * The main method for creating decks using this factory.
     * @param type The type of deck.
     * @return The created deck.
     */
    public static Deck createDeck(final DeckType type) {
        final Queue<Card> cards = new LinkedList<>();
        switch (type) {
        case ADVENTURE:
            createAdventureDeck(cards);
            break;
        case SPELL:
            createSpellDeck(cards);
            break;
        case SHOP:
            createShopDeck(cards);
            break;
        case TALISMAN:
            createTalismanDeck(cards);
            break;
        default:
            break;
        }
        return new DeckImpl(type, cards);
    }

    private static Queue<Card> createSpellDeck(final Queue<Card> cards) {
        cards.add(TalismanDeckFactory.createCard("bag of gold", "get 1 gold", "BagOfGold", CardType.OBJECT,
                        List.of(new TalismanModifyStatisticAction(-1, TalismanActionStatistic.GOLD))));
        return cards;
    }

    private static Queue<Card> createAdventureDeck(final Queue<Card> cards) {
        cards.add(TalismanDeckFactory.createCard("bag of gold", "get 1 gold", "BagOfGold", CardType.OBJECT,
                List.of(new TalismanModifyStatisticAction(-1, TalismanActionStatistic.GOLD))));
        return cards;
    }

    private static Queue<Card> createShopDeck(final Queue<Card> cards) {
        cards.add(TalismanDeckFactory.createCard("bag of gold", "get 1 gold", "BagOfGold", CardType.OBJECT,
                List.of(new TalismanModifyStatisticAction(-1, TalismanActionStatistic.GOLD))));
        return cards;
    }

    private static Queue<Card> createTalismanDeck(final Queue<Card> cards) {
        cards.add(TalismanDeckFactory.createCard("bag of gold", "get 1 gold", "BagOfGold", CardType.OBJECT,
                List.of(new TalismanModifyStatisticAction(-1, TalismanActionStatistic.GOLD))));
        return cards;
    }

    public static Card createCard(final String name, final String text, final String imageName, final CardType type,
            final Collection<TalismanAction> actions) {
        return CardImpl.createCard(name, text, PathUtils.getPathToCard(type, imageName, true), type, actions);
    }
}
