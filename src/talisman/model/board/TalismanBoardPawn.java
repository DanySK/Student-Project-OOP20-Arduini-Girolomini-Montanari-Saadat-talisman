package talisman.model.board;

import talisman.util.Pair;

/**
 * A pawn on a talisman board.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanBoardPawn implements BoardPawn {
    private final String imagePath;
    private Pair<Integer, Integer> position;

    /**
     * Creates a new pawn.
     * 
     * @param imagePath the path to the pawn's image
     */
    public TalismanBoardPawn(final String imagePath) {
        this.imagePath = imagePath;
        this.position = new Pair<>(0, 0);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPositionSection() {
        return this.position.getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getPositionCell() {
        return this.position.getY();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final int section, final int cell) {
        this.position = new Pair<>(section, cell);
    }

    /**
     * Constructs a new pawn.
     * 
     * @param imagePath the path to the pawn's image
     * @return the created pawn
     */
    public static TalismanBoardPawn createPawn(final String imagePath) {
        return new TalismanBoardPawn(imagePath);
    }
}
