package wanaprom.sudthipod.lab7;

import javax.swing.*;

/**
 * PlayerFormV1:
 * This program collects player information from user
 * including :
 * - <playerName> by JTextField
 * - <playerNationality> by JTextField
 * - <playerBirthDate> by JTextField
 * - <playerGender> by JRadioButtons in ButtonGroup
 * 
 * The class is extended from MySimpleWindow
 * and overrides the addComponents methods
 * (Static method must not be overridden but must be redefined instead)
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 24/01/2024
 */

public class PlayerFormV1 extends MySimpleWindow {
    // Components Clarification
    protected JPanel namePanel; // Use grid layout 1 row 2 columns
    protected JLabel nameLabel;
    protected JTextField nameField;

    protected JPanel nationalityPanel; // Use grid layout 1 row 2 columns
    protected JLabel nationalityLabel;
    protected JTextField nationalityField;

    protected JPanel birthDatePanel; // Use grid layout 1 row 2 columns
    protected JLabel birthDateLabel;
    protected JTextField birthDateField;

    protected final int FIELD_LENGTH = 15;

    protected JPanel genderPanel; // Use grid layout 1 row 2 columns
    protected JLabel genderLabel;
    protected JPanel genderButtonPanel; // Use grid layout 1 row 2 columns
    protected ButtonGroup genderButtonGroup;
    protected JRadioButton maleButton;
    protected JRadioButton femaleButton;

    // Main methods (redefine)
    public static void createAndShowGUI() {
        PlayerFormV1 msw = new PlayerFormV1("Player Form V1");
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
    public PlayerFormV1(String title) {
        super(title);
    }

    public PlayerFormV1() {
        super();
    }

    // Object methods
    protected void addDefaultForms() {
        // Create forms respectively
        namePanel = new TextForm("Name:", nameLabel, nameField);
        nationalityPanel = new TextForm("Nationality:", nationalityLabel, nationalityField);
        birthDatePanel = new TextForm("Date of Birth (eg.,31-01-2005):", birthDateLabel, birthDateField);
        genderPanel = new RadioForm("Gender:", genderLabel, genderButtonPanel, genderButtonGroup,
         new JRadioButton[]{maleButton, femaleButton}, new String[]{"Male", "Female"}, 1);
        // Note: femaleButton has to be selected by default

        mainPanel.add(namePanel);
        mainPanel.add(nationalityPanel);
        mainPanel.add(birthDatePanel);
        mainPanel.add(genderPanel);
    }

    @Override
    protected void addComponents() {
        // Start with main panel
        addMainPanel();

        // Add default forms
        addDefaultForms();

        // End with buttons
        addButtons();
    }
}
