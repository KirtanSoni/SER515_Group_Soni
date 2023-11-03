package src.test.java;

import src.main.java.org.classes.DBOperations;

public class DBTest {
    public static void main(String[] args) {
        DBOperations.addUserStory(2, "c", "a", "b", 1, 2);
        System.out.println(DBOperations.getUserStoryById(2));
        System.out.println(DBOperations.getAllUserStories());
        DBOperations.updateDocument();
        DBOperations.deleteUserStoryById(1);
        // DBOperations.deleteAll();
    }
}
