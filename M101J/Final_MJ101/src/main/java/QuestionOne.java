import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class QuestionOne {

	public static void main(String[] args) throws UnknownHostException {
		DBObject next;
		DBCursor cursor;
		int i = 0;
		MongoClient client = new MongoClient(new ServerAddress("localhost",
				27017));
		DB courseDB = client.getDB("enron");
		DBCollection messages = courseDB.getCollection("messages");
		DBObject query = new BasicDBObject("headers.From",
				"john.lavorato@enron.com");
		cursor = messages.find(query,
				new BasicDBObject("headers.To", true).append("_id", false));
		try {
			while (cursor.hasNext()) {

				next = cursor.next();
				ArrayList<String> list = (ArrayList<String>) ((DBObject) next
						.get("headers")).get("To");
				if (list.contains("walton3@pjm.com"))
					i++;
			}
		} catch (Exception e) {
			System.out.println("No Objects found.");
		}
		System.out.println("Count:" + i);
	}

}
