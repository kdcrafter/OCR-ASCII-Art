import javax.swing.*;

/*
 * Starts up and runs the GUI interface on the EDT
 */
public class Main {
    public static void main(String[] agrs) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface();
            }
        });
    }
}
