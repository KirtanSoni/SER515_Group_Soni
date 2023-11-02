package org.classes;

import java.util.List;

public class UserStory {
    static public int _COUNTER = 0;
    
    private int id;
    private String Title;
    private String Description;
    private String AcceptanceCriteria;
    private String BusinessValue;
    private String DeveloperValue;
    public UserStory(String title, String description, String acceptanceCriteria, String businessValue, String developerValue){
        this.id = _COUNTER++;
        this.Title = title;
        this.Description = description;
        this.AcceptanceCriteria = acceptanceCriteria;
        this.BusinessValue = businessValue;
        this.DeveloperValue = developerValue;
    }


    // Getters
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.Title;
    }
    public String getDescription(){
        return this.Description;
    }
    public String getAcceptanceCriteria(){
        return this.AcceptanceCriteria;
    }
    public String getBusinessValue(){
        return this.BusinessValue;
    }
    public String getDeveloperValue(){
        return this.DeveloperValue;
    }

    // Static getter Methods

    static public UserStory getUserStory(List<UserStory> userStories, int id){
        for(UserStory userStory : userStories){
            if(userStory.getId() == id){
                return userStory;
            }
        }
        return null;
    }

    // Setters
    public void setTitle(String title){
        this.Title = title;
    }
    public void setDescription(String description){
        this.Description = description;
    }
    public void setAcceptanceCriteria(String acceptanceCriteria){
        this.AcceptanceCriteria =  acceptanceCriteria;
    }
    public void setBusinessValue(String businessValue){
        this.BusinessValue = businessValue;
    }
    public void setDeveloperValue(String developerValue){
        this.DeveloperValue = developerValue;
    }

    //edit UserStory
    public void editUserStory(String title, String description, String acceptanceCriteria, String businessValue, String developerValue){
        this.Title = title;
        this.Description = description;
        this.AcceptanceCriteria = acceptanceCriteria;
        this.BusinessValue = businessValue;
        this.DeveloperValue = developerValue;
    }
    public void editUserStoryTitle(String title){
        this.Title = title;
    }
    public void editUserStoryDescription(String description){
        this.Description = description;
    }
    public void editUserStoryAcceptanceCriteria(String acceptanceCriteria){
        this.AcceptanceCriteria = acceptanceCriteria;
    }
    public void editUserStoryBusinessValue(String businessValue){
        this.BusinessValue = businessValue;
    }
    public void editUserStoryDeveloperValue(String developerValue){
        this.DeveloperValue = developerValue;
    }

    // toString - Debugging
    @Override
    public String toString() {
        return "UserStory{" +
                "Title='" + Title + '\'' +
                ", Description='" + Description + '\'' +
                ", AcceptanceCriteria='" + AcceptanceCriteria + '\'' +
                ", BusinessValue='" + BusinessValue + '\'' +
                ", DeveloperValue='" + DeveloperValue + '\'' +
                '}';
    }

    
}