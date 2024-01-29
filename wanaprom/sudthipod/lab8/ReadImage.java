package wanaprom.sudthipod.lab8;

import javax.swing.*;
import java.awt.*;

/**
 * ReadImage:
 * This class is used to draw an image to JPanel
 * by overriding the paintComponent() method
 * and get file location from constructor.
 * 
 * Note: IOException handling is not implemented.
 * 
 * Author: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 *
 * Latest Update: 29/01/2024
 */

public class ReadImage extends JPanel {
    protected static final String DEFAULT_FILE_LOCATION = "assets/Football.jpg";
    protected Image image;
    
    public ReadImage(String fileLocation) {
        super();

        // Get image from file path
        image = (new ImageIcon(getClass().getResource(fileLocation))).getImage();

        // Set preferred size to fit the image
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        Dimension preferredSize = new Dimension(imageWidth, imageHeight);
        this.setPreferredSize(preferredSize);
    }

    public ReadImage() {
        this(DEFAULT_FILE_LOCATION);
    }
    
    // Override paintComponent() to draw image
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    
}
