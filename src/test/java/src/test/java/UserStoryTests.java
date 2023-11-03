package src.test.java;

import src.main.java.org.classes.UserStory;

import java.util.Objects;

public class UserStoryTests implements ITest{
    public UserStoryTests(){
        test();
    }

    @Override
    public void test(){
        try {
            
            UserStory userStory = new UserStory("title1", "Description1", "AcceptanceCriteria1", 3, 4);
            System.out.println(userStory.getId());
            assert Objects.equals(userStory.getTitle(), "title1");
            assert userStory.getDescription() == "Description1";
            assert userStory.getAcceptanceCriteria() == "AcceptanceCriteria1";
            assert userStory.getBusinessValue() == 3;
            assert userStory.getDeveloperValue() == 4;

            userStory.setTitle("title2");

            assert userStory.getTitle() == "title2";

            userStory.setDescription("Description2");
            assert userStory.getDescription() == "Description2";
            userStory.setAcceptanceCriteria("AcceptanceCriteria2");
            assert userStory.getAcceptanceCriteria() == "AcceptanceCriteria2";
            userStory.setBusinessValue(4);
            assert userStory.getBusinessValue() == 4;
            userStory.setDeveloperValue(5);
            assert userStory.getDeveloperValue() == 5;
            System.out.println("UserStoryTests passed!");


        } catch (Exception e) {
            System.out.println("Error: " + e);
            // TODO: handle exception
        }
    }
}