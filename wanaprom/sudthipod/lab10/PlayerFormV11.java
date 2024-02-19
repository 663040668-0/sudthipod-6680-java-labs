package wanaprom.sudthipod.lab10;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

/**
 * PlayerFormV11:
 * This program is extended from PlayerFormV10.
 * Add new menu item 'Custom' to 'Color' menu (using JColorChooser to change text color)
 * and override handleFileMenuItem method to perform open and save files functions.
 * also overrid handleColorMenuItem method to perform custom color chooser.
 * Every menu item in 'File' menu has a mnemonic and accelerator key
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 19/02/2024
 */

public class PlayerFormV11 extends PlayerFormV10 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV11 window = new PlayerFormV11("Player Form 11");
        window.addMenus();
        window.addComponents();
        window.addListeners();
        window.enableKeyboard();
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
    public PlayerFormV11(String title) {
        super(title);
    }

    public PlayerFormV11() {
        super();
    }

    // Components
    protected JMenuItem customColorMenuItem;
    protected final String TEXT_COLOR_CHOOSER_TITLE = "Choose Text Color";

    protected JFileChooser fileOpener, fileSaver;

    // Object methods
    @Override
    protected void addMenus() {
        super.addMenus();

        // Add 'Custom' menu item
        customColorMenuItem = new JMenuItem("Custom");
        colorSubMenu.add(customColorMenuItem);
    }

    protected void enableKeyboard() {
        // Set mnemonic keys
        fileMenu.setMnemonic(KeyEvent.VK_F);
        newMenuItem.setMnemonic(KeyEvent.VK_N);
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        saveMenuItem.setMnemonic(KeyEvent.VK_S);
        exitMenuItem.setMnemonic(KeyEvent.VK_X);

        // Set accelerator keys
        newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
    }

    @Override
    protected void addComponents() {
        super.addComponents();

        // Initialize fileChooser
        fileOpener = new JFileChooser();
        fileSaver = new JFileChooser();

        // Initial directory is lab10
        fileOpener.setCurrentDirectory(new File(".\\wanaprom\\sudthipod\\lab10"));
        fileSaver.setCurrentDirectory(new File(".\\wanaprom\\sudthipod\\lab10"));
    } 

    @Override
    protected void addListeners() {
        super.addListeners();

        customColorMenuItem.addActionListener(this);
    }

    @Override
    protected void handleMenuItem(JMenuItem menuItem) {
        super.handleMenuItem(menuItem);
        if (menuItem == customColorMenuItem) {
            handleCustomColorMenuItem();
        }
    }

    @Override
    protected void handleFileMenuItem(JMenuItem menuItem) {
        if (menuItem == openMenuItem) {
            // Display fileOpener and open a file
            int result = fileOpener.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileOpener.getSelectedFile();

                // Check if the file is really existed
                if (!selectedFile.exists()) {
                    showErrorDialog("\'" + selectedFile.getAbsolutePath() + "\' isn't existed");
                    return;
                }

                // Open the file
                showMessageDialog("Opening file \'" + selectedFile.getAbsolutePath() + "\'");
            }
        } else if (menuItem == saveMenuItem) {
            // Display fileSaver and Sav a file
            int result = fileSaver.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileSaver.getSelectedFile();
                // Check if the file is already existed
                if (selectedFile.exists()) {
                    boolean overwrite = showOverwriteDialog(selectedFile.getAbsolutePath());
                    if (!overwrite) {
                        return; // Exit if user cancels
                    }
                }

                // Save the file
                showMessageDialog("Saving in file \'" + selectedFile.getAbsolutePath()  + "\'");
            }
        } else {
            // Currently unimplemented
            showMessageDialog(FILE_MENU_ITEM_DIALOG_TEMPLATE + menuItem.getText());
        }
    }

    protected void handleCustomColorMenuItem() {
        // Show color chooser dialog
        Color selectedColor = JColorChooser.showDialog(this, TEXT_COLOR_CHOOSER_TITLE, nameField.getForeground());

        // Change color of each JTextField
        nameField.setForeground(selectedColor);
        nationalityField.setForeground(selectedColor);
        birthDateField.setForeground(selectedColor);
    }

    // To display error dialog
    protected void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, "Error: " + message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // To ask if overwriting a file
    protected boolean showOverwriteDialog(String fileName) {
        int result = JOptionPane.showConfirmDialog(this, "\'" + fileName + "\' is already existed. Proceed to overwrite?", "File is already existed", JOptionPane.YES_NO_CANCEL_OPTION);
        return (result == JOptionPane.YES_OPTION);
    }
}
