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
    
    private static String INSERT = "insert into User(username, password) values(?,?)";
    
    private static String UPDATE = "update User set username = ?, password = ?";
    
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
     * @param aUser A User object to be saved.
     */
    public void createUser(User aUser) throws Exception{
        java.sql.Connection con = Connection.getConnection();
        PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, aUser.getUserName());
        stmt.setString(2, aUser.getPassword());
        
        //Add user to database
        stmt.executeUpdate();
        
        
        ResultSet key = stmt.getGeneratedKeys();
        int userId = -1;
        
        if(key != null && key.next()){
            userId = key.getInt(1);
        }
        
        stmt.close();
        
        //Add contact entry
        Contact contact = aUser.getContact();
        
        //Set user id to contact object
        contact.setUserId(userId);
        
        ContactDAO contactDAO = new ContactDAO();
        contactDAO.createNewContact(contact);
    }
    
    /**
     * Updates an existing user record.
     * @param aUser 
     */
    public void updateUser(User aUser) {
        
    }
}
