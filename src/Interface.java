import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Interface {
    //the interface itself
    private JFrame frame;

    //the left side of the interface
    private Drawing drawing; //will eventually need to be type Drawing
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
        //layout.setVgap(50);
        //layout.setHgap(50);
        frame.setLayout(layout);

        //add components
        drawing = new Drawing(); //put canvas on left side
        drawing.setPreferredSize(new Dimension(700, 700));
        frame.add(drawing, BorderLayout.LINE_START);

        resultText = new JTextField();  //add text on right side
        resultText.setPreferredSize(new Dimension(700, 700));
        frame.add(resultText, BorderLayout.LINE_END);

        center = new JPanel();  //create a center panel
        center.setPreferredSize(new Dimension(100, 700));

        toText = new JButton("To Text ->"); //put to text button in top center
        toText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                resultText.setText(toText());   //set the text field to the text version of the drawing
            }
        });
        toText.setPreferredSize(new Dimension(100, 350));
        center.add(toText, BorderLayout.PAGE_START);

        clear = new JButton("Clear");  //put clear button in bottom center
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                drawing.clear();
            }
        });
        clear.setPreferredSize(new Dimension(100, 350));
        center.add(clear, BorderLayout.PAGE_END);

        frame.add(center, BorderLayout.CENTER); //add center

        //show the interface
        frame.pack();
        frame.setVisible(true);
    }

    private String toText() {
        if (drawing != null) {
            BufferedImage img = new BufferedImage(drawing.getWidth(), drawing.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
            System.out.println(img.toString());

            return "it worked";
        }
        else {
            return "";
        }
    }
}
