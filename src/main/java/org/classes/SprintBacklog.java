package org.classes;

import java.util.ArrayList;
import java.util.List;

public class SprintBacklog {
    private List<UserStory> sprintBacklog;

// constructors
    public SprintBacklog(){
        this.sprintBacklog = new ArrayList<UserStory>();
    }
    public SprintBacklog(List<UserStory> userStories){
        this.sprintBacklog = userStories;
    }

// Get SprintBacklog
    public List<UserStory> sprintBacklog(){
        return this.sprintBacklog;
    }

// Get UserStory by id
    public UserStory getUserStory(int id){
       return UserStory.getUserStory(this.sprintBacklog, id);
    }
// add User story
    public void addUserStory(UserStory userStory){
        this.sprintBacklog.add(userStory);
    }
    public void addUserStory(List<UserStory> userStories){
        this.sprintBacklog.addAll(userStories);
    }
// remove User story
    public void removeUserStory(UserStory userStory){
        this.sprintBacklog.remove(userStory);
    }
    public void removeUserStory(int id){
        this.sprintBacklog.remove(UserStory.getUserStory(this.sprintBacklog, id));
    }

}
