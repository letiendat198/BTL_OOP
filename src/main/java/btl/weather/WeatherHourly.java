package btl.weather;

import java.util.Date;

public class WeatherHourly {
    private short hour;
    private Date date;
    private float temperature;
    private float feelTemperature;
    private float rainProbability;

    public WeatherHourly() {

    }

    public WeatherHourly(short hour, Date date, float temp, float fTemp, float rainP) {
        this.hour = hour;
        this.date = date;
        temperature = temp;
        feelTemperature = fTemp;
        rainProbability = rainP;
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

    // Getter and Setter for temperature
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    // Getter and Setter for feelTemperature
    public float getFeelTemperature() {
        return feelTemperature;
    }

    public void setFeelTemperature(float feelTemperature) {
        this.feelTemperature = feelTemperature;
    }

    // Getter and Setter for rainProbability
    public float getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(float rainProbability) {
        this.rainProbability = rainProbability;
    }
}
