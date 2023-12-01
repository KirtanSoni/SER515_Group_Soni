package org.SER.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// import java.util.ArrayList;
// import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserStoryTest {
    UserStory US;

    @BeforeEach
    void setUp() {
        US = new UserStory("title", "description", "acceptanceCriteria", 1, 1);
    }

    /*
    @Test
    void getId() {
        setUp();
        assertEquals(1, US.getId());
    }
    */

    @Test
    void getStatus() {
        assertEquals(Status.NOT_ASSIGNED, US.getStatus());
    }

    @Test
    void getTitle() {
        assertEquals("title", US.getTitle());
    }

    @Test
    void getDescription() {
        assertEquals("description", US.getDescription());
    }

    @Test
    void getAcceptanceCriteria() {
        assertEquals("acceptanceCriteria", US.getAcceptanceCriteria());
    }

    @Test
    void getBusinessValue() {
        assertEquals(1, US.getBusinessValue());
    }

    @Test
    void getDeveloperValue() {
        assertEquals(1, US.getDeveloperValue());
    }

    /*
    @Test
    void getUserStory() {
        List<UserStory> userStories = new ArrayList<>();
        userStories.add(US);
        assertEquals(US, UserStory.getUserStory(userStories, 1));
    }
    */

    @Test
    void setStatus() {
        setUp();
        US.setStatus(Status.IN_PROGRESS);
        assertEquals(Status.IN_PROGRESS, US.getStatus());
    }

    @Test
    void setTitle() {
        setUp();
        US.setTitle("newTitle");
        assertEquals("newTitle", US.getTitle());
    }

    @Test
    void setDescription() {
        setUp();
        US.setDescription("newDescription");
        assertEquals("newDescription", US.getDescription());
    }

    @Test
    void setAcceptanceCriteria() {
        setUp();
        US.setAcceptanceCriteria("newAcceptanceCriteria");
        assertEquals("newAcceptanceCriteria", US.getAcceptanceCriteria());
    }

    @Test
    void setBusinessValue() {
        setUp();
        US.setBusinessValue(2);
        assertEquals(2, US.getBusinessValue());
    }

    @Test
    void setDeveloperValue() {
        setUp();
        US.setDeveloperValue(2);
        assertEquals(2, US.getDeveloperValue());
    }
}