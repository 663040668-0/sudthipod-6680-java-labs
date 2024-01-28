package wanaprom.sudthipod.lab7;

import javax.swing.*;
import customUI.Form.*; // Absolute handmade package

/**
 * PlayerFormV2:
 * This program is extended from PlayerFormV1
 * and overrides the addComponents methods.
 * (Static method must not be overridden but must be redefined instead)
 * 
 * Added:
 * - Player Type using <Combo Box>
 * - Note using <Text Area>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 24/01/2024
 */

public class PlayerFormV2 extends PlayerFormV1 {
    // Components Clarification
    protected ComboBoxForm playerTypeForm;
    protected JLabel playerTypeLabel;
    protected JComboBox<String> playerTypeComboBox;
    protected String[] playerTypeItems = {"Beginner", "Amateur", "Professional"};

    protected TextAreaForm noteForm;
    protected JLabel noteLabel;
    protected JTextArea noteArea;
    protected final int NOTE_ROWS = 3;
    protected final int NOTE_COLUMNS = 35;

    // Main methods (redefine)
    public static void createAndShowGUI() {
        PlayerFormV2 msw = new PlayerFormV2("Player Form V2");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    // Pass the contructors to super class (JFrame)
    public PlayerFormV2(String title) {
        super(title);
    }

    public PlayerFormV2() {
        super();
    }

    // Object methods

    @Override
    protected void addComponents() {
        // Inherit components
        super.addComponents();

        // Create forms respectively
        playerTypeForm = new ComboBoxForm("Player Type:", playerTypeItems);
        playerTypeComboBox = playerTypeForm.getComboBox();
        playerTypeLabel = playerTypeForm.getLabel();
        playerTypeComboBox.setSelectedIndex(1);
        // Note: "Amateur" has to be selected by default

        noteForm = new TextAreaForm("Note:", NOTE_ROWS, NOTE_COLUMNS);
        noteArea = noteForm.getTextArea();
        noteArea.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");

        formsPanel.add(playerTypeForm);
        formsPanel.add(noteForm);
    }
}
