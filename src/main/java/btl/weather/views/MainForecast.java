package btl.weather.views;

import btl.weather.User;

import javax.swing.*;
import java.awt.*;

public class MainForecast extends JFrame {
    public MainForecast(User user) {
        this.setTitle("Weather Forecast");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel dailyForecastPanel = new DailyForecast(user);
        JPanel currentForecastPanel = new CurrentForecast(user);

        tabbedPane.add("Current Forecast", currentForecastPanel);
        tabbedPane.add("Daily Forecast", dailyForecastPanel);
        this.add(tabbedPane);
    }
}