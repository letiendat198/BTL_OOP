package btl.weather;

import java.util.Date;

public class WeatherHourly extends WeatherData {
    private short hour;
    private Date date;
    private float feelTemperature;

    public WeatherHourly(short hour, Date date, float temp, float fTemp, float rainP, float humid) {
        super(temp, rainP, humid);
        this.hour = hour;
        this.date = date;
        feelTemperature = fTemp;
    }

    // Getter and Setter for hour
    public short getHour() {
        return hour;
    }

    public void setHour(short hour) {
        this.hour = hour;
    }

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and Setter for feelTemperature
    public float getFeelTemperature() {
        return feelTemperature;
    }

    public void setFeelTemperature(float feelTemperature) {
        this.feelTemperature = feelTemperature;
    }
}
