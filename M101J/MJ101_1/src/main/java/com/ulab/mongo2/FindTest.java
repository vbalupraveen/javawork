package com.ulab.mongo2;

import java.net.UnknownHostException;
import java.util.Random;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class FindTest {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client=new MongoClient(new ServerAddress("localhost",27017));
		DB courseDB=client.getDB("course");
		DBCollection collection=courseDB.getCollection("findTest");
		collection.drop();
		for(int i=0;i<10;i++){
			//comment:collection.insert(pass DBObject);
			collection.insert(new BasicDBObject("_id",new ObjectId())
								.append("x",new BasicDBObject("start", i)
												.append("end",i+10))
								.append("y",new BasicDBObject("start", new Random().nextInt(20))
												.append("end", new Random().nextInt(20)+5)));
		}
		//DBObject query=collection.findOne(); 
		DBObject query=new BasicDBObject("x.start",new BasicDBObject("$gte",0)
													.append("$lte", 5))
							.append("y.end",new BasicDBObject("$gte",5)
													.append("$lte", 10));
		//findOne
		//System.out.println(query);
		//find
		DBCursor cursor=collection.find(query,new BasicDBObject("x.start", true)
								.append("y.end", true)
								.append("_id",false))
													.sort(new BasicDBObject("y.end",1)
																.append("x.start", -1)).limit(2);
		//DBCursor cursor=collection.find();
		while(cursor.hasNext())
			System.out.println(cursor.next());
		//count
		System.out.println(collection.getCount(query));
			
	}

}
