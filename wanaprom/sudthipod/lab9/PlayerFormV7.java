package wanaprom.sudthipod.lab9;

import javax.swing.*;
import java.awt.event.*;

/**
 * PlayerFormV7:
 * This program is extended from PlayerFormV6
 * and add itemListener to read value in buttons
 * and detect changes in button forms
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 12/02/2024
 */

public class PlayerFormV7 extends PlayerFormV6 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV7 window = new PlayerFormV7("Player Form V7");
        window.addMenus();
        window.addComponents();
        window.setFrameFeatures();
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    // Pass the contructors to super class (JFrame)
    public PlayerFormV7(String title) {
        super(title);
    }

    public PlayerFormV7() {
        super();
    }

    // Components
    protected final String GENDER_DIALOG_TEMPLATE = "Gender is updated to %s";
    protected final String HOBBIES_DIALOG_TEMPLATE = "%s is%s one of the hobbies";
    protected final String HOBBY_SELECTED_TEXT = "";
    protected final String HOBBY_DESELECTED_TEXT = " no longer";

    protected ItemListener itemListener;

    // Object methods
    @Override
    protected void addComponents() {
        super.addComponents();

        // Initialize ItemListener object to handle events from components
        createItemListeners();

        // Add listener to button forms
        for (JRadioButton button : genderForm.getRadioButtons().values()) {
            button.addItemListener(itemListener);
        }
        for (JCheckBox checkbox : hobbiesForm.getCheckBoxes().values()) {
            checkbox.addItemListener(itemListener);
        }
    }

    protected void createItemListeners() {
        // Initialize ActionListener object to handle events from components
        itemListener = (new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object src = e.getSource();
                if (src instanceof JRadioButton && e.getStateChange() == ItemEvent.SELECTED) {
                    handleGenderButton((JRadioButton) src);
                } else if (src instanceof JCheckBox) {
                    handleHobbiesCheckbox((JCheckBox) src);
                }
            }
        });
    }

    protected void handleGenderButton(JRadioButton button) {
        String gender = button.getText();
        // Display the message dialog
        showMessageDialog(String.format(GENDER_DIALOG_TEMPLATE, gender));
    }

    protected void handleHobbiesCheckbox(JCheckBox checkbox) {
        String hobbyName = checkbox.getText();
        String hobbyStatus = checkbox.isSelected() ? HOBBY_SELECTED_TEXT : HOBBY_DESELECTED_TEXT;
        // Display the message dialog
        showMessageDialog(String.format(HOBBIES_DIALOG_TEMPLATE, hobbyName, hobbyStatus));
    }
}
