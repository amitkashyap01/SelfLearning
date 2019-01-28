package com.demo.graphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.demo.graphql.exception.BookNotFoundException;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;
import com.demo.graphql.repository.AuthorRepository;
import com.demo.graphql.repository.BookRepository;

public class Mutation implements GraphQLMutationResolver{
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	public Author newAuthor(String firstName, String lastName) {
		Author author = new Author();
		author.setFirstName(firstName);
		author.setLastName(lastName);
		authorRepository.save(author);

		return author;
	}

	public Book newBook(String title, String isbn, 
			Integer pageCount, Long authorId) {

		Book book = new Book();
		book.setAuthor(new Author(authorId));
		book.setTitle(title);
		book.setIsbn(isbn);
		book.setPageCount(pageCount != null ? pageCount:0);

		bookRepository.save(book);

		return book;
	}

	public boolean deleteBook(Long bookId) {
		bookRepository.deleteById(bookId);
		return true;
	}
	
	public Book updateBookPageCount(Integer pageCount, Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		Book toBeUpdatedBook = new Book();
		
		if (optionalBook.isPresent()) {
			toBeUpdatedBook.setPageCount(pageCount);
			bookRepository.save(toBeUpdatedBook);
		}else
			throw new BookNotFoundException("Book with id: "+id+" NOT found.");
		
		return toBeUpdatedBook;
	}
}
