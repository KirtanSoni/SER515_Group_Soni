package org.classes;


public class UserStory {
    private String Title;
    private String Description;
    private String AcceptanceCriteria;
    private String BusinessValue;
    private String DeveloperValue;
    public UserStory(String Title, String Description, String AcceptanceCriteria, String BusinessValue, String DeveloperValue){
        this.Title = Title;
        this.Description = Description;
        this.AcceptanceCriteria = AcceptanceCriteria;
        this.BusinessValue = BusinessValue;
        this.DeveloperValue = DeveloperValue;
    }


    // Getters
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

    // Setters
    public void setTitle(String Title){
        this.Title = Title;
    }
    public void setDescription(String Description){
        this.Description = Description;
    }
    public void setAcceptanceCriteria(String AcceptanceCriteria){
        this.AcceptanceCriteria = AcceptanceCriteria;
    }
    public void setBusinessValue(String BusinessValue){
        this.BusinessValue = BusinessValue;
    }
    public void setDeveloperValue(String DeveloperValue){
        this.DeveloperValue = DeveloperValue;
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