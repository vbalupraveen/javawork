package com.ulab.mongo6;

import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.MongoException.DuplicateKey;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class ReplicaSetFailOverTest {

	public static void main(String[] args) throws Exception {
		// multiple nodes
		MongoClient client = new MongoClient(Arrays.asList(new ServerAddress(
				"localhost", 27017), new ServerAddress("localhost", 27018),
				new ServerAddress("localhost", 27019)));
		client.setWriteConcern(WriteConcern.JOURNALED);
		DB db = client.getDB("course");
		DBCollection test = db.getCollection("replica.test");
		test.drop();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			// keep trying the loop don't insert next value
			for (int retry = 0; retry <= 3; retry++) {
				// catching no master exception
				try {
					test.insert(new BasicDBObject("_id", i));
					System.out.println("Inserted Document:" + i);
					break;
				} catch (DuplicateKey d) {
					System.out.println("Document has already inserted:" + i);
				} catch (MongoException e) {
					System.out.println(e.getMessage());
					System.out.println("Retrying...");
				}
				Thread.sleep(5000);
			}
			Thread.sleep(500);
		}
	}
}
