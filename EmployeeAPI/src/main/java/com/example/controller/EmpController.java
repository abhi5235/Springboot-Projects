package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeRequestDTO;
import com.example.entity.Employee;
import com.example.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	EmpService empService;
	
	@PostMapping("/employee")
	private ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeRequestDTO employee){
		Employee emp=empService.addEmpToRepo(employee);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
	@GetMapping("/getEmployee/{id}")
	private Employee getEmployee(@PathVariable int id){
	return empService.getEmpDetailsFromDB(id);
	}
	@DeleteMapping("/deleteEmployee/{employeeId}")
	public String deleteEmployee(@PathVariable ("employeeId") int id) {
		 return empService.deleteEmployeeById(id);
	}
	@GetMapping("employee/assignProject")
	public ResponseEntity<EmployeeDTO> assignProject(int projectId,int empId) {
		EmployeeDTO edto=empService.assignProjectInProjectAPI(projectId,empId);
		return new ResponseEntity<EmployeeDTO>(edto, HttpStatus.OK);
	}
	
	
}
