import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;

/*
 * Specifies the GUI interface, all of its components, and logic
 * The GUI will be created whenever a object is instantiated
 */
public class Interface {
    //the entire interface
    private JFrame frame;

    //the left side of the interface
    private Canvas canvas;

    //the center components of the interface
    private JPanel center;
    private JButton clear;
    private JButton toText;

    //the right side of the interface
    private JTextField resultText;

    /*
     * Creates an instance of the interface and shows it on screen
     */
    public Interface() {
        createInterface();
    }

    /*
     * Adds each component to the frame and shows the GUI on screen
     * Functions are added to the buttons to specify what happens when those buttons are pressed
     */
    private void createInterface() {
        //create the GUI
        frame = new JFrame("Paint Number Converter");

        //edit the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1900, 900);
        frame.setResizable(false);
        BorderLayout layout = new BorderLayout();
        //layout.setVgap(50);
        //layout.setHgap(50);
        frame.setLayout(layout);

        //add components
        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(900, 900));
        frame.add(canvas, BorderLayout.LINE_START); //put canvas on left side

        resultText = new JTextField();
        resultText.setPreferredSize(new Dimension(900, 900));
        frame.add(resultText, BorderLayout.LINE_END); //add text on right side

        center = new JPanel();  //create a center panel
        center.setPreferredSize(new Dimension(100, 900));

        //TODO: be able to change font size (automatically or manually)
        toText = new JButton("To Text ->");
        toText.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                resultText.setText(toText());   //set the text field to the text version of the drawing
            }
        });
        toText.setPreferredSize(new Dimension(100, 450));
        center.add(toText, BorderLayout.PAGE_START); //put to text button in top center

        clear = new JButton("Clear");
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                canvas.clear(); //make the canvas screen entirely white
            }
        });
        clear.setPreferredSize(new Dimension(100, 450));
        center.add(clear, BorderLayout.PAGE_END); //put clear button in bottom center

        frame.add(center, BorderLayout.CENTER);

        //show the interface
        frame.pack();
        frame.setLocationRelativeTo(null);  //puts GUI in center of screen
        frame.setVisible(true);
    }

    /*
     * Calculates what the text version (in numbers 0-9) of the canvas image would be
     *
     * @return  A string containing the text version of the canvas image
     *          Returns a empty string when canvas hasn't been instantiated
     */
    private String toText() {
        if (canvas != null) { //if drawing has been instantiated
            BufferedImage img = new BufferedImage(canvas.getWidth(), canvas.getHeight(), BufferedImage.TYPE_BYTE_BINARY);
            System.out.println(img.toString());

            return "it worked";
        }
        else { //return empty when drawing hasn't been instantiated
            return "";
        }
    }
}