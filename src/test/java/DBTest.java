import com.mongodb.Create;
import com.mongodb.Delete;
import com.mongodb.Read;
import com.mongodb.Update;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.Create.CreateUtils;

import org.bson.Document;
import org.bson.conversions.Bson;

public class DBTest {

    public static void main(String[] args) {
        // Create a dummy user story.
        Document userStoryDocument = new Document();
        // userStoryDocument.put("title", "Dummy User Story");
        // userStoryDocument.put("description", "This is a dummy user story.");
        // userStoryDocument.put("acceptanceCriteria", "The user story must be complete.");
        // userStoryDocument.put("businessValue", 4);
        // userStoryDocument.put("developerValue", 3);

        // // // // Create a new user story.
        // CreateUtils.main(args);

        // // Read the user story from the database.
        // Read read = new Read();
        // Document userStoryDocumentFromDB = read.getUserStoryById("1234567890");

        // // Display the user story to the user.
        // System.out.println(userStoryDocumentFromDB);

        // Update the user story.
        // Document updateDocument = new Document();
        // updateDocument.put("1", "testing");

        Update.updateUserStory(2, new Document());

        // Delete the user story.
        // Delete.deleteUserStoryById(1);
        // Delete.deleteAll();
    }
    public static void updateUserStory(Integer id, Document updateDocument) {
    // Get the user story collection.
    MongoClient mongoClient = MongoClients.create("mongodb+srv://sshah232:ye6yVTzEYA3WdBVj@scrumsimulator.nuu1fks.mongodb.net/");
    MongoDatabase database = mongoClient.getDatabase("test");
    MongoCollection<Document> userStoryCollection = database.getCollection("UserStory");

    // Create a filter to match the user story with the specified ID.
    Bson filter = new Document("_id", new Document("$eq", id));

    // Update the user story document.
    userStoryCollection.updateOne(filter, updateDocument);
}
}

