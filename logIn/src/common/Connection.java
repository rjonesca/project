/*
 * This class used to provide a connection to the datasource for all DAO's.
 */
package common;

/**
 * @author Roshun Jones
 * @version 1.0
 */
public class Connection {
    private static String CONNECTION_STRING = "";
    
    /**
     * Returns connection to datasource.
     * @return Returns connection to datasource. 
     */
    public static java.sql.Connection getConnection() {
        java.sql.Connection con = null;
        return con;
    }
}
