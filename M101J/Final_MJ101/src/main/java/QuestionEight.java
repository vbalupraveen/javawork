import java.io.IOException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class QuestionEight {
	public static void main(String[] args) throws IOException {
		MongoClient c = new MongoClient(new MongoClientURI(
				"mongodb://localhost"));
		DB db = c.getDB("test");
		DBCollection animals = db.getCollection("animals");
		animals.drop();

		//BasicDBObject animal = new BasicDBObject("animal", "monkey");
		BasicDBObject animal = new BasicDBObject("animal", "monkey");

		 animals.insert(animal);
         animal.removeField("animal");
         /*animal.append("animal", "cat");
         animals.insert(animal);
         animal.removeField("animal");
         animal.append("animal", "lion");
         animals.insert(animal);*/
		DBCursor cursor = animals.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}

	}

}