package btl.weather.views;

import btl.weather.User;
import btl.weather.WeatherDataSource;
import btl.weather.WeatherHourly;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HourlyForecastView extends JPanel {
    public HourlyForecastView(User user, Date date) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        String[] fields = {"Temperature:", "Humidity:", "Feel Temperature:", "Rain Probability:"};

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(0,0,10, 0);
        for (String field: fields) {
            JLabel label = new JLabel(field);
            label.setHorizontalAlignment(JLabel.RIGHT);
            this.add(label, constraints);
            constraints.gridy++;
        }

        WeatherDataSource dataSource = new WeatherDataSource(user);
        WeatherHourly currentWeather = dataSource.getHourlyWeatherData(date);
        String[] data = new String[5];
        data[0] = Math.round(currentWeather.getTemperature()) + user.getPreferredUnit();
        data[1] = Math.round(currentWeather.getHumidity()) + "%";
        data[2] = Math.round(currentWeather.getFeelTemperature()) + user.getPreferredUnit();
        data[3] = Math.round(currentWeather.getRainProbability()) + "%";

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(0,5,10, 10);
        for (String i: data) {
            JLabel label = new JLabel(i);
            this.add(label, constraints);
            constraints.gridy++;
        }

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(5,10,10, 10);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        JLabel hour = new JLabel(sdf.format(date));
        hour.setHorizontalAlignment(JLabel.CENTER);
        this.add(hour, constraints);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
