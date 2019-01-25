package com.demo.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.graphql.model.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{

}
