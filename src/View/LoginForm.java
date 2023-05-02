package View;


// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionListener;

// public class LoginForm extends JPanel {

//     private JTextField usernameField;
//     private JPasswordField passwordField;
//     private JButton loginButton;
//     private JButton cancelButton;

//     public LoginForm() {

//         JLabel usernameLabel = new JLabel("Nom d'utilisateur: ");
//         JLabel passwordLabel = new JLabel("Mot de passe: ");

//         usernameField = new JTextField(20);
//         passwordField = new JPasswordField(20);

//         loginButton = new JButton("Se connecter");
//         cancelButton = new JButton("Annuler");

//         // space between fields
//         Insets fieldsInset = new Insets(10, 10, 10, 10);

//         // uses Grid Bag Layout
//         setLayout(new GridBagLayout());
//         GridBagConstraints gridBagConstraints = new GridBagConstraints();
//         gridBagConstraints.insets = fieldsInset;
//         gridBagConstraints.fill = GridBagConstraints.NONE;

//         gridBagConstraints.gridx = 0;
//         gridBagConstraints.gridy = 0;
//         gridBagConstraints.anchor = GridBagConstraints.WEST;

//         add(usernameLabel, gridBagConstraints);

//         gridBagConstraints.gridx = 1;
//         gridBagConstraints.gridy = 0;

//         add(usernameField, gridBagConstraints);

//         gridBagConstraints.gridx = 0;
//         gridBagConstraints.gridy = 1;
//         gridBagConstraints.anchor = GridBagConstraints.WEST;

//         add(passwordLabel, gridBagConstraints);

//         gridBagConstraints.gridx = 1;
//         gridBagConstraints.gridy = 1;

//         add(passwordField, gridBagConstraints);

//         gridBagConstraints.gridx = 0;
//         gridBagConstraints.gridy = 2;
//         gridBagConstraints.gridwidth = 2;
//         gridBagConstraints.anchor = GridBagConstraints.CENTER;

//         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//         buttonPanel.add(loginButton);
//         buttonPanel.add(cancelButton);

//         add(buttonPanel, gridBagConstraints);
//     }

//     // getters
//     public String getUsername() {
//         return usernameField.getText();
//     }

//     public String getPassword() {
//         return new String(passwordField.getPassword());
//     }

//     public void login(ActionListener actionListener) {
//         loginButton.addActionListener(actionListener);
//         loginButton.setActionCommand("login");
//     }

//     public void cancel(ActionListener actionListener) {
//         cancelButton.addActionListener(actionListener);
//     }

//     // reset fields
//     public void reset(boolean bln) {
//         if(bln) {
//             usernameField.setText("");
//             passwordField.setText("");
//         }
//     }

    
// }

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginForm extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton cancelButton;

    public LoginForm() {

        JLabel usernameLabel = new JLabel("Nom d'utilisateur: ");
        JLabel passwordLabel = new JLabel("Mot de passe: ");

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Se connecter");
        cancelButton = new JButton("Annuler");

        // espace entre les champs
        Insets fieldsInset = new Insets(10, 10, 10, 10);

        // utilise Grid Bag Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(usernameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;

        add(usernameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(passwordLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;

        add(passwordField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(loginButton);
        buttonPanel.add(cancelButton);

        add(buttonPanel, gridBagConstraints);
    }

    // getters
    public String getUsername() {
        return usernameField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public void login(ActionListener actionListener) {
        loginButton.addActionListener(actionListener);
    }

    public void cancel(ActionListener actionListener) {
        cancelButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            usernameField.setText("");
            passwordField.setText("");
        }
    }

}
