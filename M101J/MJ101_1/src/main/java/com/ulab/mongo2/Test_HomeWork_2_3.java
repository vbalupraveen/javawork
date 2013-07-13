package com.ulab.mongo2;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class Test_HomeWork_2_3 {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client=new MongoClient(new ServerAddress("localhost",27017));
		DB courseDB=client.getDB("blog");
		String username="bcvattem";
		DBCollection usersCollection=courseDB.getCollection("users");
		DBObject user = null;
        DBCursor cursor=usersCollection.find();
        DBObject obj=null;
        while(cursor.hasNext()){
        	obj=cursor.next();
        	if(username.equals(obj.get("_id")))
        		user=obj;
        }
        System.out.println(user.get("password"));
		
	}

}
