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
 * Static class used to abstract the creation of the default game board.
 * 
 * @author Alberto Arduini
 *
 */
public final class TalismanBoardFactory {
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
        // First i try to load from file
        final Optional<TalismanBoard> loadedBoard = TalismanBoardSerializer.loadBoard();
        if (loadedBoard.isPresent()) {
            for (int i = 0; i < startingPawns.size(); i++) {
                loadedBoard.get().addPawn(i, startingPawns.get(i));
            }
            return loadedBoard.get();
        }
        // If the loading fails (file not found, classes changed, etc.) then i create it
        // from scratch
        final List<TalismanBoardSection> sections = List.of(
                TalismanBoardFactory.createOutsideSection(),
                TalismanBoardFactory.createMiddleSection(), 
                TalismanBoardFactory.createInnerSection(),
                TalismanBoardFactory.createCrownSection());
        final TalismanBoard createdBoard = TalismanBoard.createBoard(sections, startingPawns);
        // After creation, before returning, i save it for future use
        TalismanBoardSerializer.saveBoard(createdBoard);
        return createdBoard;
    }

    private static TalismanBoardSection createOutsideSection() {
        return TalismanBoardSection.createSection(List.of(
                TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME,
                        Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME,
                        Set.of())));
    }

    private static TalismanBoardSection createMiddleSection() {
        return TalismanBoardSection.createSection(List.of(
                TalismanBoardFactory.createCell("Field", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("Field", "Test Right", CellType.RIGHT, TalismanCellType.BIOME,
                        Set.of())));
    }

    private static TalismanBoardSection createInnerSection() {
        return TalismanBoardSection.createSection(List.of(
                TalismanBoardFactory.createCell("Field", "Plains of Peril", CellType.UP, TalismanCellType.BIOME,
                        Set.of()),
                TalismanBoardFactory.createCell("Field", "Mines", CellType.UP, TalismanCellType.BIOME,
                        Set.of(new TalismanRollAction(5, TalismanActionStatistic.CRAFT, new TalismanEmptyAction(),
                                new TalismanMoveAction(0, 19)))),
                TalismanBoardFactory.createCell("Field", "Vampire's Tower", CellType.UP, TalismanCellType.BIOME,
                        Set.of(new TalismanRollAction(4, TalismanActionStatistic.NONE,
                                new TalismanModifyStatisticAction(1, TalismanActionStatistic.HEALTH),
                                new TalismanModifyStatisticAction(3, TalismanActionStatistic.HEALTH)))),
                TalismanBoardFactory.createCell("Field", "Crypt", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                TalismanBoardFactory.createCell("DiceWithDeath", "Dice with Death", CellType.DOWN,
                        TalismanCellType.MONSTER,
                        Set.of(new TalismanRollAction(5, TalismanActionStatistic.NONE, new TalismanEmptyAction(),
                                new TalismanModifyStatisticAction(1, TalismanActionStatistic.HEALTH)))),
                TalismanBoardFactory.createCell("WerewolfDen", "Werewolf Den", CellType.DOWN, TalismanCellType.MONSTER,
                        // TODO: set minimum to the werewolf's strength
                        Set.of(new TalismanRollAction(5, TalismanActionStatistic.NONE, new TalismanEmptyAction(),
                                new TalismanModifyStatisticAction(1, TalismanActionStatistic.HEALTH)))),
                TalismanBoardFactory.createCell("ValleyOfFire", "Valley of Fire", CellType.DOWN, TalismanCellType.ZONE,
                        Set.of(new TalismanRequireItemAction(0, new TalismanMoveAction(0, 3),
                                new TalismanEmptyAction()))),
                TalismanBoardFactory.createCell("Field", "Pits", CellType.RIGHT, TalismanCellType.BIOME,
                        // TODO: set minimum to the pitfiend's strength
                        Set.of(new TalismanFightAction(0)))));
    }

    private static TalismanBoardSection createCrownSection() {
        return TalismanBoardSection.createSection(List
                .of(TalismanBoardFactory.createCell("Crown", "Crown", CellType.UP, TalismanCellType.ZONE, Set.of())));
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
}
