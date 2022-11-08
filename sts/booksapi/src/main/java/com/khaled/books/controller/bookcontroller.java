package com.khaled.books.controller;



import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khaled.books.models.Book;
import com.khaled.books.servcies.Bookservcies;

@RestController
public class bookcontroller {
	private final Bookservcies bookServies;

	public bookcontroller (Bookservcies bookservcies) {
		this.bookServies = bookservcies;
	}
	@RequestMapping("/api/books")
	public List<Book> index() {
		return bookServies.allBooks();
	}
	 @RequestMapping(value="/api/books", method=RequestMethod.POST)
	    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        Book book = new Book(title, desc, lang, numOfPages);
	        return bookServies.createBook(book);
	    }
	    
	    @RequestMapping("/api/books/{id}")
	    public Book show(@PathVariable("id") Long id) {
	        Book book = bookServies.findBook(id);
	        return book;
	    }
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        Book book = bookServies.updateBook(id, title, desc, lang, numOfPages);
	        return book;
	    }
	    
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	    	bookServies.deleteBook(id);
	    }
	

}
