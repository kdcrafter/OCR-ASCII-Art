import javax.swing.JFrame;

public class Interface {
    public Interface() {
        //create the GUI
        JFrame frame = new JFrame("Paint ASCII");

        //edit the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //full screen
        frame.setVisible(true);
    }
}
