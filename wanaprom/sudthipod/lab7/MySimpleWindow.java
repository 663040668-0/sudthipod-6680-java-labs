package wanaprom.sudthipod.lab7;

import javax.swing.*;

/**
 * MySimpleWindow:
 * This program is used to create a simple window GUI with java swing.
 * It's normally contained Reset and Submit buttons.
 * The window will show on the middle of the screen
 * and its size will fit the contents. (In this case, they're buttons)
 * The program will exit when the window is closed.
 * The class will later be extended to include more features.
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 24/01/2024
 */

public class MySimpleWindow extends JFrame {
    // Components Clarification
    protected JPanel mainPanel; // Use box layout in y-axis
    // Use mainPanel for later design

    protected JPanel buttonsPanel; // Use flow layout
    protected JButton resetButton;
    protected JButton submitButton;

    // Main methods
    public static void createAndShowGUI() {
        MySimpleWindow msw = new MySimpleWindow("My Simple Window");
        msw.addComponents();
        msw.setFrameFeatures();
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
    }

    // Pass the contructors to super class (JFrame)
    public MySimpleWindow(String title) {
        super(title);
    }

    public MySimpleWindow() {
        super();
    }

    // Object methods
    protected void addMainPanel() {
        // Create main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);
    }

    protected void addButtons() {
        // Create buttons
        resetButton = new JButton("Reset");
        submitButton = new JButton("Submit");

        // Create buttons panel
        buttonsPanel = new JPanel();

        // Add buttons to buttons panel
        buttonsPanel.add(resetButton);
        buttonsPanel.add(submitButton);

        // Add buttons panel to window
        mainPanel.add(buttonsPanel);
    }

    protected void addComponents() {
        addMainPanel();
        addButtons();
    }

    protected void setFrameFeatures() {
        this.pack(); // To fit the contents
        this.setLocationRelativeTo(null); // To center the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // To exit the program when the window is closed
        this.setVisible(true); // To show the window
    }
}
