package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ConsumerService;

@RestController
public class ConsumerController {

	@Autowired
	private ConsumerService consumerService;
	
	@GetMapping("/fetchStudent/{id}")
	public Student fetchStudent(@PathVariable int id) {
		return consumerService.fetchStudentFromAPIWithId(id);
	}
	@GetMapping("/fetchAllStudent")
	public List<Student> fetchStudent() {
		return  consumerService.fetchAllStudentFromAPI();
	}
	@PostMapping("/addData")
	public Student addData(@RequestBody Student student) {
		return consumerService.addStudentData(student);
	}
	@DeleteMapping("/student/{studentId}")
	public String deleteStudentFromAPI(@PathVariable ("studentId") int id)  {
			return consumerService.deleteStudentFromStudentAPI(id);
	}
}
