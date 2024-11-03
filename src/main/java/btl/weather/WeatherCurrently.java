package btl.weather;

public class WeatherCurrently {

    private float temperature;
    private float feelTemperature;
    private float humidity;
    private short windSpeed;
    private float rainProbability;
    private short airQualityIndex;

    public WeatherCurrently() {
    }

    public WeatherCurrently(float temp, float fTemp, float humid, short windSp, float rainP, short aqi) {
        this.temperature = temp;
        this.feelTemperature = fTemp;
        this.humidity = humid;
        this.windSpeed = windSp;
        this.rainProbability = rainP;
        this.airQualityIndex = aqi;
    }

    // Getter and Setter for temperature
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temp) {
        this.temperature = temp;
    }

    // Getter and Setter for feelTemperature
    public float getFeelTemperature() {
        return feelTemperature;
    }

    public void setFeelTemperature(float fTemp) {
        this.feelTemperature = fTemp;
    }

    // Getter and Setter for humidity
    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humid) {
        this.humidity = humid;
    }

    // Getter and Setter for windSpeed
    public short getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(short windSp) {
        this.windSpeed = windSp;
    }

    // Getter and Setter for rainProbability
    public float getRainProbability() {
        return rainProbability;
    }

    public void setRainProbability(float rainP) {
        this.rainProbability = rainP;
    }

    // Getter and Setter for airQualityIndex
    public short getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(short aqi) {
        this.airQualityIndex = aqi;
    }
}
