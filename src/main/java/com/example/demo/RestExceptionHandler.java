package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.demo.model.Book;
import com.example.demo.model.User;

@ControllerAdvice
public class RestExceptionHandler {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@ResponseStatus(org.springframework.http.HttpStatus.ALREADY_REPORTED)
	@ExceptionHandler(BookAlreadyCheckoutException.class)
	public @ResponseBody Error userAlreadyCheckOut(BookAlreadyCheckoutException b){
		System.out.println("Exception LOL---------------------------------------------------------------------");
	User user=	userRepository.findOne(b.getUserID());
	Book book=	bookRepository.findOne(b.getBookID());
	return new Error(4, "This book["+book+"] is already checkedout by user "+user);
	}
	
	@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
	@ExceptionHandler(BookNotFoundException.class)
	public @ResponseBody Error bookNotExist(BookNotFoundException b){
		return new Error(4, "Book Name "+b.getBookName()+ " does not exist");
	}
}
