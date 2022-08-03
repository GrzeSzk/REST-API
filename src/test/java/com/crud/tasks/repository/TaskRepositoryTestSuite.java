package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TaskRepositoryTestSuite {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void saveTaskTest() {
        //Given
        Task task = new Task(1L, "Task no1", "Content");
        //When
        Task savedTask = taskRepository.save(task);
        //Then
        assertNotNull(savedTask.getId());
        assertEquals("Task no1", savedTask.getTitle());
        assertEquals("Content", savedTask.getContent());
        //CleanUp
        taskRepository.deleteAll();
    }

    @Test
    void findByIdTest() {
        //Given
        Task task = new Task(2L, "Task no2", "Content");
        taskRepository.save(task);
        Long id = task.getId();
        //When
        Optional<Task> resultTask = taskRepository.findById(id);
        //Then
        assertThat(resultTask).isNotNull();
        //CleanUp
        taskRepository.deleteAll();
    }
}
