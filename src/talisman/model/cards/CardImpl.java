package talisman.model.cards;

import java.util.Collection;

import talisman.model.board.action.TalismanCellAction;

public class CardImpl implements Card {
    private final String name;
    private final String text;
    private final String imagepath;
    private final CardType type;
    private final Collection<TalismanCellAction> actions;

    public CardImpl(final String name, final String text, final String imagepath, final CardType type, final Collection<TalismanCellAction> actions) {
        this.name = name;
        this.text = text;
        this.imagepath = imagepath;
        this.type = type;
        this.actions = actions;
    }

    public String getName() {
        return name;
    }
    @Override
    public String getText() {
        return text;
    }

    @Override
    public CardType getType() {
        return type;
    }

    public Collection<TalismanCellAction> getActions() {
        return actions;
    }

    public String getImagePath() {
        return imagepath;
    }
    public static Card createCard(final String name, final String text, final String imagepath, final CardType type, final Collection<TalismanCellAction> actions) {
        return new CardImpl(name, text, imagepath, type, actions);
    }
}
