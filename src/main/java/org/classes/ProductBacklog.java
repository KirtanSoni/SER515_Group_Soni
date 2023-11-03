package src.main.java.org.classes;

import java.util.ArrayList;
import java.util.List;

public class ProductBacklog {
    private List<UserStory> userStories;


//constructors
    public ProductBacklog(){
        this.userStories = new ArrayList<UserStory>();
    }
    public ProductBacklog(List<UserStory> userStories){
        this.userStories = userStories;
    }

//Get UserStories----------------------------------------------------
    public List<UserStory> getUserStories(){
        return this.userStories;
    }
    
//Get UserStories by ids---------------------------------------------
    public List<UserStory> getUserStories(List<Integer> ids){
        List<UserStory> userStories = new ArrayList<UserStory>();
        for(int id : ids){
            userStories.add(UserStory.getUserStory(this.userStories, id));
        }
        return userStories;
    }

//Get UserStory by id-------------------------------------------------
    public UserStory getUserStory(int id){
        return UserStory.getUserStory(this.userStories, id);
    }

//Set UserStories-----------------------------------------------------
    public void setUserStories(List<UserStory> userStories){
        this.userStories = userStories;
    }

//Add UserStory-------------------------------------------------------
    public void addUserStory(UserStory userStory){
        this.userStories.add(userStory);
    }
    public void addUserStory(int index, UserStory userStory){
        this.userStories.add(index, userStory);
    }
    public void addUserStory(List<UserStory> userStories){
        this.userStories.addAll(userStories);
    }


//Remove UserStory----------------------------------------------------
    public void removeUserStory(UserStory userStory){
        this.userStories.remove(userStory);
    }
    public void removeUserStory(int index){
        this.userStories.remove(index);
    }
    public void removeUserStory(List<UserStory> userStories){
        this.userStories.removeAll(userStories);
    }
    
   
    //toString
    @Override
    public String toString() {
        return "ProductBacklog{" +
                "userStories=" + userStories +
                '}';
    }
    
}
