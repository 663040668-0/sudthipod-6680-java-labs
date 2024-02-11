package wanaprom.sudthipod.lab9;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * DiceImageCanvas:
 * Original from teacher.
 * Edited to draw dots on a rectangle from <diceNumber>
 * 
 * Student: Sudthipod Wanaprom
 * ID: 663040668-0
 * Sec: 2
 */

public class DiceImageCanvas extends JPanel {
    protected int diceNumber;
    protected Graphics2D g2d;
    protected Ellipse2D.Double circleCenter, circleTopRight, circleBottomLeft,
            circleTopLeft, circleBottomRight, circleTopCenter, circleBottomCenter;
    protected Rectangle2D.Double square;
    protected int squareWidth = 150, squareHeight = 150;
    protected int canvasWidth = 400, canvasHeight = 400;
    protected int circleWidth = 30, circleHeight = 30;
    protected int startSquareX = 125;
    protected int startSquareY = 40;
    protected int margin = 10;

    public DiceImageCanvas(int diceNumber) {
        // initialize dice number
        this.diceNumber = diceNumber;

        // set size with width canvasWidth and height canvasHeight
        setSize(canvasWidth, canvasHeight);

        // initialize a square which is a background
        square = new Rectangle2D.Double(startSquareX, startSquareY, squareWidth, squareHeight);

        // call method createCircles to place dots on a rectangle
        createCircles();
    }

    protected void createCircles() {
        // initialize coordinates to be used
        double centerX = startSquareX + squareWidth/2 - circleWidth/2;
        double centerY = startSquareY + squareHeight/2 - circleHeight/2;
        double left = startSquareX + margin;
        double right = startSquareX + squareWidth - circleWidth - margin;
        double top = startSquareY + margin;
        double bottom = startSquareY + squareHeight - circleHeight - margin;

        // initialize different types of circles (circleCenter, circleTopRight, ...)
        circleCenter = new Ellipse2D.Double(centerX, centerY, circleWidth, circleHeight);
        circleTopRight = new Ellipse2D.Double(right, top, circleWidth, circleHeight);
        circleBottomLeft = new Ellipse2D.Double(left, bottom, circleWidth, circleHeight);
        circleTopLeft = new Ellipse2D.Double(left, top, circleWidth, circleHeight);
        circleBottomRight = new Ellipse2D.Double(right, bottom, circleWidth, circleHeight);
        circleTopCenter = new Ellipse2D.Double(centerX, top, circleWidth, circleHeight);
        circleBottomCenter = new Ellipse2D.Double(centerX, bottom, circleWidth, circleHeight);
    }

    protected void drawDiceNumber() {
        // depending on a dice number, place red dots properly on a rectangle
        g2d.setPaint(Color.RED);
        switch (diceNumber) {
            case 1:
                g2d.fill(circleCenter);
                break;

            case 2:
                g2d.fill(circleTopRight);
                g2d.fill(circleBottomLeft);
                break;

            case 3:
                g2d.fill(circleTopRight);
                g2d.fill(circleCenter);
                g2d.fill(circleBottomLeft);
                break;

            case 4:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopRight);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomRight);
                break;

            case 5:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopRight);
                g2d.fill(circleCenter);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomRight);
                break;

            case 6:
                g2d.fill(circleTopLeft);
                g2d.fill(circleTopCenter);
                g2d.fill(circleTopRight);
                g2d.fill(circleBottomLeft);
                g2d.fill(circleBottomCenter);
                g2d.fill(circleBottomRight);
                break;
        
            default:
                g2d.drawString("Error: Dice number \'" + diceNumber + "\' is not available.", startSquareX, startSquareY);
                break;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        // call paintComponent of super class
        super.paintComponent(g);

        // cast graphics object to graphics2D object
        g2d = (Graphics2D) g;

        // set paint to white and fill the square
        g2d.setPaint(Color.WHITE);
        g2d.fill(square);

        // call code to draw dice number
        drawDiceNumber();
    }
}
