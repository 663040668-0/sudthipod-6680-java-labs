package wanaprom.sudthipod.lab10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * PlayerFormV10:
 * This program is extended from PlayerFormV9
 * and add actionListeners to menu items to perform desired functions
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 19/02/2024
 */

public class PlayerFormV10 extends PlayerFormV9 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV10 window = new PlayerFormV10("Player Form 10");
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
    public PlayerFormV10(String title) {
        super(title);
    }

    public PlayerFormV10() {
        super();
    }

    // Components
    protected final String FILE_MENU_ITEM_DIALOG_TEMPLATE = "You click menu ";

    // Object methods
    @Override
    protected void addListeners() {
        super.addListeners();

        // Add actionListener to each JMenuItem
        newMenuItem.addActionListener(this);
        openMenuItem.addActionListener(this);
        saveMenuItem.addActionListener(this);
        exitMenuItem.addActionListener(this);

        redMenuItem.addActionListener(this);
        greenMenuItem.addActionListener(this);
        blueMenuItem.addActionListener(this);

        size16MenuItem.addActionListener(this);
        size20MenuItem.addActionListener(this);
        size24MenuItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);

        // Append a statement to handle JMenuItem components
        Object src = e.getSource();
        if (src instanceof JMenuItem) {
            handleMenuItem((JMenuItem)src);
        }
    }

    protected void handleMenuItem(JMenuItem menuItem) {
        if (menuItem == newMenuItem || menuItem == openMenuItem || menuItem == saveMenuItem || menuItem == exitMenuItem) {
            handleFileMenuItem(menuItem);
        } else if (menuItem == redMenuItem || menuItem == greenMenuItem || menuItem == blueMenuItem) {
            handleColorMenuItem(menuItem);
        } else if (menuItem == size16MenuItem || menuItem == size20MenuItem || menuItem == size24MenuItem) {
            handleSizeMenuItem(menuItem);
        }
            
    }

    protected void handleFileMenuItem(JMenuItem menuItem) {
        showMessageDialog(FILE_MENU_ITEM_DIALOG_TEMPLATE + menuItem.getText());
    }

    protected void handleColorMenuItem(JMenuItem menuItem) {
        // Select color to change from what item is selected
        Color newColor;
        switch (menuItem.getText().toLowerCase()) {
            case "red":
                newColor = Color.RED;
                break;

            case "green":
                newColor = Color.GREEN;
                break;

            case "blue":
                newColor = Color.BLUE;
                break;
        
            default:
                newColor = Color.BLACK;
                break;
        }

        // Set every JTextField to determined color
        nameField.setForeground(newColor);
        nationalityField.setForeground(newColor);
        birthDateField.setForeground(newColor);
    }

    protected void handleSizeMenuItem(JMenuItem menuItem) {
        // Change to 'Serif' and 'Bold' with desired size
        int newSize = Integer.parseInt(menuItem.getText());

        // Set JTextArea to determined fonts
        noteArea.setFont(new Font(Font.SERIF, Font.BOLD, newSize));
    }
}
