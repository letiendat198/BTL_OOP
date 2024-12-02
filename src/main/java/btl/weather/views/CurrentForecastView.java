package btl.weather.views;

import btl.weather.User;
import btl.weather.WeatherCurrently;
import btl.weather.WeatherDataSource;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentForecastView extends JPanel {
    Date date = new Date();
    public CurrentForecastView(User user) {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(50, 30, 10, 30));
        JPanel mainContainer = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        String[] fields = {"Temperature:", "Humidity:", "Feel Temperature:", "Rain Probability:", "Air Quality Index:"};

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(10,0,0, 5);
        for (String field: fields) {
            JLabel label = new JLabel(field);
            label.setHorizontalAlignment(JLabel.RIGHT);
            mainContainer.add(label, constraints);
            constraints.gridy++;
        }

        WeatherDataSource dataSource = new WeatherDataSource(user);
        WeatherCurrently currentWeather = dataSource.getCurrentWeatherData();
        String[] data = new String[5];
        data[0] = Math.round(currentWeather.getTemperature()) + user.getPreferredUnit();
        data[1] = Math.round(currentWeather.getHumidity()) + "%";
        data[2] = Math.round(currentWeather.getFeelTemperature()) + user.getPreferredUnit();
        data[3] = Math.round(currentWeather.getRainProbability()) + "%";
        data[4] = String.valueOf(currentWeather.getAirQualityIndex());

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.insets = new Insets(10,5,0, 0);
        for (String i: data) {
            JLabel label = new JLabel(i);
            mainContainer.add(label, constraints);
            constraints.gridy++;
        }

        JPanel hourlyForecastSection = new JPanel();
        hourlyForecastSection.setLayout(new BoxLayout(hourlyForecastSection, BoxLayout.LINE_AXIS));
        for (int i=0;i<12;i++) {
            Date nextHour = new Date(date.getTime() + 3600L * 1000L * (i+1));
            hourlyForecastSection.add(new HourlyForecastView(user, nextHour));
        }
        Dimension scrollPreferredSize = hourlyForecastSection.getPreferredSize();
        scrollPreferredSize.height = 130;
        hourlyForecastSection.setPreferredSize(scrollPreferredSize);
        JScrollPane scrollPane = new JScrollPane(hourlyForecastSection);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 10));

        JLabel locationLabel = new JLabel(String.format("Forecast for: %s - %s", user.getLocation().getCity(), user.getLocation().getCountry()));
        SimpleDateFormat fullDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String today = fullDateFormat.format(date);
        JLabel dateLabel = new JLabel(today);
        locationLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        dateLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        Box title = Box.createVerticalBox();
        title.add(locationLabel);
        title.add(dateLabel);

        this.add(title, BorderLayout.NORTH);
        this.add(mainContainer, BorderLayout.CENTER);
        this.add(scrollPane, BorderLayout.SOUTH);
    }
}
