package dao;

import common.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import model.Location;
import model.Service;

/**
 * @author Roshun Jones
 */
public class ServiceDAO {
   private static String INSERT = "insert into Service(user_id, start_date, end_date, short_desc, long_desc) "
           +                            "values(?,?,?,?,?)";
   
   private static String INSERT_LOCATION = "insert into Location(service_id, city, zip, country, state) "
           +                                    "values(?,?,?,?,?)";
   
   private static String INSERT_JOIN = "insert into User_Service(user_id, service_id) values(?,?) ";
   
   public Service createNewService(Service aService) throws Exception {
       Service service = null;
       SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
       
       java.sql.Connection con = Connection.getConnection();
       PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
       stmt.setInt(1, aService.getUser_id());
       stmt.setString(2, sf.format(aService.getStart_date()));
       stmt.setString(3, sf.format(aService.getEnd_date()));
       stmt.setString(4, aService.getShort_desc());
       stmt.setString(5, aService.getLong_desc());
       stmt.executeUpdate();
       
       //Get generated user id
       ResultSet serviceId = stmt.getGeneratedKeys();
       int service_id = -1;
        
       if(serviceId != null && serviceId.next()){
            service_id = serviceId.getInt(1);
            aService.setService_id(service_id);
            
            Location location = aService.getLocation();
     
            stmt = con.prepareStatement(INSERT_LOCATION);
            stmt.setInt(1, service_id);
            stmt.setString(2, location.getCity());
            stmt.setString(3, location.getState());
            stmt.setString(4, location.getZip());
            stmt.setString(5, location.getCountry());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement(INSERT_JOIN);
            stmt.setInt(1, aService.getUser_id());
            stmt.setInt(2, service_id);
            stmt.executeUpdate();
       }
     
       stmt.close();
       
       return service;
   }
   
   public Object[][] getConnectedServices(int user_id) throws Exception {
       Object[][] data = null;
       java.sql.Connection con = Connection.getConnection();
       String sql = "select a.service_id, a.short_desc, "
               + "a.start_date, a.end_date, a.long_desc, b.city, b.state, b.zip, b.country from Service a"
               + " inner join Location b on a.service_id = b.service_id " 
               + " inner join User_Service c on b.service_id = c.service_id "
               + " where c.user_id = ?";
       
       PreparedStatement stmt = con.prepareStatement(sql);
       stmt.setInt(1, user_id);
       ResultSet result = stmt.executeQuery();
       result.last();
       int rowCount = result.getRow();
       result.beforeFirst();
       
       if(rowCount > 0){
           data = new Object[rowCount][9];
           while(result.next()) {
               data[result.getRow() - 1][0] = result.getInt("service_id");
               data[result.getRow() - 1][1] = result.getString("short_desc");
               data[result.getRow() - 1][2] = result.getString("start_date");
               data[result.getRow() - 1][3] = result.getString("end_date");
               data[result.getRow() - 1][4] = result.getString("long_desc");
               data[result.getRow() - 1][5] = result.getString("city");
               data[result.getRow() - 1][6] = result.getString("state");
               data[result.getRow() - 1][7] = result.getString("zip");
               data[result.getRow() - 1][8] = result.getString("country");
           }   
       }

       return data;
   }
   
   public Object[][] getAvailableServices() throws Exception {
       return getAvailableServices("","");
   }
   
   public Object[][] getAvailableServices(String filter, String value) throws Exception {
       Object[][] data = null;
       
       String filter_clause = "";
       
       switch(filter.toLowerCase()) {
           case "city":
               filter_clause = " where city = '" + value + "'";
               break;
           case "state":
               filter_clause = " where state = '" + value + "'";
               break;
           case "zip":
               filter_clause = " where zip = '" + value + "'";
               break;
           case "country":
               filter_clause = " where country = '" + value + "'";
               break;
       }
       
       java.sql.Connection con = Connection.getConnection();
       String sql = "select a.service_id, a.short_desc, "
               + "a.start_date, a.end_date, a.long_desc, b.city, b.state, b.zip, b.country from Service a"
               + " inner join Location b on a.service_id = b.service_id " + filter_clause;
       
       PreparedStatement stmt = con.prepareStatement(sql);
       ResultSet result = stmt.executeQuery();
       
       result.last();
       int rowCount = result.getRow();
       result.beforeFirst();
       
       if(rowCount > 0){
           data = new Object[rowCount][9];
           while(result.next()) {
               data[result.getRow() - 1][0] = result.getInt("service_id");
               data[result.getRow() - 1][1] = result.getString("short_desc");
               data[result.getRow() - 1][2] = result.getString("start_date");
               data[result.getRow() - 1][3] = result.getString("end_date");
               data[result.getRow() - 1][4] = result.getString("long_desc");
               data[result.getRow() - 1][5] = result.getString("city");
               data[result.getRow() - 1][6] = result.getString("state");
               data[result.getRow() - 1][7] = result.getString("zip");
               data[result.getRow() - 1][8] = result.getString("country");
           }   
       }
 
       return data;
   }
   
   public void makeConnection(int user_id, int service_id) throws Exception{
       java.sql.Connection con = Connection.getConnection();
       PreparedStatement stmt = con.prepareStatement(INSERT_JOIN);
       stmt.setInt(1, user_id);
       stmt.setInt(2, service_id);
       stmt.executeUpdate();
   }
}

	