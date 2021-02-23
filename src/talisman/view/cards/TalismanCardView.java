package talisman.view.cards;
/**
 * Creates the view for a single card.
 * @author Abtin Saadat
 *
 */
public interface TalismanCardView {
    /**
     * Creates the view for a single card.
     * @param imagePath The card's image path
     * @param text The card's text
     * @return Returns the view 
     */
    static TalismanCardView create(final String imagePath, final String text) {
        return new TalismanCardViewImpl(imagePath, text);
    }
}
