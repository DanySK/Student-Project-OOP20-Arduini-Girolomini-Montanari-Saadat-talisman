package talisman.view.board;

import java.util.List;

import javax.swing.SwingUtilities;

public class TalismanBoardViewImpl extends PopulatedBoardViewImpl implements TalismanBoardView {
    // private Map<Pair<Integer, Integer>, CardView> cards;

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
        // this.cards = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOverlayedCard(final int section, final int cell/* , final CardView card */) {
        // if (this.cards.containsValue(card)) {
        // return;
        // }
        // this.cards.put(new Pair<>(section, cell), card);
        SwingUtilities.invokeLater(() -> {
            final BoardCellView cellInstance = this.getSection(section).getCell(cell);
            // card.setPosition(cellInstance.getX(), cellInstance.getY());
            // this.add(card);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeOverlayedCard(/* final CardView card */) {
        // for (final Map.Entry<Pair<Integer, Integer>, CardView> entry : this.cards) {
        // if (entry.getValue() != card) {
        // continue;
        // }
        // this.remove(card);
        // this.cards.remove(entry.getKey());
        // break;
        // }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeOverlayedCard(final int section, final int cell) {
        // final Pair<Integer, Integer> position = new Pair<>(section, cell);
        // if (!this.cards.containsKey(position)) {
        // return;
        // }
        // this.remove(this.cards.get(position));
        // this.cards.remove(position);
    }
}
