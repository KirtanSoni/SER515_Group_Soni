package org.SER.classes;



public class Helpers {
    public static void Move(UserStory userStory, ProductBacklog productBacklog, SprintBacklog sprintBacklog) {
        productBacklog.removeUserStory(userStory);
        userStory.setStatus(Status.TODO);
        sprintBacklog.addUserStory(userStory);
    }
    public static void Move(UserStory userStory, SprintBacklog sprintBacklog, ProductBacklog productBacklog) {
        sprintBacklog.removeUserStory(userStory);
        userStory.setStatus(Status.NOT_ASSIGNED);
        productBacklog.addUserStory(userStory);
    }
}