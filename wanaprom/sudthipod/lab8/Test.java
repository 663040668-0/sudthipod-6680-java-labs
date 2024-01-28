package wanaprom.sudthipod.lab8;

import wanaprom.sudthipod.lab7.MySimpleWindow;

import javax.swing.*;
import java.awt.*;
import customUI.Form.*;

/**
 * E:
 * AWWDA
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 27/01/2024
 */
public class Test extends MySimpleWindow {
    // Main methods
    public static void createAndShowGUI() {
        Test window = new Test("Test Window");
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
    public Test(String title) {
        super(title);
    }

    public Test() {
        super();
    }

    // Components
    protected JPanel formsPanel;

    protected TextForm usernameForm;
    protected JLabel usernameLabel;
    protected JTextField usernameField;

    protected RadioForm authorityForm;
    protected String[] authorityLevels = {"Teacher", "Parent", "Student"};

    protected ComboBoxForm currentGradeForm;
    protected JComboBox<String> currentGradeComboBox;
    protected int[] grades = {4, 5, 6};

    protected ComboBoxForm favCountryForm;
    protected String[] favCountryItems = {"Thailand", "Indonesia", "Vietnam"};

    // Object methods
    @Override
    protected void addComponents() {
        super.addComponents();
        formsPanel = new JPanel();
        formsPanel.setLayout(new BoxLayout(formsPanel, BoxLayout.Y_AXIS));
        mainPanel.add(formsPanel, BorderLayout.CENTER);

        // Create form explicitly
        usernameForm = new TextForm("Username:");
        usernameLabel = usernameForm.getFormLabel();
        formsPanel.add(usernameForm);

        // Create form implicitly
        formsPanel.add(new TextForm("Display Name:"));

        // Normal use of radio buttons
        authorityForm = new RadioForm("Authority:", authorityLevels);
        authorityForm.getRadioButton(authorityLevels[2]).setSelected(true);
        formsPanel.add(authorityForm);

        // Try combobox with int[]
        currentGradeForm = new ComboBoxForm("Current Grade:", grades);
        currentGradeComboBox = currentGradeForm.getComboBox();
        currentGradeComboBox.setSelectedIndex(1);
        formsPanel.add(currentGradeForm);

        // Create form implicitly
        favCountryForm = new ComboBoxForm("Favorite Country:", favCountryItems);
        formsPanel.add(favCountryForm);
    }
}
