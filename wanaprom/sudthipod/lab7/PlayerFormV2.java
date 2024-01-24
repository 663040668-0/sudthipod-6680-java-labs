package wanaprom.sudthipod.lab7;

import javax.swing.*;

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

    protected JPanel notePanel;
    protected JLabel noteLabel;
    protected JTextArea noteArea;

    // Main methods (redefine)
    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V2");
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
    protected void addSecondaryForms() {
        
    }

    @Override
    protected void addComponents() {
        // Start with main panel
        addMainPanel();

        // Add default forms
        addDefaultForms();

        // Add new forms
        addSecondaryForms();

        // End with buttons
        addButtons();
    }
}
