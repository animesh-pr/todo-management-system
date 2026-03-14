
package com.todo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import com.todo.factory.RepositoryFactory;

class FactoryTest {

    @Test
    void mysqlFactory(){
        assertNotNull(RepositoryFactory.createRepository(1));
    }

    @Test
    void postgresFactory(){
        assertNotNull(RepositoryFactory.createRepository(2));
    }

    @Test
    void mongoFactory(){
        assertNotNull(RepositoryFactory.createRepository(3));
    }
}
