import java.awt.*;
import javax.swing.*;

public class Interface {
    //the interface itself
    private JFrame frame;

    //the left side of the interface
    private JTextField drawing; //will eventually need to be type Drawing
    //JButton clear;

    //the center components of the interface
    private JButton toText;

    //the right side of the interface
    private JTextField resultText;

    //other stuff in the class
    private GridBagConstraints gbc;


    public Interface() {
        gbc = new GridBagConstraints();

        createInterface();
    }

    //creates everything in the GUI interface
    public void createInterface() {
        //create the GUI
        frame = new JFrame("Paint ASCII");

        //edit the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //full screen
        frame.setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //add the components
        drawing = new JTextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.LAST_LINE_END;
        gbc.insets = new Insets(0, 50, 50, 50);
        frame.add(drawing, gbc);

        toText = new JButton();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 2;
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
        frame.add(toText, gbc);

        resultText = new JTextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 4;
        gbc.gridx = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.LAST_LINE_START;
        gbc.insets = new Insets(0, 50, 50, 50);
        frame.add(resultText, gbc);

        //show the interface
        frame.pack();
        frame.setVisible(true);
    }

    //sets the properties of the components
    private void setGridBagConstraints(int y, int x, int width, int height) {
        gbc.gridy = y;
        gbc.gridx = x;
        gbc.gridwidth = width;
        gbc.gridheight = height;
    }
}
