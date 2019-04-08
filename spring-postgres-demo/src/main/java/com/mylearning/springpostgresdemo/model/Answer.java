package com.mylearning.springpostgresdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "answers")
public class Answer extends AuditModel{
	@Id
	@GeneratedValue(generator = "answerid_generator")
	@SequenceGenerator(
			name = "answerid_generator",
			sequenceName = "answerid_sequence",
			initialValue = 1000
			)
	private long id;
	
	@NotBlank
	@Column(columnDefinition = "text")
	private String text;
	
	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name = "question_id", nullable = false)
	@OnDelete( action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Question question;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
