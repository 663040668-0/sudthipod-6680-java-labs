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
 * Latest Update: 23/01/2024
 */

public class PlayerFormV1 extends MySimpleWindow {
    // Components Clarification
    protected JPanel namePanel;
    protected JLabel nameLabel;
    protected JTextField nameField;

    protected JPanel nationalityPanel;
    protected JLabel nationalityLabel;
    protected JTextField nationalityField;

    protected JPanel birthDatePanel;
    protected JLabel birthDateLabel;
    protected JTextField birthDateField;

    protected JPanel genderPanel;
    protected JLabel genderLabel;
    protected ButtonGroup genderButtonGroup;
    protected JRadioButton maleButton;
    protected JRadioButton femaleButton;

    protected final int FIELD_LENGTH = 15;

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
    protected JPanel makeForm(JPanel formPanel, JLabel formLabel, JTextField formField, String formName) {
        // This method will create and add form with text label from formName
        // and return the formPanel as an object

        // Create the form panel
        formPanel = new JPanel();

        // Create the form label and form field
        formLabel = new JLabel(formName);
        formField = new JTextField();
        formField.setSize(FIELD_LENGTH, formField.getHeight());

        // Add the form label and form field to the form panel
        formPanel.add(formLabel);
        formPanel.add(formField);

        // Add the form panel to the main panel
        add(formPanel);

        // Return the form panel
        return formPanel;
    }

    @Override
    protected void addComponents() {
        // Create grid layout

        // Create forms respectively
        makeForm(namePanel, nameLabel, nameField, "Name:");
        makeForm(nationalityPanel, nationalityLabel, nationalityField, "Nationality:");
        makeForm(birthDatePanel, birthDateLabel, birthDateField, "Date of Birth (eg.,31-01-2005):");


        // Create and add buttons
        buttonsPanel = new JPanel();
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");
        buttonsPanel.add(resetButton);
        buttonsPanel.add(submitButton);
        add(buttonsPanel);
    }
}
