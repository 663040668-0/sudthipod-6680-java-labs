package wanaprom.sudthipod.lab8;

import java.util.Arrays;
import javax.swing.*;
import customUI.Form.*;

/**
 * PlayerFormV4:
 * This program is extended from PlayerFormV3
 * and add new components
 * (Static method must not be overridden but must be redefined instead)
 * 
 * Added:
 * - Hobbies: using <CheckBox>
 * - Sports: using <List>
 * - Experience Year: using <Slider>
 * 
 * Overdelivered:
 * - actionListener for <resetButton> and <submitButton>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 12/02/2024
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
    protected CheckBoxForm hobbiesForm;
    protected String[] hobbies = {"Reading", "Browsing", "Sleeping", "Traveling"};

    protected ListForm sportForm;
    protected String[] sports = {"Badminton", "Boxing", "Football", "Running"};

    protected SliderForm experienceYearForm;
    protected int minExperienceYear = 0;
    protected int maxExperienceYear = 20;
    protected int initExperienceYear = 0;
    protected int majorStepExperienceYear = 5;
    protected int minorStepExperienceYear = 1;
    protected boolean showTickExperienceYear = true;

    // Object methods
    @Override
    protected void addComponents() {
        // Inherit components
        super.addComponents();

        formsPanel.remove(noteForm); // Realign the note form to the bottom

        // Using "MY" custom form
        hobbiesForm = new CheckBoxForm("Hobbies:", hobbies);
        hobbiesForm.getCheckBox("Sleeping").setSelected(true); // Select "Sleeping" by default
        formsPanel.add(hobbiesForm);

        Arrays.sort(sports); // Sort the sports before adding
        sportForm = new ListForm("Sports:", sports);
        sportForm.getList().setSelectedIndex(2); // Select "Football" by default
        formsPanel.add(sportForm);

        experienceYearForm = new SliderForm("Experience Year:", minExperienceYear, maxExperienceYear, initExperienceYear, majorStepExperienceYear, minorStepExperienceYear, showTickExperienceYear);
        formsPanel.add(experienceYearForm);

        formsPanel.add(noteForm); // Add the note form to the bottom

        // Just try event listener
        /*
        resetButton.addActionListener(event -> {
            nameField.setText("");
            nationalityField.setText("");
            birthDateField.setText("");
            genderButtonGroup.setSelected(maleButton.getModel(), false);
            genderButtonGroup.setSelected(femaleButton.getModel(), true);
            playerTypeComboBox.setSelectedIndex(Arrays.binarySearch(playerTypeItems, "Amateur"));
            for (String hobby : hobbies) {
                hobbiesForm.getCheckBoxes().get(hobby).setSelected(false);
            }
            hobbiesForm.getCheckBoxes().get("Sleeping").setSelected(true);
            sportForm.getList().setSelectedIndex(Arrays.binarySearch(sports, "Football"));
            experienceYearForm.getSlider().setValue(initExperienceYear);
            noteArea.setText("Thailand will face Oman at the Abdullah bin Khalifa Stadium in Doha, Qatar, on Sunday in their second match of the 2023 AFC Asian Cup, Group F.");
        });

        submitButton.addActionListener(event -> {
            int value = experienceYearForm.getSlider().getValue();
            char[] vowels = {'a', 'e', 'i', 'o', 'u'};
            String playerPronoun = maleButton.isSelected() ? "Mr." : "Ms.";
            String playerNoun = maleButton.isSelected() ? "He" : "She";
            String playerName = nameField.getText();
            String playerSport = sportForm.getList().getSelectedValue();
            String playerType = playerTypeComboBox.getSelectedItem().toString();
            String playerNationality = nationalityField.getText();
            String playerAge = "";
            if (birthDateField.getText().split("-").length == 3) {
                // Assume it's 2024 now
                final int CURRENT_YEAR = 2024;
                int birthYear = Integer.parseInt(birthDateField.getText().split("-")[2]);
                playerAge = String.valueOf(CURRENT_YEAR - birthYear);
            } else {
                playerAge = "NaN";
                System.err.println("Warning: Invalid date format. Please use DD-MM-YYYY format");
            }
            String[] playerHobbies = {};
            for (String hobby : hobbies) {
                if (hobbiesForm.getCheckBoxes().get(hobby).isSelected()) {
                    playerHobbies = Arrays.copyOf(playerHobbies, playerHobbies.length + 1);
                    playerHobbies[playerHobbies.length - 1] = hobby;
                }
            }
            System.out.println(playerPronoun + playerName + " has been playing '" + playerSport + "' for " + value + " year" + (value > 1 ? "s" : ""));
            System.out.println("and is now a" + (Arrays.binarySearch(vowels, playerType.toLowerCase().charAt(0)) >= 0 ? "n " : " ") + playerType + " player.");
            System.out.println("\t" + playerNoun + " is a " + playerAge + " years old " + playerNationality + ".");
            System.out.println("\t" + playerNoun + " loves to " + String.join(", ", playerHobbies) + ".");
        });
        */
    }
}
