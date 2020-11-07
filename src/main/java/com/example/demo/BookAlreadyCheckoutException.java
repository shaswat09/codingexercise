package com.example.demo;

public class BookAlreadyCheckoutException extends RuntimeException{
	
	private Integer userID;
	private Integer bookID;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getBookID() {
		return bookID;
	}
	public void setBookID(Integer bookID) {
		this.bookID = bookID;
	}
	public BookAlreadyCheckoutException(Integer userID, Integer bookID) {
		super();
		this.userID = userID;
		this.bookID = bookID;
	}
	
	
}
