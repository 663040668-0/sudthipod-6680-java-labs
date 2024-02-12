package wanaprom.sudthipod.lab9;

import wanaprom.sudthipod.lab8.PlayerFormV5;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * PlayerFormV6:
 * This program is extended from PlayerFormV5
 * and add actionEventListeners to read text in components
 * and detect changes in TextFields
 * also set the name to each TextField to use in actionEventListener
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 12/02/2024
 */

public class PlayerFormV6 extends PlayerFormV5 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV6 window = new PlayerFormV6("Player Form V6");
        window.addMenus();
        window.addComponents();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    // Pass the contructors to super class (JFrame)
    public PlayerFormV6(String title) {
        super(title);
    }

    public PlayerFormV6() {
        super();
    }

    // Components
    protected final String SUBMIT_DIALOG_TEMPLATE = "%s has nationality as %s and was born on %s, has gender as %s, is a %s player, has hobbies as %s and plays %s";
    protected final String TEXTFIELD_DIALOG_TEMPLATE = "%s is changed to %s";

    protected ActionListener actionListener;

    // Object methods
    @Override
    protected void addComponents() {
        super.addComponents();

        // Initialize ActionListener object to handle events from components
        createActionListeners();

        // Set name of each TextField
        nameField.setName("Name");
        nationalityField.setName("Nationality");
        birthDateField.setName("Date of Birth");

        // Add listener to buttons and TextField forms
        resetButton.addActionListener(actionListener);
        submitButton.addActionListener(actionListener);
        nameField.addActionListener(actionListener);
        nationalityField.addActionListener(actionListener);
        birthDateField.addActionListener(actionListener);
    }

    protected void createActionListeners() {
        // Initialize ActionListener object to handle events from components
        actionListener = (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object src = e.getSource();
                if (src == resetButton) {
                    handleResetButton();
                } else if (src == submitButton) {
                    handleSubmitButton();
                } else if (src instanceof JTextField) {
                    // NOTE: 'instanceof' is a 'class' checking operator
                    handleTextField((JTextField) src);
                }
            }
        });
    }

    protected void showMessageDialog(String message) {
        // Use invoke later to prevent interupting radioButtons and checkBoxes selection
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(PlayerFormV6.this, message);
            }
        });
    }

    protected void handleResetButton() {
        // Reset every form component
        nameField.setText("");
        nationalityField.setText("");
        birthDateField.setText("");
        maleButton.setSelected(false);
        femaleButton.setSelected(true);
        playerTypeComboBox.setSelectedIndex(1); // Amateur
        hobbiesForm.getCheckBox("Reading").setSelected(false);
        hobbiesForm.getCheckBox("Browsing").setSelected(false);
        hobbiesForm.getCheckBox("Sleeping").setSelected(true);
        hobbiesForm.getCheckBox("Traveling").setSelected(false);
        sportForm.getList().clearSelection();
        sportForm.getList().setSelectedIndex(2); // Football
        experienceYearForm.getSlider().setValue(0);
        noteArea.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");

    }

    protected void handleSubmitButton() {
        // Get values from components
        String name = nameField.getText();
        String nationality = nationalityField.getText();
        String birthDate = birthDateField.getText();
        String gender = maleButton.isSelected() ? maleButton.getText() : femaleButton.getText();
        String playerType = playerTypeComboBox.getSelectedItem().toString();
        ArrayList<String> hobbiesList = new ArrayList<String>();
        for (String hobby : hobbiesForm.getCheckBoxes().keySet()) {
            if (hobbiesForm.getCheckBox(hobby).isSelected()) {
                hobbiesList.add(hobby);
            }
        }
        String playerHobbies = String.join(" ", hobbiesList);
        String sport = sportForm.getList().getSelectedValuesList().toString();

        // Display the message dialog
        showMessageDialog(String.format(SUBMIT_DIALOG_TEMPLATE, name, nationality, birthDate, gender, playerType, playerHobbies, sport));
    }

    protected void handleTextField(JTextField textField) {
        String textFieldName = textField.getName();
        String textFieldValue = textField.getText();
        // Display the message dialog
        showMessageDialog(String.format(TEXTFIELD_DIALOG_TEMPLATE, textFieldName, textFieldValue));
    }
}
