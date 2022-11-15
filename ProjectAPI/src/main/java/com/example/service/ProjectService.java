package com.example.service;

import java.time.LocalDate;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Project;
import com.example.exception.ProjectAPIException;
import com.example.repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	ProjectRepository projectRepo;

	public Project addProjectDeatils(Project project) {
		return projectRepo.save(project);
	}

	@Transactional
	public Project assignEmp(int projectId, int empId) {
		Optional<Project> OptionalProject = projectRepo.findById(projectId);
		Project project=OptionalProject.orElseThrow(()->new ProjectAPIException("Project is not available in database"));
		if(project.getEndDate().compareTo(LocalDate.now())<0) {
			throw new ProjectAPIException("Project is expired.Hence employee can not be assign");
		}
		project.setEmpId(empId);
		return project;
	}

}
