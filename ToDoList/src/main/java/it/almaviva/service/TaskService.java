package it.almaviva.service;

import it.almaviva.model.Task;
import it.almaviva.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Iterable<Task> getAll() {
        return repository.findAll();
    }

    public void saveTask(Task task) {
        repository.save(task);
    }
}
