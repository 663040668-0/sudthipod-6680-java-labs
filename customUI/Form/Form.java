package customUI.Form;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * customUI.Form:
 * Use to facilitate creating simple forms in Swing.
 * - Form : Empty form with only label and empty column (use as base class).
 * - TextForm : Form with text field to put text String.
 * - RadioForm : Form with radio buttons.
 * - CheckBoxForm : Form with checkboxes.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 27/01/2024
 */

// Interfaces
interface HasLabel {
    static final String DEFAULT_LABEL_TEXT = "Unknown Form:";

    JLabel getFormLabel(String labelText);

    JLabel getFormLabel();
}

interface HasTextField {
    static final int DEFAULT_TEXT_FIELD_COLUMNS = 10;

    JTextField getFormTextField(int columns);

    JTextField getFormTextField();
}

interface HasRadioButton {
    static final String DEFAULT_RADIO_NAME = "...";

    JPanel getRadioButtonsPanel();

    ButtonGroup getButtonGroup();

    JRadioButton getRadioButton(String radioName); // Add and get button

    JRadioButton getRadioButton(); // Add and get button with default name

    String getRadioButtonName(JRadioButton radioButton); // Add and get button

    Map<String, JRadioButton> getRadioButtons();

    void setRadioButtonName(String newRadioName, String oldRadioName);

    void setRadioButtonName(String newRadioName, JRadioButton radioButton);

    void setMultipleSelectionsEnabled(boolean isMultipleSelections);

    boolean isMultipleSelectionsEnabled();
}

interface HasCheckBox {
    static final String DEFAULT_CHECKBOX_NAME = "...";

    JPanel getCheckBoxesPanel();

    ButtonGroup getButtonGroup();

    JCheckBox  getCheckBox(String checkBoxName); // Add and get button

    JCheckBox  getCheckBox(); // Add and get button with default name

    String getCheckBoxName(JCheckBox checkBox); // Add and get button

    Map<String, JCheckBox> getCheckBoxes();

    void setCheckBoxName(String newCheckBoxName, String oldCheckBoxName);

    void setCheckBoxName(String newCheckBoxName, JCheckBox checkBox);

    void setMultipleSelectionsEnabled(boolean isMultipleSelections);

    boolean isMultipleSelectionsEnabled();
}

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
    public JLabel getFormLabel(String labelText) {
        // Both setter and getter
        formLabel.setText(labelText);
        return formLabel;
    }

    public JLabel getFormLabel() {
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