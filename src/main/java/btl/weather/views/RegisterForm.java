package btl.weather.views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegisterForm extends JPanel {
    Map<Integer, JTextField> inputMap = new HashMap<>();
    String preferredUnit = "°C";
    public RegisterForm(String[] fields) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.1;
        constraints.insets = new Insets(10,0,0, 0);
        for(String field: fields) {
            JLabel label = new JLabel(field);
            this.add(label, constraints);
            constraints.gridy++;
        }
        JLabel tempUnitLabel = new JLabel("Temperature Unit");
        this.add(tempUnitLabel, constraints);

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.insets = new Insets(10,0,0, 0);
        for(String field: fields) {
            JTextField input = new JTextField();
            this.add(input, constraints);
            this.inputMap.put(constraints.gridy, input);
            constraints.gridy++;
        }

        JComboBox<String> unitComboBox = new JComboBox<>(new String[]{"°C", "°F"});
        unitComboBox.addActionListener(e -> {
            this.preferredUnit = unitComboBox.getSelectedItem().toString();
        });
        this.add(unitComboBox, constraints);
    }

    public JTextField getTextFieldByIndex(int index) {
        return inputMap.get(index);
    }

    public String getPreferredUnit() {
        return this.preferredUnit;
    }
}
