package com.demo.graphql.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.graphql.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long>{

}
