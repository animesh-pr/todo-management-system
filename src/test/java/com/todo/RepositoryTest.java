
package com.todo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import com.todo.model.Todo;
import com.todo.repository.mongo.MongoTodoRepository;
import com.todo.repository.mysql.MysqlTodoRepository;
import com.todo.repository.postgres.PostgresTodoRepository;

class RepositoryTest {

    @Test
    void mysqlRepoWorks(){
        MysqlTodoRepository repo = new MysqlTodoRepository();
        repo.create(new Todo("1","t","d",false));
        assertNotNull(repo.findById("1"));
    }

    @Test
    void postgresRepoWorks(){
        PostgresTodoRepository repo = new PostgresTodoRepository();
        repo.create(new Todo("2","t","d",false));
        assertEquals(1, repo.findAll().size());
    }

    @Test
    void mongoRepoWorks(){
        MongoTodoRepository repo = new MongoTodoRepository();
        repo.create(new Todo("3","t","d",false));
        repo.delete("3");
        assertNull(repo.findById("3"));
    }
}
