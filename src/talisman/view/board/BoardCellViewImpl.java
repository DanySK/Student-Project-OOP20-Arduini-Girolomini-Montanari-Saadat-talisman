package talisman.view.board;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.JLabel;
import javax.swing.JPanel;

import talisman.util.ViewUtils;

/**
 * An implementation for a swing-based cell view.
 * 
 * * @author Alberto Arduini
 *
 */
public class BoardCellViewImpl extends JPanel implements BoardCellView {
    private final JLabel textLabel;
    private final JPanel textBackground;
    private final Image backgroundImage;

    /**
     * Creates a new cell.
     * 
     * @param imagePath the path to the background image
     * @param text      the text on the cell
     * @param type      the type of the cell
     */
    public BoardCellViewImpl(final String imagePath, final String text, final CellType type) {
        // I try to load the specified image
        File imageFile = new File(imagePath);
        // If the image doesn't exist, then I default to the "image not found" image
        if (!imageFile.exists()) {
            imageFile = new File(ViewUtils.NO_IMAGE_PATH);
        }
        Image loadedImage = null;
        try {
            loadedImage = ImageIO.read(imageFile);
        } catch (IOException e) {
            // Shouldn't happen, since the file in "NO_IMAGE_PATH" should always exist
            e.printStackTrace();
        }
        this.backgroundImage = loadedImage;
        this.textBackground = new JPanel();
        this.textBackground.setBackground(Color.BLACK);
        this.add(this.textBackground);
        this.textLabel = new JLabel();
        this.textLabel.setText(text);
        this.textLabel.setForeground(Color.WHITE);
        this.add(this.textLabel);
    }

    /**
     * {@inheritDoc}
     */
    // Needs to be overridden to display the background image
    public void paintComponent(final Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}
