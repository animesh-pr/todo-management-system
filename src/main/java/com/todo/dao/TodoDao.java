
package com.todo.dao;

import com.todo.model.Todo;
import java.util.List;

public interface TodoDao {

    void create(Todo todo);
    Todo findById(String id);
    List<Todo> findAll();
    void update(Todo todo);
    void delete(String id);
}
