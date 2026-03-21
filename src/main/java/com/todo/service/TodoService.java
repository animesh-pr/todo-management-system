
package com.todo.service;

import com.todo.dao.TodoDao;
import com.todo.model.Todo;
import java.util.List;

public class TodoService {
    

    private final TodoDao dao;

    public TodoService(TodoDao dao){
        this.dao = dao;
    }

    public void createTodo(Todo todo){
        dao.create(todo);
    }

    public Todo getTodo(String id){
        return dao.findById(id);
    }

    public List<Todo> getAll(){
        return dao.findAll();
    }

    public void update(Todo todo){
        dao.update(todo);
    }

    public void delete(String id){
        dao.delete(id);
    }
}
