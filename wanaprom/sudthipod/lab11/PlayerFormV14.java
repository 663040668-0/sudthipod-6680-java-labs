package wanaprom.sudthipod.lab11;

import java.io.*;

import javax.swing.*;
import java.util.Arrays;

/**
 * PlayerFormV14:
 * This program is extended from PlayerFormV13.
 * Can write and read .obj file which is the data in serializable implemented class <Player>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 01/03/2024
 */

public class PlayerFormV14 extends PlayerFormV13 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV14 window = new PlayerFormV14("Player Form V14");
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
    public PlayerFormV14(String title) {
        super(title);
    }

    public PlayerFormV14() {
        super();
    }
    
    // Components
    protected JMenu fillMenu;
    protected ButtonGroup fillButtonGroup;
    protected JRadioButton fillYesButton, fillNoButton;

    // Create a new writer and reader object everytime writing and reading files instead of initial declaration

    // Object methods
    @Override
    protected void addMenus() {
        super.addMenus();

        // Add fill menu
        fillMenu = new JMenu("Fill");
        fillYesButton = new JRadioButton("Yes");
        fillNoButton = new JRadioButton("No");
        fillButtonGroup = new ButtonGroup();
        fillButtonGroup.add(fillYesButton);
        fillButtonGroup.add(fillNoButton);
        fillNoButton.setSelected(true); // Set default to 'No'
        fillMenu.add(fillYesButton);
        fillMenu.add(fillNoButton);
        menuBar.add(fillMenu);
    }

    @Override
    protected void handleOpenFile() {
        File selectedFile = fileOpener.getSelectedFile();
        System.out.println("OPEN");

        // Check if the file is really existed
        if (!selectedFile.exists()) {
            showErrorDialog("\'" + selectedFile.getAbsolutePath() + "\' isn't existed");
            return;
        }

        // Read the file and show on MessageDialog (if possible)
        if (fillNoButton.isSelected()) {
            // Work the same as PlayerFormV13
            super.handleOpenFile();
        } else if (fillYesButton.isSelected()) {
            // Reading file with data from serializable implemented class (if found)
            try (ObjectInputStream inputFile = new ObjectInputStream(new FileInputStream(selectedFile.getAbsolutePath()))) {
                final Player player = (Player) inputFile.readObject(); // Read and cast the object to Player class
                showMessageDialog("Opening file " + selectedFile.getAbsolutePath());
                removeListeners(); // Prevent message dialogs to show up
                fillPlayerInfo(player); // Display player info into components
                addListeners(); // Enable message dialogs back
            } catch (IOException | ClassNotFoundException e) {
                showErrorDialog(e.getMessage());
            }
        }
    }

    protected void fillPlayerInfo(Player player) {
        nameField.setText(player.getName());
        nameField.setEnabled(true);
        
        nationalityField.setText(player.getNationality());
        nationalityField.setEnabled(true);

        birthDateField.setText(player.getBirthDate());
        birthDateField.setEnabled(true);

        if (player.getGender().equals("Male")) {
            maleButton.setSelected(true);
        } else if (player.getGender().equals("Female")) {
            femaleButton.setSelected(true);
        }

        playerTypeComboBox.setSelectedItem(player.getPlayerType());
        for (String hobby : hobbies) {
            if (player.getHobbies().contains(hobby)) {
                hobbiesForm.getCheckBox(hobby).setSelected(true);
            } else {
                hobbiesForm.getCheckBox(hobby).setSelected(false);
            }
        }

        sportForm.getList().clearSelection(); // Clear selection first
        int[] selectedIndices = new int[0];
        for (String sport : sportForm.getListItems()) {
            if (player.getSports().contains(sport)) {
                selectedIndices = Arrays.copyOf(selectedIndices, selectedIndices.length + 1);
                selectedIndices[selectedIndices.length - 1] = Arrays.binarySearch(sportForm.getListItems(), sport);
            }
        }
        sportForm.getList().setSelectedIndices(selectedIndices);

        experienceYearForm.getSlider().setValue(player.getExpYear());
    }

    protected void removeListeners() {
        // Use to temporary remove the listener to prevent message dialogs on file opening
        newMenuItem.removeActionListener(this);
        openMenuItem.removeActionListener(this);
        saveMenuItem.removeActionListener(this);
        exitMenuItem.removeActionListener(this);
        redMenuItem.removeActionListener(this);
        greenMenuItem.removeActionListener(this);
        blueMenuItem.removeActionListener(this);
        customColorMenuItem.removeActionListener(this);
        size16MenuItem.removeActionListener(this);
        size20MenuItem.removeActionListener(this);
        size24MenuItem.removeActionListener(this);

        nameField.removeActionListener(this);
        nationalityField.removeActionListener(this);
        birthDateField.removeActionListener(this);
        maleButton.removeItemListener(this);
        femaleButton.removeItemListener(this);
        for (JCheckBox hobby : hobbiesForm.getCheckBoxes().values()) {
            hobby.removeItemListener(this);
        }
        sportForm.getList().removeListSelectionListener(this);
        experienceYearForm.getSlider().removeChangeListener(this);
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

        if (fillNoButton.isSelected()) {
            // Work the same as PlayerFormV13
            super.handleSaveFile();
        } else if (fillYesButton.isSelected()) {
            // Writing to file with serializable implemented class
            try (final ObjectOutputStream outputFile = new ObjectOutputStream(new FileOutputStream(selectedFile.getAbsolutePath()))) {
                // Create a Player class object
                Player player = new Player();
                getPlayerInfoText(); // Set the data from components to the variables
                player.setName(name);
                player.setNationality(nationality);
                player.setBirthDate(birthDate);
                player.setGender(gender);
                player.setPlayerType(playerType);
                player.setHobbies(hobbiesList);
                player.setSports(selectedSport);
                player.setExpYear(experienceYearForm.getSlider().getValue()); // Never implemented getting value from JSlider
                // Write data in to the file
                outputFile.writeObject(player); // Write to ObjectOutputStream
                outputFile.flush(); // Write to file
                showMessageDialog("Saving in file " + selectedFile.getAbsolutePath());
            } catch (IOException e) {
                showErrorDialog(e.getMessage());
            }
        }
    }

    @Override
    protected void handleResetButton() {
        // Prevent message dialogs to show up
        removeListeners();
        super.handleResetButton();
        addListeners();
    }
}
