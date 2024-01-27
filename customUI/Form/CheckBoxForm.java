package customUI.Form;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * CheckBoxForm.java:
 * Extend Form class and implement HasCheckBox.
 * simply a form with checkBoxes which has no ButtonGroup by default.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 27/01/2024
 */

public class CheckBoxForm extends Form implements HasCheckBox {
    protected JPanel checkBoxesPanel;
    protected ButtonGroup checkBoxButtonGroup;
    protected Map<String, JCheckBox> checkBoxesMap; // <Key, CheckBox>
    protected boolean isMultipleSelectionsEnabled;

    public CheckBoxForm() {
        super();
        // Create checkBox panel
        checkBoxesPanel = new JPanel(); // Use default FlowLayout
        add(checkBoxesPanel);

        // Create button group
        checkBoxButtonGroup = new ButtonGroup();

        // Create empty checkBox map (dictionary)
        checkBoxesMap = new HashMap<String, JCheckBox>();

        // Multiple selections by default
        isMultipleSelectionsEnabled = true;

        // Set default style
        setStyle(0);
    }

    public CheckBoxForm(String[] checkBoxNames) {
        this();
        for (String checkBoxName : checkBoxNames) {
            JCheckBox checkBox = getCheckBox(checkBoxName);
            checkBoxesMap.put(checkBoxName, checkBox);
            checkBoxesPanel.add(checkBox);
            if (!isMultipleSelectionsEnabled) {
                checkBoxButtonGroup.add(checkBox);
            }
        }
    }

    // Implement methods
    @Override
    public JPanel getCheckBoxesPanel() {
        return checkBoxesPanel;
    }

    @Override
    public ButtonGroup getButtonGroup() {
        return checkBoxButtonGroup;
    }

    @Override
    public JCheckBox getCheckBox(String checkBoxName) {
        if (!checkBoxesMap.containsKey(checkBoxName)) {
            // Create new button if not exists
            JCheckBox checkBox = new JCheckBox(checkBoxName);
            checkBoxesMap.put(checkBoxName, checkBox);
            checkBoxesPanel.add(checkBox);
            if (!isMultipleSelectionsEnabled) {
                checkBoxButtonGroup.add(checkBox);
            }
        }
        return checkBoxesMap.get(checkBoxName);
    }

    @Override
    public JCheckBox getCheckBox() {
        // Create new button with default name
        JCheckBox checkBox = new JCheckBox(DEFAULT_CHECKBOX_NAME);
        checkBoxesMap.put(DEFAULT_CHECKBOX_NAME, checkBox);
        checkBoxesPanel.add(checkBox);
        if (!isMultipleSelectionsEnabled) {
            checkBoxButtonGroup.add(checkBox);
        }
        return checkBox;
    }

    @Override
    public String getCheckBoxName(JCheckBox checkBox) {
        if (!checkBoxesMap.containsKey(checkBox.getText())) {
            return DEFAULT_CHECKBOX_NAME;
        }

        return checkBox.getText();
    }

    @Override
    public Map<String, JCheckBox> getCheckBoxes() {
        return checkBoxesMap;
    }

    @Override
    public void setCheckBoxName(String newCheckBoxName, String oldCheckBoxName) {
        JCheckBox checkBox = checkBoxesMap.get(oldCheckBoxName);
        if (checkBox != null) {
            // Remove old name
            checkBoxesMap.remove(oldCheckBoxName);
            checkBoxesMap.put(newCheckBoxName, checkBox);

            // Set new name
            checkBox.setText(newCheckBoxName);
        }
    }

    @Override
    public void setCheckBoxName(String newCheckBoxName, JCheckBox checkBox) {
        // Pass old checkBox name to another method
        setCheckBoxName(newCheckBoxName, checkBox.getText());
    }

    @Override
    public void setMultipleSelectionsEnabled(boolean isMultipleSelections) {
        if (this.isMultipleSelectionsEnabled == isMultipleSelections) return; // No changes
        this.isMultipleSelectionsEnabled = isMultipleSelections;
        if (!isMultipleSelections) {
            for (JCheckBox checkBox : checkBoxesMap.values()) {
                checkBoxButtonGroup.add(checkBox);
            }
        } else {
            for (JCheckBox checkBox : checkBoxesMap.values()) {
                checkBoxButtonGroup.remove(checkBox);
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
                checkBoxesPanel.setBackground(null);
                for (JCheckBox checkBox : checkBoxesMap.values()) {
                    checkBox.setFont(UIManager.getDefaults().getFont("Label.font"));
                    checkBox.setForeground(null);
                    checkBox.setBackground(null);
                }
                setBackground(null);
                break;

            case 1:
                // Future Blue
                checkBoxesPanel.setBackground(Color.BLACK);
                for (JCheckBox checkBox : checkBoxesMap.values()) {
                    checkBox.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
                    checkBox.setForeground(Color.decode("#0062ff"));
                    checkBox.setBackground(Color.BLACK);
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