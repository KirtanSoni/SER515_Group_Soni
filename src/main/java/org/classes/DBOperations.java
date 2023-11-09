package src.main.java.org.classes;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
public class DBOperations {
    private com.mongodb.client.MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> userStoryCollection;

    public DBOperations(String connectionString, String dbName, String collectionName) {
        mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase(dbName);
        userStoryCollection = database.getCollection(collectionName);
    }

    // Adding/Creating a US in the Database
    public void addUserStory(UserStory US) {
        Document userStoryDocument = new Document();
        userStoryDocument.put("uid", US.getId());
        userStoryDocument.put("title", US.getTitle());
        userStoryDocument.put("description", US.getDescription());
        userStoryDocument.put("acceptanceCriteria", US.getAcceptanceCriteria());
        userStoryDocument.put("businessValue", US.getBusinessValue());
        userStoryDocument.put("developerValue", US.getDeveloperValue());

        userStoryCollection.insertOne(userStoryDocument);
    }

    // To Fetch a US from DB by ID
    public Document getUserStoryById(int id) {
        Bson filter = new Document("_id", id);
        return userStoryCollection.find(filter).first();
    }

    // To fetch all US's from DB
    public List<Document> getAllUserStories() {
        return userStoryCollection.find().into(new ArrayList<>());
    }

    //Updating Document based on a particular field in the DB
    public void updateDocument(String filterField, Object filterValue, String updateField, Object updateValue) {
        Document filter = new Document(filterField, filterValue);
        Document update = new Document("$set", new Document(updateField, updateValue));
        userStoryCollection.updateOne(filter, update);
    }

    //Deleting US by ID from DB
    public void deleteUserStoryById(int uid) {
        Bson filter = new Document("uid", uid);
        userStoryCollection.deleteOne(filter);
    }

    //Deleting all US's
    public void deleteAll() {
        userStoryCollection.drop();
    }
}
