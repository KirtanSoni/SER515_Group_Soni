package com.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Update {

    public static void main(String[] args) {
        // Get a MongoClient instance.
        MongoClient mongoClient = MongoClients.create("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/");

        // Get the test database.
        MongoDatabase database = mongoClient.getDatabase("test");

        // Get the UserStory collection.
        MongoCollection<Document> userStoryCollection = database.getCollection("UserStory");

        // Create a filter to match the document to update.
        Bson filter = new Document("_id", new Document("$eq", "1"));

        // Create an update document.
        Document updateDocument = new Document();
        updateDocument.put("title", "New Title");

        // Update the document in the database.
        userStoryCollection.updateOne(filter, updateDocument);

        // Close the MongoClient.
        mongoClient.close();
    }
    
    public static void updateUserStory(int id, Document updateDocument) {
        // TODO: Implement this method.
      }
      
}