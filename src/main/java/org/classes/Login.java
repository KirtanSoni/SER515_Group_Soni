package src.main.java.org.classes;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Login extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Login() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(110, 110, 806, 532);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Calibri", Font.BOLD, 18));

        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        contentPane.add(emailLabel, c);

        c.gridx = 1;
        contentPane.add(emailField, c);

        c.gridx = 0;
        c.gridy = 1;
        contentPane.add(passwordLabel, c);

        c.gridx = 1;
        contentPane.add(passwordField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        contentPane.add(loginButton, c);

        // Add action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (isValidEmail(email)) {
                    if (isValidPassword(password)) {
                        System.out.println("Email and password are valid");
                    } else {
                        JOptionPane.showMessageDialog(contentPane, "Invalid password");
                    }
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Invalid email address");
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        return Pattern.compile(emailPattern).matcher(email).matches();
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8;
    }

    public void setEmail(String email) {
        emailField.setText(email);
    }

    public void setPassword(String password) {
        passwordField.setText(password);
    }

    public void clickLoginButton() {
        // Simulate a button click
        System.out.println(passwordField);
        System.out.println(emailField);

        loginButton.doClick();
    }
}
