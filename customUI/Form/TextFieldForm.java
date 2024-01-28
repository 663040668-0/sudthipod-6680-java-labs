package customUI.Form;

import javax.swing.*;
import java.awt.*;

/**
 * TextForm.java:
 * Extend Form class and implement HasTextField.
 * simply a form with text field.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 28/01/2024
 */

public class TextFieldForm extends Form implements HasTextField {
    protected JTextField formTextField;

    public TextFieldForm(String labelText, int columns) {
        // Create form
        super(labelText);

        // Create text field
        formTextField = new JTextField(columns);
        add(formTextField);

        // Set default style
        setStyle(0);
    }

    public TextFieldForm(String labelText) {
        // Create form
        this(labelText, DEFAULT_TEXT_FIELD_COLUMNS);
    }

    public TextFieldForm(int columns) {
        // Create form
        this(DEFAULT_LABEL_TEXT, columns);
    }

    public TextFieldForm() {
        // Create form
        this(DEFAULT_LABEL_TEXT, DEFAULT_TEXT_FIELD_COLUMNS);
    }

    // Implement methods
    @Override
    public JTextField getTextField(int columns) {
        // Both setter and getter
        formTextField.setColumns(columns);
        return formTextField;
    }

    @Override
    public JTextField getTextField() {
        return formTextField;
    }

    // Extend methods
    @Override
    public void setStyle(int styleNumber) {
        super.setStyle(styleNumber);
        switch (styleNumber) {
            case 0:
                // Reset style
                formTextField.setFont(UIManager.getDefaults().getFont("TextField.font"));
                formTextField.setBackground(null);
                formTextField.setForeground(null);
                formTextField.setBorder(UIManager.getDefaults().getBorder("TextField.border"));
                break;

            case 1:
                // Future Blue
                formTextField.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
                formTextField.setBackground(Color.decode("#00003d"));
                formTextField.setBorder(BorderFactory.createLineBorder(Color.decode("#0062ff"), 1));
                formTextField.setForeground(Color.WHITE);
                break;

            default:
                // Do nothing
                System.err.println("Unknown style number: " + styleNumber + " for TextFieldForm.");
                break;
        }
    }
}