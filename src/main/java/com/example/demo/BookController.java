package com.example.demo;

import java.net.URI;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
public class BookController {

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@ApiOperation(value="Retrivies all Books",notes="A book may or may not have user",response=Book.class,responseContainer="List",produces="application/json")
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		System.out.println(bookRepository.findAll());
		return bookRepository.findAll();
	}

	@ApiResponses(value={@ApiResponse(code=200,message="Successfull retrival of book",response=Book.class),@ApiResponse(code=404,message="Book not found")})
	@GetMapping("/book/{name}")
	public Book findBookByName(@PathVariable String name){
		Book b= bookRepository.getBookByName(name);
		if(b==null){
			throw new BookNotFoundException(name);
		}
		return b;
	}
	
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	@PostMapping("/book")
	public ResponseEntity<Void> addBook(@RequestBody Book book){
		Book b=bookRepository.save(book);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(b.getId()).toUri();
return ResponseEntity.created(uri).build();	
	}
	
	@GetMapping("/dummy")
	public DummyClass getDum(){
		Date d=new Date(1995, 12, 12);
		Date d1=new Date(9999, 12, 31); 
		return new DummyClass("D8762678", "QCare", "WI", "16002909809", d, d1, "");
	}
	
}
