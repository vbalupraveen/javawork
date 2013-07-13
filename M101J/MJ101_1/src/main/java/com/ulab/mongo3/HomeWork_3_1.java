package com.ulab.mongo3;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class HomeWork_3_1 {

	public static void main(String[] args) throws UnknownHostException {
		Map<Integer, Double> idHwScores = new HashMap<Integer, Double>();
		MongoClient client = new MongoClient(new ServerAddress("localhost",
				27017));
		DB school = client.getDB("school");
		DBCollection students = school.getCollection("students");
		DBObject query = new BasicDBObject();
		DBCursor cursor = students.find(query,
				new BasicDBObject("scores", true));
		int id = 0;
		double hwScore = 0;
		while (cursor.hasNext()) {
			DBObject next = cursor.next();
			BasicDBList dbList = (BasicDBList) next.get("scores");

			ArrayList<Object> list = dbList;
			for (int i = 0; i < list.size(); i++) {
				BasicDBObject obj = (BasicDBObject) dbList.get(i);
				if (obj.get("type").equals("homework")) {
					id = (Integer) next.get("_id");
					hwScore = (Double) obj.get("score");
					if (idHwScores.containsKey(id)) {
						if (idHwScores.get(id) < hwScore) {
							idHwScores.put(id, hwScore);
							list.remove(i - 1);
						} else
							list.remove(i);
					} else if (!(idHwScores.containsKey(id))) {
						idHwScores.put(id, hwScore);
					}
				}
			}
			//System.out.println(list);
			/*---------------------update------------------------------*/

			for (int i = 0; i < list.size(); i++) {
				students.update(new BasicDBObject("_id", next.get("_id")),
						new BasicDBObject("$set", new BasicDBObject("scores",
								list)), true, false);
			}

		}
	}
}
