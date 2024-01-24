package wanaprom.sudthipod.lab7;

import javax.swing.*;
import java.awt.*;

/**
 * EmptyForm:
 * This class is extended from JPanel
 * and used to create an empty form
 * in the pattern:
 * <formName> <emptyGridSpace>
 * Using grid layout 1 row and 2 columns
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 24/01/2024
 */

public class EmptyForm extends JPanel {
    // Constructors
    public EmptyForm(String formName, JLabel formLabel) {
        super();
        // Set layout
        setLayout(new GridLayout(1, 2));
        // Use grid layout for equal spacing between components

        // Create the form label and form field
        formLabel = new JLabel(formName);

        // Add the form label and form field to the form panel
        add(formLabel);
    }

    public EmptyForm(String formName) {
        // Create a new label
        this(formName, new JLabel());
    }
}
