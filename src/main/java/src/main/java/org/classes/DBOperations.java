package src.main.java.org.classes;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

public class DBOperations {

    private static com.mongodb.client.MongoClient mongoClient = MongoClients.create("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/");
    private static MongoDatabase database = mongoClient.getDatabase("test");
    private static MongoCollection<Document> userStoryCollection = database.getCollection("UserStory");

    public static void addUserStory(int uid, String title, String description, String acceptanceCriteria, int businessValue, int developerValue) {
        Document userStoryDocument = new Document();
        userStoryDocument.put("uid", uid);
        userStoryDocument.put("title", title);
        userStoryDocument.put("description", description);
        userStoryDocument.put("acceptanceCriteria", acceptanceCriteria);
        userStoryDocument.put("businessValue", businessValue);
        userStoryDocument.put("developerValue", developerValue);

        userStoryCollection.insertOne(userStoryDocument);
    }

    public static Document getUserStoryById(int id) {
        Bson filter = new Document("_id", new Document("$eq", id));
        return userStoryCollection.find(filter).first();
    }

    public static List<Document> getAllUserStories() {
        return userStoryCollection.find().into(new ArrayList<>());
    }

    public static void updateDocument() {
        Document filter = new Document("title", "Test1");
        // Define the update operation (e.g., set a new value for a field)
        Document update = new Document("$set", new Document("title", "NewTitle"));
        // Update the document that matches the filter
        userStoryCollection.updateOne(filter, update);
    }

    public static void deleteUserStoryById(int uid) {
        Bson filter = new Document("uid", new Document("$eq", uid));
        userStoryCollection.deleteOne(filter);
    }

    public static void deleteAll() {
        userStoryCollection.drop();
    }
}
