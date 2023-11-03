package src.test.java;

import java.awt.EventQueue;
import src.main.java.org.classes.Backlog;

public class BacklogTests implements ITest {
    public BacklogTests() {
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
                Object[][] userStories = {
                        {"User Story 1: As a user, I want...", 5, 5, "Edit", "Delete"},
                        {"User Story 2: As a user, I want...", 11, 3, "Edit", "Delete"},
                        // Define user stories for test case 1
                };

                Backlog backlog = new Backlog(userStories);

                backlog.setVisible(true);
                System.out.println("Test case 1 passed!");
            } catch (Exception e) {
                System.out.println("Error in test case 1: " + e);
            }
        });
    }

    private void testCase2() {
        EventQueue.invokeLater(() -> {
            try {
                Object[][] userStories = {
                        // Define different user stories for test case 2
                };

                Backlog backlog = new Backlog(userStories);

                backlog.setVisible(true);
                System.out.println("Test case 2 passed!");
            } catch (Exception e) {
                System.out.println("Error in test case 2: " + e);
            }
        });
    }

    // Add more test cases as needed
}
