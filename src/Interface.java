import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.*;

/*
 * Specifies the GUI interface, all of its components, and logic
 * The GUI will be created whenever a Interface object is instantiated
 */
public class Interface {
    //the entire interface
    private JFrame frame;

    //left side of the gui
    private JPanel left;
    private Canvas canvas; //where the user draws stuff on the left of the interface


    //the center components to clear the canvas and activate resultText
    private JPanel center;
    private JButton clear;
    private JButton toText;

    //on the right of the interface, shows the text version of the user drawing
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
        frame = new JFrame("OCR ASCII Art");

        //edit the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1900, 900);
        frame.setResizable(false);
        BorderLayout layout = new BorderLayout();
        //layout.setVgap(50);
        //layout.setHgap(50);
        frame.setLayout(layout);

        //add left side
        left = new JPanel();
        left.setPreferredSize(new Dimension(900, 900));
        left.setLayout(new FlowLayout());

        Font numInputFont = new Font("SansSerif", Font.PLAIN, 30);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 40);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(800, 800));
        left.add(canvas); //put canvas on left side

        frame.add(left, BorderLayout.LINE_START);

        //add right side
        resultText = new JTextField();
        resultText.setPreferredSize(new Dimension(900, 900));
        Font largeFont = new Font("SansSerif", Font.BOLD, 200);
        resultText.setFont(largeFont);
        frame.add(resultText, BorderLayout.LINE_END); //add text on right side

        //add center
        center = new JPanel();
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
            //get image from canvas
            BufferedImage canvasImg = (BufferedImage) canvas.getCanvasImage();

            //save image
            try {
                File imgFile = new File(System.getProperty("user.dir") + "\\src" + "\\Drawing.png");
                ImageIO.write(canvasImg, "png", imgFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            //get text version from python script
            try {
                System.out.println(System.getProperty("user.dir") + "\\src" + "\\NN_Predict.py");
                Process p = Runtime.getRuntime().exec("python " + System.getProperty("user.dir") + "\\src" + "\\NN_Predict.py");
                Scanner reader = new Scanner(p.getInputStream());

                return reader.nextLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        }
        else { //return empty when drawing hasn't been instantiated
            return "";
        }
    }
}