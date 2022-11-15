package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Project;
import com.example.service.ProjectService;


@RestController
public class ProjectController {

	@Autowired
	ProjectService projectService;
	
	@PostMapping("/project")
	private ResponseEntity<Project> addProject(@RequestBody Project project){
		Project addproject=projectService.addProjectDeatils(project);
		return new ResponseEntity<Project>(addproject, HttpStatus.CREATED);
	}
	
	@PutMapping("/assignEmpToProject")
	public ResponseEntity<Project> assignEmpToProject(int projectId,int empId){
		Project assignEmp=projectService.assignEmp(projectId,empId);
		return new ResponseEntity<Project>(assignEmp, HttpStatus.CREATED);
	}
}
