package btl.weather.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import btl.weather.User;

public class Planner extends JPanel {

    private JComboBox<String> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> yearComboBox;
    private JTextArea taskTextArea;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private String username; // Tên người dùng

    public Planner(User user) {
        this.username = user.getUsername();  // Nhận tên người dùng khi đăng nhập
        setLayout(new BorderLayout());  // Cài đặt Layout cho panel

        // Tạo bảng điều khiển (panel)
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Tạo panel chọn ngày
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new FlowLayout());

        // Combobox chọn ngày
        dayComboBox = new JComboBox<>(generateDayList());
        monthComboBox = new JComboBox<>(generateMonthList());
        yearComboBox = new JComboBox<>(generateYearList());

        datePanel.add(new JLabel("Day:"));
        datePanel.add(dayComboBox);
        datePanel.add(new JLabel("Month:"));
        datePanel.add(monthComboBox);
        datePanel.add(new JLabel("Year:"));
        datePanel.add(yearComboBox);

        panel.add(datePanel, BorderLayout.NORTH);

        // Tạo panel nhập công việc
        JPanel taskPanel = new JPanel();
        taskPanel.setLayout(new BorderLayout());

        taskTextArea = new JTextArea(5, 20);
        taskTextArea.setLineWrap(true);
        taskTextArea.setWrapStyleWord(true);
        JScrollPane taskScrollPane = new JScrollPane(taskTextArea);

        JButton addButton = new JButton("Add Task");

        // Danh sách công việc
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane taskListScrollPane = new JScrollPane(taskList);

        taskPanel.add(taskScrollPane, BorderLayout.CENTER);
        taskPanel.add(addButton, BorderLayout.SOUTH);
        taskPanel.add(taskListScrollPane, BorderLayout.EAST);

        panel.add(taskPanel, BorderLayout.CENTER);

        // Thêm sự kiện cho nút "Add Task"
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskTextArea.getText();
                if (!task.trim().isEmpty()) {
                    String selectedDate = getSelectedDate();
                    taskListModel.addElement(selectedDate + " - " + task);
                    taskTextArea.setText("");
                    saveTaskToFile(selectedDate, task); // Lưu công việc vào file khi thêm
                } else {
                    JOptionPane.showMessageDialog(Planner.this, "Please enter a task.");
                }
            }
        });

        // Thêm panel chính vào frame
        add(panel, BorderLayout.CENTER);

        // Tải công việc của người dùng khi khởi động
        loadTasksFromFile();
    }

    // Hàm tạo danh sách ngày (1 đến 31)
    private String[] generateDayList() {
        String[] days = new String[31];
        for (int i = 0; i < 31; i++) {
            days[i] = String.format("%02d", i + 1);
        }
        return days;
    }

    // Hàm tạo danh sách tháng (1 đến 12)
    private String[] generateMonthList() {
        return new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
    }

    // Hàm tạo danh sách năm (2020 đến 2030)
    private String[] generateYearList() {
        String[] years = new String[11];
        for (int i = 0; i < 11; i++) {
            years[i] = String.valueOf(2020 + i);
        }
        return years;
    }

    // Hàm lấy ngày, tháng, năm đã chọn
    private String getSelectedDate() {
        String day = (String) dayComboBox.getSelectedItem();
        String month = (String) monthComboBox.getSelectedItem();
        String year = (String) yearComboBox.getSelectedItem();
        return day + "/" + month + "/" + year;
    }

    // Lưu công việc vào file
    private void saveTaskToFile(String date, String task) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(username + "_tasks.txt", true))) {
            writer.write(date + " - " + task);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Tải công việc từ file của người dùng
    private void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(username + "_tasks.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                taskListModel.addElement(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
