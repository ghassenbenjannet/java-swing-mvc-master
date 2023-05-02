import View.*;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        // runs in AWT thread
        SwingUtilities.invokeLater(ConnexionFrame::new);
    }
}
