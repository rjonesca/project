/*
 * This class is used to authenticate users.
 */
package dao;

import common.Connection;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.Contact;
import model.User;

/**
 * @author Roshun Jones
 * @version 1.0
 */
public class UserDAO {
    private static String 
            AUTHENTICATE = "select null from User where username = ? and password = ?";
    
    private static String INSERT = "insert into User(username, password, role) values(?,?,?)";
    private static String GET_USER = "select * from User a"
            + "                         inner join Contact b on a.user_id = b.user_id"
            + "                       where a.username = ?";
        
    /**
     * Authenticates a user with the provided username and password and values stored
     * in the database. Password will be hashed using "MD5" before sending to database.
     * @param aUsername Username provided by the user.
     * @param aPassword Password provided by the user.
     * @return Returns true if the authentication was successful, false otherwise.
     */
    public boolean authenticateUser(final String aUsername, final String aPassword) 
        throws Exception {
        
        boolean pass = false;
        
        // Password user typed in.
        MessageDigest md = MessageDigest.getInstance("MD5");                    
        byte[] hashedPassword = md.digest( aPassword.getBytes() );
        
        java.sql.Connection con = Connection.getConnection();
        PreparedStatement stmt = con.prepareStatement(AUTHENTICATE);
        stmt.setString(1, aUsername);
        stmt.setString(2, aPassword);//hashedPassword.toString());
        ResultSet result = stmt.executeQuery();
        
        if(result != null) {
            pass = result.next();
            result.close();
        }
        
        stmt.close();
        
        //false if no records exist matching username/password, true otherwise.
        return pass; 
    }
    
    /**
     * Creates a new user record.
     */
    public User createUser(User aUser) throws Exception{
        java.sql.Connection con = Connection.getConnection();
        PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, aUser.getUserName());
        stmt.setString(2, aUser.getPassword());
        stmt.setString(3, aUser.getRole());
        
        //Add user to database
        stmt.executeUpdate();
        
        //Get generated user id
        ResultSet user_id = stmt.getGeneratedKeys();
        int userId = -1;
        
        if(user_id != null && user_id.next()){
            userId = user_id.getInt(1);
        }
        
        stmt.close();
        
        //Add contact entry
        ContactDAO contactDAO = new ContactDAO();
        
        //Set user id to contact object
        aUser.getContact().setUserId(userId);
        
        Contact contact = contactDAO.createNewContact(aUser.getContact());
        aUser.setContactId(contact.getContactId());
        aUser.setContact(contact);
        
        return aUser;
    }
    
    public User getUser(String aUsername) throws Exception {
        User user = null;
        Contact contact = null;
        
        java.sql.Connection con = Connection.getConnection();
        PreparedStatement stmt = con.prepareStatement(GET_USER);
        stmt.setString(1, aUsername);
        
        ResultSet result = stmt.executeQuery();
        
        if(result != null && result.next()) {
            contact = new Contact(result.getString("firstName"), result.getString("lastName"),
                result.getString("address"), result.getString("city"), result.getString("state"),
                result.getString("zip"), result.getString("country"), result.getString("phone"));
            contact.setContactId(result.getInt("contact_id"));
            contact.setUserId(result.getInt("user_id"));
            
            user = new User(result.getString("username"), result.getString("password"), contact);
            user.setRole(result.getString("role"));
            user.setContactId(result.getInt("contact_id"));
        }
        
        return user;
    }
}
