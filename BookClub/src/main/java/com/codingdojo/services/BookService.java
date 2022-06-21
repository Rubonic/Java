package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Book;
import com.codingdojo.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
//------------------------------SHOW ALL-----------------------------------------//
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
//------------------------------ADD-----------------------------------------//
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
//------------------------------FIND ONE-----------------------------------------//
	public Book findOneBook(Long id) {
		Optional<Book>optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			return optionalBook.get();
		}else {
			return null;
		}
	}
//------------------------------DELETE-----------------------------------------//
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
//------------------------------EDIT-----------------------------------------//
	public Book editBook(Book book) {
		return bookRepo.save(book);
	}
}
