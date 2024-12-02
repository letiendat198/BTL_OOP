package btl.weather.views;

import btl.weather.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class MainForecastView extends JFrame {
    public MainForecastView(User user) {
        this.setTitle("Weather Forecast");
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel dailyForecastPanel = new DailyForecastView(user);
        JPanel currentForecastPanel = new CurrentForecastView(user);
        JPanel plannerPanel = new Planner(user);

        tabbedPane.add("Current Forecast", currentForecastPanel);
        tabbedPane.add("Daily Forecast", dailyForecastPanel);
        tabbedPane.add("Planner", plannerPanel);
        this.add(tabbedPane);
    }
}
