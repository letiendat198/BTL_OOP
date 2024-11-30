package btl.weather.views;

import btl.weather.User;
import btl.weather.WeatherCurrently;
import btl.weather.WeatherDataSource;
import btl.weather.WeatherHourly;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class HourlyForecast extends JPanel {
    public HourlyForecast (User user) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        String[] fields = {"Temperature:", "Humidity:", "Feel Temperature:", "Rain Probability:"};

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(0,10,10, 5);
        for (String field: fields) {
            JLabel label = new JLabel(field);
            label.setHorizontalAlignment(JLabel.RIGHT);
            this.add(label, constraints);
            constraints.gridy++;
        }

        WeatherDataSource dataSource = new WeatherDataSource(user);
        WeatherHourly currentWeather = dataSource.getHourlyWeatherData(new Date());
        String[] data = new String[5];
        data[0] = Math.round(currentWeather.getTemperature()) + user.getPreferredUnit();
        data[1] = Math.round(currentWeather.getHumidity()) + "%";
        data[2] = Math.round(currentWeather.getFeelTemperature()) + user.getPreferredUnit();
        data[3] = Math.round(currentWeather.getRainProbability()) + "%";

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(0,5,10, 10);
        for (String i: data) {
            JLabel label = new JLabel(i);
            this.add(label, constraints);
            constraints.gridy++;
        }
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
