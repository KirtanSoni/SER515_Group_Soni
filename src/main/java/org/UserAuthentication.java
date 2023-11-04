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

        // Create a new user and add them to the list
        User newUser = new User(email, username, password, userType);
        users.add(newUser);
        System.out.println("User signed up successfully.");
    }

    public void login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
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
}
