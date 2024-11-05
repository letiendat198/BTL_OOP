package btl.weather;

public class Location {
    private double longitude;
    private double latitude;
    private String city;
    private String country;
    private float timezone;

    public Location() {
        this.longitude = 0.0;
        this.latitude = 0.0;
        this.city = "";
        this.country = "";
        this.timezone = 0.0f;
    }

    public Location(double longitude, double latitude, String city, String country, float timezone) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.city = city;
        this.country = country;
        this.timezone = timezone;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
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

    public float getTimezone() {
        return this.timezone;
    }

    public void setTimezone(float timezone) {
        this.timezone = timezone;
    }
}
