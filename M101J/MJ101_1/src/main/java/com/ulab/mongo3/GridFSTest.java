package com.ulab.mongo3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

public class GridFSTest {

	public static void main(String[] args) throws IOException {
		MongoClient client = new MongoClient(new ServerAddress("localhost",
				27017));
		DB db = client.getDB("test");
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		/*
		 * creates videos.files videos.chunks.
		 * 
		 * Here videos is a collection video is a document
		 */
		GridFS videos = new GridFS(db, "videos");
		/*
		 * creates a "videos" bucket in test db
		 */		
		try {
			inputStream = new FileInputStream(
					"/home/bpc/Downloads/ManOfSteel.mp4");
		} catch (FileNotFoundException e) {
			System.err.println("video not found in the specified path.");
			System.exit(1);
		}
		// write into Mongo
		GridFSInputFile video = videos
				.createFile(inputStream, "ManOfSteel.mp4");
		// creating metadata
		BasicDBObject metadata = new BasicDBObject("discription",
				"Man Of Steel (2013) trailer");
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("Super Man");
		metadata.append("tags", tags);

		// appending metadata to video
		video.setMetaData(metadata);
		video.save();

		System.out.println("The saved video ID is:" + video.get("_id"));
		System.out.println("videos successfully saved.");

		// read from Mongo and put it in disk
		GridFSDBFile outFile = videos.findOne(new BasicDBObject("filename",
				"ManOfSteel.mp4"));
		try {
			outputStream = new FileOutputStream(
					"/home/bpc/Downloads/ManOfSteel_copy.mp4");
			outFile.writeTo(outputStream);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to write in to disk.");
		}

	}

}
