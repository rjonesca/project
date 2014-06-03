package model;

/**
 *
 * @author roshunjones
 */
public class Service {
    private int service_id = -1;
    private int user_id = -1;
    private java.util.Date start_date;
    private java.util.Date end_date;
    private String short_desc;
    private String long_desc;
    private Location location;
    
    
    public Service(int user_id, java.util.Date start_date, java.util.Date end_date, 
            String short_desc, String long_desc){
        this.user_id = user_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.short_desc = short_desc;
        this.long_desc = long_desc;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public java.util.Date getStart_date() {
        return start_date;
    }

    public void setStart_date(java.util.Date start_date) {
        this.start_date = start_date;
    }

    public java.util.Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(java.util.Date end_date) {
        this.end_date = end_date;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getLong_desc() {
        return long_desc;
    }

    public void setLong_desc(String long_desc) {
        this.long_desc = long_desc;
    }
}
