package btl.weather;

public class WeatherCurrently {
    private float temperature;
    private float rainProbability;
    private float humidity;
    private float feelTemperature;
    private int airQualityIndex;

    public WeatherCurrently(float feelTemperature, float temperature, float rainProbability, float humidity, int airQualityIndex) {
        this.feelTemperature = feelTemperature;
        this.temperature = temperature;
        this.rainProbability = rainProbability;
        this.humidity = humidity;
        this.airQualityIndex = airQualityIndex;
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

    // Getter and Setter for feelTemperature
    public float getFeelTemperature() {
        return feelTemperature;
    }

    public void setFeelTemperature(float fTemp) {
        this.feelTemperature = fTemp;
    }

    // Getter and Setter for airQualityIndex
    public int getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(int aqi) {
        this.airQualityIndex = aqi;
    }
}
