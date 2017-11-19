import javax.swing.*;

public class Main {
    public static void main(String[] agrs) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Interface();
            }
        });
    }
}
