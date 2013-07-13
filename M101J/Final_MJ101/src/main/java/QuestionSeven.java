import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;


public class QuestionSeven {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient client = new MongoClient(new ServerAddress("localhost",
				27017));
		DB courseDB = client.getDB("course");
		DBCollection albums = courseDB.getCollection("albums");
		DBCollection images = courseDB.getCollection("images");
		DBObject next;
		HashSet<Integer> imagesSet=new HashSet<Integer>();
		ArrayList<Integer> imageList = new ArrayList<Integer>();
		ArrayList<Integer> albumImageList;
		DBCursor cursor=albums.find();
		DBCursor cur=images.find(new BasicDBObject(), new BasicDBObject("_id",true));
		while(cur.hasNext()){
			next=cur.next();
			imageList.add((Integer) next.get("_id"));
		}
		System.out.println(imageList.size());
		while(cursor.hasNext()){
			next=cursor.next();
			albumImageList=(ArrayList<Integer>) next.get("images");
			for(int i=0;i<albumImageList.size();i++){
				imagesSet.add(albumImageList.get(i));
			}
		}
		System.out.println(imagesSet.size());
		int j=0;
		for(int i=0;i<imageList.size();i++){
			if(!(imagesSet.contains(imageList.get(i)))){
				images.remove(new BasicDBObject("_id",imageList.get(i)));
				j++;
			}
		}
		System.out.println("removed docs:"+j);
		ArrayList<String> tags;
		cur=images.find(new BasicDBObject(), new BasicDBObject("tags",true).append("_id",false));
		j=0;
		while(cur.hasNext()){
		tags=(ArrayList<String>) cur.next().get("tags");
		if(tags.contains("sunrises"))
			j++;
		}
		System.out.println("Images with sunrises tag after removal:"+j);
	}

}
