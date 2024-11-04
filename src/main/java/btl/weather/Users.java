package btl.weather;

import java.util.ArrayList;
import java.util.List;

public class Users {

    private String userId;
    private String username;
    private String email;
    private Location location;
    private Settings settings;
    private List<Plan> plans;

    public Users() {
        this.plans = new ArrayList<>();
    }

    public String properties() {
        return "UserId: " + userId + "\n" +
                "Username: " + username + "\n" +
                "Email: " + email + "\n" +
                "Location: " + location + "\n" +
                "Settings: " + settings + "\n" +
                "Plans: " + plans;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public void addPlan(Plan plan) {
        this.plans.add(plan);
    }

    public void removePlan(int index) {
        if (index >= 0 && index < plans.size()) {
            this.plans.remove(index);
        } else {
            System.out.println("Invalid plan index.");
        }
    }

    public Plan getPlan(int index) {
        if (index >= 0 && index < plans.size()) {
            return plans.get(index);
        } else {
            System.out.println("Invalid plan index.");
            return null;
        }
    }

    // Weather methods
    public WeatherCurrently getCurrentWeather(Location location, Settings settings) {
        //
        //
        return new WeatherCurrently();
    }

    public WeatherHourly getHourlyWeather(Location location, Settings settings) {
        //
        //
        return new WeatherHourly();
    }

    public WeatherDaily getDailyWeather(Location location, Settings settings) {
        //
        //
        return new WeatherDaily();
    }
}

class Location {
    //
}

class Settings {
    //
}

class Plan {
    //
}

class WeatherCurrently {
    //
}

class WeatherHourly {
    //
}

class WeatherDaily {
    //
}
