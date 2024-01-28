package customUI.Form;

import javax.swing.*;
import java.awt.*;

/**
 * TextForm.java:
 * Extend Form class and implement HasTextField.
 * simply a form with text field.
 * 
 * Author: Fire Of Ender (Sudthipod Wanaprom)
 * Last update: 28/01/2024
 */

public class SliderForm extends Form implements HasSlider {
    protected JSlider slider;

    public SliderForm(String labelText, int minValue, int maxValue, int initValue, int majorTickSpacing, int minorTickSpacing, boolean showTickDetails) {
        // Create form
        super(labelText);
        setLayout(new BorderLayout());
        remove(formLabel);
        add(formLabel, BorderLayout.NORTH);

        // Create slider
        slider = new JSlider(minValue, maxValue, (initValue >= minValue && initValue <= maxValue) ? initValue : minValue);
        // Note: avoid setting value out of range by using ternary operator
        slider.setMajorTickSpacing(majorTickSpacing);
        slider.setMinorTickSpacing(minorTickSpacing);
        slider.setSnapToTicks(DEFAULT_SLIDER_SNAP_TO_TICKS);
        if (showTickDetails) {
            slider.setPaintTicks(true);
            slider.setPaintLabels(true);
        }
        add(slider, BorderLayout.CENTER);

        // Set default style
        setStyle(0);
    }

    public SliderForm(String labelText, int minValue, int maxValue, int initValue, boolean showTickDetails) {
        // Create form
        this(labelText, minValue, maxValue, initValue, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, showTickDetails);
    }

    public SliderForm(String labelText, int initValue, boolean showTickDetails) {
        // Create form
        this(labelText, DEFAULT_SLIDER_MIN_VALUE, DEFAULT_SLIDER_MAX_VALUE, initValue, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, showTickDetails);
    }

    public SliderForm(int minValue, int maxValue, int initValue, int majorTickSpacing, int minorTickSpacing, boolean showTickDetails) {
        // Create form
        this(DEFAULT_LABEL_TEXT, minValue, maxValue, initValue, majorTickSpacing, minorTickSpacing, showTickDetails);
    }

    public SliderForm(int minValue, int maxValue, int initValue, boolean showTickDetails) {
        // Create form
        this(DEFAULT_LABEL_TEXT, minValue, maxValue, initValue, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, showTickDetails);
    }

    public SliderForm(int initValue, boolean showTickDetails) {
        // Create form
        this(DEFAULT_LABEL_TEXT, DEFAULT_SLIDER_MIN_VALUE, DEFAULT_SLIDER_MAX_VALUE, initValue, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, showTickDetails);
    }

    public SliderForm(boolean showTickDetails) {
        // Create form
        this(DEFAULT_LABEL_TEXT, DEFAULT_SLIDER_MIN_VALUE, DEFAULT_SLIDER_MAX_VALUE, DEFAULT_SLIDER_INIT_VALUE, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, showTickDetails);
    }

    public SliderForm(int minValue, int maxValue, int initValue, int majorTickSpacing, int minorTickSpacing) {
        // Create form
        this(DEFAULT_LABEL_TEXT, minValue, maxValue, initValue, majorTickSpacing, minorTickSpacing, DEFAULT_SLIDER_SHOW_TICK_DETAILS);
    }

    public SliderForm(int minValue, int maxValue, int initValue) {
        // Create form
        this(DEFAULT_LABEL_TEXT, minValue, maxValue, initValue, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, DEFAULT_SLIDER_SHOW_TICK_DETAILS);
    }

    public SliderForm(int minValue, int maxValue) {
        // Create form
        this(DEFAULT_LABEL_TEXT, minValue, maxValue, DEFAULT_SLIDER_INIT_VALUE, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, DEFAULT_SLIDER_SHOW_TICK_DETAILS);
    }

    public SliderForm(int initValue) {
        // Create form
        this(DEFAULT_LABEL_TEXT, DEFAULT_SLIDER_MIN_VALUE, DEFAULT_SLIDER_MAX_VALUE, initValue, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, DEFAULT_SLIDER_SHOW_TICK_DETAILS);
    }

    public SliderForm() {
        // Create form
        this(DEFAULT_LABEL_TEXT, DEFAULT_SLIDER_MIN_VALUE, DEFAULT_SLIDER_MAX_VALUE, DEFAULT_SLIDER_INIT_VALUE, DEFAULT_SLIDER_MAJOR_TICK_SPACING, DEFAULT_SLIDER_MINOR_TICK_SPACING, DEFAULT_SLIDER_SHOW_TICK_DETAILS);
    }

    // Implement methods
    @Override
    public JSlider getSlider() {
        return slider;
    }

    @Override
    public JSlider getSlider(int setValue) {
        slider.setValue((setValue >= slider.getMinimum() && setValue <= slider.getMaximum()) ? setValue : slider.getMinimum());
        return slider;
    }

    @Override
    public JSlider getSlider(int minValue, int maxValue) {
        slider.setMinimum(minValue);
        slider.setMaximum(maxValue);
        return slider;
    }

    @Override
    public JSlider getSlider(int minValue, int maxValue, int setValue) {
        slider.setMinimum(minValue);
        slider.setMaximum(maxValue);
        slider.setValue((setValue >= slider.getMinimum() && setValue <= slider.getMaximum()) ? setValue : slider.getMinimum());
        return slider;
    }

    @Override
    public JSlider getSlider(boolean showTickDetails) {
        setShowTickDetails(showTickDetails);
        return slider;
    }

    @Override
    public JSlider getSlider(int setValue, boolean showTickDetails) {
        slider.setValue((setValue >= slider.getMinimum() && setValue <= slider.getMaximum()) ? setValue : slider.getMinimum());
        setShowTickDetails(showTickDetails);
        return slider;
    }

    @Override
    public JSlider getSlider(int minValue, int maxValue, boolean showTickDetails) {
        slider.setMinimum(minValue);
        slider.setMaximum(maxValue);
        setShowTickDetails(showTickDetails);
        return slider;
    }

    @Override
    public JSlider getSlider(int minValue, int maxValue, int setValue, boolean showTickDetails) {
        slider.setMinimum(minValue);
        slider.setMaximum(maxValue);
        slider.setValue((setValue >= slider.getMinimum() && setValue <= slider.getMaximum()) ? setValue : slider.getMinimum());
        setShowTickDetails(showTickDetails);
        return slider;
    }

    @Override
    public void setShowTickDetails(boolean showTickDetails) {
        slider.setPaintTicks(showTickDetails);
        slider.setPaintLabels(showTickDetails);
    }

    
}