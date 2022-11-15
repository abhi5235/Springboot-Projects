package com.example.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.controller.Student;
import com.example.utiity.ConsumerDeleteException;

@Service
public class ConsumerService {

	@Autowired
	RestTemplate restTemplate;

	public Student fetchStudentFromAPIWithId(int id) {
		Student student = restTemplate.getForObject("http://localhost:8888/student/{id}", Student.class, id);
		return student;
	}

	public List<Student> fetchAllStudentFromAPI() {
		List<Student> list = restTemplate.getForObject("http://localhost:8888/student", List.class);
		return list;
	}

	public Student addStudentData(Student student) {
		Student postForObject = restTemplate.postForObject("http://localhost:8888/postStudentData", student,
				Student.class);
		return postForObject;
	}

	public String deleteStudentFromStudentAPI(int id)  {
		try {
			restTemplate.delete("http://localhost:8888/student/{id}", id);
		} catch (HttpClientErrorException exception ) {
		 throw new ConsumerDeleteException("Student data is not available");
		}
		return "done";
	}
}
