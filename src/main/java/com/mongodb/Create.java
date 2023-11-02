package com.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Create {

    private static MongoClient mongoClient = MongoClients.create("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/");
    private static MongoDatabase database = mongoClient.getDatabase("test");
    private static MongoCollection<Document> userStoryCollection = database.getCollection("UserStory");

    public static void addUserStory(Document userStoryDocument) {
        userStoryCollection.insertOne(userStoryDocument);
    }

    public static class CreateUtils {

        public static void main(String[] args) {
            // Create a dummy user story.
            Document userStoryDocument = new Document();
            userStoryDocument.put("_id", 2);
            userStoryDocument.put("title1", "Dummy User Story3");
            userStoryDocument.put("description", "This is a dummy user story3.");
            userStoryDocument.put("acceptanceCriteria", "The user story must be complete3.");
            userStoryDocument.put("businessValue", 4);
            userStoryDocument.put("developerValue", 3);

            // Add the user story to the database.
            Create.addUserStory(userStoryDocument);
        }
    }
}

