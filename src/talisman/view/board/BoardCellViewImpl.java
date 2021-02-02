package talisman.view.board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import talisman.util.CellType;
import talisman.util.ViewUtils;

/**
 * An implementation for a swing-based cell view.
 * 
 * * @author Alberto Arduini
 *
 */
// getX and getY do not get overridden since they are already define in JComponent
public final class BoardCellViewImpl extends JPanel implements BoardCellView {
    private final JLabel textLabel;
    private final JPanel textBackground;
    private final Image backgroundImage;
    private final CellType type;

    /**
     * Creates a new cell.
     * 
     * @param imagePath the path to the background image
     * @param text      the text on the cell
     * @param type      the type of the cell
     */
    public BoardCellViewImpl(final String imagePath, final String text, final CellType type) {
        this.type = type;
        // I try to load the specified image
        File imageFile = new File(imagePath);
        // If the image doesn't exist, then I default to the "image not found" image
        if (!imageFile.exists() || !imageFile.isFile()) {
            imageFile = new File(ViewUtils.PROJ_NO_IMAGE_PATH);
        }
        Image loadedImage = null;
        try {
            loadedImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            // Shouldn't happen, since the file in "*_NO_IMAGE_PATH" should always exist
            e.printStackTrace();
        }
        final LayoutManager layout = new BorderLayout();
        this.setLayout(layout);
        this.backgroundImage = loadedImage;
        this.textBackground = new JPanel();
        this.textBackground.setBackground(Color.BLACK);
        this.add(this.textBackground, BorderLayout.PAGE_END);
        this.textLabel = new JLabel();
        this.textLabel.setText(text);
        this.textLabel.setForeground(Color.WHITE);
        this.textBackground.add(this.textLabel);
        this.setMinimumSize(new Dimension(100, 100));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CellType getCellType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    // Needs to be overridden to display the background image
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Image scaledImage = this.backgroundImage.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT);
        g.drawImage(scaledImage, 0, 0, this);
    }
}
