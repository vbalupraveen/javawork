package com.ulab.mongo2;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class HomeWOrk_2_2 {

	public static void main(String[] args) throws UnknownHostException {
		
		int id = 0;
		int oldId = 1;
		DBObject obj;
		DBObject oldObj = null;
		
		MongoClient client=new MongoClient(new ServerAddress("localhost",27017));
		DB courseDB=client.getDB("students");
		DBCollection grades=courseDB.getCollection("grades");
		DBObject query=new BasicDBObject("type","homework");
		DBCursor cursor=grades.find(query,new BasicDBObject("_id",false)).sort(new BasicDBObject("student_id",1).append("score",-1));
		while(cursor.hasNext()){
			obj=cursor.next();
			id = (Integer) obj.get("student_id");
			if(oldId==id){
				System.out.println("removed:" +id+"---"+obj.get("score"));
				//grades.remove(obj);
			}
			else{
				System.out.println(id+"---"+obj.get("score"));
			}
			oldObj=obj;
			oldId=(Integer) oldObj.get("student_id");
		}
		System.out.println(grades.count());
	}

}
