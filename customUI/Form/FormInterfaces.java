package customUI.Form;

import javax.swing.*;
import java.util.Map;

/**
 * customUI.FormInterfaces:
 * Use to implement common methods for forms in customUI.Form
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 28/01/2024
 */

interface HasLabel {
    static final String DEFAULT_LABEL_TEXT = "Unknown Form:";

    JLabel getLabel(String labelText);

    JLabel getLabel();
}

interface HasTextField {
    static final int DEFAULT_TEXT_FIELD_COLUMNS = 10;

    JTextField getTextField(int columns);

    JTextField getTextField();
}

interface HasTextArea {
    static final int DEFAULT_TEXT_AREA_ROWS = 10;

    static final int DEFAULT_TEXT_AREA_COLUMNS = 30;

    JTextArea getTextArea(int rows, int columns);

    JTextArea getTextArea();
}

interface HasScrollPane {
    JScrollPane getScrollPane();
}

interface HasRadioButton {
    static final String DEFAULT_RADIO_NAME = "...";

    JPanel getRadioButtonsPanel();

    ButtonGroup getButtonGroup();

    JRadioButton getRadioButton(String radioName); // Add and get button

    JRadioButton getRadioButton(); // Add and get button with default name

    String getRadioButtonName(JRadioButton radioButton); // Add and get button

    Map<String, JRadioButton> getRadioButtons();

    void setRadioButtonName(String newRadioName, String oldRadioName);

    void setRadioButtonName(String newRadioName, JRadioButton radioButton);

    void setMultipleSelectionsEnabled(boolean isMultipleSelections);

    boolean isMultipleSelectionsEnabled();
}

interface HasCheckBox {
    static final String DEFAULT_CHECKBOX_NAME = "...";

    JPanel getCheckBoxesPanel();

    ButtonGroup getButtonGroup();

    JCheckBox  getCheckBox(String checkBoxName); // Add and get button

    JCheckBox  getCheckBox(); // Add and get button with default name

    String getCheckBoxName(JCheckBox checkBox); // Add and get button

    Map<String, JCheckBox> getCheckBoxes();

    void setCheckBoxName(String newCheckBoxName, String oldCheckBoxName);

    void setCheckBoxName(String newCheckBoxName, JCheckBox checkBox);

    void setMultipleSelectionsEnabled(boolean isMultipleSelections);

    boolean isMultipleSelectionsEnabled();
}

interface HasComboBox {
    JComboBox<String> getComboBox();

    String[] getComboBoxItems();

    int[] getComboBoxItemsAsIntegers();

    void replaceComboBoxItem(String newItem, String oldItem);

    void replaceComboBoxItemAt(String newItem, int index);

    void setComboBoxItems(String[] comboBoxItems);

    void setComboBoxItems(int[] comboBoxItems);
}

interface HasList {
    static final int DEFAULT_MAXIMUM_VISIBLE_ROWS = 5;

    JList<String> getList();

    String[] getListItems();

    int[] getListItemsAsIntegers();

    void replaceListItem(String newItem, String oldItem);

    void replaceListItemAt(String newItem, int index);

    void setListItems(String[] listItems);

    void setListItems(int[] listItems);
}

interface HasSlider {
    static final boolean DEFAULT_SLIDER_SHOW_TICK_DETAILS = true;

    static final boolean DEFAULT_SLIDER_SNAP_TO_TICKS = true;

    static final int DEFAULT_SLIDER_MIN_VALUE = 0;

    static final int DEFAULT_SLIDER_MAX_VALUE = 100;

    static final int DEFAULT_SLIDER_INIT_VALUE = 50;

    static final int DEFAULT_SLIDER_MAJOR_TICK_SPACING = 10;

    static final int DEFAULT_SLIDER_MINOR_TICK_SPACING = 1;

    JSlider getSlider();

    JSlider getSlider(int setValue);

    JSlider getSlider(int minValue, int maxValue);

    JSlider getSlider(int minValue, int maxValue, int setValue);

    JSlider getSlider(boolean showTickDetails);

    JSlider getSlider(int setValue, boolean showTickDetails);

    JSlider getSlider(int minValue, int maxValue, boolean showTickDetails);

    JSlider getSlider(int minValue, int maxValue, int setValue, boolean showTickDetails);

    void setShowTickDetails(boolean showTickDetails);
}
