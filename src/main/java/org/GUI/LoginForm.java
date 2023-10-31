package org.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class LoginForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);

        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        JPanel loginPanel = createLoginForm();
        JPanel signUpPanel = new SignUp();

        cardPanel.add(loginPanel, "login");
        cardPanel.add(signUpPanel, "signup");

        // Add the CardLayout panel to the frame
        frame.add(cardPanel);

        JButton signUpButton = new JButton("Don't have an account? Sign Up");

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Switch to the sign-up form
                cardLayout.show(cardPanel, "signup");
            }
        });

        loginPanel.add(signUpButton);

        frame.setVisible(true);
    }

    private static JPanel createLoginForm() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton googleSignInButton = new JButton("Sign in with Google");

        JButton submitButton = new JButton("Submit");

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        panel.add(emailLabel, c);

        c.gridx = 1;
        panel.add(emailField, c);

        c.gridx = 0;
        c.gridy = 1;
        panel.add(passwordLabel, c);

        c.gridx = 1;
        panel.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        panel.add(googleSignInButton, c);

        c.gridy = 3;
        panel.add(submitButton, c);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (isValidEmail(email)) {
                    if (isValidPassword(password)) {
                        System.out.println("Email and password are valid");
                    } else {
                        JOptionPane.showMessageDialog(panel, "Invalid password");
                    }
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid email address");
                }
            }
        });

        return panel;
    }

    private static boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        return Pattern.compile(emailPattern).matcher(email).matches();
    }

    private static boolean isValidPassword(String password) {
        return password.length() >= 8;
    }
}




