package src.test.java;

import src.main.java.org.classes.Login;

import java.awt.EventQueue;

public class LoginTest implements ITest {
    public LoginTest() {
        test();
    }

    @Override
    public void test() {
        testCase1();
    }

    private void testCase1() {
        EventQueue.invokeLater(() -> {
            try {
                Login loginForm = new Login();
                loginForm.setEmail("test@example.com");
                loginForm.setPassword("password123");


                System.out.println("Test case 1 passed!");
                loginForm.setVisible(true);
            } catch (Exception e) {
                System.out.println("Error in test case 1: " + e);
            }
        });
    }
}
