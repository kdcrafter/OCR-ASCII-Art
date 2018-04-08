import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/*
 * Starts up and the GUI interface on the EDT and the neural network
 */
public class Main {
    public static void main(String[] agrs) {
        //initialize the NN
//        try {
//            Process p = Runtime.getRuntime().exec(
//                    "python3 " + System.getProperty("user.dir") + "\\src" + "\\NN_Init.py");
//
//            //check if script was successful
//            Scanner reader = new Scanner(p.getInputStream());
//            System.out.println(reader.nextLine());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //start up the GUI interface
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface();
            }
        });
    }
}
