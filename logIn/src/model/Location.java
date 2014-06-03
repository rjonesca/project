package model;

/**
 * @author Roshun Jones
 */
public class Location {
    private String city;
    private String state;
    private String zip;
    private String country;
    
    public Location(String city, String state, String zip, String country){
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
