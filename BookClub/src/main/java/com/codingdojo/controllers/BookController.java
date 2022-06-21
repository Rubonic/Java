package com.codingdojo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.models.Book;
import com.codingdojo.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);		
		return "dashboard";
	}
//------------------------------ADD-----------------------------------------//
	@GetMapping("/books/add")
	public String addBook(@ModelAttribute("book")Book book, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		return "addBook";
	}
	
	@PostMapping("/books/add")
	public String processAddBook(@Valid @ModelAttribute("book")Book book, BindingResult result, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "addBook";
		}else {
			bookService.addBook(book);
			return "redirect:/books";
		}
	}
//------------------------------SHOW-----------------------------------------//
	@GetMapping("books/{id}")
	public String showOneBook(@PathVariable("id")Long id, Model model, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		Book book = bookService.findOneBook(id);
		model.addAttribute("book", book);
		return "showBook";
	}
//------------------------------DELETE-----------------------------------------//
	@DeleteMapping("/books/{id}/delete")
	public String processDelete(@PathVariable("id")Long id, HttpSession session) {
		if(session.getAttribute("userId")==null) {
			return "redirect:/";
		}
		bookService.deleteBook(id);
		return "redirect:/books";
	}
//------------------------------EDIT-----------------------------------------//
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id")Long id, HttpSession session, Model model) {
		Book book = bookService.findOneBook(id);
		Long userId = (Long) session.getAttribute("userId");
		if(!book.getCreator().getId().equals(userId)) {
			return "redirect:/books";
		}
		model.addAttribute("book", book);
		return "editBook";
	}
	
	@PutMapping("/books/{id}/edit")
	public String processEditBook(@Valid @ModelAttribute("book")Book book, 
			BindingResult result, HttpSession session){
		Long userId = (Long) session.getAttribute("userId");
		if(!book.getCreator().getId().equals(userId)) {
			return "redirect:/books";
		}
		if(result.hasErrors()) {
			return "editBook";
		}else {
			bookService.editBook(book);
			return "redirect:/books";
		}
	}
}