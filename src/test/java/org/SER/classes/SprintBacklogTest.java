package org.SER.classes;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SprintBacklogTest {

    @Test
    void getsprintBacklog() {
        // Arrange
        List<UserStory> userStories = new ArrayList<>();
        userStories.add(new UserStory("Story 1", "Description 1", "Acceptance Criteria 1", 5, 3));
        SprintBacklog sprintBacklog = new SprintBacklog(userStories, 0);

        // Act
        List<UserStory> result = sprintBacklog.getsprintBacklog();

        // Assert
        assertEquals(userStories, result);
    }

    @Test
    void setBacklogVelocity() {
        // Arrange
        SprintBacklog sprintBacklog = new SprintBacklog();

        // Act
        sprintBacklog.setBacklogVelocity(10);

        // Assert
        assertEquals(10, sprintBacklog.getBacklogVelocity());
    }

    @Test
    void getBacklogVelocity() {
        // Arrange
        SprintBacklog sprintBacklog = new SprintBacklog();
        sprintBacklog.setBacklogVelocity(15);

        // Act
        int result = sprintBacklog.getBacklogVelocity();

        // Assert
        assertEquals(15, result);
    }

    @Test
    void getTotalBusinessValue() {
        // Arrange
        List<UserStory> userStories = new ArrayList<>();
        userStories.add(new UserStory("Story 1", "Description 1", "Acceptance Criteria 1", 5, 3));
        userStories.add(new UserStory("Story 2", "Description 2", "Acceptance Criteria 2", 8, 4));
        SprintBacklog sprintBacklog = new SprintBacklog(userStories, 0);

        // Act
        int totalBusinessValue = sprintBacklog.getTotalBusinessValue();

        // Assert
        assertEquals(13, totalBusinessValue);
    }

    @Test
    void getTotalDeveloperValue() {
        // Arrange
        List<UserStory> userStories = new ArrayList<>();
        userStories.add(new UserStory("Story 1", "Description 1", "Acceptance Criteria 1", 5, 3));
        userStories.add(new UserStory("Story 2", "Description 2", "Acceptance Criteria 2", 8, 4));
        SprintBacklog sprintBacklog = new SprintBacklog(userStories, 0);

        // Act
        int totalDeveloperValue = sprintBacklog.getTotalDeveloperValue();

        // Assert
        assertEquals(7, totalDeveloperValue);
    }

    /*
    @Test
    void updateStatus() {
        // Arrange
        List<UserStory> userStories = new ArrayList<>();
        UserStory userStory = new UserStory("Story 1", "Description 1", "Acceptance Criteria 1", 5, 3);
        userStories.add(userStory);
        SprintBacklog sprintBacklog = new SprintBacklog(userStories, 0);

        // Act
        sprintBacklog.updateStatus(1, Status.IN_PROGRESS);

        // Assert
        assertEquals(Status.IN_PROGRESS, userStory.getStatus());
    }
    */

    @Test
    void getProgress() {
        // Arrange
        List<UserStory> userStories = new ArrayList<>();
        userStories.add(new UserStory("Story 1", "Description 1", "Acceptance Criteria 1", 5, 3));
        userStories.add(new UserStory("Story 2", "Description 2", "Acceptance Criteria 2", 8, 4));
        SprintBacklog sprintBacklog = new SprintBacklog(userStories, 0);

        // Act
        int progress = sprintBacklog.getProgress();

        // Assert
        assertEquals(0, progress); // Assuming no stories are marked as DONE initially
    }

    @Test
    void getUserStoriesbyStatus() {
        // Arrange
        List<UserStory> userStories = new ArrayList<>();
        UserStory story1 = new UserStory("Story 1", "Description 1", "Acceptance Criteria 1", 5, 3);
        UserStory story2 = new UserStory("Story 2", "Description 2", "Acceptance Criteria 2", 8, 4);
        userStories.add(story1);
        userStories.add(story2);
        SprintBacklog sprintBacklog = new SprintBacklog(userStories, 0);

        // Act
        List<UserStory> result = sprintBacklog.getUserStoriesbyStatus(Status.TODO);

        // Assert
        assertEquals(userStories, result); // Assuming all stories are initially in TODO status
    }

    @Test
    void removeUserStory() {
        // Arrange
        List<UserStory> userStories = new ArrayList<>();
        UserStory story1 = new UserStory("Story 1", "Description 1", "Acceptance Criteria 1", 5, 3);
        UserStory story2 = new UserStory("Story 2", "Description 2", "Acceptance Criteria 2", 8, 4);
        userStories.add(story1);
        userStories.add(story2);
        SprintBacklog sprintBacklog = new SprintBacklog(userStories, 0);

        // Act
        sprintBacklog.removeUserStory(story1);

        // Assert
        assertFalse(sprintBacklog.getsprintBacklog().contains(story1));
    }

    /*
    @Test
    void getUserStory() {
        // Arrange
        List<UserStory> userStories = new ArrayList<>();
        UserStory story1 = new UserStory("Story 1", "Description 1", "Acceptance Criteria 1", 5, 3);
        UserStory story2 = new UserStory("Story 2", "Description 2", "Acceptance Criteria 2", 8, 4);
        userStories.add(story1);
        userStories.add(story2);
        SprintBacklog sprintBacklog = new SprintBacklog(userStories, 0);

        // Act
        UserStory result = sprintBacklog.getUserStory(1);

        // Assert
        assertEquals(story1, result);
    }
    */
}