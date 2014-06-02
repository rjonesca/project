package dao;

import common.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Contact;

/**
 *
 * @author Roshun Jones
 */
public class ContactDAO {
    private static String 
            INSERT = "insert into Contact(user_id, name, address, city, state, zip, country, phone) " +
                "values(?,?,?,?,?,?,?,?)";
            
    private static String 
            UPDATE = "update Contact set name=?, address=?, city=?, state=?, zip=?, country=?, phone=?";
    
    /**
     * Adds a contact to the database.
     * @param aContact Contact object to save.
     * @throws java.lang.Exception
     */
    public Contact createNewContact(Contact aContact) throws Exception {
        java.sql.Connection con = Connection.getConnection();
        PreparedStatement stmt = con.prepareStatement(INSERT);
        stmt.setInt(1, aContact.getUserId());
        stmt.setString(2, aContact.getFirstName());
        stmt.setString(3, aContact.getAddress());
        stmt.setString(4, aContact.getCity());
        stmt.setString(5, aContact.getState());
        stmt.setString(6, aContact.getZip());
        stmt.setString(7, aContact.getCountry());
        stmt.setString(8, aContact.getPhone());
        
        stmt.executeUpdate();
        
        //Get generated user id
        ResultSet contactId = stmt.getGeneratedKeys();
        int contact_id = -1;
        
        if(contactId != null && contactId.next()){
            contact_id = contactId.getInt(1);
            aContact.setContactId(contact_id);
        }
        stmt.close();
        
        return aContact;
    }
}
