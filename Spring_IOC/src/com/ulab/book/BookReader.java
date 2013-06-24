package com.ulab.book;

import java.util.List;

public class BookReader {
private BookLibrary bookLibrary;
public BookReader(BookLibrary bookLibrary) {
	this.bookLibrary = bookLibrary;
	}
public List<Book> read() {
List<Book> books = bookLibrary.search("Spring");
	for(Book book : books) {
	System.out.printf("Reading: %s%n", book);
	}
	return books;
	}
}