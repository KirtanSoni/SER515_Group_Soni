import java.util.Arrays;
import java.util.List;

import org.classes.ProductBacklog;
import org.classes.UserStory;
public class ProductBacklogTests {
    public ProductBacklogTests(){
       objTest();
    }
    void objTest(){
         ProductBacklog productBacklog = new ProductBacklog();
        assert productBacklog.getUserStories().size() == 0;

        //creating 3 user stories
        UserStory userStory1 = new UserStory("title1", "Description1", "AcceptanceCriteria1", "BusinessValue1", "DeveloperValue1");
        UserStory userStory2 = new UserStory("title2", "Description2", "AcceptanceCriteria2", "BusinessValue2", "DeveloperValue2");
        UserStory userStory3 = new UserStory("title3", "Description3", "AcceptanceCriteria3", "BusinessValue3", "DeveloperValue3");

        //adding user stories to product backlog
        productBacklog.addUserStory(userStory1);
        List<UserStory> userStories = Arrays.asList(userStory2, userStory3);
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
