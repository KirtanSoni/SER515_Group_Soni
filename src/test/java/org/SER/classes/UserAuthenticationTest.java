package org.SER.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAuthenticationTest {

//    @Test
//    void signUp() {
//        UserAuthentication auth = new UserAuthentication();
//
//        // Test a successful sign-up
//        auth.signUp("test@example.com", "testUser", "password123", UserType.SCRUM_MASTER);
//        assertNotNull(auth.getCurrentUser());
//
//        // Test signing up with the same email (should fail)
//        auth.signUp("test@example.com", "anotherUser", "password456", UserType.DEVELOPER);
//        assertNull(auth.getCurrentUser());
//    }

//    @Test
//    void login() {
//        UserAuthentication auth = new UserAuthentication();
//
//        // Test a successful login
//        auth.signUp("test@example.com", "testUser", "password123", UserType.SCRUM_MASTER);
//        auth.login("test@example.com", "password123");
//        assertNotNull(auth.getCurrentUser());
//
//        // Test login with incorrect password (should fail)
//        auth.login("test@example.com", "wrongPassword");
//        assertNull(auth.getCurrentUser());
//
//        // Test login with non-existing email (should fail)
//        auth.login("nonexistent@example.com", "password123");
//        assertNull(auth.getCurrentUser());
//    }

    @Test
    void logout() {
        UserAuthentication auth = new UserAuthentication();

        // Test logout when no user is logged in
        auth.logout();
        assertNull(auth.getCurrentUser());

        // Test logout when a user is logged in
        auth.signUp("test@example.com", "testUser", "password123", UserType.DEVELOPER);
        auth.login("test@example.com", "password123");
        auth.logout();
        assertNull(auth.getCurrentUser());
    }

    @Test
    void getCurrentUser() {
        UserAuthentication auth = new UserAuthentication();

        // Test getCurrentUser when no user is logged in
        assertNull(auth.getCurrentUser());

        // Test getCurrentUser after login
        auth.signUp("test@example.com", "testUser", "password123", UserType.DEVELOPER);
        auth.login("test@example.com", "password123");
        assertNotNull(auth.getCurrentUser());
    }
}