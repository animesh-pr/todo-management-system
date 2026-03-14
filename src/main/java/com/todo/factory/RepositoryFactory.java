package com.todo.factory;

import com.todo.dao.TodoDao;
import com.todo.repository.mongo.MongoTodoRepository;
import com.todo.repository.mysql.MysqlTodoRepository;
import com.todo.repository.postgres.PostgresTodoRepository;

public class RepositoryFactory {

    // Fix for Sonar rule java:S1118
    private RepositoryFactory() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static TodoDao createRepository(int choice) {

        switch (choice) {
            case 1 -> {
                return new MysqlTodoRepository();
            }

            case 2 -> {
                return new PostgresTodoRepository();
            }

            case 3 -> {
                return new MongoTodoRepository();
            }

            default -> throw new IllegalArgumentException("Invalid database choice");
        }
    }
}