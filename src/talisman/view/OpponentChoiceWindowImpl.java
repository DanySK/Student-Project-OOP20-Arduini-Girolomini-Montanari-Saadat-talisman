package talisman.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import talisman.Controllers;
import talisman.controller.battle.BattleController;
import talisman.controller.battle.BattleControllerImpl;
import talisman.model.battle.BattleModel;
import talisman.model.battle.BattleModelImpl;
import talisman.model.character.CharacterModel;
/**
 * Swing implementation of the view used to select an opponent to fight.
 * 
 * @author Alice Girolomini
 *
 */
public class OpponentChoiceWindowImpl extends JFrame implements OpponentChoiceWindow {
    private static final long serialVersionUID = 1L;
    private final List<Integer> opponents;
    private final JTextField textField;
    private final JButton choiceButton;
    /**
     * Creates the window.
     * 
     * @param players - the list of players in the same cell
     */
    public OpponentChoiceWindowImpl(final List<Integer> players) {
        this.opponents = players;
        this.textField = new JTextField(10);
        this.choiceButton = new JButton("Continue");
        final BorderLayout layout = new BorderLayout();
        this.setLayout(layout);
        this.setTitle("Choose your opponent:");
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.getContentPane().add(createTitlePanel(), BorderLayout.NORTH);
        this.getContentPane().add(createTextPanel(), BorderLayout.CENTER);
        this.getContentPane().add(createButtonPanel(), BorderLayout.SOUTH);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     * Creates a panel with the title.
     */
    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        JLabel title = new JLabel("Choose one of these opponents: " + listToString(this.opponents));
        title.setForeground(Color.BLACK);
        panel.setBackground(Color.darkGray);
        panel.add(title);
        return panel;
    }

    /**
     * Creates a panel with the text field.
     */
    private JPanel createTextPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.add(textField);
        return panel;
    }

    /**
     * Creates a panel with the continue button.
     */
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        choiceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                if (!textField.getText().equals("")) {
                    if (checkOpponent(Integer.parseInt(textField.getText()))) {
                        startFight(Integer.parseInt(textField.getText()));
                    } else {
                        JOptionPane.showMessageDialog(null, "This opponent is not available!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You have to choose one of the opponents before you continue.");
                }
            }

        });
        panel.setBackground(Color.darkGray);
        panel.add(choiceButton);
        return panel;
    }

    /**
     * Puts the integers of the list in a string.
     * 
     * @param list - the list of integers
     */
    private String listToString(final List<Integer> list) {
        String values = list.stream().map(String::valueOf).collect(Collectors.joining(", "));
        return values;
    }

    /**
     * Checks whether the opponent exists.
     * 
     * @param index - the opponents'index
     */
    private boolean checkOpponent(final int index) {
        return this.opponents.contains(index);
    }

    /**
     * Starts the fight.
     */
    private void startFight(final int index) {
        this.setVisible(false);
        CharacterModel firstcharacter = Controllers.getCharactersController().getCurrentPlayer().getCurrentCharacter();
        CharacterModel secondcharacter = Controllers.getCharactersController().getPlayers()[index].getCurrentCharacter();
        BattleModel battleModel = new BattleModelImpl(firstcharacter.getStrength(), secondcharacter.getStrength());
        BattleController battleController = new BattleControllerImpl(firstcharacter, secondcharacter, battleModel);
        new BattleWindow(battleController);
    }
}
