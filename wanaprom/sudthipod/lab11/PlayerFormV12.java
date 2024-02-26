package wanaprom.sudthipod.lab11;

import wanaprom.sudthipod.lab10.PlayerFormV11;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.*;

/**
 * PlayerFormV12:
 * This program is extended from PlayerFormV11.
 * Detect whenever the user press enter in JTextField with empty text then disable next component
 * after the dialog is shown, focus the JTextField for user to input
 * Date Of Birth field is also need to be validated in format <dd-mm-yyyy>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 26/02/2024
 */

public class PlayerFormV12 extends PlayerFormV11 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV12 window = new PlayerFormV12("Player Form 12");
        window.addMenus();
        window.addComponents();
        window.addListeners();
        window.enableKeyboard();
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
    public PlayerFormV12(String title) {
        super(title);
    }

    public PlayerFormV12() {
        super();
    }
    
    // Components
    protected final String TEXTFIELD_EMPTY_DIALOG_TEMPLATE = "Please enter some data in ";
    protected final String INVALID_BIRTHDATE_DIALOG_TEMPLATE = "Please enter a valid date in ";

    protected DateTimeFormatter birthDateFormatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");

    // Object methods
    @Override
    protected void addComponents() {
        super.addComponents();
        
        // Handle weird background color change with JTextField.setEnabled();
        nameField.setBackground(Color.WHITE);
        nationalityField.setBackground(Color.WHITE);
        birthDateField.setBackground(Color.WHITE);
    }

    @Override
    protected void handleTextField(JTextField textField) {
        if (textField == birthDateField) {
            try {
                // Check date format as dd-mm-yyyy pattern
                birthDateFormatter.parse(textField.getText());
            } catch (DateTimeParseException e) {
                // Show dialog
                showMessageDialog(INVALID_BIRTHDATE_DIALOG_TEMPLATE + textField.getName());

                // Focus the text field
                textField.requestFocusInWindow();

                return;
            }
        } else if (textField.getText().isEmpty()) {
            // If text field is empty, show dialog
            showMessageDialog(TEXTFIELD_EMPTY_DIALOG_TEMPLATE + textField.getName());

            // Disable next component
            if (textField == nameField) nationalityField.setEnabled(false);
            if (textField == nationalityField) birthDateField.setEnabled(false);

            // Focus the text field
            textField.requestFocusInWindow();

            return;
        }

        // No error is occurred
        super.handleTextField(textField);
        // Enable next back the component
        if (textField == nameField) nationalityField.setEnabled(true);
        if (textField == nationalityField) birthDateField.setEnabled(true);
    }
}
