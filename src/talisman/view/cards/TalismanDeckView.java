package talisman.view.cards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import talisman.model.cards.Card;

public interface TalismanDeckView {
    static void create(final List<Card> deck) {
        int index = 0;
        TalismanCardViewImpl deckView = new TalismanCardViewImpl(deck.get(index).getImagePath(), deck.get(index).getText());
        JButton button = new JButton("Click 0");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                index = index -1;
                deckView.setView(deck.get(index).getImagePath(), deck.get(index).getText());
            }
        });
        JButton button2 = new JButton("Click 1");
        button2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                // TODO Auto-generated method stub
                deckView.setView(deck.get(index).getImagePath(), deck.get(index).getText());
            }
        });
        deckView.add(button);
        deckView.add(button2);
    }
}
