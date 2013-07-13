import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

/*
 * The values are already updated, be careful before execute
 */
public class QuestionThree {

	public static void main(String[] args) throws UnknownHostException {
		DBObject next;
		MongoClient client = new MongoClient(new ServerAddress("localhost",
				27017));
		DB courseDB = client.getDB("enron");
		DBCollection messages = courseDB.getCollection("messages");
		DBObject query = new BasicDBObject("headers.Message-ID",
				"<8147308.1075851042335.JavaMail.evans@thyme>");
		DBCursor cursor = messages.find(query, new BasicDBObject("headers.To",
				true).append("header.Message-ID", true).append("_id", false));

		try {
			while (cursor.hasNext()) {
				next = cursor.next();
				ArrayList<String> list = (ArrayList<String>) ((DBObject) next
						.get("headers")).get("To");
				// ----------------
				list.add("mrpotatohead@10gen.com");
				// ----------------
				for (int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i));
				}
				System.out.println(list.size());
				// ----------------
				messages.update(new BasicDBObject("headers.Message-ID",
						"<8147308.1075851042335.JavaMail.evans@thyme>"),
						new BasicDBObject("$set", new BasicDBObject(
								"headers.To", list)), true, false);
				// ----------------
			}
		} catch (Exception e) {
			System.out.println("No Objects found.");
		}
	}

}
