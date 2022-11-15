package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.EmployeeDTO;
import com.example.dto.EmployeeRequestDTO;
import com.example.dto.ProjectDTO;
import com.example.entity.Employee;
import com.example.exception.EmployeeAPIException;
import com.example.exception.EmployeeNotAvailableException;
import com.example.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	EmpRepository empRepo;
	@Autowired
	RestTemplate restTemplate;

	public Employee addEmpToRepo(EmployeeRequestDTO employeeDTO) {
		Employee employee=employeeDTO.convertToEntity();
		Optional<Employee> findById = empRepo.findById(employee.getEmpId());
		if(findById.isPresent()) {
			throw new EmployeeAPIException("Employee with this empId is already available");
		}
		return empRepo.save(employee);
	}

	public Employee getEmpDetailsFromDB(int id) {
		Optional<Employee> optionalEmp = empRepo.findById(id);
		Employee orElseThrow = optionalEmp.orElseThrow(()->new EmployeeNotAvailableException("Employee is not available"));
		return orElseThrow;
	}

	public String deleteEmployeeById(int id) {
		Optional<Employee> findById = empRepo.findById(id);
		Employee orElseThrow = findById.orElseThrow(()->new EmployeeNotAvailableException("Employee which you are trying to delete already unavailable"));
		empRepo.deleteById(id);
		return "deleted";
		}

	public EmployeeDTO assignProjectInProjectAPI(int projectId, int empId) {
		if(projectId==0 && empId==0) {
			throw new EmployeeAPIException("Either projectId or employeeId is null");
		}
		Optional<Employee> optionalEmployee = empRepo.findById(empId);
		Employee employee = optionalEmployee.orElseThrow(()->new EmployeeAPIException("Employee is not available in DB"));
		
		EmployeeDTO employeeDTO=employee.convertToDTO();
		ResponseEntity<ProjectDTO> exchange=restTemplate.exchange("http://project-service/assignEmpToProject?projectId={projectId}&empId={empId}", HttpMethod.PUT,null,ProjectDTO.class,projectId,empId);
		ProjectDTO projectDTO=exchange.getBody();
		employeeDTO.setProject(projectDTO);
		return employeeDTO;
	}
	}

	


