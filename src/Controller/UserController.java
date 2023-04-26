package Controller;

import Model.Database;
import Model.User;
import View.Form;
import View.UserDetails;

import javax.swing.*;
import java.io.File;

public class UserController {
    // database file
    private String databaseFile = "src\\data\\database.txt";
    private Database database;
    private Form form;
    private UserDetails userDetails;

    public UserController(Form form, UserDetails userDetails) {
        this.database = new Database();
        this.form = form;
        this.userDetails = userDetails;

        // submit user
        this.form.submitUsers(e -> {
            String firstname = this.form.getFirstname().trim();
            String lastname = this.form.getLastname().trim();
            String email = this.form.getEmail().trim();
            String password = this.form.getPassword().trim();
            int role = this.form.getRole() ;

            // simple validations
            if(firstname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Prénom à saisir.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(lastname.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Nom à saisir.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(email.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "E-mail à saisir.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else if(password.isEmpty()) {
                JOptionPane.showMessageDialog(this.form, "Mot de passe à saisir.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            this.database.addUser(new User(firstname, lastname, email, password, role));
            this.database.saveUser(new File(databaseFile));
            this.form.reset(true);
        });

        // load users
        this.form.viewUsers(e -> {
            Object[] usersList = this.database.loadUsers(new File(databaseFile));
            this.userDetails.getUsers(usersList);
        });

    }
}
