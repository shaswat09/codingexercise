package com.example.demo;

import java.util.List;
import java.util.Locale;

import org.apache.commons.httpclient.URI;
import org.apache.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.model.*;

@RestController
@ConfigurationProperties
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	private Integer age;
	
	@Autowired
	MessageSource messageSource;
	
	@Autowired
	private AdministrationInfo administrationInfo;	
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		System.out.println("LOL---------------------"+userRepository.findAll());
		return userRepository.findAll();
	}

	@GetMapping("/")
	public User getDefaultUser(){
		return new User("Shaswat", "M", "Talati", age, "male", "7325012875", "32771");
	}

	@GetMapping("/admin")
	public AdministrationInfo getAdminInfo(){
		return administrationInfo;
	}
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	@PostMapping("/user")
	public ResponseEntity<Void> createUser(@RequestBody User user){
	User u=	userRepository.save(user);
	java.net.URI uri=	ServletUriComponentsBuilder.fromCurrentRequest().path("/").path("{id}").buildAndExpand(u.getUserID()).toUri();
	return ResponseEntity.created(uri).build();
	}
	
	@ResponseStatus(org.springframework.http.HttpStatus.CREATED)
	@RequestMapping(value="/updateUser",method=RequestMethod.PUT)
	public User updateUser(@RequestBody User user){
		return userRepository.save(user);
	}

	@RequestMapping(value="/checkout/{userID}/{bookID}",method=org.springframework.web.bind.annotation.RequestMethod.PUT)
	public User checkOutBook(@PathVariable Integer userID, @PathVariable Integer bookID){
		Book book=bookRepository.findOne(bookID);
		if(book.getCheckedOutBy()!=null){
			throw new BookAlreadyCheckoutException(book.getCheckedOutBy().getUserID(), bookID);
		}
		User u=userRepository.findOne(userID);
		book.setCheckedOutBy(u);
		
		userRepository.save(u);
		bookRepository.save(book);
	
		return u;
	}
	
	@GetMapping("/internationalized")
	public String msg(@RequestHeader(value="Accept-Language",required=false) String locale){
		
		return messageSource.getMessage("welcome.message", null, new Locale(locale));
		
	}
	
}
