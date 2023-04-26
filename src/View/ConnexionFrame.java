package View;

import javax.swing.*;
import java.awt.*;

public class ConnexionFrame extends JFrame {

    private CardLayout cardLayout;

    public ConnexionFrame() {
        super("Connexion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        LoginForm loginForm = new LoginForm();
        add(loginForm, "loginForm");

        setSize(400, 300);
        setResizable(false);

        ImageIcon imageIcon = new ImageIcon("src/assets/appicon.png");
        setIconImage(imageIcon.getImage());
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void showLoginForm() {
        cardLayout.show(getContentPane(), "loginForm");
    }
}
