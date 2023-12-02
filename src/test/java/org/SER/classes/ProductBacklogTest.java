package org.SER.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductBacklogTest {

    @Test
    void getUserStories() {
        // Arrange
        ProductBacklog productBacklog = new ProductBacklog();
        UserStory userStory1 = new UserStory("User story 1", "As a user, I want...", "Acceptance criteria 1", 3, 5);
        UserStory userStory2 = new UserStory("User story 2", "As a developer, I want...", "Acceptance criteria 2", 2, 4);
        productBacklog.addUserStory(userStory1);
        productBacklog.addUserStory(userStory2);

        // Act
        var result = productBacklog.getUserStories();

        // Assert
        assertEquals(2, result.size());
        assertTrue(result.contains(userStory1));
        assertTrue(result.contains(userStory2));
    }

    /*
    @Test
    void setUserStories() {
        // Arrange
        ProductBacklog productBacklog = new ProductBacklog();
        UserStory userStory1 = new UserStory("User story 1", "As a user, I want...", "Acceptance criteria 1", 3, 5);
        UserStory userStory2 = new UserStory("User story 2", "As a developer, I want...", "Acceptance criteria 2", 2, 4);
        List<UserStory> userStories = List.of(userStory1, userStory2);

        // Act
        productBacklog.setUserStories(userStories);

        // Assert
        assertEquals(userStories, productBacklog.getUserStories());
    }
    */

    @Test
    void addUserStory() {
        // Arrange
        ProductBacklog productBacklog = new ProductBacklog();
        UserStory userStory = new UserStory("User story 1", "As a user, I want...", "Acceptance criteria 1", 3, 5);

        // Act
        productBacklog.addUserStory(userStory);

        // Assert
        assertTrue(productBacklog.getUserStories().contains(userStory));
    }

    @Test
    void removeUserStory() {
        // Arrange
        ProductBacklog productBacklog = new ProductBacklog();
        UserStory userStory = new UserStory("User story 1", "As a user, I want...", "Acceptance criteria 1", 3, 5);
        productBacklog.addUserStory(userStory);

        // Act
        productBacklog.removeUserStory(userStory);

        // Assert
        assertFalse(productBacklog.getUserStories().contains(userStory));
    }

    @Test
    void testToString() {
        // Arrange
        ProductBacklog productBacklog = new ProductBacklog();
        UserStory userStory1 = new UserStory("User story 1", "As a user, I want...", "Acceptance criteria 1", 3, 5);
        UserStory userStory2 = new UserStory("User story 2", "As a developer, I want...", "Acceptance criteria 2", 2, 4);
        productBacklog.addUserStory(userStory1);
        productBacklog.addUserStory(userStory2);

        // Act
        String result = productBacklog.toString();

        // Assert
        assertTrue(result.contains("userStories=" + productBacklog.getUserStories()));
    }
}