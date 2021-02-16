package talisman.model.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import talisman.model.action.TalismanAction;
import talisman.model.action.TalismanActionStatistic;
import talisman.model.action.TalismanEmptyAction;
import talisman.model.action.TalismanFightAction;
import talisman.model.action.TalismanModifyStatisticAction;
import talisman.model.action.TalismanMoveAction;
import talisman.model.action.TalismanRequireItemAction;
import talisman.model.action.TalismanRollAction;

import talisman.util.CellType;
import talisman.util.ViewUtils;

/**
 * Static class used to help serialize the board.
 * 
 * @author Alberto Arduini
 *
 */
public final class TalismanBoardSerializer {
    private static final String BOARD_FILE_PATH = "board.tal";

    private TalismanBoardSerializer() {
    }

    /**
     * Saves the given board to a file.
     * 
     * @param board the board to save
     */
    public static void saveBoard(final TalismanBoard board) {
        try (FileOutputStream fileOut = new FileOutputStream(BOARD_FILE_PATH);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(board);
            out.close();
            fileOut.close();
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Loads the saved board.
     * 
     * @return An optional containing the loaded board, if present, otherwise an
     *         empty optional if it wasn't found or if there was an error
     */
    public static Optional<TalismanBoard> loadBoard() {
        if (!new File(BOARD_FILE_PATH).exists()) {
            return Optional.empty();
        }
        try (FileInputStream fileIn = new FileInputStream(BOARD_FILE_PATH);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            final TalismanBoard board = (TalismanBoard) in.readObject();
            in.close();
            fileIn.close();
            return Optional.ofNullable(board);
        } catch (final IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }
}
