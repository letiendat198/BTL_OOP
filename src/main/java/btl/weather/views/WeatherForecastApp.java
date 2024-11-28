package btl.weather.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.JTableHeader;

public class WeatherForecastApp {
    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Weather Forecast Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);  // Center the frame on the screen

        // Column names for the table (Days of the week)
        String[] columnNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // Weather data for each day: [Temperature, Weather Condition, Humidity, Wind, Pressure, Rain]
        Object[][] data = {
                {"28°C", "30°C", "27°C", "29°C", "31°C", "32°C", "30°C"}, // Temperature
                {"Sunny", "Cloudy", "Rainy", "Sunny", "Cloudy", "Sunny", "Sunny"}, // Weather Condition
                {"60%", "55%", "75%", "65%", "50%", "40%", "60%"}, // Humidity
                {"15 km/h", "18 km/h", "12 km/h", "20 km/h", "17 km/h", "22 km/h", "14 km/h"}, // Wind
                {"1010 hPa", "1012 hPa", "1009 hPa", "1013 hPa", "1011 hPa", "1014 hPa", "1010 hPa"}, // Pressure
                {"0 mm", "0 mm", "10 mm", "0 mm", "0 mm", "0 mm", "0 mm"}  // Rain
        };

        // Create DefaultTableModel with data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create JTable with the model
        JTable table = new JTable(model);
        table.setFont(new Font("Arial", Font.PLAIN, 16));  // Set table font
        table.setRowHeight(40);  // Adjust row height for better readability
        table.setGridColor(new Color(220, 220, 220));  // Lighter grid color
        table.setSelectionBackground(new Color(255, 204, 102));  // Set selection background color
        table.setSelectionForeground(Color.BLACK);  // Set selection text color

        // Set table header style
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 18));
        header.setBackground(new Color(60, 60, 60));  // Dark header background
        header.setForeground(Color.WHITE);  // White header text
        header.setReorderingAllowed(false);  // Disable reordering columns

        // Set alternating row colors
        table.setDefaultRenderer(Object.class, new javax.swing.table.DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (row % 2 == 0) {
                    c.setBackground(new Color(245, 245, 245));  // Light gray for even rows
                } else {
                    c.setBackground(Color.WHITE);  // White for odd rows
                }
                return c;
            }
        });

        // Map weather conditions to colors
        Map<String, Color> weatherColorMap = new HashMap<>();
        weatherColorMap.put("Sunny", new Color(255, 204, 0));  // Yellow
        weatherColorMap.put("Cloudy", new Color(169, 169, 169));  // Gray
        weatherColorMap.put("Rainy", new Color(0, 102, 204));  // Blue

        // Customize table cell rendering for the Weather column
        table.getColumnModel().getColumn(1).setCellRenderer((table1, value, isSelected, hasFocus, row, column) -> {
            JLabel label = new JLabel(value.toString());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 16));
            label.setOpaque(true);
            label.setBackground(weatherColorMap.getOrDefault(value.toString(), Color.WHITE)); // Set background color based on weather
            label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Padding for the label
            return label;
        });

        // Create a JScrollPane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2)); // Add border to the scrollPane

        // Create a panel with a nice background
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240));  // Light gray background for the panel
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));  // Add padding around the content
        panel.add(scrollPane, BorderLayout.CENTER);

        // Add panel to the frame
        frame.getContentPane().add(panel);

        // Set the frame visible
        frame.setVisible(true);
    }
}



