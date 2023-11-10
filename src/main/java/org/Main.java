package org;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Create a UserManagement instance
        UserManagement userManagement = new UserManagement();

        // Create user objects
        User scrumMaster = new User("scrum@example.com", "ScrumMaster123", "password123", UserType.SCRUM_MASTER);
        User developer = new User("developer@example.com", "Developer456", "securePassword", UserType.DEVELOPER);
        User productOwner = new User("owner@example.com", "ProductOwner789", "topSecret", UserType.PRODUCT_OWNER);

        // Add users to UserManagement
        userManagement.addUser(scrumMaster);
        userManagement.addUser(developer);
        userManagement.addUser(productOwner);

        // Test cases using assertions
        assert userManagement.getAllUsers().size() == 3 : "Expected 3 users in UserManagement";
        assert userManagement.getUserByEmail("developer@example.com") == developer : "User not found by email";
        assert userManagement.getUserByUserType(UserType.DEVELOPER).size() == 1 : "Expected 1 developer in UserManagement";
        assert userManagement.getUserByUserType(UserType.SCRUM_MASTER).size() == 1 : "Expected 1 Scrum Master in UserManagement";

        // Remove a user
        userManagement.removeUser(scrumMaster);
        assert userManagement.getAllUsers().size() == 2 : "Expected 2 users after removal";

        UserAuthentication userAuth = new UserAuthentication();

        // Sign up a new user
        userAuth.signUp("user1@example.com", "User1", "password1", UserType.DEVELOPER);

        // Login with valid credentials
        userAuth.login("user1@example.com", "password1");
        assert userAuth.getCurrentUser() != null : "Login failed";

        // Attempt to sign up with the same email (should fail)
        userAuth.signUp("user1@example.com", "User2", "password2", UserType.PRODUCT_OWNER);

        // Attempt to log in with invalid credentials (should fail)
        userAuth.login("user1@example.com", "wrongpassword");
        assert userAuth.getCurrentUser() == null : "Login with invalid credentials succeeded";

        // Logout the current user
        userAuth.logout();
        assert userAuth.getCurrentUser() == null : "Logout failed";

        // Attempt to log out without a user logged in
        userAuth.logout();

        System.out.println("All test cases passed.");
    }
}