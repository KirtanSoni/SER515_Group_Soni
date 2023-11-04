package src.test.java;

import java.util.List;

import org.bson.Document;
import src.main.java.org.classes.DBOperations;
import src.main.java.org.classes.UserStory;

public class DBTest implements ITest{

    public DBTest(){
        test();
        System.out.println("DBTest passed!");
    }
    @Override
    public void test() {
        UserStory userStory1 = new UserStory("title1", "Description1", "AcceptanceCriteria1", 3, 4);
        DBOperations dbOperations = new DBOperations("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/", "test", "UserStory");
        dbOperations.addUserStory(userStory1);
        Document userStory = dbOperations.getUserStoryById(userStory1.getId());
        List<Document> allUserStories = dbOperations.getAllUserStories();
        System.out.println(allUserStories);
//        dbOperations.deleteUserStoryById(userStory1.getId());
//        dbOperations.deleteAll();
    }
}
