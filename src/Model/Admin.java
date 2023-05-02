package Model;

public class Admin extends User {
    public Admin(String firstname, String lastname, String email, String password) {
        super(firstname, lastname, email, password, 1);
    }

    public static Admin fromString(String line) {
        String[] parts = line.split(",");
        String firstname = parts[0];
        String lastname = parts[1];
        String email = parts[2];
        String password = parts[3];
        return new Admin(firstname, lastname, email, password);
    }
}