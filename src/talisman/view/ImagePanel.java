package talisman.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import talisman.util.ViewUtils;

public class ImagePanel extends JPanel {
    private final Image backgroundImage;

    /**
     * Creates a new panel.
     * 
     * @param imagePath the path to the background image
     */
    public ImagePanel(final String imagePath) {
        // I try to load the specified image
        File imageFile = new File(imagePath);
        // If the image doesn't exist, then I default to the "image not found" image
        if (!imageFile.exists() || !imageFile.isFile()) {
            imageFile = new File(ViewUtils.RESOURCES_PATH + ViewUtils.NO_IMAGE_PATH);
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
        this.setMinimumSize(new Dimension(100, 100));
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
