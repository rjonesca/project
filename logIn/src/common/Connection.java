/*
 * This class used to provide a connection to the datasource for all DAO's.
 */
package common;

import java.sql.DriverManager;

/**
 * @author Roshun Jones
 * @version 1.0
 */
public class Connection {
    /**
     * Sole connection object for application instance.
     */
    private static java.sql.Connection con = null; 
    
   /**
     * Returns connection to datasource.
     * @return Returns connection to datasource. 
    */
    public static java.sql.Connection getConnection() {
        String url = "jdbc:mysql://vergil.u.washington.edu:64111/MedicalCareAlliance"; 
        String driver = "com.mysql.jdbc.Driver";
        
        if( con == null ){
            try { 
                Class.forName(driver).newInstance(); 
                con = DriverManager.getConnection(url,"care_appuser","h3!pMe");  
            } catch (Exception e) { e.printStackTrace();} 
        }

        return con;
    }
    
    /**
     * Close the open connection.
     */
    public static void closeConnection(){
        if( con != null ){
            try {
                con.close();
            }catch(Exception e){}
        }
    }
}
