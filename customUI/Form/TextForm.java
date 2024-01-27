package customUI.Form;

import javax.swing.*;
import java.awt.*;

/**
 * TextForm.java:
 * Extend Form class and implement HasTextField.
 * simply a form with text field.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 27/01/2024
 */

public class TextForm extends Form implements HasTextField {
    protected JTextField formTextField;

    public TextForm() {
        // Create form
        super();

        // Create text field
        formTextField = new JTextField(DEFAULT_TEXT_FIELD_COLUMNS);
        add(formTextField);

        // Set default style
        setStyle(0);
    }

    // Implement methods
    @Override
    public JTextField getFormTextField(int columns) {
        // Both setter and getter
        formTextField.setColumns(columns);
        return formTextField;
    }

    @Override
    public JTextField getFormTextField() {
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
                break;
        }
    }
}