package com.task.operations.SpringbootTask.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.operations.SpringbootTask.exceptions.StudentNotFoundException;
import com.task.operations.SpringbootTask.model.Student;
import com.task.operations.SpringbootTask.repository.StudentRepo;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentRepo;

	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	public Student getStudentById(Long stundetId){
		// TODO Auto-generated method stub
		Student student = studentRepo.findById(stundetId).orElseThrow(()-> new StudentNotFoundException(stundetId, "FirstName", "LastName"));
		return student;
	}

	public void deleteStudent(Long studentId) {
		// TODO Auto-generated method stub
		
		Student student = studentRepo.findById(studentId).orElseThrow(()-> new StudentNotFoundException(studentId, "FirstName", "LastName"));
				
		studentRepo.deleteById(studentId);
	}

	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		Student presentStudent = studentRepo.findById(student.getStudentId()).orElseThrow(
				()-> new StudentNotFoundException(student.getStudentId(), "id", "Student"));
		presentStudent.setFirstName(student.getFirstName());
		presentStudent.setLastName(student.getLastName());
		Student updatedStudent = studentRepo.save(presentStudent);
		return updatedStudent;
	}

}
