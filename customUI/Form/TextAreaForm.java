package customUI.Form;

import javax.swing.*;
import java.awt.*;

/**
 * TextForm.java:
 * Extend Form class and implement HasTextArea and HasScrollPane.
 * simply a form with scrollable text area.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 28/01/2024
 */

public class TextAreaForm extends Form implements HasTextArea, HasScrollPane {
    protected JScrollPane formScrollPane;
    protected JTextArea formTextArea;


    public TextAreaForm(String labelText, int rows, int columns) {
        // Create form
        super(labelText);
        setLayout(new BorderLayout());
        remove(formLabel);
        add(formLabel, BorderLayout.NORTH);

        // Create text area
        formTextArea = new JTextArea(rows, columns);
        formTextArea.setLineWrap(true);
        formTextArea.setWrapStyleWord(true);

        // Create scroll pane
        formScrollPane = new JScrollPane(formTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(formScrollPane, BorderLayout.CENTER);

        // Set default style
        setStyle(0);
    }

    public TextAreaForm(String labelText) {
        // Create form
        this(labelText, DEFAULT_TEXT_AREA_ROWS, DEFAULT_TEXT_AREA_COLUMNS);
    }

    public TextAreaForm(int rows, int columns) {
        // Create form
        this(DEFAULT_LABEL_TEXT, rows, columns);
    }

    public TextAreaForm() {
        // Create form
        this(DEFAULT_LABEL_TEXT, DEFAULT_TEXT_AREA_ROWS, DEFAULT_TEXT_AREA_COLUMNS);
    }

    // Implement methods
    @Override
    public JTextArea getTextArea(int rows, int columns) {
        // Both setter and getter
        formTextArea.setRows(rows);
        formTextArea.setColumns(columns);
        return formTextArea;
    }

    @Override
    public JTextArea getTextArea() {
        return formTextArea;
    }

    @Override
    public JScrollPane getScrollPane() {
        return formScrollPane;
    }

    // Extend methods
    @Override
    public void setStyle(int styleNumber) {
        super.setStyle(styleNumber);
        switch (styleNumber) {
            case 0:
                // Reset style
                formTextArea.setFont(UIManager.getDefaults().getFont("TextArea.font"));
                formTextArea.setBackground(Color.WHITE);
                formTextArea.setForeground(null);
                formTextArea.setBorder(UIManager.getDefaults().getBorder("TextArea.border"));
                break;

            case 1:
                // Future Blue
                formTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
                formTextArea.setBackground(Color.decode("#00003d"));
                formTextArea.setBorder(BorderFactory.createLineBorder(Color.decode("#0062ff"), 1));
                formTextArea.setForeground(Color.WHITE);
                break;

            default:
                // Do nothing
                System.err.println("Unknown style number: " + styleNumber + " for TextAreaForm.");
                break;
        }
    }
}