package talisman.model.board;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import talisman.model.board.action.TalismanCellAction;
import talisman.util.CellType;
import talisman.util.ViewUtils;

/**
 * Static class used to abstract the creation of the default game board.
 * 
 * @author Alberto Arduini
 *
 */
public final class TalismanBoardFactory {
    private static final String BOARD_FILE_PATH = "board.tal";

    private TalismanBoardFactory() {
    }

    /**
     * Creates a default board model with the starting player pawns, saving it to
     * the file for reuse or loading it if already present.
     * 
     * @param startingPawns the pawns that the players start with
     * @return the create board model
     */
    public static TalismanBoard createDefaultBoardModel(final List<TalismanBoardPawn> startingPawns) {
        TalismanBoard board;
        if (new File(BOARD_FILE_PATH).exists()) {
            board = TalismanBoardFactory.loadBoard();
            if (board == null) {
                return null;
            }
            for (int i = 0; i < startingPawns.size(); i++) {
                board.addPawn(i, startingPawns.get(i));
            }
        } else {
            // For now the values used are for testing
            final List<TalismanBoardSection> sections = new ArrayList<>();
            sections.add(TalismanBoardSection.createSection(List.of(
                    TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME, Set.of())
                    )));
            sections.add(TalismanBoardSection.createSection(List.of(
                    TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME,
                            Set.of()))));
            sections.add(TalismanBoardSection.createSection(List.of(
                    TalismanBoardFactory.createCell("Field", "Plains of Peril", CellType.UP, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Mines", CellType.UP, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Vampire's Tower", CellType.UP, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Crypt", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                    TalismanBoardFactory.createCell("DiceWithDeath", "Dice with Death", CellType.DOWN, TalismanCellType.MONSTER, Set.of()),
                    TalismanBoardFactory.createCell("WerewolfDen", "Werewolf Den", CellType.DOWN, TalismanCellType.MONSTER, Set.of()),
                    TalismanBoardFactory.createCell("ValleyOfFire", "Valley of Fire", CellType.DOWN, TalismanCellType.ZONE, Set.of()),
                    TalismanBoardFactory.createCell("Field", "Pits", CellType.RIGHT, TalismanCellType.BIOME, Set.of())
                    )));
            sections.add(TalismanBoardSection.createSection(List.of(
                    TalismanBoardFactory.createCell("Crown", "Crown", CellType.UP, TalismanCellType.ZONE, Set.of())
                    )));
            board = TalismanBoard.createBoard(sections, startingPawns);
        }
        TalismanBoardFactory.saveBoard(board);
        return board;
    }

    /**
     * Creates a new cell. Automatically gets the full path to the image.
     * 
     * @param imageName   the name of the image
     * @param text        the text of the cell
     * @param orientation the orientation in the board
     * @param type        the type if ambient
     * @param actions     the cell's actions
     * @return the created cell
     */
    public static TalismanBoardCell createCell(final String imageName, final String text, final CellType orientation,
            final TalismanCellType type, final Collection<TalismanCellAction> actions) {
        return TalismanBoardCell.createCell(ViewUtils.getPathToCell(type, imageName, true), text, orientation, type, actions);
    }

    private static void saveBoard(final TalismanBoard board) {
        try (FileOutputStream fileOut = new FileOutputStream(BOARD_FILE_PATH);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(board);
            out.close();
            fileOut.close();
        } catch (final IOException ex) {
            ex.printStackTrace();
        }
    }

    private static TalismanBoard loadBoard() {
        try (FileInputStream fileOut = new FileInputStream(BOARD_FILE_PATH);
                ObjectInputStream out = new ObjectInputStream(fileOut)) {
            final TalismanBoard board = (TalismanBoard) out.readObject();
            out.close();
            fileOut.close();
            return board;
        } catch (final IOException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
