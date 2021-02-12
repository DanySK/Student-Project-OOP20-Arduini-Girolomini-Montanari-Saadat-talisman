package talisman.model.cards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import talisman.model.action.*;

/**
 * A class that generates that generates the needed decks.
 * 
 * @author Abtin Saadat
 *
 */
public final class TalismanDeckFactory {
    private TalismanDeckFactory() {
    }

    public static Deck createDeck(final DeckType type) {
        final List<Card> cards = new ArrayList<>();
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
        //cards.add(TalismanDeckFactory.createCard("bag of gold", "get 1 gold", "", CardType.OBJECT,
        //        List.of(new TalismanModifyStatisticAction(-1, TalismanActionStatistic.GOLD))));
    }

    private static List<Card> createSpellDeck(final List<Card> cards) {
        return cards;
    }

    private static List<Card> createAdventureDeck(final List<Card> cards) {
        return cards;
    }

    private static List<Card> createShopDeck(final List<Card> cards) {
        return cards;
    }

    private static List<Card> createTalismanDeck(final List<Card> cards) {
        return cards;
    }

    public static Card createCard(final String name, final String text, final String imagepath, final CardType type,
            final Collection<TalismanAction> actions) {
        return CardImpl.createCard(name, text, imagepath, type, actions);
    }
}
