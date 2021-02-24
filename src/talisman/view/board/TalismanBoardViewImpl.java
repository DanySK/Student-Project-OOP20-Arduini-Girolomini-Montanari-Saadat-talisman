package talisman.view.board;

import java.awt.Color;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import talisman.Controllers;
import talisman.model.board.TalismanBoardPawn;
import talisman.util.Pair;

import talisman.view.cards.TalismanCardView;
import talisman.view.cards.TalismanCardViewImpl;

public class TalismanBoardViewImpl extends PopulatedBoardViewImpl implements TalismanBoardView {
    private static final long serialVersionUID = 1L;
    private final Map<Pair<Integer, Integer>, TalismanCardView> cards;

    private boolean hideCardOnLeave = true;
    private boolean isShowingCard = false;
    private CardPickupListener listener;

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
        for (int i = 0; i < this.getSectionCount(); i++) {
            final BoardSectionView section = this.getSection(i);
            for (int j = 0; j < section.getCellCount(); j++) {
                final BoardCellViewImpl cell = (BoardCellViewImpl) section.getCell(j);
                cell.addMouseListener(new MouseAdapter() {

                    @Override
                    public void mouseEntered(final MouseEvent e) {
                        cell.setTextVisiblity(true);
                    }

                    @Override
                    public void mouseExited(final MouseEvent e) {
                        cell.setTextVisiblity(false);
                    }
                });
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOverlayedCard(final int section, final int cell, final TalismanCardView card,
            final boolean canBePickedUp) {
        if (this.cards.containsValue(card)) {
            return;
        }

        this.cards.put(new Pair<>(section, cell), card);
        final BoardCellView cellInstance = this.getSection(section).getCell(cell);
        final TalismanCardViewImpl swingCard = (TalismanCardViewImpl) card;

        final JPanel cardPanel = new JPanel();
        final LayoutManager panelManager = new BoxLayout(cardPanel, BoxLayout.Y_AXIS);
        cardPanel.setLayout(panelManager);
        cardPanel.add(swingCard);
        if (canBePickedUp) {
            final JButton pickupButton = new JButton("Pickup");
            pickupButton.addActionListener((e) -> {
                this.hideCardOnLeave = true;
                cardPanel.setVisible(false);
                this.pickupCard(card);
            });
            cardPanel.add(pickupButton);
        }
        final JButton hideButton = new JButton("Close");
        hideButton.addActionListener((e) -> {
            this.hideCardOnLeave = true;
            cardPanel.setVisible(false);
        });
        cardPanel.add(hideButton);
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        SwingUtilities.invokeLater(() -> {
            cardPanel.setVisible(false);
            this.add(cardPanel, 0);
        });

        ((BoardCellViewImpl) cellInstance).addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent e) {
                if (!TalismanBoardViewImpl.this.isShowingCard
                        && TalismanBoardViewImpl.this.canShowCard(section, cell)) {
                    cardPanel.setVisible(true);
                    TalismanBoardViewImpl.this.isShowingCard = true;
                }
            }

            @Override
            public void mouseExited(final MouseEvent e) {
                if (TalismanBoardViewImpl.this.hideCardOnLeave) {
                    cardPanel.setVisible(false);
                    TalismanBoardViewImpl.this.isShowingCard = false;
                }
            }

            @Override
            public void mouseClicked(final MouseEvent e) {
                if (TalismanBoardViewImpl.this.isShowingCard) {
                    TalismanBoardViewImpl.this.hideCardOnLeave = false;
                }
            }
        });

        swingCard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                TalismanBoardViewImpl.this.hideCardOnLeave = true;
                cardPanel.setVisible(false);
                TalismanBoardViewImpl.this.isShowingCard = false;
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
            final Container cardPanel = ((TalismanCardViewImpl) this.cards.get(position)).getParent();
            if (this.isShowingCard && cardPanel.isVisible()) {
                this.isShowingCard = false;
                this.hideCardOnLeave = true;
            }
            this.remove(cardPanel);
            this.cards.remove(position);
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCardPickupListener(final CardPickupListener listener) {
        this.listener = listener;
    }

    private boolean canShowCard(final int section, final int cell) {
        final int playerIndex = Controllers.getCharactersController().getCurrentPlayer().getIndex();
        final TalismanBoardPawn pawn = Controllers.getBoardController().getCharacterPawn(playerIndex);
        return pawn.getPositionSection() == section && pawn.getPositionCell() == cell;
    }

    private void pickupCard(final TalismanCardView card) {
        if (this.listener != null) {
            this.listener.pickupCard(card);
        }
    }
}
