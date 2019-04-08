package com.mylearning.springpostgresdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question extends AuditModel{
	
	@Id
	@GeneratedValue(generator = "questionid_generator")
	@SequenceGenerator(
				name = "questionid_generator",
				sequenceName = "questionid_sequence",
				initialValue = 1000
			)
	private long id;

	@NotBlank
	@Size(min = 3, max = 11)
	private String title;
	
	@Column(columnDefinition = "text")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
