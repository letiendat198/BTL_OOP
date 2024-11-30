package btl.weather;

import java.util.Date;

public class WeatherHourly {
    private float temperature;
    private float rainProbability;
    private float humidity;
    private Date date;
    private float feelTemperature;

    public WeatherHourly(Date dat, float temperature, float feelTemperature, float rainProbability, float humidity) {
        this.temperature = temperature;
        this.rainProbability = rainProbability;
        this.humidity = humidity;
        this.date = date;
        this.feelTemperature = feelTemperature;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
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

    // Getter and Setter for feelTemperature
    public float getFeelTemperature() {
        return feelTemperature;
    }

    public void setFeelTemperature(float feelTemperature) {
        this.feelTemperature = feelTemperature;
    }
}
