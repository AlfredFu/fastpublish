package me.wmn.rest;

import org.springframework.web.client.RestTemplate;

import me.wmn.domain.Product;

public class RestTemplateDemo {

	public static void main(String[] args) {
		Product p = new RestTemplate().getForObject("http://localhost:8080/fastpublish/p/{id}", Product.class, 29);
		System.out.println(p);
	}

}
