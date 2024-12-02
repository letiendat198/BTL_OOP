package btl.weather;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private String username;
    private String email;
    private String preferredUnit;
    private Location location;
    private List<Plan> plans;

    public User() {
        this.plans = new ArrayList<>();
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

    public String getPreferredUnit() {
        return preferredUnit;
    }

    public void setPreferredUnit(String preferredUnit) {
        this.preferredUnit = preferredUnit;
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

    public List<Plan> getPlans() {
        return plans;
    }
}