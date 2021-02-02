package talisman.view.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.LayoutManager;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import talisman.util.CellType;

/**
 * A swing implementation of a board section.
 * 
 * @author Alberto Arduini
 *
 */
public class BoardSectionViewImpl extends JPanel implements BoardSectionView {
    private final List<BoardCellView> cells;

    /**
     * Creates a new section.
     * 
     * @param cells the cells that the section contains
     */
    public BoardSectionViewImpl(final List<BoardCellView> cells) {
        this.cells = List.copyOf(cells);
        final LayoutManager layout = new BorderLayout();
        this.setLayout(layout);
        final Map<CellType, JPanel> subsections = new HashMap<>();
        // I create the four containers for the subsections
        subsections.put(CellType.UP, this.createSubsection(BoxLayout.X_AXIS));
        subsections.put(CellType.DOWN, this.createSubsection(BoxLayout.X_AXIS));
        subsections.put(CellType.LEFT, this.createSubsection(BoxLayout.Y_AXIS));
        subsections.put(CellType.RIGHT, this.createSubsection(BoxLayout.Y_AXIS));
        // I add all the subsections in the right part of the BorderLayout
        this.add(subsections.get(CellType.UP), BorderLayout.PAGE_START);
        this.add(subsections.get(CellType.DOWN), BorderLayout.PAGE_END);
        this.add(subsections.get(CellType.LEFT), BorderLayout.LINE_START);
        this.add(subsections.get(CellType.RIGHT), BorderLayout.LINE_END);
        for (final BoardCellView cell : this.cells) {
            // I take as granted that the cells use the swing implementation
            // (Also we can't have a GUI with mixed frameworks, so if the section is using
            // swing then the cells must too)
            // Anyway i still cast to the most generic type possible, to retain some
            // abstraction
            // in case the implementation changes the type of component.
            final Component swingCell = (Component) cell;
            final JPanel subsection = subsections.get(cell.getCellType());
            subsection.add(swingCell);
            subsection.add(Box.createGlue());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setContainedSection(final BoardSectionView section) {
        // The same principle used for casting the cells applies here
        this.add((Component) section, BorderLayout.CENTER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCellCount() {
        return this.cells.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BoardCellView getCell(final int cellIndex) {
        return this.cells.get(cellIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCellPositionX(final int cellIndex) {
        return this.getCell(cellIndex).getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCellPositionY(final int cellIndex) {
        return this.getCell(cellIndex).getY();
    }

    /**
     * Abstracts the creation for the container for a row/column of the section.
     * 
     * @param orientation
     * @return
     */
    private JPanel createSubsection(final int orientation) {
        final JPanel panel = new JPanel();
        final LayoutManager layout = new BoxLayout(panel, orientation);
        panel.setLayout(layout);
        panel.add(Box.createGlue());
        return panel;
    }
}
