package com.demo.graphql.resolver;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.demo.graphql.model.Author;
import com.demo.graphql.model.Book;
import com.demo.graphql.repository.AuthorRepository;

public class BookResolver implements GraphQLResolver<Book>{
	
	@Autowired
	private AuthorRepository authorRepository;
	
	public Author getAuthor(Book book) {
		Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
		
		if(author.isPresent()) {
			return null;
		}else
			return author.get();
	}
}
