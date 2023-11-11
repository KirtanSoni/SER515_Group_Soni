package org.SER.classes;
import java.util.List;


public class UserStory {
    static public int _COUNTER = 0;
    private final int id;
    private String Title;
    private Status status ;
    private String Description;
    private String AcceptanceCriteria;
    private int BusinessValue;
    private int DeveloperValue;


// constructors --------------------------------------------------------
    public UserStory(String title, String description, String acceptanceCriteria, int businessValue, int developerValue){
        this.id = _COUNTER+1;
        _COUNTER++;
        this.status = Status.NOT_ASSIGNED;
        this.Title = title;
        this.Description = description;
        this.AcceptanceCriteria = acceptanceCriteria;
        this.BusinessValue = businessValue;
        this.DeveloperValue = developerValue;
    }

// Getters ---------------------------------------------------------
    public int getId(){
        return this.id;
    }
    public Status getStatus() { return this.status; }
    public String getTitle(){
        return this.Title;
    }
    public String getDescription(){
        return this.Description;
    }
    public String getAcceptanceCriteria(){
        return this.AcceptanceCriteria;
    }
    public int getBusinessValue(){
        return this.BusinessValue;
    }
    public int getDeveloperValue(){
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

// Setters ---------------------------------------------------------
    public void setStatus(Status status) { this.status = status;}
    public void setTitle(String title){
        this.Title = title;
    }
    public void setDescription(String description){
        this.Description = description;
    }
    public void setAcceptanceCriteria(String acceptanceCriteria){
        this.AcceptanceCriteria =  acceptanceCriteria;
    }
    public void setBusinessValue(int businessValue){
        this.BusinessValue = businessValue;
    }
    public void setDeveloperValue(int developerValue){
        this.DeveloperValue = developerValue;
    }

//edit UserStory ---------------------------------------------------------
    public void editUserStory(String title, String description, String acceptanceCriteria, int businessValue, int developerValue){
        this.Title = title;
        this.Description = description;
        this.AcceptanceCriteria = acceptanceCriteria;
        this.BusinessValue = businessValue;
        this.DeveloperValue = developerValue;
    }

// add db functionality.
//    public void updateUserStory(Status status,DBOperations DB){
//        if (this.status.ordinal()<status.ordinal()){
//            DB.UpgradeStatus(this.id,status);
//        }
//        else if(this.status.ordinal()>status.ordinal())
//        {
//            DB.DowngradeStatus(this.id,status);
//        }
//    }

    public void editUserStoryTitle(String title){
        this.Title = title;
    }
    public void editUserStoryDescription(String description){
        this.Description = description;
    }
    public void editUserStoryAcceptanceCriteria(String acceptanceCriteria){ this.AcceptanceCriteria = acceptanceCriteria; }
    public void editUserStoryBusinessValue(int businessValue){
        this.BusinessValue = businessValue;
    }
    public void editUserStoryDeveloperValue(int developerValue){
        this.DeveloperValue = developerValue;
    }





    // toString - Debugging ---------------------------------------------------------
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