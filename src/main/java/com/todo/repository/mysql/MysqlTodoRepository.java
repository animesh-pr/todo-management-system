
package com.todo.repository.mysql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.todo.dao.TodoDao;
import com.todo.model.Todo;

public class MysqlTodoRepository implements TodoDao {

    private final Map<String,Todo> storage = new HashMap<>();

    @Override
    public void create(Todo todo){
        storage.put(todo.getId(),todo);
    }

    @Override
    public Todo findById(String id){
        return storage.get(id);
    }

    @Override
    public List<Todo> findAll(){
        return new ArrayList<>(storage.values());
    }

    @Override
    public void update(Todo todo){
        storage.put(todo.getId(),todo);
    }

    @Override
    public void delete(String id){
        storage.remove(id);
    }
}
