package Model;

public class Admin extends User {
    public Admin(String firstname, String lastname, String email, String password) {
        super(firstname, lastname, email, password, 1);
    }
}

