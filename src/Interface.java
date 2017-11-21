import java.awt.*;
import javax.swing.*;

public class Interface {
    //the interface itself
    private JFrame frame;

    //the left side of the interface
    private JPanel drawing; //will eventually need to be type Drawing
    //JButton clear;

    //the center components of the interface
    private JPanel center;
    private JButton clear;
    private JButton toText;

    //the right side of the interface
    private JTextField resultText;


    public Interface() {
        createInterface();
    }

    //creates everything in the GUI interface
    public void createInterface() {
        //create the GUI
        frame = new JFrame("Paint ASCII");

        //edit the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1600, 700);
        frame.setResizable(false);
        BorderLayout layout = new BorderLayout();
        layout.setVgap(10);
        layout.setHgap(10);
        frame.setLayout(layout);

        //add components
        drawing = new JPanel(); //put canvas on left side
        drawing.setPreferredSize(new Dimension(700, 700));
        frame.add(drawing, BorderLayout.LINE_START);

        center = new JPanel();  //create a center panel
        center.setPreferredSize(new Dimension(100, 700));

        toText = new JButton("To Text ->"); //put to text button in top center
        toText.setPreferredSize(new Dimension(100, 350));
        center.add(toText, BorderLayout.PAGE_START);

        toText = new JButton("Clear");  //put clear button in bottom center
        toText.setPreferredSize(new Dimension(100, 350));
        center.add(toText, BorderLayout.PAGE_END);

        frame.add(center, BorderLayout.CENTER); //add center

        resultText = new JTextField();  //add text on right side
        resultText.setPreferredSize(new Dimension(700, 700));
        frame.add(resultText, BorderLayout.LINE_END);

        //show the interface
        frame.pack();
        frame.setVisible(true);
    }
}
