package model;

// Encapsulation: User class hides its data (private fields) and provides public getters
public class User {
    private int id;
    private String uname;
    private String role;
    private String password;

    public User(int id, String uname, String role, String password) {
        this.id = id;
        this.uname = uname;
        this.role = role;
        this.password = password;
    }

    // Getter methods to access private fields (Encapsulation)
    public int getId() { return id; }
    public String getUname() { return uname; }
    public String getRole() { return role; }
    public String getPassword() { return password; }
}
