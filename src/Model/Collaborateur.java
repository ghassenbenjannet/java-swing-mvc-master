package Model;

public class Collaborateur extends User {
    public Collaborateur(String firstname, String lastname, String email, String password) {
        super(firstname, lastname, email, password, 0);
    }
}

