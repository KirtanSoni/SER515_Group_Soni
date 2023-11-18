package org.SER.classes;



import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Login extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private final JPanel cardPanel;
//    private final UserAuthentication userAuthentication;

    public Login() {
        setTitle("Login Form");
        setBounds(110, 110, 806, 532);

//        userAuthentication = new UserAuthentication(); // Initialize UserAuthentication

        cardPanel = new JPanel(new CardLayout());
        JPanel loginPanel = createLoginPanel();
        JPanel signupPanel = new Signup();

        cardPanel.add(loginPanel, "login");
        cardPanel.add(signupPanel, "signup");

        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, "login");

        add(cardPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createLoginPanel() {
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Calibri", Font.BOLD, 18));

        JButton signupButton = new JButton("Don't have an account? SignUp");
        signupButton.setFont(new Font("Calibri", Font.PLAIN, 14));

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

        c.gridy = 3;
        contentPane.add(signupButton, c);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            char[] passwordChars = passwordField.getPassword();

            if (isValidEmail(email)) {
                if (isValidPassword(passwordChars)) {
                    HomePage homepage = new HomePage();
                    homepage.setVisible(true);
                    this.dispose();                } else {

                }
                showMessageDialog("Invalid email address");
            }
        });

        signupButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
            cardLayout.show(cardPanel, "signup");
        });

        return contentPane;
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
        return Pattern.compile(emailPattern).matcher(email).matches();
    }

    private boolean isValidPassword(char[] passwordChars) {
        return passwordChars.length >= 8;
    }

    private void login(String email, char[] passwordChars) {

        String password = new String(passwordChars);
        System.out.print("password");
        System.out.println(password);
//        userAuthentication.login(email, password);
//        User currentUser = userAuthentication.getCurrentUser();

//        if (currentUser != null) {
//            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
//            // You can perform additional actions after successful login
//        } else {
//            showMessageDialog("Invalid login credentials.");
//        }
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Methods for testing purposes
    public void setEmail(String email) {
        emailField.setText(email);
    }

    public void setPassword(String password) {
        passwordField.setText(password);
    }
}
