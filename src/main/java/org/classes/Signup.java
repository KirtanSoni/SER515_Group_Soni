package src.main.java.org.classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JPanel {
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton signUpButton;
    private JButton switchToLoginButton;

    public Signup() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField(20);

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        signUpButton = new JButton("Sign Up");

        switchToLoginButton = new JButton("Already have an account? Login");

        // Apply the same font as the Login class
        Font font = new Font("Calibri", Font.PLAIN, 14);
        firstNameLabel.setFont(font);
        lastNameLabel.setFont(font);
        emailLabel.setFont(font);
        passwordLabel.setFont(font);
        signUpButton.setFont(new Font("Calibri", Font.BOLD, 18));

        switchToLoginButton.setFont(font);

        // Apply the same background color as the Login class
        setBackground(new Color(255, 255, 255));

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
                signUpActionPerformed();
            }
        });

        switchToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToLoginActionPerformed();
            }
        });
    }

    private void signUpActionPerformed() {
        // Get the values from the input fields
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);

        // Check for empty fields
        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Perform the sign-up logic here
            // You can use the validated fields
            // Implement your sign-up process
        }
    }

    private void switchToLoginActionPerformed() {
        // Switch back to the login form
        CardLayout cardLayout = (CardLayout) getParent().getLayout();
        cardLayout.show(getParent(), "login");
    }

    // Methods for testing purposes
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

    public void clickSignUpButton() {
        // Simulate a button click
        signUpButton.doClick();
    }

    public void runSignupCode() {
        initializeUI();
    }
}
