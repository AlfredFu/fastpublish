package me.wmn.demo;

import java.io.IOException;
import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.thoughtworks.xstream.io.xml.StaxDriver;

import me.wmn.domain.User;

public class MessageConverterTest {
	
	private final static String rootUrl = "http://localhost:8080/fastpublish/";
	
	@Test
	public void testhandle41(){
		RestTemplate restTemplate = this.buildRestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("userName", "tom");
		form.add("age", "45");
		restTemplate.postForLocation(rootUrl + "demo/requestbody", form);
	}
	
	
	@Test
	public void testHandle42(){
		RestTemplate rt = this.buildRestTemplate();
		MultiValueMap<String, String> form = new LinkedMultiValueMap<String, String>();
		form.add("userName", "tom");
		form.add("password", "123456");
		form.add("age", "45");
		rt.postForLocation(rootUrl + "user/handler42", form);
	}
	
	@Test
	public void testHandle51() throws IOException{
		RestTemplate rt = this.buildRestTemplate();
		
		User user = new User();
		user.setUsername("Tom");
		user.setPassword("1234");
		
		HttpHeaders entityHeaders = new HttpHeaders();
		entityHeaders.setContentType(MediaType.APPLICATION_XML);
		entityHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
		
		HttpEntity<User> requestEntity = new HttpEntity<User>(user, entityHeaders);
		ResponseEntity<User> responseEntity = rt.exchange(rootUrl + "demo/handle51", HttpMethod.POST, requestEntity, User.class);
		
		
		User responseUser = responseEntity.getBody();
		Assert.assertNotNull(responseUser);
		Assert.assertEquals(1000, responseUser.getId());
		Assert.assertEquals("Tom", responseUser.getUsername());
	}
	
	private RestTemplate buildRestTemplate(){
		RestTemplate rt = new RestTemplate();
		
		XStreamMarshaller xmlMarshaller = new XStreamMarshaller();
		xmlMarshaller.setStreamDriver(new StaxDriver());
		xmlMarshaller.setAnnotatedClasses(new Class[]{User.class});
		
		MarshallingHttpMessageConverter xmlConverter = new MarshallingHttpMessageConverter();
		xmlConverter.setMarshaller(xmlMarshaller);
		xmlConverter.setUnmarshaller(xmlMarshaller);
		
		rt.getMessageConverters().add(xmlConverter);
		
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		rt.getMessageConverters().add(jsonConverter);
		
		
		return rt;
		
	}
	

}
