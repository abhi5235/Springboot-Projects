package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/student")
	public List<Student> getStudent() {
		return studentService.getAllStudnet();
	}

	@GetMapping("/student/{studentId}")
	public Student getStudentById(@PathVariable("studentId") int id) {
		return studentService.getStudentByStudentId(id);

	}
	@PostMapping("postStudentData")
	public Student postStudentData(@RequestBody Student student) {
		return studentService.postStudentDataInDB(student);
		
	}
	@DeleteMapping("/student/{studentId}")
	public String deleteStudent(@PathVariable ("studentId") int id) {
		 return studentService.deleteStudentById(id);
	}
}
