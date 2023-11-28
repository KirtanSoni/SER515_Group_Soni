package org.SER.classes;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScrumGame {
    ProductBacklog productbacklog;
    List<SprintBacklog> Sprints;

    public static List<UserStory> viewProductBacklog() {
        List<UserStory> userStories = new ArrayList<>();

        try (MongoClient mongoClient = MongoClients.create("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/")) {
            MongoDatabase database = mongoClient.getDatabase("test");
            MongoCollection<Document> userStoryCollection = database.getCollection("UserStory");


            for (Document document : userStoryCollection.find()) {
                System.out.println("Test");
                UserStory userStory = new UserStory(
//                        document.getInteger("id"),
                        document.getString("title"),
                        document.getString("description"),
                        document.getString("acceptanceCriteria"),
                        document.getInteger("businessValue"),
                        document.getInteger("developerValue")
                );
                userStories.add(userStory);
            }

        }
        ProductBacklog productBacklog = new ProductBacklog(userStories);
        Backlog backlogFrame = new Backlog(productBacklog,null);
        backlogFrame.setVisible(true);
        return userStories;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        viewProductBacklog();
    }


}
