package wanaprom.sudthipod.lab9;

import wanaprom.sudthipod.lab8.PlayerFormV5;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * PlayerFormV6:
 * This program is extended from PlayerFormV5
 * and add actionEventListeners to read text in components
 * and detect changes in TextFields
 * also set the name to each TextField to use in actionEventListener
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 12/02/2024
 */

public class PlayerFormV6 extends PlayerFormV5 {
    // Main methods
    public static void createAndShowGUI() {
        PlayerFormV6 window = new PlayerFormV6("Player Form V6");
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
    public PlayerFormV6(String title) {
        super(title);
    }

    public PlayerFormV6() {
        super();
    }

    // Components
    protected final String SUBMIT_DIALOG_TEMPLATE = "%s has nationality as %s and was born on %s, has gender as %s, is a %s player, has hobbies as %s and plays %s";
    protected final String TEXFIELD_DIALOG_TEMPLATE = "%s is changed to %s";

    // Object methods
    @Override
    public void addComponents() {
        super.addComponents();

        // Set name of each TextField
        nameField.setName("Name");
        nationalityField.setName("Nationality");
        birthDateField.setName("Date of Birth");
    }

    protected void addListeners() {
        // Initialize ActionListener object to handle events from components
        ActionListener listener = (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object src = e.getSource();
                if (src == resetButton) {
                    // Reset every form component
                    nameField.setText("");
                    nationalityField.setText("");
                    birthDateField.setText("");
                    maleButton.setSelected(false);
                    femaleButton.setSelected(true);
                    playerTypeComboBox.setSelectedIndex(1); // Amateur
                    hobbiesForm.getCheckBox("Reading").setSelected(false);
                    hobbiesForm.getCheckBox("Browsing").setSelected(false);
                    hobbiesForm.getCheckBox("Sleeping").setSelected(true);
                    hobbiesForm.getCheckBox("Traveling").setSelected(false);
                    sportForm.getList().clearSelection();
                    sportForm.getList().setSelectedIndex(2); // Football
                    experienceYearForm.getSlider().setValue(0);
                    noteArea.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");
                } else if (src == submitButton) {
                    // Get values from components
                    String name = nameField.getText();
                    String nationality = nationalityField.getText();
                    String birthDate = birthDateField.getText();
                    String gender = maleButton.isSelected() ? maleButton.getText() : femaleButton.getText();
                    String playerType = playerTypeComboBox.getSelectedItem().toString();
                    ArrayList<String> hobbiesList = new ArrayList<String>();
                    for (String hobby : hobbiesForm.getCheckBoxes().keySet()) {
                        if (hobbiesForm.getCheckBox(hobby).isSelected()) {
                            hobbiesList.add(hobby);
                        }
                    }
                    String playerHobbies = String.join(" ", hobbiesList);
                    String sport = sportForm.getList().getSelectedValuesList().toString();

                    // Display the message dialog (parented by PlayerForm window)
                    JOptionPane.showMessageDialog(PlayerFormV6.this, String.format(SUBMIT_DIALOG_TEMPLATE, name, nationality, birthDate, gender, playerType, playerHobbies, sport), "Result", JOptionPane.INFORMATION_MESSAGE);
                } else if (src instanceof JTextField) {
                    // NOTE: 'instanceof' is a 'class' checking operator
                    // Display the message dialog (parented by PlayerForm window)
                    String textFieldName = ((JTextField)src).getName();
                    String textFieldValue = ((JTextField)src).getText();
                    JOptionPane.showMessageDialog(PlayerFormV6.this, String.format(TEXFIELD_DIALOG_TEMPLATE, textFieldName, textFieldValue));
                }
            }
        });

        // Add listener to buttons and TextField forms
        resetButton.addActionListener(listener);
        submitButton.addActionListener(listener);
        nameField.addActionListener(listener);
        nationalityField.addActionListener(listener);
        birthDateField.addActionListener(listener);
    }
}
