package org.classes;

import java.util.ArrayList;
import java.util.List;

public class ProductBacklog {
    private List<UserStory> userStories;


    //contructors
    public ProductBacklog(){
        this.userStories = new ArrayList<UserStory>();
    }
    public ProductBacklog(List<UserStory> userStories){
        this.userStories = userStories;
    }

    //Get UserStories   
    public List<UserStory> getUserStories(){
        return this.userStories;
    }

    //Set UserStories
    public void setUserStories(List<UserStory> userStories){
        this.userStories = userStories;
    }

    //Add UserStory
    public void addUserStory(UserStory userStory){
        this.userStories.add(userStory);
    }
    public void addUserStory(int index, UserStory userStory){
        this.userStories.add(index, userStory);
    }
    public void addUserStory(List<UserStory> userStories){
        this.userStories.addAll(userStories);
    }


    //Remove UserStory
    public void removeUserStory(UserStory userStory){
        this.userStories.remove(userStory);
    }
    public void removeUserStory(int index){
        this.userStories.remove(index);
    }

    //update UserStory
    public void updateUserStory(int index, UserStory userStory){
        this.userStories.set(index, userStory);
    }
    public void updateUserStory(UserStory oldUserStory, UserStory newUserStory){
        this.userStories.set(this.userStories.indexOf(oldUserStory), newUserStory);
    }
    
    //toString
    @Override
    public String toString() {
        return "ProductBacklog{" +
                "userStories=" + userStories +
                '}';
    }
    
}
