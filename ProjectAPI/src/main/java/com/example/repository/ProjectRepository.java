package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
