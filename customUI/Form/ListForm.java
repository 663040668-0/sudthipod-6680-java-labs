package customUI.Form;

import javax.swing.*;

/**
 * ListForm.java:
 * Extend Form class and implement HasList and HasScrollPane.
 * simply a form with list that can be scrolled if it exceeds the maximum items.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 28/01/2024
 */

public class ListForm extends Form implements HasList, HasScrollPane {
    protected JScrollPane formScrollPane;
    protected JList<String> list;

    public ListForm(String labelText, String[] listItems) {
        // Create form
        super(labelText);

        // Create list
        list = new JList<String>(listItems);
        // Set maximum visible row count to the biggest possible
        list.setVisibleRowCount(listItems.length < DEFAULT_MAXIMUM_VISIBLE_ROWS ? listItems.length : DEFAULT_MAXIMUM_VISIBLE_ROWS);

        // Create scroll pane
        formScrollPane = new JScrollPane(list, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        add(formScrollPane);

        // Set default style
        setStyle(0);
    }

    public ListForm(String[] listItems) {
        // Create form
        this(DEFAULT_LABEL_TEXT, listItems);
    }

    public ListForm(String labelText) {
        // Create form
        this(labelText, new String[0]); // Use String array as default
    }

    public ListForm() {
        // Create form
        this(DEFAULT_LABEL_TEXT);
    }

    public ListForm(String labelText, int[] listItems) {
        // Create form
        this(labelText, getConvertedListItems(listItems));
    }

    public ListForm(int[] listItems) {
        // Create form
        this(getConvertedListItems(listItems));
    }

    // Utility methods
    protected static String[] getConvertedListItems(int[] listItems) {
        String[] listStringItems = new String[listItems.length];
        for (int i = 0; i < listItems.length; i++) {
            listStringItems[i] = String.valueOf(listItems[i]);
        }
        return listStringItems;
    }

    // Implement methods
    @Override
    public JScrollPane getScrollPane() {
        return formScrollPane;
    }
    @Override
    public String[] getListItems() {
        String[] listItems = new String[list.getModel().getSize()];
        for (int i = 0; i < listItems.length; i++) {
            listItems[i] = list.getModel().getElementAt(i);
        }
        return listItems;
    }

    @Override
    public int[] getListItemsAsIntegers() {
        // Convert String to int
        int[] listItems = new int[list.getModel().getSize()];
        for (int i = 0; i < listItems.length; i++) {
            // Catch conversion error
            try {
                listItems[i] = Integer.parseInt(list.getModel().getElementAt(i));
            } catch (Exception e) {
                e.printStackTrace();
                // Return empty array to avoid crash
                return new int[0];
            }
        }
        return listItems;
    }

    @Override
    public JList<String> getList() {
        return list;
    }

    @Override
    public void replaceListItem(String newItem, String oldItem) {
        String[] listItems = getListItems();
        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i].equals(oldItem)) {
                listItems[i] = newItem;
            }
        }
        setListItems(listItems);
    }

    @Override
    public void replaceListItemAt(String newItem, int index) {
        String[] listItems = getListItems();
        listItems[index] = newItem;
        setListItems(listItems);
    }

    @Override
    public void setListItems(String[] listItems) {
        setListItems(listItems);
    }

    @Override
    public void setListItems(int[] listItems) {
        setListItems(getConvertedListItems(listItems));
    }
}