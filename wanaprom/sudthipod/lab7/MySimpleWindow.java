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
 * Latest Update: 23/01/2024
 */

public class MySimpleWindow extends JFrame {
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
    protected void addComponents() {
        // Create buttons
        JButton resetButton = new JButton("Reset");
        JButton submitButton = new JButton("Submit");

        // Create buttons panel
        JPanel buttonsPanel = new JPanel();

        // Add buttons
        buttonsPanel.add(resetButton);
        buttonsPanel.add(submitButton);

        // Add buttons panel
        add(buttonsPanel);

        // Note: All the components are created within this method due to this class will later be extended.
        //       Therefore, keep it as clean as possible.
    }

    protected void setFrameFeatures() {
        this.pack(); // To fit the contents
        this.setLocationRelativeTo(null); // To center the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // To exit the program when the window is closed
        this.setVisible(true); // To show the window
    }
}
