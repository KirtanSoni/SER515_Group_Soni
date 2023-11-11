package org.SER.classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStoryTest {
    UserStory US ;
    void setUp() {
        US = new UserStory( "title", "description", "acceptanceCriteria", 1, 1);

    }
    @Test
    void getId() {
        setUp();
        assertEquals(1, US.getId());
    }

    @Test
    void getStatus() {
    }

    @Test
    void getTitle() {
    }

    @Test
    void getDescription() {
    }

    @Test
    void getAcceptanceCriteria() {
    }

    @Test
    void getBusinessValue() {
    }

    @Test
    void getDeveloperValue() {
    }

    @Test
    void getUserStory() {
    }

    @Test
    void setStatus() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void setDescription() {
    }

    @Test
    void setAcceptanceCriteria() {
    }

    @Test
    void setBusinessValue() {
    }

    @Test
    void setDeveloperValue() {
    }
}