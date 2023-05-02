// package View;

// import javax.swing.*;
// import java.awt.*;

// public class ConnexionFrame extends JFrame {

//     private CardLayout cardLayout;

//     public ConnexionFrame() {
//         super("Connexion");
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         cardLayout = new CardLayout();
//         setLayout(cardLayout);

//         LoginForm loginForm = new LoginForm();
//         add(loginForm, "loginForm");

//         setSize(400, 300);
//         setResizable(false);

//         ImageIcon imageIcon = new ImageIcon("src/assets/appicon.png");
//         setIconImage(imageIcon.getImage());
//         setLocationRelativeTo(null);

//         setVisible(true);
//     }

//     public void showLoginForm() {
//         cardLayout.show(getContentPane(), "loginForm");
//     }
// }

package View;

import Controller.*;
import Service.*;
import javax.swing.*;
import java.awt.*;

public class ConnexionFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public ConnexionFrame() {
        super("Connexion");
        cardLayout = new CardLayout();
        LoginForm form = new LoginForm();
        AuthenticationService authServ= new AuthenticationService();
        // MainFrame adminFrame = new MainFrame();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        new ConnexionController(authServ, form);

        // adds view to card layout with unique constraints
        add(form, "form");
        // switch view according to its constraints on click
        form.login(e -> cardLayout.show(ConnexionFrame.this.getContentPane(), "index"));

        // icon for our application
        ImageIcon imageIcon = new ImageIcon("src/assets/appicon.png");
        setIconImage(imageIcon.getImage());
        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
