package com.ulab.mongo2;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class Test_HomeWork_2_2 {

	public static void main(String[] args) throws UnknownHostException {
		String id="";
		Integer counter = 0;
		Integer oldCounter = 1;
		DBObject old = null,now;
		MongoClient client = new MongoClient(new ServerAddress("localhost",
				27017));
		DB courseDB = client.getDB("hw2");
		DBCollection numbers = courseDB.getCollection("numbers");
		numbers.drop();
		for (int i = 0; i < 10; i++) {
			numbers.insert(new BasicDBObject("counter", i));
			numbers.insert(new BasicDBObject("counter", i));
		}
		DBObject query = new BasicDBObject();
		DBCursor c = numbers.find(query);
		System.out.println("Total:" + numbers.count());
		while (c.hasNext()) {
			now=c.next();
			counter = (Integer) now.get("counter");
			
			if (oldCounter==counter) {
				System.out.println("removed:" + counter+"-"+now.get("_id"));
				//numbers.remove(new BasicDBObject("_id",now.get("_id")));
				numbers.remove(now);
			} else {
				System.out.println(counter+"-"+now.get("_id"));
			}
			old=now;
			oldCounter=(Integer) old.get("counter");
		}
	}

}
