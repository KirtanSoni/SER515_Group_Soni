package com.mongodb;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

public class Read {

    private static MongoClient mongoClient = MongoClients.create("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/");
    private static MongoDatabase database = mongoClient.getDatabase("test");
    private static MongoCollection<Document> userStoryCollection = database.getCollection("UserStory");

    public static Document getUserStoryById(String id) {
        Bson filter = new Document("_id", new Document("$eq", id));
        return userStoryCollection.find(filter).first();
    }

    public static List<Document> getAllUserStories() {
        return userStoryCollection.find().into(new ArrayList<>());
    }
}
