package talisman.view.board;

import java.util.List;

public interface TalismanBoardView extends PopulatedBoardView {
    /**
     * Adds a card on top of the specified cell. If the card is already present on
     * the board it does nothing.
     * 
     * @param section the section of the cell
     * @param cell    the cell
     */
    // TODO: Add card parameter
    void addOverlayedCard(int section, int cell);

    /**
     * Removes a card from the board. If the card is not present it does nothing.
     */
    void removeOverlayedCard(/* final CardView card */);

    /**
     * Removes the card on the specified cell. If the cell doesn't have a card it
     * does nothing.
     * 
     * @param section the cell's section
     * @param cell    the cell
     */
    void removeOverlayedCard(int section, int cell);

    /**
     * Constructs a new talisman board.
     * 
     * @param sections    the board sections
     * @param mainSection the board main section index
     * @param pawns       the pawns
     * @return the created board
     */
    static TalismanBoardView create(List<BoardSectionView> sections, int mainSection, List<PawnView> pawns) {
        return new TalismanBoardViewImpl(sections, mainSection, pawns);
    }
}
