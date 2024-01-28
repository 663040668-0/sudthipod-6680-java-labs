package wanaprom.sudthipod.lab8;

import wanaprom.sudthipod.lab7.PlayerFormV2;

import javax.swing.*;

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

public class PlayerFormV3 extends PlayerFormV2 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV3 window = new PlayerFormV3("Player Form V3");
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
    public PlayerFormV3(String title) {
        super(title);
    }

    public PlayerFormV3() {
        super();
    }

    // Components
    JMenuBar menuBar;

    JMenu fileMenu;
    JMenuItem newMenuItem, openMenuItem, saveMenuItem, exitMenuItem;

    JMenu configMenu;
    JMenu colorSubMenu;
    JMenuItem redMenuItem, greenMenuItem, blueMenuItem;
    JMenu sizeSubMenu;
    JMenuItem size16MenuItem, size20MenuItem, size24MenuItem;

    // Object methods
    protected void addMenus() {
        // Create menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // Create file menu in menu bar
        fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New");
        openMenuItem = new JMenuItem("Open");
        saveMenuItem = new JMenuItem("Save");
        exitMenuItem = new JMenuItem("Exit");

        menuBar.add(fileMenu);

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Create config menu in menu bar
        configMenu = new JMenu("Config");
        
        colorSubMenu = new JMenu("Color");
        redMenuItem = new JMenuItem("Red");
        greenMenuItem = new JMenuItem("Green");
        blueMenuItem = new JMenuItem("Blue");

        sizeSubMenu = new JMenu("Size");
        size16MenuItem = new JMenuItem("16");
        size20MenuItem = new JMenuItem("20");
        size24MenuItem = new JMenuItem("24");

        menuBar.add(configMenu);

        configMenu.add(colorSubMenu);
        colorSubMenu.add(redMenuItem);
        colorSubMenu.add(greenMenuItem);
        colorSubMenu.add(blueMenuItem);
        
        configMenu.add(sizeSubMenu);
        sizeSubMenu.add(size16MenuItem);
        sizeSubMenu.add(size20MenuItem);
        sizeSubMenu.add(size24MenuItem);
    }
}
