package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class TaskMapperTestSuite {

    @Autowired
    TaskMapper taskMapper;

    @BeforeEach
    void before(){
        taskMapper = new TaskMapper();
    }

    @Test
    public void mapToTaskTest() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Title", "Content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //THen
        assertNotNull(task.getId());
        assertEquals("Title", task.getTitle());
        assertEquals("Content", task.getContent());
    }

    @Test
    public void mapToTaskDtoTest() {
        //Given
        Task task = new Task(1L, "Title", "Contente");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //THen
        assertNotNull(taskDto.getId());
        assertEquals("Title", taskDto.getTitle());
        assertEquals("Contente", taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoListTest() {
        Task task = new Task(1L, "Title", "Contente");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        //Wehn
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertEquals(1, taskDtoList.size());
        assertEquals("Title", taskDtoList.get(0).getTitle());
        assertEquals("Contente", taskDtoList.get(0).getContent());
        assertNotNull(taskDtoList.get(0).getId());
    }
}
