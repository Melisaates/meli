package com.development.springbootbackend.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.development.springbootbackend.exception.ResourceNotFoundException;
import com.development.springbootbackend.model.Student;
import com.development.springbootbackend.repository.IStudentRepo;

@RestController
@RequestMapping("/api/v1")
public class StudentController {
	
	@Autowired
	private IStudentRepo studentRepo;

	@GetMapping("/students")
	public List<Student> getAll(){
		return studentRepo.findAll();
	}
	
	@PostMapping("/students")
	public Student createStudent(@RequestBody Student student) {
		return studentRepo.save(student);
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student>  getStudentById (@PathVariable long id ) {
		Student student= studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not exist with id :"+id));
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent (@PathVariable long id ,@RequestBody Student studentDetails){
		Student student= studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not exist with id :"+id));
		student.setFirstName(studentDetails.getFirstName());
		student.setLastName(studentDetails.getLastName());
		student.setEmailId(studentDetails.getEmailId());
		
		Student updatedStudent = studentRepo.save(student);
		
		return ResponseEntity.ok(updatedStudent);	
	}
	
	@DeleteMapping("/students/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteStudent (@PathVariable long id){
		Student student=studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Student not exist with id :"+id));
		studentRepo.delete(student);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
}
