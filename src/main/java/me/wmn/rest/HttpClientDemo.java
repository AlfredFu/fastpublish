package me.wmn.rest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;

import com.fasterxml.jackson.databind.ObjectMapper;

import me.wmn.domain.Product;

public class HttpClientDemo {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet getRequest = new HttpGet("http://localhost:8080/fastpublish/p/29");
		getRequest.setHeader(new BasicHeader("Accept", "application/json"));
		HttpResponse response = httpClient.execute(getRequest);
		HttpEntity entity = response.getEntity();
		ObjectMapper mapper = new ObjectMapper();
		
		Product p = mapper.readValue(entity.getContent(), Product.class);
		System.out.println(p);
	}

}
