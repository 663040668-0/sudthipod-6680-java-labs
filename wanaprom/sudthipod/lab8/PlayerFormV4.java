package wanaprom.sudthipod.lab8;

import java.awt.GridLayout;

import javax.swing.*;
import customUI.Form.*;

/**
 * PlayerFormV3:
 * This program is extended from PlayerFormV2
 * and implements the addMenus method
 * (Static method must not be overridden but must be redefined instead)
 * 
 * Added:
 * - Menus including <File> and <Config>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 28/01/2024
 */

public class PlayerFormV4 extends PlayerFormV3 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV4 window = new PlayerFormV4("Player Form V4");
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
    public PlayerFormV4(String title) {
        super(title);
    }

    public PlayerFormV4() {
        super();
    }

    // Components
    CheckBoxForm hobbiesForm;
    String[] hobbies = {"Reading", "Browsing", "Sleeping", "Traveling"};

    // Object methods
    @Override
    protected void addComponents() {
        // Inherit components
        super.addComponents();

        formsPanel.remove(notePanel); // Realign the note panel to the bottom

        // Using "MY" custom form
        hobbiesForm = new CheckBoxForm("Hobbies:", hobbies);
        hobbiesForm.getCheckBox("Sleeping").setSelected(true); // Select "Sleeping" by default

        // Adjust form layout
        hobbiesForm.setLayout(new GridLayout(2, 1));

        formsPanel.add(hobbiesForm);


        formsPanel.add(notePanel); // Add the note panel to the bottom
    }
}
