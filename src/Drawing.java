import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Drawing extends JPanel {
    Image img = null; //the thing that will be drawn on
    Graphics2D draw;  //used to draw lines

    //the current and previous coordinates of the mouse
    int currX, currY, prevX, prevY;

    public Drawing() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }


    //initialize the drawing with a blank canvas
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw = (Graphics2D) g;

        clear();
    }

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
}
