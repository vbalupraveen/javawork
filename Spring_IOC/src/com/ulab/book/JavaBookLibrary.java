package com.ulab.book;

import java.util.*;

public class JavaBookLibrary implements BookLibrary{
	List<Book> books;
	ArrayList<Book> results;
public JavaBookLibrary() {
	this.books	=new ArrayList<Book>();
	books.add(new Book("Spring In Action"));
	books.add(new Book("Spring Recipies"));
	books.add(new Book("Java Complete Reference"));
}
	@Override
	public List<Book> search(String title) {
		results = new ArrayList<Book>();
		Iterator<Book> iterator=books.listIterator();
		while(iterator.hasNext()){
			Book b=iterator.next();
			if(b.getTitle().contains(title))
			results.add(b);
		}
		return results;
	}

}
