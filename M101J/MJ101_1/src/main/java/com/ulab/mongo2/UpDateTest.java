package com.ulab.mongo2;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class UpDateTest {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client=new MongoClient(new ServerAddress("localhost",27017));
		DB courseDB=client.getDB("course");
		DBCollection users=courseDB.getCollection("updateTest");
		users.drop();
		String[] names={"Balu","Praveen","Chandra"};
		for(String name:names){
		users.insert(new BasicDBObject("_id",name));
		}
		//update document where _id="Balu" set position=1
		users.update(new BasicDBObject("_id","Balu"),new BasicDBObject("position",1));
		//upsert dcoument where _id=vattem set position=0....upsert=true,,multi=false
		users.update(new BasicDBObject("_id","Vattem") , new BasicDBObject("$set",new BasicDBObject("position", 0)),true,false);
		//update all with gender="male" ...upsert=false,multi=true
		users.update(new BasicDBObject() , new BasicDBObject("$set",new BasicDBObject("gender", "Male")),false,true);
		
		//if _id="Balu" exists then update balu position with 3
		users.update(new BasicDBObject("_id","Balu"),  new BasicDBObject("$set",new BasicDBObject("position", 3)),true,false);
		DBObject query=new BasicDBObject();
		DBCursor cursor=users.find(query);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
			
		}
		
	}

}
