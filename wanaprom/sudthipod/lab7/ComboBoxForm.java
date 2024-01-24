package wanaprom.sudthipod.lab7;

import javax.swing.*;

/**
 * ComboBoxForm:
 * This class is extended from EmptyForm
 * and adds a combo box with provided items
 * in the pattern:
 * <formName> <formComboBox>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 24/01/2024
 */

public class ComboBoxForm extends EmptyForm {
    protected static final int DEFAULT_FIELD_LENGTH = 15;

    // Constructors
    public ComboBoxForm(String formName, JLabel formLabel, JComboBox<String> formComboBox, String[] comboBoxItems, int selectedComboBoxIndex) {
        // Set up the form
        super(formName, formLabel);

        // Create the combo box
        formComboBox = new JComboBox<String>(comboBoxItems);

        // Set the selected index
        if (selectedComboBoxIndex < comboBoxItems.length) {
            formComboBox.setSelectedIndex(selectedComboBoxIndex);
        }

        // Add to the form panel
        add(formComboBox);
    }

    public ComboBoxForm(String formName, JLabel formLabel, JComboBox<String> formComboBox, String[] comboBoxItems) {
        // Select the first item by default
        this(formName, formLabel, formComboBox, comboBoxItems, 0);
    }
}