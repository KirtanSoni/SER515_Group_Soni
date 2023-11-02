import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

class User {
    private String email;
    private String username;
    private String password;
    private UserType userType;

    public User(String email, String username, String password, UserType userType) {
        this.email = email;
        this.username = username;
        this.password = hashPassword(password);
        this.userType = userType;
    }

    // Helper method to hash the password using SHA-256
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            Formatter formatter = new Formatter();
            for (byte b : hash) {
                formatter.format("%02x", b);
            }
            return formatter.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                '}';
    }
}

enum UserType {
    SCRUM_MASTER, DEVELOPER, PRODUCT_OWNER
}
