package com.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.todo.dao.TodoDao;
import com.todo.model.Todo;
import com.todo.repository.mysql.MysqlTodoRepository;

class TodoDaoTest {

    @Test
    void testCreateAndFind() {

        TodoDao dao = new MysqlTodoRepository();

        Todo todo = new Todo("100", "Task", "Desc", false);

        dao.create(todo);

        Todo result = dao.findById("100");

        assertNotNull(result);
        assertEquals("Task", result.getTitle());
    }

    @Test
    void testDelete() {

        TodoDao dao = new MysqlTodoRepository();

        Todo todo = new Todo("200", "Task", "Desc", false);

        dao.create(todo);

        dao.delete("200");

        assertNull(dao.findById("200"));
    }
}