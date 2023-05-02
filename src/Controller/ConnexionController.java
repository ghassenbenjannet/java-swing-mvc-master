package Controller;

import Model.User;
import Service.AuthenticationService;
import View.*;

import javax.swing.*;

public class ConnexionController {

    private AuthenticationService authService;
    private LoginForm loginForm;

    public ConnexionController(AuthenticationService authService, LoginForm loginForm) {
        this.authService = authService;
        this.loginForm = loginForm;

        // set up event listeners for login and cancel buttons
        loginForm.login(e -> {
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();
            User user = AuthenticationService.authenticate(username, password);
            if (user != null) {
                if (user.getRole() == 1) {
                    // if the user is an admin, switch to the main frame view
                    JOptionPane.showMessageDialog(loginForm, "Vous êtes connecté en tant qu'administrateur.");
                    IndexAdmin adminFrame = new IndexAdmin();
                    loginForm.reset(true);
                    adminFrame.setVisible(true);
                    loginForm.setVisible(false);
                } else {
                    // if the user is a regular user, switch to the user details view
                    JOptionPane.showMessageDialog(loginForm, "Vous êtes connecté en tant que collaborateur.");
                    IndexCollab collabFrame = new IndexCollab();
                    loginForm.reset(true);
                    collabFrame.setVisible(true);
                    loginForm.setVisible(false);
                }
            } else {
                // if authentication fails, show an error message
                JOptionPane.showMessageDialog(loginForm, "Nom d'utilisateur ou mot de passe incorrect.");
                loginForm.reset(false);
            }
        });

        loginForm.cancel(e -> System.exit(0));
    }
    
}
