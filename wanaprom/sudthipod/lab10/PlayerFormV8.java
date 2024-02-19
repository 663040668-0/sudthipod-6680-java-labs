package wanaprom.sudthipod.lab10;

import javax.swing.*;
import javax.swing.event.*;
import wanaprom.sudthipod.lab9.PlayerFormV7;

/**
 * PlayerFormV8:
 * This program is extended from PlayerFormV7
 * and add listSelectionListener to read value in JList component
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 19/02/2024
 */

public class PlayerFormV8 extends PlayerFormV7 implements ListSelectionListener {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV8 window = new PlayerFormV8("Player Form V8");
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
    public PlayerFormV8(String title) {
        super(title);
    }

    public PlayerFormV8() {
        super();
    }

    // Components
    protected final String SPORTS_DIALOG_TEMPLATE = "Selected sports are %s";

    // Object methods
    @Override
    protected void addListeners() {
        super.addListeners();
        
        // Add ListSelectionListener to the JList (Sports form)
        sportForm.getList().addListSelectionListener(this);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        // There's only a JList component in the program, so checking component could be unnecessary
        handleSportsList();
    }

    protected void handleSportsList() {
        String selectedSports = String.join(" ", sportForm.getList().getSelectedValuesList());
        // Display the message dialog
        showMessageDialog(String.format(SPORTS_DIALOG_TEMPLATE, selectedSports));
    }
}
