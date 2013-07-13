package com.ulab.mongo1;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class SparkFormHandling {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(
				HelloWorldFromFreeMarker.class, "/");
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request request, Response response) {
				StringWriter writer = new StringWriter();
				try {
					Map<String, Object> fruitMap = new HashMap<String, Object>();
					fruitMap.put("fruits",
							Arrays.asList("Mango", "Apple", "Orange", "Peach"));
					Template template = configuration.getTemplate("fruit.ftl");
					template.process(fruitMap, writer);
				} catch (Exception e) {
					halt(500);
				}
				return writer;
			}
		});
		Spark.post(new Route("/fav_fruit") {

			@Override
			public Object handle(Request request, Response response) {
				String fruit = request.queryParams("fruit");
				if (fruit == null)
					return "Please pick one.";
				else
					return "Your fav fruit is:" + fruit;
			}
		});
	}

}
