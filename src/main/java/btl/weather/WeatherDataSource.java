package btl.weather;

import java.util.Date;
import java.util.Random;

public class WeatherDataSource {
    User user;
    public WeatherDataSource(User user) {
        this.user = user;
    }

    private float generateRandomFloat(float min, float max) {
        Random random = new Random();
        return random.nextFloat(max - min) + min;
    }

    public float getHumidity() {
        return generateRandomFloat(20f, 100f);
    }

    public float getRainProbability() {
        return generateRandomFloat(0f, 100f);
    }

    public float getTemperature() {
        if (user.getPreferredUnit().equals("°C")) {
            return generateRandomFloat(0f, 40f);
        }
        else return generateRandomFloat(32f, 104f);
    }

    public int getAqi() {
        Random random = new Random();
        return random.nextInt(500);
    }

    public WeatherCurrently getCurrentWeatherData() {
        return new WeatherCurrently(getTemperature(), getTemperature(), getRainProbability(), getHumidity(), getAqi());
    }

    public WeatherDaily getDailyWeatherData(Date date) {
        return new WeatherDaily(date, getTemperature(), getTemperature(), getRainProbability(), getHumidity());
    }

    public WeatherHourly getHourlyWeatherData(Date date) {
        return new WeatherHourly(date, getTemperature(), getTemperature(), getRainProbability(), getHumidity());
    }
}
