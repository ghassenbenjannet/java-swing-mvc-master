package Service;

import Model.*;
import Controller.ConnexionController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {

    private static final String DATABASE_PATH = "src/data/data_users.txt";

    /**
     * Authenticate the user with the given username and password.
     *
     * @param username the username to authenticate
     * @param password the password to authenticate
     * @return the authenticated user, or null if the username/password combination is invalid
     */
    public static User authenticate(String username, String password) {
        List<User> users = readUsersFromDatabase();
        for (User user : users) {
            if (user.getEmail().equals(username) && user.getPassword().equals(password)) {
                ConnexionController.currentUser= user;
                return user;
            }
        }
        return null;
    }

    /**
     * Read the list of users from the database file.
     *
     * @return the list of users
     */
    public static List<User> readUsersFromDatabase() {
        List<User> users = new ArrayList<>();
        User user;
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String firstname = parts[0].trim();
                String lastname = parts[1].trim();
                String email = parts[2].trim();
                String password = parts[3].trim();
                int role = Integer.parseInt(parts[4].trim());
                if (role == 1 )
                     user = new Admin(firstname, lastname, email, password);
                else 
                     user = new Collaborateur(firstname, lastname, email, password);

                users.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
