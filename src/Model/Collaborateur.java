package Model;

public class Collaborateur extends User {
    public Collaborateur(String firstname, String lastname, String email, String password) {
        super(firstname, lastname, email, password, 2);
    }

    public static Collaborateur fromString(String line) {
        String[] parts = line.split(",");
        String firstname = parts[0];
        String lastname = parts[1];
        String email = parts[2];
        String password = parts[3];
        return new Collaborateur(firstname, lastname, email, password);
    }
}