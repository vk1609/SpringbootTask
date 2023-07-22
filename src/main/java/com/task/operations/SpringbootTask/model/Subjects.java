package com.task.operations.SpringbootTask.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long SubjectId;
	private float Telugu;
	private float Hindi;
	private float English;
	private float Maths;
	
//	@OneToOne
//	private Student student;
	
}
