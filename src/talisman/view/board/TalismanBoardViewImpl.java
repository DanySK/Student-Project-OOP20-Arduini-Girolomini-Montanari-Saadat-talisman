package talisman.view.board;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.SwingUtilities;

import talisman.util.Pair;

import talisman.view.cards.TalismanCardView;

public class TalismanBoardViewImpl extends PopulatedBoardViewImpl implements TalismanBoardView {
    private static final long serialVersionUID = 1L;
    private final Map<Pair<Integer, Integer>, TalismanCardView> cards;

    /**
     * Creates a new talisman board view.
     * 
     * @param sections    the board sections
     * @param mainSection the main (outed) board section index in the list
     * @param pawns       the list of pawns
     */
    public TalismanBoardViewImpl(final List<BoardSectionView> sections, final int mainSection,
            final List<PawnView> pawns) {
        super(sections, mainSection, pawns);
        this.cards = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOverlayedCard(final int section, final int cell, final TalismanCardView card) {
        if (this.cards.containsValue(card)) {
            return;
        }

        this.cards.put(new Pair<>(section, cell), card);
        final BoardCellView cellInstance = this.getSection(section).getCell(cell);
        final Component swingCard = (Component) card;

        SwingUtilities.invokeLater(() -> {
            swingCard.setVisible(false);
            this.add(swingCard, 0);
        });

        ((Component) cellInstance).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent e) {
                swingCard.setLocation(e.getLocationOnScreen());
                swingCard.setVisible(true);
            }

            @Override
            public void mouseExited(final MouseEvent e) {
                swingCard.setVisible(false);
            }
        });

        swingCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(final MouseEvent e) {
                swingCard.setVisible(false);
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeOverlayedCard(final TalismanCardView card) {
        for (final Map.Entry<Pair<Integer, Integer>, TalismanCardView> entry : this.cards.entrySet()) {
            if (entry.getValue() == card) {
                this.removeOverlayedCard(entry.getKey().getX(), entry.getKey().getY());
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeOverlayedCard(final int section, final int cell) {
        SwingUtilities.invokeLater(() -> {
            final Pair<Integer, Integer> position = new Pair<>(section, cell);
            if (!this.cards.containsKey(position)) {
                return;
            }
            this.remove((Component) this.cards.get(position));
            this.cards.remove(position);
        });
    }
}
