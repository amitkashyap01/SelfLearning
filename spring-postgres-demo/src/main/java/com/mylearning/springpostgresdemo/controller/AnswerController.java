package com.mylearning.springpostgresdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mylearning.springpostgresdemo.exception.ResourceNotFoundException;
import com.mylearning.springpostgresdemo.model.Answer;
import com.mylearning.springpostgresdemo.repository.AnswerRepository;
import com.mylearning.springpostgresdemo.repository.QuestionRepository;

@RestController
public class AnswerController {
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@GetMapping("/questions/{questionId}/answers")
	public List<Answer> getAnswersFromQuestion(@PathVariable Long questionId){
		return answerRepository.findByQuestionId(questionId);
	}
	
	@PostMapping("/questions/{questionId}/answers")
	public Answer addAnswer(@PathVariable Long questionId,
			@Valid @RequestBody Answer answer) {
		
		return questionRepository.findById(questionId)
			.map(question ->{
				answer.setQuestion(question);
				return answerRepository.save(answer);
			})
			.orElseThrow(() -> new ResourceNotFoundException("Question not found"
					+ "with question id:"+questionId));
	}
	
	
	@PutMapping("/questions/{questionId}/answers/{answerId}")
	public Answer updateAnswer(@PathVariable Long questionId,
			@PathVariable Long answerId,
			@Valid Answer answerRequest) {
		
		if(!questionRepository.existsById(questionId)) {
			throw new ResourceNotFoundException("Question not found with questionId: "+questionId);
		}
		
		return answerRepository.findById(answerId)
				.map(answer -> {
					answer.setText(answerRequest.getText());
					return answerRepository.save(answer);
				})
				.orElseThrow(() -> new ResourceNotFoundException("Answer not found with"
						+ "answerId: "+answerId));
	}

	@DeleteMapping("/questions/{questionId}/answers/{answerId}")
	public ResponseEntity<?> deleteAnswer(@PathVariable Long questionId,
			@PathVariable Long answerId) {
		
		if(!questionRepository.existsById(questionId)) {
			throw new ResourceNotFoundException("Question not found with questionId: "+questionId);
		}
		
		return answerRepository.findById(answerId)
				.map(answer -> {
					answerRepository.delete(answer);
					return ResponseEntity.ok().build();
				})
				.orElseThrow(() -> new ResourceNotFoundException("Answer not found with"
						+ "answerId: "+answerId));
	}
}
