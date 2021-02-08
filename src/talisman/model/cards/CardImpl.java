package talisman.model.cards;

public abstract class CardImpl implements Card {
    private String text;
    private CardType type;

    @Override
    public String getText() {
        return text;
    }

    @Override
    public CardType getType() {
        return type;
    }

}
