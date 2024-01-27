package customUI.Form;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * RadioForm.java:
 * Extend Form class and implement HasRadioButton.
 * simply a form with radio buttons which has ButtonGroup by default.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 27/01/2024
 */

public class RadioForm extends Form implements HasRadioButton {
    protected JPanel radioButtonsPanel;
    protected ButtonGroup radioButtonsGroup;
    protected Map<String, JRadioButton> radioButtonsMap; // <Key, Button>
    protected boolean isMultipleSelectionsEnabled;

    // Without array of radio button names
    public RadioForm(String labelText) {
        // Create form
        super(labelText);

        // Create radio buttons panel
        radioButtonsPanel = new JPanel(); // Use default FlowLayout
        add(radioButtonsPanel);

        // Create button group
        radioButtonsGroup = new ButtonGroup();

        // Create empty radio buttons map (dictionary)
        radioButtonsMap = new HashMap<String, JRadioButton>();

        // Multiple selections by default
        isMultipleSelectionsEnabled = false;

        // Set default style
        setStyle(0);
    }

    public RadioForm() {
        this(DEFAULT_LABEL_TEXT);
    }

    // With array of radio button names
    public RadioForm(String labelText, String[] radioNames) {
        this(labelText);
        for (String radioName : radioNames) {
            JRadioButton radioButton = getRadioButton(radioName);
            radioButtonsMap.put(radioName, radioButton);
            radioButtonsPanel.add(radioButton);
            if (!isMultipleSelectionsEnabled) {
                radioButtonsGroup.add(radioButton);
            }
        }
    }

    public RadioForm(String[] radioNames) {
        this(DEFAULT_LABEL_TEXT, radioNames);
    }

    // Implement methods
    @Override
    public JPanel getRadioButtonsPanel() {
        return radioButtonsPanel;
    }

    @Override
    public ButtonGroup getButtonGroup() {
        return radioButtonsGroup;
    }

    @Override
    public JRadioButton getRadioButton(String radioName) {
        if (!radioButtonsMap.containsKey(radioName)) {
            // Create new button if not exists
            JRadioButton radioButton = new JRadioButton(radioName);
            radioButtonsMap.put(radioName, radioButton);
            radioButtonsPanel.add(radioButton);
            if (!isMultipleSelectionsEnabled) {
                radioButtonsGroup.add(radioButton);
            }
        }
        return radioButtonsMap.get(radioName);
    }

    @Override
    public JRadioButton getRadioButton() {
        // Create new button with default name
        JRadioButton radioButton = new JRadioButton(DEFAULT_RADIO_NAME);
        radioButtonsMap.put(DEFAULT_RADIO_NAME, radioButton);
        radioButtonsPanel.add(radioButton);
        if (!isMultipleSelectionsEnabled) {
            radioButtonsGroup.add(radioButton);
        }
        return radioButton;
    }

    @Override
    public String getRadioButtonName(JRadioButton radioButton) {
        if (!radioButtonsMap.containsKey(radioButton.getText())) {
            return DEFAULT_RADIO_NAME;
        }

        return radioButton.getText();
    }

    @Override
    public Map<String, JRadioButton> getRadioButtons() {
        return radioButtonsMap;
    }

    @Override
    public void setRadioButtonName(String newRadioName, String oldRadioName) {
        JRadioButton oldRadioButton = radioButtonsMap.get(oldRadioName);
        if (oldRadioButton != null) {
            // Remove old name
            radioButtonsMap.remove(oldRadioName);

            // Set new name
            radioButtonsMap.put(newRadioName, oldRadioButton);
            oldRadioButton.setText(newRadioName);
        }
    }

    @Override
    public void setRadioButtonName(String newRadioName, JRadioButton radioButton) {
        // Pass old button name to another method
        setRadioButtonName(newRadioName, radioButton.getText());
    }

    @Override
    public void setMultipleSelectionsEnabled(boolean isMultipleSelections) {
        if (this.isMultipleSelectionsEnabled == isMultipleSelections) return; // No changes
        this.isMultipleSelectionsEnabled = isMultipleSelections;
        if (!isMultipleSelections) {
            for (JRadioButton radioButton : radioButtonsMap.values()) {
                radioButtonsGroup.add(radioButton);
            }
        } else {
            for (JRadioButton radioButton : radioButtonsMap.values()) {
                radioButtonsGroup.remove(radioButton);
            }
        }
    }

    @Override
    public boolean isMultipleSelectionsEnabled() {
        return isMultipleSelectionsEnabled;
    }

    // Extend methods
    @Override
    public void setStyle(int styleNumber) {
        super.setStyle(styleNumber);
        switch (styleNumber) {
            case 0:
                // Reset style
                radioButtonsPanel.setBackground(null);
                for (JRadioButton radioButton : radioButtonsMap.values()) {
                    radioButton.setFont(UIManager.getDefaults().getFont("RadioButton.font"));
                    radioButton.setForeground(null);
                    radioButton.setBackground(null);
                }
                break;

            case 1:
                // Future Blue
                radioButtonsPanel.setBackground(Color.BLACK);
                for (JRadioButton radioButton : radioButtonsMap.values()) {
                    radioButton.setFont(new Font(Font.MONOSPACED , Font.PLAIN, 14));
                    radioButton.setForeground(Color.decode("#0062ff"));
                    radioButton.setBackground(Color.BLACK);
                }
                setBackground(Color.BLACK);
                break;

            default:
                // Warning
                System.err.println("Unknown style number: " + styleNumber + " for Form.");
                break;
        }
    }
}