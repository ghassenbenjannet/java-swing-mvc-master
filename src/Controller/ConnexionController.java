package Controller;

import View.*;
import View.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ConnexionController {

    private ConnexionFrame connexionFrame;
    private LoginForm loginForm;

    public ConnexionController(ConnexionFrame connexionFrame, LoginForm loginForm) {
        this.connexionFrame = connexionFrame;
        this.loginForm = loginForm;

        loginForm.login(new LoginListener());
        loginForm.cancel(new CancelListener());
    }

    private class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();

            if (username.equals("admin") && password.equals("admin")) {
                MainFrame mainFrame = new MainFrame();
                connexionFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(connexionFrame, "Nom d'utilisateur ou mot de passe incorrect.");
                loginForm.reset(true);
            }
        }
    }

    private class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            loginForm.reset(true);
        }
    }
}
