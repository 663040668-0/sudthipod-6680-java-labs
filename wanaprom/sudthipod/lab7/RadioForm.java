package wanaprom.sudthipod.lab7;

import javax.swing.*;

/**
 * RadioForm:
 * This class is extended from EmptyForm
 * and adds radio buttons to the received ButtonGroup
 * accepts any amount of radio buttons
 * but need to match the amount of radio buttons name
 * and required ButtonGroup
 * in the pattern:
 * <formName> [<radioButton[0]><radioButtonName[0]> <radioButton[1]><radioButtonName[1]> ...]
 * 
 * Can initially select a radio button by specifying the index
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 24/01/2024
 */

public class RadioForm extends EmptyForm {
    // Constructors
    public RadioForm(String formName, JLabel formLabel, JPanel radioButtonPanel, ButtonGroup buttonGroup, JRadioButton[] radioButtons, String[] radioButtonNames, int selectedButtonIndex) {
        // Set up the form
        super(formName, formLabel);

        // Throw an exception if the number of radio buttons and the number of radio button names is not match
        if (radioButtons.length != radioButtonNames.length) {
            throw new IllegalArgumentException("The number of radio buttons and the number of radio button names must be the same");
        }

        // Create the panel, ButtonGroup, and radio buttons
        radioButtonPanel = new JPanel(); // Use flow layout
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton(radioButtonNames[i]);
            buttonGroup.add(radioButtons[i]);
            radioButtonPanel.add(radioButtons[i]);

            // Set the selected radio button
            if (i == selectedButtonIndex) {
                radioButtons[i].setSelected(true);
            }
        }

        // Add the form label and form field to the form panel
        add(radioButtonPanel);
    }

    // Doesn't specify selectedButtonIndex
    public RadioForm(String formName, JLabel formLabel, JPanel radioButtonPanel, ButtonGroup buttonGroup, JRadioButton[] radioButtons, String[] radioButtonNames) {
        // Select the first radio button by default
        this(formName, formLabel, radioButtonPanel, buttonGroup, radioButtons, radioButtonNames, 0);
    }

    // Does not allow 0 arguments constructor
}
