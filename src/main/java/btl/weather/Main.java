package btl.weather;

import btl.weather.views.DailyForecast;
import btl.weather.views.MainForecast;
import btl.weather.views.RegisterForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Weather App");

        mainFrame.setMinimumSize(new Dimension(400, 350));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout()); // Use BorderLayout, which will center children by default
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 30, 50, 30));

        JPanel mainContainer = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JLabel title = new JLabel("Login or register new user");
        title.setHorizontalAlignment(JLabel.CENTER);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(10, 50, 0, 50);
        String[] registerFields = new String[]{"Username", "Email", "City", "Country"};
        RegisterForm registerForm = new RegisterForm(registerFields);
        mainContainer.add(registerForm, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            UserManager userManager = new UserManager();
            String username = registerForm.getTextFieldByIndex(0).getText();
            boolean isUserExist = userManager.validateUserByUsername(username);
            if (isUserExist) {
                User user = userManager.getUserByUsername(username);
                MainForecast mainForecastFrame = new MainForecast(user);
                mainForecastFrame.setVisible(true);
            }
            else JOptionPane.showMessageDialog(mainFrame, "User not found!", "Login Error!", JOptionPane.ERROR_MESSAGE);
        });
        mainContainer.add(loginButton, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> {
            User user = new User();
            user.setUserId(registerForm.getTextFieldByIndex(0).getText());
            user.setEmail(registerForm.getTextFieldByIndex(1).getText());
            user.setPreferredUnit(registerForm.getPreferredUnit());
            Location location = new Location();
            location.setCity(registerForm.getTextFieldByIndex(2).getText());
            location.setCountry(registerForm.getTextFieldByIndex(3).getText());
            user.setLocation(location);

            UserManager userManager = new UserManager();
            userManager.createNewUser(user);
            JOptionPane.showMessageDialog(mainFrame, "New user created successfully", "New User Created", JOptionPane.INFORMATION_MESSAGE);
        });
        mainContainer.add(registerButton, constraints);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(mainContainer, BorderLayout.CENTER);
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);
    }
}
