package wanaprom.sudthipod.lab8;

import javax.swing.*;

/**
 * PlayerFormV5:
 * This program is extended from PlayerFormV4
 * and add menu icons and an image.
 * (Static method must not be overridden but must be redefined instead)
 * 
 * Added:
 * - Menu icons including <New>, <Open>, <Save> in <File> menu
 * - Image in <formPanel> using ReadImage class
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 29/01/2024
 */

public class PlayerFormV5 extends PlayerFormV4 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV5 window = new PlayerFormV5("Player Form V4");
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
    public PlayerFormV5(String title) {
        super(title);
    }

    public PlayerFormV5() {
        super();
    }

    // Components
    protected ImageIcon newMenuIcon = new ImageIcon(getClass().getResource("assets/New-icon.png"));
    protected ImageIcon openMenuIcon = new ImageIcon(getClass().getResource("assets/Open-icon.png"));
    protected ImageIcon saveMenuIcon = new ImageIcon(getClass().getResource("assets/Save-icon.png"));
    protected ReadImage footBallImage = new ReadImage("assets/Football.jpg");


    // Object methods
    @Override
    protected void addComponents() {
        // Inherit components
        super.addComponents();

        // Assign menu icons
        newMenuItem.setIcon(newMenuIcon);
        openMenuItem.setIcon(openMenuIcon);
        saveMenuItem.setIcon(saveMenuIcon);

        // Add custom image
        formsPanel.add(footBallImage);
    }
}
