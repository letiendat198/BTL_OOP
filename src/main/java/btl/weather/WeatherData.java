package btl.weather;

public class WeatherData {
    private float temperature;
    private float rainProbability;
    private float humidity;

    public WeatherData(float temperature, float rainProbability, float humidity) {
        this.temperature = temperature;
        this.rainProbability = rainProbability;
        this.humidity = humidity;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(float rainProbability) {
        this.rainProbability = rainProbability;
    }

    public void presentData() {

    }
}
