package com.task.operations.SpringbootTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.operations.SpringbootTask.model.Subjects;

@Repository
public interface SubjectRepo extends JpaRepository<Subjects, Double>{
	

}
