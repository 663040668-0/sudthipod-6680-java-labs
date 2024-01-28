package customUI.Form;

import javax.swing.*;
import java.awt.*;

/**
 * customUI.Form.java:
 * Use to facilitate creating simple forms in Swing.
 * - Form : Empty form with only label and empty column (use as base class).
 * - TextForm : Form with text field to put text String.
 * - RadioForm : Form with radio buttons.
 * - CheckBoxForm : Form with checkboxes.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 28/01/2024
 */

public class Form extends JPanel implements HasLabel {
    protected JLabel formLabel;

    public Form(String labelText) {
        // Create empty panel with 2 columns
        setLayout(new GridLayout(1, 2));

        // Create label
        formLabel = new JLabel(labelText);
        add(formLabel);
    }

    public Form() {
        this(DEFAULT_LABEL_TEXT);
    }

    // Implement methods
    public JLabel getLabel(String labelText) {
        // Both setter and getter
        formLabel.setText(labelText);
        return formLabel;
    }

    public JLabel getLabel() {
        return formLabel;
    }

    // Extend methods
    public void setStyle(int styleNumber) {
        switch (styleNumber) {
            case 0:
                // Reset style
                formLabel.setFont(UIManager.getDefaults().getFont("Label.font"));
                formLabel.setForeground(null);
                setBackground(null);
                break;

            case 1:
                // Future Blue
                formLabel.setFont(new Font(Font.MONOSPACED , Font.BOLD, 16));
                formLabel.setForeground(Color.decode("#0062ff"));
                setBackground(Color.BLACK);
                break;

            default:
                // Warning
                System.err.println("Unknown style number: " + styleNumber + " for Form.");
                break;
        }
    }
}