package wanaprom.sudthipod.lab7;

import javax.swing.*;

/**
 * TextForm:
 * This class is extended from EmptyForm
 * and adds a text field
 * in the pattern:
 * <formName> <formField>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 24/01/2024
 */

public class TextForm extends EmptyForm {
    protected static final int DEFAULT_FIELD_LENGTH = 15;

    // Constructors
    public TextForm(String formName, JLabel formLabel, JTextField formField, int formFieldLength) {
        // Set up the form
        super(formName, formLabel);

        // Create the form field
        formField = new JTextField(formFieldLength);

        // Add the form label and form field to the form panel
        add(formField);
    }

    public TextForm(String formName, JLabel formLabel, JTextField formField) {
        // Use default form field length
        this(formName, formLabel, formField, DEFAULT_FIELD_LENGTH);
    }

    public TextForm(String formName) {
        // Create new label and field
        this(formName, new JLabel(), new JTextField());
    }
}
