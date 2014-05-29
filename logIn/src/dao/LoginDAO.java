/*
 * This class is used to authenticate users.
 */
package dao;

import common.Connection;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Roshun Jones
 * @version 1.0
 */
public class LoginDAO {
    private static String 
            AUTHENTICATE = "select null from User where username = ? and password = ?";
    /**
     * Authenticates a user with the provided username and password and values stored
     * in the database. Password will be hashed using "MD5" before sending to database.
     * @param aUsername Username provided by the user.
     * @param aPassword Password provided by the user.
     * @return Returns true if the authentication was successful, false otherwise.
     */
    public boolean authenticateUser(final String aUsername, final String aPassword) 
        throws Exception {
        
        // Password user typed in.
        MessageDigest md = MessageDigest.getInstance("MD5");                    
        byte[] hashedPassword = md.digest( aPassword.getBytes() );
        
        java.sql.Connection con = Connection.getConnection();
        PreparedStatement stmt = con.prepareStatement(AUTHENTICATE);
        stmt.setString(1, aUsername);
        stmt.setString(2, hashedPassword.toString());
        ResultSet result = stmt.executeQuery();
        
        //false if no records exist matching username/password, true otherwise.
        return result.next(); 
    }
}
