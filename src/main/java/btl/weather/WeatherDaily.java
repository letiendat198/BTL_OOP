package btl.weather;

import java.util.Date;

public class WeatherDaily extends WeatherData{

    private Date date;
    private float highTemperature;
    private float lowTemperature;

    public WeatherDaily(Date date, float highTemperature, float lowTemperature, float rainProbability, float humid) {
        super(highTemperature, rainProbability, humid);
        this.date = date;
        this.highTemperature = highTemperature;
        this.lowTemperature = lowTemperature;
    }

    // Getter and Setter for date
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    // Getter and Setter for highTemperature
    public float getHighTemperature() {
        return highTemperature;
    }

    public void setHighTemperature(float highTemperature) {
        this.highTemperature = highTemperature;
    }

    // Getter and Setter for lowTemperature
    public float getLowTemperature() {
        return lowTemperature;
    }

    public void setLowTemperature(float lowTemperature) {
        this.lowTemperature = lowTemperature;
    }
}
