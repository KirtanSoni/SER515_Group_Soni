package org;

public class Main {
    public static void main(String[] args) {
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

        // Display success message if all assertions pass
        System.out.println("All test cases passed.");
    }
}

