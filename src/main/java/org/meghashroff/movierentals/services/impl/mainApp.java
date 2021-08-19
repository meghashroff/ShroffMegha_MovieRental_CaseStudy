package org.meghashroff.movierentals.services.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class mainApp {

	public static void main(String[] args) throws IOException, InterruptedException {

		//Dojo API
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://imdb8.p.rapidapi.com/auto-complete?q=game%20of%20thr"))
//				.header("x-rapidapi-key", "2dbdb856e7mshc84ca696de257e2p14b07bjsn869ca3f6cf28")
//				.header("x-rapidapi-host", "imdb8.p.rapidapi.com")
//				.method("GET", HttpRequest.BodyPublishers.noBody())
//				.build();
//		HttpResponse<String> response;
//		try {
//			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());
//
//		//System.out.println("response: "+response);
//		} catch (IOException | InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		}

		
		//GoWatch
//		HttpRequest request = HttpRequest.newBuilder()
//				.uri(URI.create("https://gowatch.p.rapidapi.com/lookup/title/imdb_id"))
//				.header("content-type", "application/x-www-form-urlencoded")
//				.header("x-rapidapi-key", "2dbdb856e7mshc84ca696de257e2p14b07bjsn869ca3f6cf28")
//				.header("x-rapidapi-host", "gowatch.p.rapidapi.com")
//				.method("POST", HttpRequest.BodyPublishers.ofString("id=tt6751668&type=movie&country=us"))
//				.build();
//		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//		System.out.println(response.body());
//	}
}
}
