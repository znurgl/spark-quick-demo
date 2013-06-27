package io.kiiro.web.sparkplayground;

import static spark.Spark.get;
import io.kiiro.web.sparkplayground.view.MicroView;
import io.kiiro.web.sparkplayground.view.XMLMicroView;
import spark.Request;
import spark.Response;
import spark.Route;

public class Application {

	public static void main(String[] args) {

		get(new Route("/") {
			@Override
			public Object handle(Request request, Response response) {
				return "Frontpage";
			}
		});

		get(new Route("/hello") {
			@Override
			public Object handle(Request request, Response response) {
				return "Hello World!";
			}
		});

		// matches "GET /hello/foo" and "GET /hello/bar"
		// request.params(":name") is 'foo' or 'bar'
		get(new Route("/hello/:name") {
			@Override
			public Object handle(Request request, Response response) {
				return "Hello: " + request.params(":name");
			}
		});
		
		// testing XML functionality
		get(new Route("/xml-test") {
			@Override
			public Object handle(Request request, Response response) {
				
				response.type("text/xml");
				
				MicroView view = new XMLMicroView();
				
				return view.render();
			}
		});

	}

}
