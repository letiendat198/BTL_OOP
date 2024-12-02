package btl.weather.views;

import btl.weather.User;
import btl.weather.WeatherDaily;
import btl.weather.WeatherDataSource;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.JTableHeader;

public class DailyForecastView extends JPanel{
    User user;
    Date date;

    public DailyForecastView(User user) {
        this.user = user;
        date = new Date();
        Date today = new Date();

        String[] columnNames = new String[7];
        WeatherDataSource dataSource = new WeatherDataSource(user);

        String[][] data = new String[3][7];

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");

        for (int i = 0; i < 7; i++) {
            Date currentDate = new Date(today.getTime() + (i * 24L * 60L * 60L * 1000L));
            columnNames[i] = sdf.format(currentDate);

            WeatherDaily dailyData = dataSource.getDailyWeatherData(currentDate);

            int roundedHTemp = Math.round(dailyData.getHighTemperature());
            int roundedLTemp = Math.round(dailyData.getLowTemperature());

            if (roundedLTemp > roundedHTemp) {
                int temp = roundedLTemp;
                roundedLTemp = roundedHTemp;
                roundedHTemp = temp;
            }

            if ((roundedHTemp - roundedLTemp) > 10) {
                roundedHTemp = roundedLTemp + 10;
            }

            data[0][i] = roundedLTemp + user.getPreferredUnit() + " - " + roundedHTemp + user.getPreferredUnit();

            float rainProbability = dailyData.getRainProbability();
            String formattedRainProbability = String.format("%.2f", rainProbability);

            if (rainProbability < 20) {
                data[1][i] = "Sunny";
            } else if (rainProbability < 60) {
                data[1][i] = "Cloudy";
            } else {
                data[1][i] = "Rainy";
            }

            data[2][i] = formattedRainProbability + "%";
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 16));
        table.setRowHeight(60);
        table.setGridColor(new Color(220, 220, 220));
        table.setSelectionBackground(new Color(255, 204, 102));
        table.setSelectionForeground(Color.BLACK);

        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 18));
        header.setBackground(new Color(60, 60, 60));
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);

        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    c.setBackground(new Color(245, 245, 245));
                } else {
                    c.setBackground(Color.WHITE);
                }
                return c;
            }
        });

        Map<String, Color> weatherColorMap = new HashMap<>();
        weatherColorMap.put("Sunny", new Color(242, 242, 122)); // Yellow
        weatherColorMap.put("Cloudy", new Color(169, 169, 169)); // Gray
        weatherColorMap.put("Rainy", new Color(144, 213, 255)); // Blue

        for (int i = 0; i < columnNames.length; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer((table1, value, isSelected, hasFocus, row, column) -> {
                JLabel label = new JLabel(value.toString());
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setFont(new Font("Arial", Font.BOLD, 16));
                label.setOpaque(true);

                if (row == 1) {
                    label.setBackground(weatherColorMap.getOrDefault(value.toString(), Color.WHITE));
                } else {
                    label.setBackground(Color.WHITE);
                }

                label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                return label;
            });
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(240, 240, 240));
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        this.add(scrollPane, BorderLayout.CENTER);
    }
}



