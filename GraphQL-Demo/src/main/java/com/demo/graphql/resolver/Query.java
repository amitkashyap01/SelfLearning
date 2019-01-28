package com.demo.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;
import com.demo.graphql.repository.AuthorRepository;
import com.demo.graphql.repository.BookRepository;

public class Query implements GraphQLQueryResolver{
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Iterable<Author> findAllAuthors(){
		return authorRepository.findAll();
	}
	
	public long countAuthors() {
		return authorRepository.count();
	}
	
	public Iterable<Book> findAllBooks(){
		return bookRepository.findAll();
	}
	
	public long countBooks() {
		return bookRepository.count();
	}
}
