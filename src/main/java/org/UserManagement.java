import java.util.ArrayList;
import java.util.List;

class UserManagement {
    private List<User> users;

    public UserManagement() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    public User getUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null; // User not found
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null; // User not found
    }

    public List<User> getUserByUserType(UserType userType) {
        List<User> usersByType = new ArrayList<>();
        for (User user : users) {
            if (user.getUserType() == userType) {
                usersByType.add(user);
            }
        }
        return usersByType;
    }

    public List<User> getAllUsers() {
        return users;
    }
}
