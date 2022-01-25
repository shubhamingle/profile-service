//package com.reliance.profileservice;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.utils.URIBuilder;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.Scanner;
//
//@SpringBootTest
//@Slf4j
//public class ProfileIT {
//
//	@Test
//	void testOk() {
//		log("Hello HTTP Client");
//	}
//
//	@Test
//	void testProfiles() throws Exception {
//
//		// Creating a HttpClient object
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//
//		// Creating a HttpGet object
//		HttpGet httpget = new HttpGet("http://localhost:4040/api/profiles");
//
//		// Printing the method used
//		log.info("Request Type {}", httpget.getMethod());
//
//		// Executing the Get request
//		HttpResponse httpresponse = httpclient.execute(httpget);
//
//		Scanner sc = new Scanner(httpresponse.getEntity().getContent());
//
//		// Printing the status line
//		log.info("Status Line {}", httpresponse.getStatusLine().toString());
//		log.info("Status Code {}", httpresponse.getStatusLine().getStatusCode());
//		while (sc.hasNext()) {
//			log.info("Response {}", sc.nextLine());
//		}
//	}
//
//	@Test
//	void testProfileDetails() throws Exception {
//
//		// Creating a HttpClient object
//		CloseableHttpClient httpclient = HttpClients.createDefault();
//
//		// Creating a HttpGet object
//		String baseUri = "http://localhost:4040";
//		HttpGet httpget = new HttpGet();
//		long profileId = 2;
//		URIBuilder profileDetailsUri = new URIBuilder(baseUri);
//		String profileDetailsUrl = "/api/profiles/" + String.valueOf(profileId);
//		profileDetailsUri.setPath(profileDetailsUrl);
//		httpget.setURI(profileDetailsUri.build());
//
//		// Printing the method used
//		log.info("Request Type {}", httpget.getMethod());
//
//		// Executing the Get request
//		HttpResponse httpresponse = httpclient.execute(httpget);
//
//		// Printing Status Line and code
//		log.info("Status Line {}", httpresponse.getStatusLine().toString());
//		log.info("Status Code {}", httpresponse.getStatusLine().getStatusCode());
//
//		Scanner sc = new Scanner(httpresponse.getEntity().getContent());
//
//		while (sc.hasNext()) {
//			log.info("Response {}", sc.nextLine());
//		}
//	}
//}
