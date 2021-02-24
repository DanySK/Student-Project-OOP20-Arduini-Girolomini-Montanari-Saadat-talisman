package talisman.view.cards;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import talisman.model.cards.Card;

public class TalismanDeckViewImpl implements TalismanDeckView {
    private int index;
    private final TalismanCardViewImpl deckView;

    public TalismanDeckViewImpl(final List<Card> deck) {
        index = 0;
        deckView = new TalismanCardViewImpl(deck.get(index).getImagePath(), deck.get(index).getText(),
                deck.get(index).getName());
        final JButton button = new JButton("<<");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                index = index - 1;
                deckView.setView(deck.get(index).getImagePath(), deck.get(index).getText(), deck.get(index).getName());
            }
        });
        final JButton button2 = new JButton(">>");
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                index = index + 1;
                deckView.setView(deck.get(index).getImagePath(), deck.get(index).getText(), deck.get(index).getName());
            }
        });
        deckView.add(button);
        deckView.add(button2);
    }

    public final TalismanCardView createDeckView() {
        return this.deckView;
    }
}
