package src.test.java;

import src.main.java.org.classes.Helpers;
import src.main.java.org.classes.ProductBacklog;
import src.main.java.org.classes.SprintBacklog;
import src.main.java.org.classes.UserStory;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class HelperTest {
    public HelperTest(){
        test();
        System.out.println("HelperTest passed!");
    }
    public void test(){
        UserStory userStory = new UserStory("title1", "Description1", "AcceptanceCriteria1", 3, 4);
        UserStory userStory2 = new UserStory("title2", "Description2", "AcceptanceCriteria2", 4, 5);
        UserStory userStory3 = new UserStory("title3", "Description3", "AcceptanceCriteria3", 5, 6);
        List<UserStory> userStories = new ArrayList<>();
        userStories.add(userStory);
        userStories.add(userStory2);
        userStories.add(userStory3);
        ProductBacklog productBacklog = new ProductBacklog();
        productBacklog.addUserStory(userStories);
        SprintBacklog sprintBacklog = new SprintBacklog();

        Helpers.Move(userStory, productBacklog,sprintBacklog);
        assert productBacklog.getUserStories().size()==2;
        assert sprintBacklog.sprintBacklog().size()==1;

        Helpers.Move(userStory, sprintBacklog, productBacklog);
        assert productBacklog.getUserStories().size()==3;
        assert sprintBacklog.sprintBacklog().size()==0;


    }
}
