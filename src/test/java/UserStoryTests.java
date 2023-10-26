
import org.classes.UserStory;


public class UserStoryTests {
    public UserStoryTests(){
        testUserStory();
    }
    void testUserStory(){
        try {
            
            UserStory userStory = new UserStory("title1", "Description1", "AcceptanceCriteria1", "BusinessValue1", "DeveloperValue1");
            
            assert userStory.getTitle() == "title1";
            assert userStory.getDescription() == "Description1";
            assert userStory.getAcceptanceCriteria() == "AcceptanceCriteria1";
            assert userStory.getBusinessValue() == "BusinessValue1";
            assert userStory.getDeveloperValue() == "DeveloperValue1";
            userStory.setTitle("title2");
            assert userStory.getTitle() == "title2";
            userStory.setDescription("Description2");
            assert userStory.getDescription() == "Description2";
            userStory.setAcceptanceCriteria("AcceptanceCriteria2");
            assert userStory.getAcceptanceCriteria() == "AcceptanceCriteria2";
            userStory.setBusinessValue("BusinessValue2");
            assert userStory.getBusinessValue() == "BusinessValue2";
            userStory.setDeveloperValue("DeveloperValue2");
            assert userStory.getDeveloperValue() == "DeveloperValue2";
            assert userStory.toString() == "UserStory{Title='title2', Description='Description2', AcceptanceCriteria='AcceptanceCriteria2', BusinessValue='BusinessValue2', DeveloperValue='DeveloperValue2'}";
            System.out.println("UserStoryTests passed!");


        } catch (Exception e) {
            System.out.println("Error: " + e);
            // TODO: handle exception
        }
    }
}
