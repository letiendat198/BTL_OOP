package btl.weather;

import java.io.Serializable;

public class Location implements Serializable {
    private String city;
    private String country;

    public Location() {
        this.city = "";
        this.country = "";
    }

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
