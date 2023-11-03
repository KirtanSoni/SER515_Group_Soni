package src.test.java;

import src.main.java.org.classes.UserStory;
import src.main.java.org.classes.ProductBacklog;
import src.main.java.org.classes.SprintBacklog;
import src.main.java.org.classes.Status;

import java.util.ArrayList;
import java.util.List;


public class SprintBacklogTests implements ITest {
    public SprintBacklogTests() {
        test();
        System.out.println("SprintBacklogTests passed!");
    }
    @Override
    public void test() {
        UserStory userStory3 = new UserStory("title3", "Description1", "AcceptanceCriteria1", 3, 4);
        UserStory userStory4 = new UserStory("title4", "Description2", "AcceptanceCriteria2", 4,5);
        UserStory userStory5 = new UserStory("title5", "Description3", "AcceptanceCriteria3", 5, 6);
        UserStory userStory6 = new UserStory("title6", "Description4", "AcceptanceCriteria4", 6, 7);
        List<UserStory> userStories = new ArrayList<>();
        userStories.add(userStory3);
        userStories.add(userStory4);
        userStories.add(userStory5);

        SprintBacklog sprintBacklog = new SprintBacklog();
        sprintBacklog.setBacklogVelocity(10);
        sprintBacklog.addUserStory(userStories);
        sprintBacklog.addUserStory(userStory6);
        sprintBacklog.updateStatus(userStory4.getId(), Status.IN_PROGRESS);
        assert sprintBacklog.getBacklogVelocity()==10;
        assert sprintBacklog.getTotalBusinessValue()==18;
        assert sprintBacklog.getTotalDeveloperValue()==22;
        assert sprintBacklog.getUserStory(userStory4.getId()).getTitle().equals(userStory4.getTitle());

        sprintBacklog.updateStatus(userStory4.getId(), Status.DONE);

        assert sprintBacklog.getProgress()==22;


    }
}
