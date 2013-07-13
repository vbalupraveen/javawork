package com.ulab.mongo1;

import java.io.StringWriter;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldMangoSparkFreeMarker {

	public static void main(String[] args) throws UnknownHostException {
		Spark.setPort(4567);
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(
				HelloWorldFromFreeMarker.class, "/");
		final MongoClient client = new MongoClient(new ServerAddress(
				"localhost", 27017));
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request request, Response response) {
				StringWriter writer = new StringWriter();
				try {
					Template template = configuration.getTemplate("hello.ftl");
					System.out.println(writer);
					/* DB Configuration */
					DB db = client.getDB("course");
					DBCollection collection = db.getCollection("names");
					DBObject doc = collection.findOne();// DBObject implements a
														// collection
					template.process(doc, writer);
				} catch (Exception e) {
					halt(500);
				}
				return writer;
			}
		});
		Spark.get(new Route("/:param") {

			@Override
			public Object handle(Request request, Response response) {
				return request.params(":param");
			}
		});
	}

}
