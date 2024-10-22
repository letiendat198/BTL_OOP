package btl.weather.api;

import org.apache.http.client.utils.URIBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class OpenMeteoOptions {
    private String apiUrl = "https://api.open-meteo.com/v1/forecast";
    private float latitude;
    private float longitude;
    private String temperatureUnit="celsius";
    private String timezone="auto";
    private int forecastDays = 2;
    private OpenMeteoHourlyOptions hourlyOptions;
    private OpenMeteoDailyOptions dailyOptions;

    public OpenMeteoOptions(float latitude, float longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public URI toURI() throws URISyntaxException, MalformedURLException {
        URIBuilder uriBuilder = new URIBuilder(apiUrl);
        uriBuilder.addParameter("latitude", Float.toString(this.latitude));
        uriBuilder.addParameter("longitude", Float.toString(this.longitude));
        uriBuilder.addParameter("temperature_unit", temperatureUnit);
        uriBuilder.addParameter("timezone", timezone);
        uriBuilder.addParameter("forecast_days", Integer.toString(forecastDays));
        if (hourlyOptions!=null) uriBuilder.addParameter("hourly", hourlyOptions.toString());
        if (dailyOptions!=null) uriBuilder.addParameter("daily", dailyOptions.toString());
        return uriBuilder.build();
    }

    public int getForecastDays() {
        return forecastDays;
    }

    public void setForecastDays(int forecastDays) {
        this.forecastDays = forecastDays;
    }

    public String getTemperatureUnit() {
        return temperatureUnit;
    }

    public void setTemperatureUnit(String temperatureUnit) {
        this.temperatureUnit = temperatureUnit;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public OpenMeteoHourlyOptions getHourlyOptions() {
        return hourlyOptions;
    }

    public void setHourlyOptions(OpenMeteoHourlyOptions hourlyOptions) {
        this.hourlyOptions = hourlyOptions;
    }

    public OpenMeteoDailyOptions getDailyOptions() {
        return dailyOptions;
    }

    public void setDailyOptions(OpenMeteoDailyOptions dailyOptions) {
        this.dailyOptions = dailyOptions;
    }
}
