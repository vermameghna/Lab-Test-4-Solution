package com.bookapp.dao;

public interface BookDao {
	public void addBook(Book book);
	public Book getBook(String isbn);
}
