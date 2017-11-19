import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Drawing extends JPanel {
    Image img = null; //the thing that will be drawn on
    Graphics2D draw;  //used to draw lines

    //the current and previous coordinates of the mouse
    int currX, currY, prevX, prevY;

    public Drawing() {

    }
}
