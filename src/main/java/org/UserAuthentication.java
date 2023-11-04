import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class UserAuthentication {
    private List<User> users;
    private User currentUser;

    public UserAuthentication() {
        this.users = new ArrayList<>();
        this.currentUser = null;
    }

    public void signUp(String email, String username, String password, UserType userType) {
        // Check if the email is already in use
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                System.out.println("Email is already in use. Please choose another.");
                return;
            }
        }

        // Hash the password using SHA-256 before storing
        String hashedPassword = hashPasswordSHA256(password);

        // Create a new user and add them to the list with the hashed password
        User newUser = new User(email, username, hashedPassword, userType);
        users.add(newUser);
        System.out.println("User signed up successfully.");
    }

    public void login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && verifyPasswordSHA256(password, user.getPassword())) {
                currentUser = user;
                System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
                return;
            }
        }
        System.out.println("Invalid login credentials.");
    }

    public void logout() {
        if (currentUser != null) {
            System.out.println(currentUser.getUsername() + " logged out.");
            currentUser = null;
        } else {
            System.out.println("No user is currently logged in.");
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // Function to hash the password using SHA-256
    private String hashPasswordSHA256(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder(2 * hash.length);

            for (byte b : hash) {
                String hex = Integer.toHexString(0xFF & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Function to verify a password using SHA-256
    private boolean verifyPasswordSHA256(String inputPassword, String hashedPassword) {
        return hashPasswordSHA256(inputPassword).equals(hashedPassword);
    }
}
