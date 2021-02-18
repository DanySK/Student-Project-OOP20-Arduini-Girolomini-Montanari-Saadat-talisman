package talisman.view.cards;

public interface TalismanCardView {
    static TalismanCardView create(final String imagePath, final String text) {
        return new TalismanCardViewImpl(imagePath, text);
    }
}
