package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.exception.StudentNotAvailableException;
import com.example.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	public List<Student> getAllStudnet() {
		Iterable<Student> iterableStudent=studentRepo.findAll();
		List<Student> allStudents=new ArrayList<Student>();
		iterableStudent.forEach(e->allStudents.add(e));
		return allStudents;
	}

	public Student getStudentByStudentId(int id) {
		Optional<Student>  OptionalStudent= studentRepo.findById(id);
		Student orElseThrow = OptionalStudent.orElseThrow(()->new StudentNotAvailableException("Student is not available"));	
		return orElseThrow;
		
	}

	public Student postStudentDataInDB(Student student) {
		return studentRepo.save(student);
	}

	public String deleteStudentById(int id) {
		Optional<Student> findById = studentRepo.findById(id);
		Student orElseThrow = findById.orElseThrow(()->new StudentNotAvailableException("Student which you are trying to delete already unavailable"));
		studentRepo.deleteById(id);
		return "deleted";
		}
}
