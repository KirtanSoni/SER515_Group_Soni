package org.SER.classes;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


class UserManagementTest {

    @Test
    void addUser() {
        // Arrange
        UserManagement userManagement = new UserManagement();
        User user = new User("john@example.com", "JohnDoe", "password123", UserType.DEVELOPER);

        // Act
        userManagement.addUser(user);

        // Assert
        assertTrue(userManagement.getAllUsers().contains(user));
    }

    @Test
    void removeUser() {
        // Arrange
        UserManagement userManagement = new UserManagement();
        User user = new User("john@example.com", "JohnDoe", "password123", UserType.DEVELOPER);
        userManagement.addUser(user);

        // Act
        userManagement.removeUser(user);

        // Assert
        assertFalse(userManagement.getAllUsers().contains(user));
    }

    @Test
    void getUserByEmail() {
        // Arrange
        UserManagement userManagement = new UserManagement();
        User user = new User("john@example.com", "JohnDoe", "password123", UserType.DEVELOPER);
        userManagement.addUser(user);

        // Act
        User retrievedUser = userManagement.getUserByEmail("john@example.com");

        // Assert
        assertEquals(user, retrievedUser);
    }

    @Test
    void getUserByUsername() {
        // Arrange
        UserManagement userManagement = new UserManagement();
        User user = new User("john@example.com", "JohnDoe", "password123", UserType.DEVELOPER);
        userManagement.addUser(user);

        // Act
        User retrievedUser = userManagement.getUserByUsername("JohnDoe");

        // Assert
        assertEquals(user, retrievedUser);
    }

    @Test
    void getUserByUserType() {
        // Arrange
        UserManagement userManagement = new UserManagement();
        User developer = new User("john@example.com", "JohnDoe", "password123", UserType.DEVELOPER);
        User productOwner = new User("jane@example.com", "JaneDoe", "password456", UserType.PRODUCT_OWNER);
        userManagement.addUser(developer);
        userManagement.addUser(productOwner);

        // Act
        List<User> developers = userManagement.getUserByUserType(UserType.DEVELOPER);
        List<User> productOwners = userManagement.getUserByUserType(UserType.PRODUCT_OWNER);

        // Assert
        assertTrue(developers.contains(developer));
        assertFalse(developers.contains(productOwner));
        assertTrue(productOwners.contains(productOwner));
        assertFalse(productOwners.contains(developer));
    }

    @Test
    void getAllUsers() {
        // Arrange
        UserManagement userManagement = new UserManagement();
        User user1 = new User("john@example.com", "JohnDoe", "password123", UserType.DEVELOPER);
        User user2 = new User("jane@example.com", "JaneDoe", "password456", UserType.PRODUCT_OWNER);
        userManagement.addUser(user1);
        userManagement.addUser(user2);

        // Act
        List<User> allUsers = userManagement.getAllUsers();

        // Assert
        assertTrue(allUsers.contains(user1));
        assertTrue(allUsers.contains(user2));
    }
}
