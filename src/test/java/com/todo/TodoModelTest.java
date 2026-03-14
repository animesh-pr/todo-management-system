package com.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.todo.model.Todo;

class TodoModelTest {

    @Test
    void testGettersAndSetters() {

        Todo todo = new Todo();

        todo.setId("1");
        todo.setTitle("Test");
        todo.setDescription("Description");
        todo.setCompleted(true);

        assertEquals("1", todo.getId());
        assertEquals("Test", todo.getTitle());
        assertEquals("Description", todo.getDescription());
        assertTrue(todo.isCompleted());
    }

    @Test
    void testConstructor() {

        Todo todo = new Todo("2", "Task", "Desc", false);

        assertEquals("2", todo.getId());
        assertEquals("Task", todo.getTitle());
        assertEquals("Desc", todo.getDescription());
        assertFalse(todo.isCompleted());
    }
}