package com.ulab.mongo2;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class InsertTest {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client=new MongoClient(new ServerAddress("localhost",27017));
		DB courseDB=client.getDB("course");
		DBCollection collection=courseDB.getCollection("insertTest");
		collection.drop();
		ArrayList<Double> list=new ArrayList<Double>();
		list.add(1.2);
		list.add(1.4);
		DBObject doc=new BasicDBObject("_id",new ObjectId()).append("x", 1).append("x[]", Arrays.asList(1.1,1.2)).append("Date", new Date());
		//DBObject doc=new BasicDBObject("_id",new ObjectId()).append("x", 1).append("x[]", list).append("Date", new Date();
		DBObject doc2=new BasicDBObject().append("y", 2);
		//collection.insert(Arrays.asList(doc,doc2));
		collection.insert(doc);
		System.out.println(doc);
		doc.removeField("_id");
		collection.insert(doc);
		System.out.println(doc);	
	}

}
