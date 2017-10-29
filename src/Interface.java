import java.awt.*;
import javax.swing.*;

public class Interface {
    //the interface itself
    JFrame frame;

    //components of the interface
    JButton clear;
    JButton save;
    JPanel drawing;

    public Interface() {
        //create the GUI
        this.frame = new JFrame("Paint ASCII");

        //edit the frame
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //full screen
        this.frame.setVisible(true);

        //set up the top part of the interface
        this.clear = new JButton("Clear");
        this.clear.setPreferredSize(new Dimension(this.frame.getWidth()/2, this.frame.getHeight()/10));
        this.frame.getContentPane().add(this.clear, BorderLayout.LINE_START);

        this.save = new JButton("Save");
        this.save.setPreferredSize(new Dimension(this.frame.getWidth()/2, this.frame.getHeight()/10));
        this.frame.getContentPane().add(this.save, BorderLayout.LINE_END);

        this.drawing = new JPanel();
        this.drawing.setPreferredSize(new Dimension(this.frame.getWidth(), (int) (this.frame.getHeight() * 0.9)));
        this.frame.getContentPane().add(this.drawing, BorderLayout.SOUTH);

        this.frame.pack();
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //full screen
    }
}
