package talisman.view.cards;

import talisman.model.cards.CardType;

public interface TalismanCardView {
    static TalismanCardView create(final String imagePath, final String text, final CardType type) {
        return new TalismanCardViewImpl(imagePath, text, type);
    }
}
