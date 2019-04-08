package com.mylearning.springpostgresdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mylearning.springpostgresdemo.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{

}
