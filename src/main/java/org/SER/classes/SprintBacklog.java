package org.SER.classes;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.List;

public class SprintBacklog {
    static public int _COUNTER = 0;
    private boolean isComplete = false;
    private List<UserStory> sprintBacklog = new ArrayList<UserStory>();
    private int backlogVelocity;

    // constructors
    public SprintBacklog() {
        backlogVelocity = 0;
        this.sprintBacklog = new ArrayList<UserStory>();
    }

    public SprintBacklog(List<UserStory> userStories, int backlogVelocity) {
        this.backlogVelocity = backlogVelocity;
        this.sprintBacklog = userStories;
        for (UserStory userStory : this.sprintBacklog) {
            userStory.setStatus(Status.TODO);
        }
    }


    // Get SprintBacklog
    public List<UserStory> getsprintBacklog() {
          _COUNTER = Math.max(_COUNTER,getProgress() );
        return this.sprintBacklog;
    }

    public void setBacklogVelocity(int backlogVelocity) {
        this.backlogVelocity = backlogVelocity;
    }

    public int getBacklogVelocity() {
        return this.backlogVelocity;
    }

    // get Total Business Value
    public int getTotalBusinessValue() {
        int totalBusinessValue = 0;
        for (UserStory userStory : this.sprintBacklog) {
            totalBusinessValue += userStory.getBusinessValue();
        }
        return totalBusinessValue;
    }

    // get Total Developer Value
    public int getTotalDeveloperValue() {
        int totalDeveloperValue = 0;
        for (UserStory userStory : this.sprintBacklog) {
            totalDeveloperValue += userStory.getDeveloperValue();
        }
        return totalDeveloperValue;
    }

    // Update Status
    public void updateStatus(int id, Status status) {
        UserStory userStory = UserStory.getUserStory(this.sprintBacklog, id);
        userStory.setStatus(status);
    }

    public void PushChangetoDatabase(int id, Status prev, Status curr) {

    }

    // progress
    public int getProgress() {
        int progress = 0;
        for (UserStory userStory : this.sprintBacklog) {
            if (userStory.getStatus() == Status.DONE) {
                progress += userStory.getDeveloperValue();
            }
        }
        return progress * 100 / this.getTotalDeveloperValue();
    }

    // Get UserStory by id
    public UserStory getUserStory(int id) {
        return UserStory.getUserStory(this.sprintBacklog, id);
    }

    // add User story
    public void addUserStory(UserStory userStory) {
        userStory.setStatus(Status.TODO);
        this.sprintBacklog.add(userStory);
    }

    public void addUserStory(List<UserStory> userStories) {
        for (UserStory userStory : userStories) {
            userStory.setStatus(Status.TODO);
        }
        this.sprintBacklog.addAll(userStories);
    }

    public List<UserStory> getUserStoriesbyStatus(Status status) {
        List<UserStory> userStories = new ArrayList<UserStory>();
        for (UserStory userStory : this.sprintBacklog) {
            if (userStory.getStatus() == status) {
                userStories.add(userStory);
            }
        }

        return userStories;
    }

    // remove User story
    //make sure to handle Status if user story is not in the list
    public void removeUserStory(UserStory userStory) {
        this.sprintBacklog.remove(userStory);
    }

    public void removeUserStory(int id) {
        this.sprintBacklog.remove(UserStory.getUserStory(this.sprintBacklog, id));
    }
  public void transferUnusedUserStories(ProductBacklog productBacklog) {
        List<UserStory> unusedUserStories = new ArrayList<>();
        _COUNTER = 0;
        for (UserStory userStory : this.sprintBacklog) {
            if (!productBacklog.getUserStories().contains(userStory)) {
                userStory.setStatus(Status.NOT_ASSIGNED);
                unusedUserStories.add(userStory);
            }
        }

        this.sprintBacklog.removeAll(unusedUserStories);
        productBacklog.addUserStory(unusedUserStories);
    }



    
}

