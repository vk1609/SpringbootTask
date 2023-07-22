package com.task.operations.SpringbootTask.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.operations.SpringbootTask.model.Student;
import com.task.operations.SpringbootTask.service.StudentService;

@RestController
@RequestMapping("/student/v1")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/savedstudent")
	public ResponseEntity<Student> saveStudentSetails(@RequestBody Student student){
		Student savedStudent = studentService.saveStudent(student);
		return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = studentService.getAllStudents();
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Long stundetId){
		Student student = studentService.getStudentById(stundetId);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
		studentService.deleteStudent(studentId);
		return new ResponseEntity<>("Student deleted!", HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") Long StudentId, @RequestBody Student student){
		student.setStudentId(StudentId);
		Student updateStudent = studentService.updateStudent(student);
		return new ResponseEntity<>(updateStudent, HttpStatus.OK);
	}
	
}
