package talisman.model.board;

/**
 * A pawn on a talisman board.
 * 
 * @author Alberto Arduini
 *
 */
public class TalismanBoardPawn implements BoardPawn {
    private final String imagePath;

    /**
     * Creates a new pawn.
     * 
     * @param imagePath the path to the pawn's image
     */
    public TalismanBoardPawn(final String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getImagePath() {
        return this.imagePath;
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
