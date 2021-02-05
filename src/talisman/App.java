package talisman;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import talisman.controller.board.TalismanBoardController;

import talisman.model.board.TalismanBoard;
import talisman.model.board.TalismanBoardCell;
import talisman.model.board.TalismanBoardPawn;
import talisman.model.board.TalismanBoardSection;
import talisman.model.board.TalismanCellType;
import talisman.view.board.PopulatedBoardView;
import talisman.view.board.PopulatedBoardViewBuilder;
import talisman.util.CellType;

public final class App {
    private App() {
    }

    private void run() {
        // Hard-coded swing GUI for testing
        final JFrame window = new JFrame();
        final LayoutManager layout = new GridLayout(1, 1);
        window.setLayout(layout);
        final PopulatedBoardView boardView = createBoard().getView();
        window.getContentPane().add((JPanel) boardView);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(600, 600);
        window.setVisible(true);
        
        System.out.println(((Component) boardView.getSection(0).getCell(0)).getSize());
    }

    private TalismanBoardController createBoard() {
        // For now all hard-coded for testing
        // Create model
        final List<TalismanBoardSection> sections = new ArrayList<>();
        sections.add(TalismanBoardSection.createSection(
                List.of(TalismanBoardCell.createCell("", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Right", CellType.RIGHT, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Right", CellType.RIGHT, TalismanCellType.BIOME, Set.of()))));
        sections.add(TalismanBoardSection.createSection(
                List.of(TalismanBoardCell.createCell("", "Test Up", CellType.UP, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Left", CellType.LEFT, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Down", CellType.DOWN, TalismanCellType.BIOME, Set.of()),
                        TalismanBoardCell.createCell("", "Test Right", CellType.RIGHT, TalismanCellType.BIOME, Set.of()))));
        final List<TalismanBoardPawn> pawns = new ArrayList<>();
        pawns.add(TalismanBoardPawn.createPawn(""));
        final TalismanBoard board = TalismanBoard.createBoard(sections, pawns);
        // Create view based on model
        final PopulatedBoardViewBuilder viewBuilder = new PopulatedBoardViewBuilder();
        return TalismanBoardController.create(board, viewBuilder.buildFromModel(board));
    }

    public static void main(final String[] args) {
        new App().run();
    }
}
