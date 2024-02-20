package wanaprom.sudthipod.lab10;

import javax.swing.*;
import javax.swing.event.*;

/**
 * PlayerFormV9:
 * This program is extended from PlayerFormV8
 * and add changeListener to read value in JSLider component
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 19/02/2024
 */

public class PlayerFormV9 extends PlayerFormV8 implements ChangeListener {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV9 window = new PlayerFormV9("Player Form 9");
        window.addMenus();
        window.addComponents();
        window.addListeners();
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
    public PlayerFormV9(String title) {
        super(title);
    }

    public PlayerFormV9() {
        super();
    }

    // Components
    protected final String EXPERIENCE_DIALOG_TEMPLATE = "Year of experience in this sport is ";

    // Object methods
    @Override
    protected void addListeners() {
        super.addListeners();

        // Add ListSelectionListener to the JSlider (Experience Year form)
        experienceYearForm.getSlider().addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // There's only a JSlider component in the program, so checking component could be unnecessary
        handleExperienceSlider();
    }

    protected void handleExperienceSlider() {
        // Check if the value stopped increasing
        if (!experienceYearForm.getSlider().getValueIsAdjusting()) {
            int experienceYears = experienceYearForm.getSlider().getValue();
            // Display the message dialog
            showMessageDialog(EXPERIENCE_DIALOG_TEMPLATE + experienceYears);
        }
    }
}
