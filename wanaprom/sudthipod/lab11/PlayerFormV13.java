package wanaprom.sudthipod.lab11;

import java.io.*;
import java.util.stream.Collectors;

import javax.swing.*;

/**
 * PlayerFormV13:
 * This program is extended from PlayerFormV12.
 * Detect whenever the user press enter in JTextField with empty text then disable next component
 * after the dialog is shown, focus the JTextField for user to input
 * Date Of Birth field is also need to be validated in format <dd-mm-yyyy>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 19/02/2024
 */

public class PlayerFormV13 extends PlayerFormV12 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV13 window = new PlayerFormV13("Player Form 12");
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
    public PlayerFormV13(String title) {
        super(title);
    }

    public PlayerFormV13() {
        super();
    }
    
    // Components
    protected BufferedReader fileReader;
    protected PrintWriter fileWriter;

    // Object methods
    @Override
    protected void addComponents() {
        super.addComponents();

        // Change open and save file location
        fileOpener.setCurrentDirectory(new File(".\\wanaprom\\sudthipod\\lab11"));
        fileSaver.setCurrentDirectory(new File(".\\wanaprom\\sudthipod\\lab11"));
    }

    @Override
    protected void handleOpenFile() {
        File selectedFile = fileOpener.getSelectedFile();

        // Check if the file is really existed
        if (!selectedFile.exists()) {
            showErrorDialog("\'" + selectedFile.getAbsolutePath() + "\' isn't existed");
            return;
        }

        // Read the file and show on MessageDialog (if possible)
        try {
            fileReader = new BufferedReader(new FileReader(selectedFile));
            String textData = fileReader.lines().collect(Collectors.joining(" ")); // Collect each line together with joining method

            // Display status
            JOptionPane.showMessageDialog(this, "Opening file \'" + selectedFile.getAbsolutePath() + "\'");

            // Display the data
            JOptionPane.showMessageDialog(this, "Data read from file: " + selectedFile.getAbsolutePath() + " is\n" + textData);

            // NOTE: Using JOptionPane directly to display dialog in desired order
        } catch (Exception e) {
            showErrorDialog(e.getMessage());
        }
    }

    @Override
    protected void handleSaveFile() {
        File selectedFile = fileSaver.getSelectedFile();
        
        // Check if the file is already existed
        if (selectedFile.exists()) {
            boolean overwrite = showOverwriteDialog(selectedFile.getAbsolutePath());
            if (!overwrite) {
                return; // Exit if user cancels
            }
        }

        try (PrintWriter fileWriter = new PrintWriter(selectedFile.getAbsolutePath())) { // Will be closed automatically after done writing
            fileWriter.println(getPlayerInfoText());

            // Display status
            showMessageDialog("Saving in file \'" + selectedFile.getAbsolutePath()  + "\'");
        } catch (Exception e) {
            showErrorDialog(e.getMessage());
        }
    }
}
