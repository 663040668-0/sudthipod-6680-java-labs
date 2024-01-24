package wanaprom.sudthipod.lab7;

import javax.swing.*;
import java.awt.*;

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
    protected JPanel typePanel;
    protected JLabel typeLabel;
    protected JComboBox<String> typeComboBox;
    protected String[] typeItems = {"Beginner", "Amateur", "Professional"};

    protected JPanel notePanel;
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
        typePanel = new ComboBoxForm("Player Type:", typeLabel, typeComboBox, typeItems, 1);
        // Note: "Amateur" has to be selected by default
        notePanel = new ParagraphForm("Note:", noteLabel, noteArea, NOTE_ROWS, NOTE_COLUMNS);

        formsPanel.add(typePanel);
        formsPanel.add(notePanel);
    }
}
