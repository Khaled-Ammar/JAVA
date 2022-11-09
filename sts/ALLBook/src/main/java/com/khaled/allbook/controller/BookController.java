package com.khaled.allbook.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.khaled.allbook.model.bookmodel.Book;
import com.khaled.allbook.services.Bookservcies;

@Controller
public class BookController {

		private final Bookservcies bookServies;

		public BookController (Bookservcies bookservcies) {
			this.bookServies = bookservcies;
		}
//		@RequestMapping("/api/books")
//		public List<Book> index() {
//			return bookServies.allBooks();
//		}
//		 @RequestMapping(value="/api/books", method=RequestMethod.POST)
//		    public Book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//		        Book book = new Book(title, desc, lang, numOfPages);
//		        return bookServies.createBook(book);
//		    }
//		    
//		    @RequestMapping("/api/books/{id}")
//		    public Book show(@PathVariable("id") Long id) {
//		        Book book = bookServies.findBook(id);
//		        return book;
//		    }
//		    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
//		    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
//		        Book book = bookServies.updateBook(id, title, desc, lang, numOfPages);
//		        return book;
//		    }
//		    
//		    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
//		    public void destroy(@PathVariable("id") Long id) {
//		    	bookServies.deleteBook(id);
//		    }
		    
		 
		    @RequestMapping("/")
		    public String index0() {
		    	return "redirect:/books";
		    }
		    
		    @RequestMapping("/books")
		    public String index(Model model) {
		        List<Book> books = bookServies.allBooks();
		        model.addAttribute("books", books);
		        return "Show.jsp";
		    }
			@RequestMapping("/books/{id}")
			public String index(Model model, @PathVariable("id") Long id) {
				
				Book book = bookServies.findBook(id);
				model.addAttribute("book", book);
				return "index.jsp";
				
			}
			

			
		
		    

	}


