package talisman.view.board;

import java.awt.Component;
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
        SwingUtilities.invokeLater(() -> {
            final BoardCellView cellInstance = this.getSection(section).getCell(cell);
            final Component swingCard = (Component) card;
            swingCard.setLocation(cellInstance.getCellX(), cellInstance.getCellY());
            this.add(swingCard);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeOverlayedCard(final TalismanCardView card) {
        for (final Map.Entry<Pair<Integer, Integer>, TalismanCardView> entry : this.cards.entrySet()) {
            if (entry.getValue() == card) {
                SwingUtilities.invokeLater(() -> {
                    this.remove((Component) card);
                    this.cards.remove(entry.getKey());
                });
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
