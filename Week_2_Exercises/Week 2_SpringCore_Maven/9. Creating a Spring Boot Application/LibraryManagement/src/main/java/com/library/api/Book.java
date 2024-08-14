package com.library.api;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    //primary key
	@Id
	//auto generate the value of primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
	//created the member variables
    private int bookid;
    private String bookname;
    private String authorname;
    private double price;
    private String isbn;

   public Book() {
	   this.bookid=0;
	   this.bookname=null;
	   this.authorname=null;
	   this.price=0;
	   this.isbn=null;
   }

public Book(String bookname, String authorname, double price, String isbn) {
	super();
	this.bookname = bookname;
	this.authorname = authorname;
	this.price = price;
	this.isbn = isbn;
}
//generate the getter and setter

public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public String getBookname() {
	return bookname;
}
public void setBookname(String bookname) {
	this.bookname = bookname;
}
public String getAuthorname() {
	return authorname;
}
public void setAuthorname(String authorname) {
	this.authorname = authorname;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getIsbn() {
	return isbn;
}
public void setIsbn(String isbn) {
	this.isbn = isbn;
}
}
