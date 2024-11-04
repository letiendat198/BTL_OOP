package btl.weather;

public class Settings {
    private String temperatureUnit;
    private String windSpeedUnit;
    private String language;

    public Settings() {
        this.temperatureUnit = "Celsius";
        this.windSpeedUnit = "m/s";
        this.language = "English";
    }

    public Settings(String tUnit, String wsUnit, String language) {
        this.temperatureUnit = tUnit;
        this.windSpeedUnit = wsUnit;
        this.language = language;
    }

    public String getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public void setTemperatureUnit(String unit) {
        this.temperatureUnit = unit;
    }

    public String getWindSpeedUnit() {
        return this.windSpeedUnit;
    }

    public void setWindSpeedUnit(String unit) {
        this.windSpeedUnit = unit;
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
