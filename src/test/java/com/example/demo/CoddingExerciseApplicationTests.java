package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Book;

@RunWith(SpringRunner.class)
@WebMvcTest(value=BookController.class,secure=false)
public class CoddingExerciseApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	BookRepository bookRepository;
	
	@MockBean
	UserRepository userRepository;
	
	@Test
	public void getBook() throws Exception{
		Book b=new Book(11, "SpringBT", "Shaswat", null);
		
		Mockito.when(bookRepository.getBookByName(anyString())).thenReturn(b);
		
RequestBuilder rb=	MockMvcRequestBuilders.get("/book/dummy").accept(MediaType.APPLICATION_JSON);
	MvcResult mvcREsult=	mockMvc.perform(rb).andReturn();
	String expected="{id:11,name:SpringBT,authors:Shaswat,checkedOutBy:null}";
	System.out.println("LOL-------- "+mvcREsult.getResponse().getContentAsString());
	JSONAssert.assertEquals(expected, mvcREsult.getResponse().getContentAsString(), false);
	
	}
	
	@Test
	public void addBook() throws Exception{
		String inputJSON="{\"id\":11,\"name\":\"SpringBT\",\"authors\":\"Shaswat\",\"checkedOutBy\":null}";
	//	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10 Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";
//String in="{\"id\":\"Spring\",\"description\":\"10 Steps\",\"steps\":;
		Book saveBook=new Book(11, "SpringBT", "John", null);
		Mockito.when(bookRepository.save(Mockito.any(Book.class))).thenReturn(saveBook);
	RequestBuilder rb=	MockMvcRequestBuilders.post("/book").accept(MediaType.APPLICATION_JSON).content(inputJSON).contentType(MediaType.APPLICATION_JSON);
MvcResult mr=	mockMvc.perform(rb).andReturn();
MockHttpServletResponse res=mr.getResponse();
assertEquals(org.springframework.http.HttpStatus.CREATED.value(),res.getStatus());
assertEquals("http://localhost/book11" , res.getHeader(HttpHeaders.LOCATION));

	}
}
