import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/*
 * Starts up and the GUI interface on the EDT and the neural network
 */
public class Main {
    public static void main(String[] agrs) {
        //start up the GUI interface
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface();
            }
        });
    }
}
