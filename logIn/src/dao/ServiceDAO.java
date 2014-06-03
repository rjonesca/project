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
       }
     
       stmt.close();
       
       return service;
   }
}

	