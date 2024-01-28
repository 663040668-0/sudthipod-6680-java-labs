package wanaprom.sudthipod.lab7;

import customUI.Form.*;
import javax.swing.*;
import java.awt.*;

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
    protected JPanel formsPanel; // Use box layout in y-axis

    protected static final int TEXTFIELD_LENGTH = 20;

    protected TextFieldForm nameForm; // Use grid layout 1 row 2 columns
    protected JLabel nameLabel;
    protected JTextField nameField;

    protected TextFieldForm nationalityForm; // Use grid layout 1 row 2 columns
    protected JLabel nationalityLabel;
    protected JTextField nationalityField;

    protected TextFieldForm birthDateForm; // Use grid layout 1 row 2 columns
    protected JLabel birthDateLabel;
    protected JTextField birthDateField;

    protected RadioForm genderForm; // Use grid layout 1 row 2 columns
    protected JLabel genderLabel;
    protected JPanel genderButtonPanel; // Use grid layout 1 row 2 columns
    protected ButtonGroup genderButtonGroup;
    protected JRadioButton maleButton;
    protected JRadioButton femaleButton;
    protected String[] genders = {"Male", "Female"};

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
    @Override
    protected void addComponents() {
        // Inherit components
        super.addComponents();

        // Create forms panel
        formsPanel = new JPanel();
        formsPanel.setLayout(new BoxLayout(formsPanel, BoxLayout.Y_AXIS));

        // Add empty form panel to main panel
        mainPanel.add(formsPanel, BorderLayout.CENTER);

        // Create forms respectively
        nameForm = new TextFieldForm("Name:", TEXTFIELD_LENGTH);
        nameLabel = nameForm.getLabel();
        nameField = nameForm.getTextField();

        nationalityForm = new TextFieldForm("Nationality:", TEXTFIELD_LENGTH);
        nationalityLabel = nationalityForm.getLabel();
        nationalityField = nationalityForm.getTextField();

        birthDateForm = new TextFieldForm("Date of Birth (eg.,31-01-2005):", TEXTFIELD_LENGTH);
        birthDateLabel = birthDateForm.getLabel();
        birthDateField = birthDateForm.getTextField();

        genderForm = new RadioForm("Gender:", genders);
        genderLabel = genderForm.getLabel();
        genderButtonPanel = genderForm.getRadioButtonsPanel();
        genderButtonGroup = genderForm.getButtonGroup();
        maleButton = genderForm.getRadioButton("Male");
        femaleButton = genderForm.getRadioButton("Female");
        femaleButton.setSelected(true);

        // Note: femaleButton has to be selected by default

        formsPanel.add(nameForm);
        formsPanel.add(nationalityForm);
        formsPanel.add(birthDateForm);
        formsPanel.add(genderForm);
    }
}
