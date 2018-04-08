import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 * A GUI component that allows the user to draw lines on the canvas
 */
public class Canvas extends JPanel {
    Image image; //the image that's being drawn on
    Graphics2D draw;  //used to draw lines

    //the current and previous coordinates of the mouse
    private int currX, currY, prevX, prevY;

    /*
     * Creates a new instance and specifies when lines should be drawn on the canvas
     */
    public Canvas() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //set the coordinates to the location the user clicked on
                currX = e.getX();
                currY = e.getY();
                prevX = currX;
                prevY = currY;
            }

            @Override
            public void mouseDragged (MouseEvent e){
                //get the new location of the mouse
                currX = e.getX();
                currY = e.getY();

                //draw a line between new and old points
                if (draw != null) {
                    draw.drawLine(prevX, prevY, currX, currY);
                    repaint();
                }

                //set the coordinates to the location the user clicked on
                prevX = currX;
                prevY = currY;
            }
        };

        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    /*
     * Initializes the canvas with a blank canvas with a black border
     * This function isn't called directly
     *
     * @param   g   A Graphics instance used to draw components on the canvas
     */
    protected void paintComponent(Graphics g) {
        //set up the image canvas if hasn't already been set up
        if(image == null){
            image = createImage(getSize().width, getSize().height);
            draw = (Graphics2D) image.getGraphics();
            clear();
        }

        //draw on the canvas
        g.drawImage(image, 0, 0, null);
    }

    /*
     * Clears the canvas screen by covering it with a white rectangle
     * Called when the clear button is pressed
     */
    public void clear() {
        if (draw != null) {
            //fill the canvas with a white rect
            draw.setColor(Color.WHITE);
            draw.drawRect(0, 0, getWidth(), getHeight());
            draw.fillRect(0, 0, getWidth(), getHeight());

            draw.setColor(Color.BLACK); //so user doesn't draw white on a white canvas

            repaint();  //make sure that changes appear on canvas
        }

        //don't do anything if draw hasn't yet been initialized
    }

    /*
     * get the drawing on the canvas
     */
    public Image getCanvasImage() {
        return image;
    }
}
