package com.ulab.mongo1;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class HelloWorld {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client=new MongoClient(new ServerAddress("localhost", 27017));
		//use course
		DB db=client.getDB(	"course");
		//db.names.find();
		DBCollection collection=db.getCollection("names");
		DBObject doc=collection.findOne();
		System.out.println(doc);	
	}

}
