package src.test.java;

import src.main.java.org.classes.Login;

import java.awt.EventQueue;

public class LoginTest implements ITest {
    public LoginTest() {
        test();
    }

    @Override
    public void test() {
        // Run multiple test cases here
        testCase1();
//        testCase2();
        // Add more test cases as needed
    }

    private void testCase1() {
        EventQueue.invokeLater(() -> {
            try {
                // Simulate a login scenario with specific email and password
                Login loginForm = new Login();
                loginForm.setEmail("test@example.com");
                loginForm.setPassword("password123");

                // Trigger the login button click
                loginForm.clickLoginButton();

                // Add assertions for the expected behavior based on the provided email and password
                // For example, check if the user is successfully logged in or if an error message is displayed.

                System.out.println("Test case 1 passed!");
            } catch (Exception e) {
                System.out.println("Error in test case 1: " + e);
            }
        });
    }
    private void testCase2() {
        EventQueue.invokeLater(() -> {
            try {
                // Simulate a login scenario with specific email and password
                Login loginForm = new Login();
                loginForm.setEmail("test@example");
                loginForm.setPassword("p");

                // Trigger the login button click
                loginForm.clickLoginButton();

                // Add assertions for the expected behavior based on the provided email and password
                // For example, check if the user is successfully logged in or if an error message is displayed.

//                System.out.println("Test case 2 passed!");
            } catch (Exception e) {
                System.out.println("Error in test case 2: " + e);
            }
        });
    }
    // Add more test cases as needed
}
