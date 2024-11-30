package btl.weather;

import java.util.Date;

public class WeatherDaily {
    private float rainProbability;
    private float humidity;
    private Date date;
    private float highTemperature;
    private float lowTemperature;

    public WeatherDaily(Date date, float highTemperature, float lowTemperature, float rainProbability, float humidity) {
        this.rainProbability = rainProbability;
        this.humidity = humidity;
        this.date = date;
        this.highTemperature = highTemperature;
        this.lowTemperature = lowTemperature;
    }

    public float getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(float rainProbability) {
        this.rainProbability = rainProbability;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
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
