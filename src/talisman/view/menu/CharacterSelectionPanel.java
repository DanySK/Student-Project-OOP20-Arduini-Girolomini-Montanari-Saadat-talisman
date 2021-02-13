package talisman.view.menu;

import java.awt.Component;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import talisman.util.ViewUtils;

/**
 * A panel that contains a button for each character. Used to select the
 * characters before starting the game.
 * 
 * @author Alberto Arduini
 *
 */
public class CharacterSelectionPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int OFFSET = 5;

    /**
     * Listener for when a character is selected.
     * 
     * @author Alberto Arduini
     *
     */
    public interface CharacterSelectedListener extends EventListener {
        void selected(int character);
    }

    private final List<JButton> buttons;
    private CharacterSelectedListener selectedListener;

    /**
     * Creates a new panel.
     */
    public CharacterSelectionPanel() {
        this.buttons = new ArrayList<>();

        final LayoutManager layout = new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(layout);

        // TODO: get characters count
        final int count = 4;
        for (int i = 0; i < count; i++) {
            // TODO: get image path
            final String imageName = "";
            final JButton button = this.createCharacterButton(imageName);
            this.buttons.add(button);
            button.addActionListener(this::characterButtonPressed);
            final JPanel wrapper = this.wrapInPanel(button, i != 0);
            this.add(wrapper);
        }
    }

    /**
     * Sets the listener that is waiting for a character to be selected.
     * 
     * @param listener
     */
    public void setSelectedListener(final CharacterSelectedListener listener) {
        this.selectedListener = listener;
    }

    /**
     * Disables the selection of the given character.
     * 
     * @param index the character index
     */
    public void disableCharacter(final int index) {
        this.buttons.get(index).setEnabled(false);
    }

    private JButton createCharacterButton(final String imageName) {
        // TODO: get image path
        final String imagePath = ViewUtils.getDevImagePath(ViewUtils.NO_IMAGE_NAME, true);
        return new JButton(new ImageIcon(imagePath));
    }

    private JPanel wrapInPanel(final Component component, final boolean addLeftOffset) {
        final JPanel panel = new JPanel();
        panel.add(component);
        if (addLeftOffset) {
            panel.setBorder(BorderFactory.createEmptyBorder(0, CharacterSelectionPanel.OFFSET, 0, 0));
        }
        return panel;
    }

    private void characterButtonPressed(final ActionEvent e) {
        this.selectedListener.selected(this.buttons.indexOf((JButton) e.getSource()));
    }
}
