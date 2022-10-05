package model;

import java.net.URI; 
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Rajapinta {
	
	private static Json Data = null;
	
	 
	public static void yhteys(String isbn) {

		java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
		java.net.http.HttpRequest request = java.net.http.HttpRequest.newBuilder()
				.uri(URI.create("https://openlibrary.org/search.json?q=" + isbn + "&fields=title+author_name+publisher,availability&limit=1"))
				.timeout(Duration.ofMinutes(1)).header("Content-Type", "application/JSON")
				.GET().build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(Rajapinta::parse).join();
	}
	/**
	 * <p>Metodi parsee rajapinnasta olevan json datan ja muuttaa sen gson-kirjaston avulla Json olioon</p>
	 */
	public static void parse(String responseBody) {
		
		System.out.println(responseBody);
		JsonParser parser = new JsonParser();
		JsonElement e = parser.parse(responseBody);
		Gson gson = new Gson();
		Data = gson.fromJson(e, Json.class);
		System.out.println(Data.numFound);
		System.out.println(Data.docs.get(0).title);
		System.out.println(Data.docs.get(0).author_name);
		System.out.println(Data.docs.get(0).publisher);

	}
	public static Json getData() {
		return Data;
	}
	public static void setData(Json data) {
		Data = data;
	}
	

}
