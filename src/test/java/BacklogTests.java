package src.test.java;

import java.awt.EventQueue;
import java.util.List;

import src.main.java.org.classes.Backlog;
import src.main.java.org.classes.UserStory;
import src.main.java.org.classes.*;
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
                UserStory userStory1 = new UserStory("title1", "Description1", "AcceptanceCriteria1", 4, 5);
                UserStory userStory2 = new UserStory("title2", "Description2", "AcceptanceCriteria2", 5, 6);
                UserStory userStory3 = new UserStory("title3", "Description3", "AcceptanceCriteria3", 6, 7);

                //adding user stories to product backlog
                ProductBacklog productBacklog = new ProductBacklog();
                productBacklog.addUserStory(userStory1);
                List<UserStory> userStories = List.of(userStory2, userStory3);
                productBacklog.addUserStory(userStories);
                Backlog B = new Backlog(productBacklog);

                B.setVisible(true);
                System.out.println("Test case 1 passed!");
            } catch (Exception e) {
                System.out.println("Error in test case 1: " + e);
            }
        });
    }


    // Add more test cases as needed
}
