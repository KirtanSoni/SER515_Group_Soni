package org.SER.classes;

import javax.swing.*;
import java.awt.*;

public class Signup extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;

    public Signup() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);

        Font font = new Font("Calibri", Font.PLAIN, 14);

        JLabel[] labels = {
                new JLabel("First Name:"),
                new JLabel("Last Name:"),
                new JLabel("Email:"),
                new JLabel("Password:")
        };

        for (JLabel label : labels) {
            label.setFont(font);
        }

        firstNameField = new JTextField(20);
        lastNameField = new JTextField(20);
        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);

        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setFont(new Font("Calibri", Font.BOLD, 18));

        JButton switchToLoginButton = new JButton("Already have an account? Login");
        switchToLoginButton.setFont(font);

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < labels.length; i++) {
            c.gridx = 0;
            c.gridy = i;
            add(labels[i], c);

            c.gridx = 1;
            add(createField(i), c);
        }

        c.gridy = labels.length;
        add(signUpButton, c);

        c.gridy = labels.length + 1;
        add(switchToLoginButton, c);

        signUpButton.addActionListener(e -> signUpActionPerformed());
        switchToLoginButton.addActionListener(e -> switchToLoginActionPerformed());
    }

    private JComponent createField(int index) {
        return switch (index) {
            case 0 -> firstNameField;
            case 1 -> lastNameField;
            case 2 -> emailField;
            case 3 -> passwordField;
            default -> new JPanel();
        };
    }

    private void signUpActionPerformed() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        if (isAnyFieldEmpty(firstName, lastName, email, password)) {
            showErrorDialog();
        } else {
            // Implement your sign-up process
            System.out.println("Sign Up successful!");
        }
    }

    private void switchToLoginActionPerformed() {
        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.show(getParent(), "login");
    }

    private boolean isAnyFieldEmpty(String... fields) {
        for (String field : fields) {
            if (field.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void showErrorDialog() {
        JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
    }

    // Methods for setting values (added for testing purposes)
    public void setFirstName(String firstName) {
        firstNameField.setText(firstName);
    }

    public void setLastName(String lastName) {
        lastNameField.setText(lastName);
    }

    public void setEmail(String email) {
        emailField.setText(email);
    }

    public void setPassword(String password) {
        passwordField.setText(password);
    }
}
