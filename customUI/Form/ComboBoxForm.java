package customUI.Form;

import javax.swing.*;

/**
 * ComboBoxForm.java:
 * Extend Form class and implement HasComboBox.
 * simply a form with comboBoxes.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 28/01/2024
 */

public class ComboBoxForm extends Form implements HasComboBox {
    protected JComboBox<String> comboBox;

    public ComboBoxForm(String labelText, String[] comboBoxItems) {
        // Create form
        super(labelText);

        // Create comboBox
        comboBox = new JComboBox<String>(comboBoxItems);
        add(comboBox);

        // Set default style
        setStyle(0);
    }

    public ComboBoxForm(String[] comboBoxItems) {
        // Create form
        this(DEFAULT_LABEL_TEXT, comboBoxItems);
    }

    public ComboBoxForm(String labelText) {
        // Create form
        this(labelText, new String[0]); // Use String array as default
    }

    public ComboBoxForm() {
        // Create form
        this(DEFAULT_LABEL_TEXT);
    }

    public ComboBoxForm(String labelText, int[] comboBoxItems) {
        // Create form
        this(labelText, getConvertedComboBoxItems(comboBoxItems));
    }

    public ComboBoxForm(int[] comboBoxItems) {
        // Create form
        this(getConvertedComboBoxItems(comboBoxItems));
    }

    // Utility methods
    protected static String[] getConvertedComboBoxItems(int[] comboBoxItems) {
        String[] comboBoxStringItems = new String[comboBoxItems.length];
        for (int i = 0; i < comboBoxItems.length; i++) {
            comboBoxStringItems[i] = String.valueOf(comboBoxItems[i]);
        }
        return comboBoxStringItems;
    }

    // Implement methods
    @Override
    public String[] getComboBoxItems() {
        String[] comboBoxItems = new String[comboBox.getItemCount()];
        for (int i = 0; i < comboBoxItems.length; i++) {
            comboBoxItems[i] = comboBox.getItemAt(i);
        }
        return comboBoxItems;
    }

    @Override
    public int[] getComboBoxItemsAsIntegers() {
        // Convert String to int
        int[] comboBoxItems = new int[comboBox.getItemCount()];
        for (int i = 0; i < comboBoxItems.length; i++) {
            // Catch conversion error
            try {
                comboBoxItems[i] = Integer.parseInt(comboBox.getItemAt(i));
            } catch (Exception e) {
                e.printStackTrace();
                // Return empty array to avoid crash
                return new int[0];
            }
        }
        return comboBoxItems;
    }

    @Override
    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    @Override
    public void replaceComboBoxItem(String newItem, String oldItem) {
        String[] comboBoxItems = getComboBoxItems();
        for (int i = 0; i < comboBoxItems.length; i++) {
            if (comboBoxItems[i].equals(oldItem)) {
                comboBox.removeItemAt(i);
                comboBox.insertItemAt(newItem, i);
            }
        }
    }

    @Override
    public void replaceComboBoxItemAt(String newItem, int index) {
        comboBox.removeItemAt(index);
        comboBox.insertItemAt(newItem, index);
    }

    @Override
    public void setComboBoxItems(String[] comboBoxItems) {
        comboBox.setModel(new DefaultComboBoxModel<String>(comboBoxItems));
    }

    @Override
    public void setComboBoxItems(int[] comboBoxItems) {
        comboBox.setModel(new DefaultComboBoxModel<String>(getConvertedComboBoxItems(comboBoxItems)));
    }
}