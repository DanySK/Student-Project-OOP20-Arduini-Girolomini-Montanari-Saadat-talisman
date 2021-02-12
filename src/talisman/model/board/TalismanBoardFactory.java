package talisman.model.board;

import static talisman.model.action.TalismanRollAction.RollStatistic;

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
import java.util.Set;

import talisman.model.action.TalismanAction;
import talisman.model.action.TalismanDamageAction;
import talisman.model.action.TalismanEmptyAction;
import talisman.model.action.TalismanFightAction;
import talisman.model.action.TalismanMoveAction;
import talisman.model.action.TalismanRequireItemAction;
import talisman.model.action.TalismanRollAction;
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
        if (new File(BOARD_FILE_PATH).exists()) {
            try {
                final TalismanBoard board = TalismanBoardFactory.loadBoard();
                if (board != null) {
                    for (int i = 0; i < startingPawns.size(); i++) {
                        board.addPawn(i, startingPawns.get(i));
                    }
                }
                return board;
            } catch (final InvalidClassException ex) {
                System.out.println("Something has changed in the board classes, re-creating it...");
            }
        }
        // For now the values used are for testing
        final List<TalismanBoardSection> sections = new ArrayList<>();
        sections.add(TalismanBoardSection.createSection(List.of(
                TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME,
                        Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME,
                        Set.of()))));
        sections.add(TalismanBoardSection.createSection(List.of(
                TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME,
                        Set.of()))));
        sections.add(TalismanBoardSection.createSection(List.of(
                TalismanBoardFactory.createCell("Field", "Plains of Peril", CellType.UP, TalismanCellType.BIOME,
                        Set.of()),
                TalismanBoardFactory.createCell("Field", "Mines", CellType.UP, TalismanCellType.BIOME,
                        Set.of(new TalismanRollAction(5, RollStatistic.CRAFT, new TalismanEmptyAction(),
                                new TalismanMoveAction(0, 19)))),
                TalismanBoardFactory.createCell("Field", "Vampire's Tower", CellType.UP, TalismanCellType.BIOME,
                        Set.of(new TalismanRollAction(4, RollStatistic.ABSOLUTE, new TalismanDamageAction(1),
                                new TalismanDamageAction(3)))),
                TalismanBoardFactory.createCell("Field", "Crypt", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("DiceWithDeath", "Dice with Death", CellType.DOWN,
                        TalismanCellType.MONSTER,
                        Set.of(new TalismanRollAction(5, RollStatistic.ABSOLUTE, new TalismanEmptyAction(),
                                new TalismanDamageAction(1)))),
                TalismanBoardFactory.createCell("WerewolfDen", "Werewolf Den", CellType.DOWN, TalismanCellType.MONSTER,
                        // TODO: set mininum to the werewolf's strength
                        Set.of(new TalismanRollAction(5, RollStatistic.ABSOLUTE, new TalismanEmptyAction(),
                                new TalismanDamageAction(1)))),
                TalismanBoardFactory.createCell("ValleyOfFire", "Valley of Fire", CellType.DOWN, TalismanCellType.ZONE,
                        Set.of(new TalismanRequireItemAction(0, new TalismanMoveAction(0, 3),
                                new TalismanEmptyAction()))),
                TalismanBoardFactory.createCell("Field", "Pits", CellType.RIGHT, TalismanCellType.BIOME,
                        // TODO: set mininum to the pitfiend's strength
                        Set.of(new TalismanFightAction(0))))));
        sections.add(TalismanBoardSection.createSection(List
                .of(TalismanBoardFactory.createCell("Crown", "Crown", CellType.UP, TalismanCellType.ZONE, Set.of()))));
        final TalismanBoard board = TalismanBoard.createBoard(sections, startingPawns);
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
            final TalismanCellType type, final Collection<TalismanAction> actions) {
        return TalismanBoardCell.createCell(ViewUtils.getPathToCell(type, imageName, true), text, orientation, type,
                actions);
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

    private static TalismanBoard loadBoard() throws InvalidClassException {
        try (FileInputStream fileIn = new FileInputStream(BOARD_FILE_PATH);
                ObjectInputStream in = new ObjectInputStream(fileIn)) {
            final TalismanBoard board = (TalismanBoard) in.readObject();
            in.close();
            fileIn.close();
            return board;
        } catch (final InvalidClassException ex) {
            throw ex;
        } catch (final IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
