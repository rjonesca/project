package model;

/**
 *
 * @author Roshun Jones
 */
public class User {
    private int userId = -1;
    private String userName;
    private String password;
    private Contact contact;
    private String role;

    public User(String userName, String password, Contact contact) {
        this.userName = userName;
        this.password = password;
        this.contact = contact;
    }
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
