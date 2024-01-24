package wanaprom.sudthipod.lab7;

import javax.swing.*;
import java.awt.*;

/**
 * ParagraphForm:
 * This class is extended from EmptyForm
 * realign the form to vertical layout
 * and adds a text area with provided rows and columns
 * 
 * in the pattern:
 * <formName>
 * <formArea>
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 24/01/2024
 */

public class ParagraphForm extends EmptyForm {
    protected static final int DEFAULT_AREA_ROWS = 5, DEFAULT_AREA_COLUMNS = 15;

    // Constructors
    public ParagraphForm(String formName, JLabel formLabel, JScrollPane formScrollPane, JTextArea formArea, int rows, int columns) {
        // Set up the form
        super(formName, formLabel);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Change the layout to vertical
        setAlignmentX(Component.CENTER_ALIGNMENT); // Center the form to the window

        // Create the form area and scroll pane
        formArea = new JTextArea(rows, columns);
        
        formScrollPane = new JScrollPane(formArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        // Always show the vertical scroll bar but never the horizontal
        formScrollPane.setAlignmentX(Component.LEFT_ALIGNMENT); // Prevent weird label alignment

        // Add to the form panel
        add(formScrollPane);
    }

    public ParagraphForm(String formName, JLabel formLabel, JTextArea formArea, int rows, int columns) {
        this(formName, formLabel, new JScrollPane(), formArea, rows, columns);
    }

    public ParagraphForm(String formName, JLabel formLabel, int rows, int columns) {
        this(formName, formLabel, new JTextArea(), rows, columns);
    }

    public ParagraphForm(String formName, int rows, int columns) {
        this(formName, new JLabel(), rows, columns);
    }

    public ParagraphForm(String formName) {
        // Use default text area size
        this(formName, DEFAULT_AREA_ROWS, DEFAULT_AREA_COLUMNS);
    }
}
