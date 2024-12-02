package btl.weather;

import btl.weather.views.MainForecastView;
import btl.weather.views.RegisterForm;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Weather App");

        mainFrame.setMinimumSize(new Dimension(400, 375));
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
                MainForecastView mainForecastFrame = new MainForecastView(user);
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
            String username = registerForm.getTextFieldByIndex(0).getText();
            String email = registerForm.getTextFieldByIndex(1).getText();
            String city = registerForm.getTextFieldByIndex(2).getText();
            String country = registerForm.getTextFieldByIndex(3).getText();

            if (!username.isEmpty() && !email.isEmpty() && !city.isEmpty() && !country.isEmpty()) {
                User user = new User();
                user.setUsername(username);
                user.setEmail(email);
                user.setPreferredUnit(registerForm.getPreferredUnit());
                Location location = new Location();
                location.setCity(city);
                location.setCountry(country);
                user.setLocation(location);
                UserManager userManager = new UserManager();
                userManager.createNewUser(user);
                JOptionPane.showMessageDialog(mainFrame, "New user created successfully", "New User Created", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(mainFrame, "Please fill out all fields", "Register Error", JOptionPane.ERROR_MESSAGE);
            }

        });
        mainContainer.add(registerButton, constraints);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(mainContainer, BorderLayout.CENTER);
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);
    }
}
