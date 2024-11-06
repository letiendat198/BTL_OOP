package btl.weather;

public class WeatherCurrently extends WeatherData {
    private float feelTemperature;
    private short windSpeed;
    private short airQualityIndex;

    public WeatherCurrently(float temp, float fTemp, float humid, short windSp, float rainP, short aqi) {
        super(temp, rainP, humid);
        this.feelTemperature = fTemp;
        this.windSpeed = windSp;
        this.airQualityIndex = aqi;
    }

    // Getter and Setter for feelTemperature
    public float getFeelTemperature() {
        return feelTemperature;
    }

    public void setFeelTemperature(float fTemp) {
        this.feelTemperature = fTemp;
    }

    // Getter and Setter for windSpeed
    public short getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(short windSp) {
        this.windSpeed = windSp;
    }

    // Getter and Setter for airQualityIndex
    public short getAirQualityIndex() {
        return airQualityIndex;
    }

    public void setAirQualityIndex(short aqi) {
        this.airQualityIndex = aqi;
    }
}
