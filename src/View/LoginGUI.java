package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginGUI() {
        super("Login");

        // Set the layout of the window
        setLayout(new GridLayout(3, 2));

        // Create the components
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        // Add the components to the window
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JPanel());
        add(loginButton);

        // Set the behavior of the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // TODO: Check if the username and password are valid
                boolean isValid = checkCredentials(username, password);

                if (isValid) {
                    // If the credentials are valid, close the login window and open the main frame
                    dispose();
                    MainFrame mainFrame = new MainFrame();
                    mainFrame.setVisible(true);
                } else {
                    // If the credentials are invalid, show an error message
                    JOptionPane.showMessageDialog(LoginGUI.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set the size and location of the window
        setSize(300, 150);
        setLocationRelativeTo(null);

        // Exit the application when the window is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // A method to check if the username and password are valid
    private boolean checkCredentials(String username, String password) {
        // TODO: Check if the username and password are valid (e.g. by querying a database)
        return username.equals("admin") && password.equals("password");
    }

    public static void main(String[] args) {
        // Create and show the login window
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setVisible(true);
    }
}
