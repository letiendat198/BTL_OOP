package btl.weather;

import btl.weather.views.RegisterForm;

import javax.swing.*;
import java.awt.*;

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
        RegisterForm registerForm = new RegisterForm(new String[]{"Username", "Email", "City", "Country"});
        mainContainer.add(registerForm, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        JButton loginButton = new JButton("Login");
        mainContainer.add(loginButton, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.weightx = 0.5;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(10, 0, 0, 0);
        JButton registerButton = new JButton("Register");
        mainContainer.add(registerButton, constraints);

        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(mainContainer, BorderLayout.CENTER);
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setVisible(true);
    }
}
