
package com.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.todo.model.Todo;
import com.todo.repository.mysql.MysqlTodoRepository;
import com.todo.service.TodoService;

class TodoServiceTest {

    
    @Test
    void createAndFetch(){
        TodoService service = new TodoService(new MysqlTodoRepository());
        Todo t = new Todo("1","Task","desc",false);
        service.createTodo(t);
        assertNotNull(service.getTodo("1"));
    }

    @Test
    void updateTodo(){
        TodoService service = new TodoService(new MysqlTodoRepository());
        Todo t = new Todo("2","Task","desc",false);
        service.createTodo(t);

        t.setTitle("Updated");
        service.update(t);

        assertEquals("Updated", service.getTodo("2").getTitle());
    }

    @Test
    void deleteTodo(){
        TodoService service = new TodoService(new MysqlTodoRepository());
        Todo t = new Todo("3","Task","desc",false);
        service.createTodo(t);

        service.delete("3");

        assertNull(service.getTodo("3"));
    }

    @Test
    void findAllTodos(){
        TodoService service = new TodoService(new MysqlTodoRepository());
        service.createTodo(new Todo("4","A","d",false));
        service.createTodo(new Todo("5","B","d",false));

        assertEquals(2, service.getAll().size());
    }
}
