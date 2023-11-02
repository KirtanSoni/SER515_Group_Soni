package org.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JPanel {
    public SignUp() {
        setLayout(new GridBagLayout());

        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton signUpButton = new JButton("Sign Up");
        JButton switchToLoginButton = new JButton("Already have an account? Login");

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        add(firstNameLabel, c);

        c.gridx = 1;
        add(firstNameField, c);

        c.gridx = 0;
        c.gridy = 1;
        add(lastNameLabel, c);

        c.gridx = 1;
        add(lastNameField, c);

        c.gridx = 0;
        c.gridy = 2;
        add(emailLabel, c);

        c.gridx = 1;
        add(emailField, c);

        c.gridx = 0;
        c.gridy = 3;
        add(passwordLabel, c);

        c.gridx = 1;
        add(passwordField, c);

        c.gridy = 4;
        add(signUpButton, c);

        c.gridy = 5;
        add(switchToLoginButton, c);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values from the input fields
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                // Check for empty fields
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(SignUp.this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Perform the sign-up logic here
                    // You can use the validated fields
                    // Implement your sign-up process
                }
            }
        });

        switchToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch back to the login form
                CardLayout cardLayout = (CardLayout) getParent().getLayout();
                cardLayout.show(getParent(), "login");
            }
        });
    }
}
