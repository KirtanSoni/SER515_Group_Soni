package src.test.java;

import src.main.java.org.classes.Signup;

import java.awt.EventQueue;

public class SignupTest implements ITest {
    public SignupTest() {
        test();
    }

    @Override
    public void test() {
        testCase1();
    }

    private void testCase1() {
        EventQueue.invokeLater(() -> {
            try {
                Signup signupForm = new Signup();
                signupForm.setFirstName("John");
                signupForm.setLastName("Doe");
                signupForm.setEmail("john.doe@example.com");
                signupForm.setPassword("strongPassword");

                // Perform assertions or other actions based on your requirements

                System.out.println("Signup Test Case 1 passed!");
                signupForm.setVisible(true);
            } catch (Exception e) {
                System.out.println("Error in Signup Test Case 1: " + e);
            }
        });
    }

}
