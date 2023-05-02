package Model;



public abstract class  User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private int role;

    public User() {
        // empty constructor
    }

    public User(String firstname, String lastname, String email, String password, int role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    

    // getters
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getRole() {
        return role;
    }

    // setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.firstname, this.lastname, this.email, this.password, this.role == 0 ? "Collaborateur" : "Admin");
    }

    public static User fromString(String line) {
        String[] parts = line.split(",");
        String firstname = parts[0];
        String lastname = parts[1];
        String email = parts[2];
        String password = parts[3];
        int role = Integer.parseInt(parts[4]);
        
        if (role == 1) {
            return new Admin(firstname, lastname, email, password);
        } else if (role == 2) {
            return new Collaborateur(firstname, lastname, email, password);
        } else {
            // role is not valid, return null or throw an exception
            return null;
        }
    }
    
    
    

}
