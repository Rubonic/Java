package com.codingdojo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.models.Task;
import com.codingdojo.repositories.TaskRepository;

@Service
public class ProjectTaskService {
	private final TaskRepository taskRepository;
	
	public ProjectTaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> allTasks(){
		return taskRepository.findAll();
	}
	
	public List<Task> projectTasks(Long projectId){
		return taskRepository.findByProjectIdIs(projectId);
	}
	
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}
	
	public void deleteTask(Task task) {
		taskRepository.delete(task);
	}
}
