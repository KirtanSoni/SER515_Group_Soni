package src.test.java;

import java.util.List;
import src.main.java.org.classes.ProductBacklog;
import src.main.java.org.classes.UserStory;

public class ProductBacklogTests implements ITest{
    public ProductBacklogTests(){
       test();
    }
    @Override
    public void test(){
         ProductBacklog productBacklog = new ProductBacklog();
        assert productBacklog.getUserStories().isEmpty();

        //creating 3 user stories
        UserStory userStory1 = new UserStory("title1", "Description1", "AcceptanceCriteria1", 4, 5);
        UserStory userStory2 = new UserStory("title2", "Description2", "AcceptanceCriteria2", 5, 6);
        UserStory userStory3 = new UserStory("title3", "Description3", "AcceptanceCriteria3", 6, 7);

        //adding user stories to product backlog
        productBacklog.addUserStory(userStory1);
        List<UserStory> userStories = List.of(userStory2, userStory3);
        productBacklog.addUserStory(userStories);

        //testing getters
        assert (productBacklog.getUserStories().size() == 3);
        assert productBacklog.getUserStories().get(0) == userStory1;
        assert productBacklog.getUserStories().get(1) == userStory2;
        assert productBacklog.getUserStories().get(2) == userStory3;

        //testing setters ( replacing user stories with new ones)
        productBacklog.setUserStories(userStories);
        assert productBacklog.getUserStories().size()==2;
        assert productBacklog.getUserStories().get(0) == userStory2;
        assert productBacklog.getUserStories().get(1) == userStory3;



        
        System.out.println("ProductBacklogTests passed!");

    }
}