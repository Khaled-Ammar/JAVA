package com.khaled.books.servcies;



import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.khaled.books.models.Book;
import com.khaled.books.repositores.Bookrepositores;

@Service
public class  Bookservcies {
	private final Bookrepositores bookrepositoes;
	
	public Bookservcies(Bookrepositores bookrepositoes) {
		this.bookrepositoes = bookrepositoes;
		
	}
    public List<Book> allBooks() { 
        return bookrepositoes.findAll();
    }
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		Book book = findBook(id);
		if(book.getId()== id) {
			book.setTitle(title);
			book.setDescription(desc);
			book.setLanguage(lang);
			book.setNumberOfPages(numOfPages);
			return createBook(book);
		}else {
			return null;
		}
	}
    // creates a book
    public Book createBook(Book b) {
        return bookrepositoes.save(b);
    }
    
    public void deleteBook(Long id) {
    	   Optional<Book> optionalBook = bookrepositoes.findById(id);
           if(optionalBook.isPresent()) {
        	   bookrepositoes.deleteById(id);
           }
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookrepositoes.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}

