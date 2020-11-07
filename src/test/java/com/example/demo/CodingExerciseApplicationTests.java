package com.example.demo;


import static org.junit.Assert.assertTrue;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=CodingExerciseApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CodingExerciseApplicationTests {

	@LocalServerPort
	private int port;
	
	TestRestTemplate testRestTemplate =new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();
	
	@Test
	public void contextLoads() {
		HttpEntity<String> httpEntity=new HttpEntity<String>(null,headers);
	ResponseEntity<String> res=	testRestTemplate.exchange(createURLWithPort("/webapp/book/SpringBoot"),HttpMethod.GET,httpEntity,String.class);
		String expected="{id:2,name:SpringBoot,authors:Karanam,checkedOutBy:null}";
		try {
			System.out.println("LOL------"+res.getBody());
			JSONAssert.assertEquals(expected, res.getBody(), false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void addUser(){
		User u=new User("Shashwat", "M", "Talati", 27, "male", "7325012875", "38104");
		u.setUserID(4);
		HttpEntity<User> entity=new HttpEntity<User>(u, headers);
	ResponseEntity<String> res=	testRestTemplate.exchange(createURLWithPort("/webapp/user"),HttpMethod.POST,entity,String.class);
		String actual=res.getHeaders().get(HttpHeaders.LOCATION).get(0);
		assertTrue(actual.contains("user/4"));
	}
}
