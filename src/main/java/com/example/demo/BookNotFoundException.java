package com.example.demo;

public class BookNotFoundException extends RuntimeException {

	private String bookName;

	
	public BookNotFoundException(String bookName) {
		super();
		this.bookName = bookName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
}
