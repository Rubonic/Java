package com.codingdojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.models.Project;
import com.codingdojo.repositories.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	private ProjectRepository projectRepo;
	
	// all projects
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	// find one project
	public Project findOneProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	}
	
	// create project
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}

	// update project
	public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
	
	
	// delete project
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
	
}
