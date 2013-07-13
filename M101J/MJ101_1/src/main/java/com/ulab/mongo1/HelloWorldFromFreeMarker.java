package com.ulab.mongo1;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class HelloWorldFromFreeMarker {

	public static void main(String[] args) {
		final Configuration configuration = new Configuration();
		configuration.setClassForTemplateLoading(
				HelloWorldFromFreeMarker.class, "/");
		Spark.setPort(8000);
		Spark.get(new Route("/") {
			@Override
			public Object handle(Request request, Response response) {
				StringWriter writer = new StringWriter();
				try {
					Template template = configuration.getTemplate("hello.ftl");
					Map<String, Object> helloMap = new HashMap<String, Object>();
					helloMap.put("name", "FreeMarker");
					template.process(helloMap, writer);
					System.out.println(writer);
				} catch (Exception e) {
					halt(500);
				}
				return writer;
			}
		});
	}
}
